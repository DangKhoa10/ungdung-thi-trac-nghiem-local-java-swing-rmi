package dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import dao.IKetQuaDao;
import dto.KetQuaMonHoc;
import dto.KetQuaSinhVien;
import entity.GiangVien;
import entity.KetQua;
import entity.SinhVien;
import hibernateCfg.HibernateConfig;

public class KetQuaDaoImpl implements IKetQuaDao{
	
private SessionFactory sessionFactory = null;
	
	public KetQuaDaoImpl() {
		sessionFactory = HibernateConfig.getInstance().getSessionFactory();
	} 
	

	public boolean themKQ(KetQua ketQua) {
		Session session = sessionFactory.openSession();
		Transaction tr = session.getTransaction();
		try {
			tr.begin();
			session.createNativeQuery("insert into KetQua (maMH, maSV,DiemThi) values (?1,?2,?3)")
			.setParameter(1, ketQua.getMonHoc().getMaMH())
			.setParameter(2, ketQua.getSinhVien().getMaSV())
			.setParameter(3, ketQua.getDiemThi())
			.executeUpdate();
			
			tr.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		} finally {
			session.close();
		}
		return false;
	}

	@SuppressWarnings("deprecation")
	public boolean xoaKQ(String maMH,String maSV) {
		Session session = sessionFactory.openSession();
		Transaction tr = session.getTransaction();
		try {
			tr.begin();
			session.createNativeQuery("delete from KetQua where maMH = '" + maMH + "' and maSV = '" + maSV + "'")
			.executeUpdate();
			tr.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		} finally {
			session.close();
		}
		return false;
	}

	public boolean suaKQ(KetQua ketQua) {
		Session session = sessionFactory.openSession();
		Transaction tr = session.getTransaction();
		try {
			tr.begin();
			session.createNativeQuery("update KetQua set DiemThi = " + ketQua.getDiemThi() + " where maMH = '" + ketQua.getMonHoc().getMaMH()  + "' and maSV = '" + ketQua.getSinhVien().getMaSV() + "'")
			.executeUpdate();
			tr.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		} finally {
			session.close();
		}
		return false;
	}


	public KetQua getKQSVMH(String maMH, String maSV) {
		Session session = sessionFactory.openSession();
		KetQua kq =session.createNativeQuery("SELECT * FROM KetQua where maMH = '" + maMH + "' and maSV = '" + maSV + "'",KetQua.class).getSingleResultOrNull();
		return kq;
	
	}


	public List<KetQuaMonHoc> getDiemMHcuaSV(String maSV) {
		Session session = sessionFactory.openSession();
		Transaction tr = session.getTransaction();
		try {
			tr.begin();
			List<Object[]> list = session.createNativeQuery("select m.MaMH, m.TenMH , k.DiemThi from MonHoc m "
					+" join KetQua k on m.MaMH = k.maMH "
					+ " join SinhVien s on s.MaSV = k.maSV "
					+ " where s.MaSV = '" + maSV + "'").getResultList();
			tr.commit();
			List<KetQuaMonHoc> listMH = new ArrayList<KetQuaMonHoc>();
			for(Object[] o : list) {
				KetQuaMonHoc k = new KetQuaMonHoc(o[0].toString(), o[1].toString(), Float.parseFloat(o[2].toString()));
				listMH.add(k);
			}
			return listMH;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		} finally {
			session.close();
		}
		return null;
	}


	public List<KetQuaSinhVien> getDiemSVcuaMH(String maMH) {
		Session session = sessionFactory.openSession();
		Transaction tr = session.getTransaction();
		try {
			tr.begin();
			List<Object[]> list = session.createNativeQuery("select s.MaSV , s.TenSV , s.SDT , s.Email ,k.DiemThi from SinhVien s  "
					+" join KetQua k on s.MaSV = k.maSV "
					+ " join MonHoc m on m.MaMH = k.maMH "
					+ " where m.MaMH = '" + maMH + "'").getResultList();
			
			tr.commit();
			
			List<KetQuaSinhVien> listSV = new ArrayList<KetQuaSinhVien>();
			for(Object[] o : list) {
				KetQuaSinhVien k = new KetQuaSinhVien(o[0].toString(), o[1].toString(),o[2].toString(), o[3].toString(), Float.parseFloat(o[4].toString()));
				listSV.add(k);
			}
			return listSV;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		} finally {
			session.close();
		}
		return null;
	}

}
