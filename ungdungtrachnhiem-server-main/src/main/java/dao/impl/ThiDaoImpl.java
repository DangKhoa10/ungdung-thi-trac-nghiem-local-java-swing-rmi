package dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import dao.IThiDao;
import entity.CauHoiThi;
import entity.DapAn;
import entity.Thi;
import hibernateCfg.HibernateConfig;

public class ThiDaoImpl implements IThiDao{

	
	private SessionFactory sessionFactory = null;
	public ThiDaoImpl() {
		sessionFactory = HibernateConfig.getInstance().getSessionFactory();
	} 
	
	public boolean ThemLichThi(Thi thi) {
		Session session = sessionFactory.openSession();
		Transaction tr = session.getTransaction();
		try {
			tr.begin();
			session.save(thi);
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

	public boolean XoaLichThi(Thi thi) {
		Session session = sessionFactory.openSession();
		Transaction tr = session.getTransaction();
		try {
			tr.begin();
			session.remove(thi);
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

	public boolean SuaLichThi(Thi thi) {
		Session session = sessionFactory.openSession();
		Transaction tr = session.getTransaction();
		try {
			tr.begin();
			session.update(thi);
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

	public Thi GetLichThi(int ma) {
		Session session = sessionFactory.openSession();
		Transaction tr = session.getTransaction();
		try {
			tr.begin();
			Thi thi = session.find(Thi.class, ma);
			tr.commit();
			return thi;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		} finally {
			session.close();
		}
		return null;
	}

	public List<Thi> GetAllLichThi() {
		Session session = sessionFactory.openSession();
		Transaction tr = session.getTransaction();
		try {
			tr.begin();
			List<Thi> list = session.createNativeQuery("select * from Thi",Thi.class).getResultList();
			tr.commit();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		} finally {
			session.close();
		}
		return null;
	}

	public List<Thi> GetAllLichThiTheoMon(String maMH) {
		Session session = sessionFactory.openSession();
		Transaction tr = session.getTransaction();
		try {
			tr.begin();
			List<Thi> list =  session.createNativeQuery("select * FROM Thi where maMH = '"+ maMH + "'" ,Thi.class).getResultList();
			tr.commit();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		} finally {
			session.close();
		}
		return null;
	}

	public List<Thi> GetThiTheoSinhVien(String maSV) {
		Session session = sessionFactory.openSession();
		Transaction tr = session.getTransaction();
		try {
			tr.begin();
			List<Thi> list =  session.createNativeQuery("select t.MaThi"
					+ ",t.PhanTramCauHoiKho"
					+ ", t.SoCauHoi"
					+ ", t.maMH "
					+ ",t.TenKyThi"
					+ ",t.ThoiGianDongDe"
					+ ",t.ThoiGianMoDe "
					+ ", t.ThoiGianLambai"
					+ " from Thi t join MonHoc m on t.maMH = m.MaMH"
					+ "	join KetQua k on m.MaMH = k.maMH"
					+ "	join SinhVien s on s.MaSV = k.maSV"
					+ "	where s.MaSV = '"+ maSV + "'" ,Thi.class).getResultList();
			tr.commit();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		} finally {
			session.close();
		}
		return null;
	}

}
