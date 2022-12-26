package dao.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import dao.IGiangVienDao;
import dao.ITaiKhoanDao;
import entity.GiangVien;
import entity.TaiKhoan;
import hibernateCfg.HibernateConfig;
import service.ITaiKhoanService;

public class GiangVienDaoImpl implements IGiangVienDao{
	
	private SessionFactory sessionFactory = null;

	public GiangVienDaoImpl() throws RemoteException {
		// TODO Auto-generated constructor stub
		sessionFactory = HibernateConfig.getInstance().getSessionFactory();
	}

	public List<GiangVien> getAllGV() {
		Session session = sessionFactory.openSession();
		Transaction tr = session.getTransaction();
		try {
			tr.begin();
			List<GiangVien> listGV = session.createNativeQuery("SELECT * FROM GiangVien", GiangVien.class).getResultList();
			tr.commit();
			return listGV;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		} finally {
			session.close();
		}
		return null;
	}

	public GiangVien getGiangVien(String maGV) {
		Session session = sessionFactory.openSession();
		Transaction tr = session.getTransaction();
		try {
			tr.begin();
			GiangVien giangVien = session.find(GiangVien.class, maGV);
			tr.commit();
			return giangVien;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		} finally {
			session.close();
		}
		return null;
	}

	public boolean addGiangVien(GiangVien giangVien) {
		Session session = sessionFactory.openSession();
		Transaction tr = session.getTransaction();
		try {
			tr.begin();
			session.save(giangVien);
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

	public boolean updateGiangVien(GiangVien giangVien) {
		Session session = sessionFactory.openSession();
		Transaction tr = session.getTransaction();
		try {
			tr.begin();
			session.update(giangVien);
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

	public boolean deleteGiangVien(String maGV) {
		Session session = sessionFactory.openSession();
		Transaction tr = session.getTransaction();
		try {
			tr.begin();
			session.delete(session.find(GiangVien.class, maGV));
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

	public List<GiangVien> getGiangVienByTen(String tenGV) {
		Session session = sessionFactory.openSession();
		Transaction tr = session.getTransaction();
		try {
			tr.begin();
			List<GiangVien> listGV = session.createNativeQuery("SELECT * FROM GIANGVIEN WHERE TenGV LIKE '%" + tenGV + "%'", GiangVien.class).getResultList();
			tr.commit();
			return listGV;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		} finally {
			session.close();
		}
		return null;
	}

	
	
	
}
