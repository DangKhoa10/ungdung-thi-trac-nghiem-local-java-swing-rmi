package dao.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import dao.IGiangVienDao;
import dao.IMonHocDao;
import dao.ITaiKhoanDao;
import entity.GiangVien;
import entity.MonHoc;
import entity.TaiKhoan;
import hibernateCfg.HibernateConfig;
import service.ITaiKhoanService;

public class MonHocDaoImpl implements IMonHocDao{
	
	private SessionFactory sessionFactory = null;

	public MonHocDaoImpl() throws RemoteException {
		// TODO Auto-generated constructor stub
		sessionFactory = HibernateConfig.getInstance().getSessionFactory();
	}

	public List<MonHoc> getAllMH() {
		Session session = sessionFactory.openSession();
		Transaction tr = session.getTransaction();
		try {
			tr.begin();
			List<MonHoc> listMonHoc = session.createNativeQuery("SELECT * FROM MonHoc", MonHoc.class).getResultList();
			tr.commit();
			return listMonHoc;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		} finally {
			session.close();
		}
		return null;
	}

	public MonHoc getMonHoc(String maMH) {
		Session session = sessionFactory.openSession();
		Transaction tr = session.getTransaction();
		try {
			tr.begin();
			MonHoc monHoc = session.find(MonHoc.class, maMH);
			tr.commit();
			return monHoc;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		} finally {
			session.close();
		}
		return null;
	}

	public List<MonHoc> getMonHocByGiangVien(String tenGV) {
		Session session = sessionFactory.openSession();
		Transaction tr = session.getTransaction();
		try {
			tr.begin();
			List<MonHoc> listMH = session.createNativeQuery("SELECT * FROM MonHoc WHERE tenMH LIKE '%" + tenGV + "%'", MonHoc.class).getResultList();
			tr.commit();
			return listMH;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		} finally {
			session.close();
		}
		return null;
	}

	public boolean addMonHoc(MonHoc monHoc) {
		Session session = sessionFactory.openSession();
		Transaction tr = session.getTransaction();
		try {
			tr.begin();
			session.createNativeQuery("insert into MonHoc (MaMH, TenMH,maGV) values (?1,?2,?3)")
			.setParameter(1, monHoc.getMaMH())
			.setParameter(2, monHoc.getTenMH())
			.setParameter(3, monHoc.getGiangVien().getMaGV())
			
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

	public boolean updateMonHoc(MonHoc monHoc) {
		Session session = sessionFactory.openSession();
		Transaction tr = session.getTransaction();
		try {
			tr.begin();
			session.update(monHoc);
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

	public boolean deleteMonHoc(String maMonHoc) {
		Session session = sessionFactory.openSession();
		Transaction tr = session.getTransaction();
		try {
			tr.begin();
			session.delete(session.find(MonHoc.class, maMonHoc));
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

	public int getStudentsFromMonHoc(String maMonHoc) {
		// TODO Auto-generated method stub
//SELECT COUNT(sinhViens_MaSV) FROM MONHOC_SINHVIEN where monHoc_MaMH = 'MH0001'
		Session session = sessionFactory.openSession();
		Transaction tr = session.getTransaction();
		int students = 0;
		try {
			tr.begin();
				students = session.createNativeQuery("SELECT COUNT(maSV) FROM KetQua where maMH = '" + maMonHoc + "'", Integer.class).getSingleResult();
			tr.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		} finally {
			session.close();
		}
		return students;
	}

	public List<MonHoc> getMonHocMaGiangVien(String maGV) {
		Session session = sessionFactory.openSession();
		Transaction tr = session.getTransaction();
		try {
			tr.begin();
			List<MonHoc> listMH = session.createNativeQuery("SELECT * FROM MonHoc WHERE maGV = '" + maGV + "'", MonHoc.class).getResultList();
			tr.commit();
			return listMH;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		} finally {
			session.close();
		}
		return null;
	}

	
	
	
}
