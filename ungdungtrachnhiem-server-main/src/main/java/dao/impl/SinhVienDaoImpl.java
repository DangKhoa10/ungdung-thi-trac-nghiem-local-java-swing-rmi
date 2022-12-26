package dao.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import dao.IGiangVienDao;
import dao.ISinhVienDao;
import dao.ITaiKhoanDao;
import entity.GiangVien;
import entity.SinhVien;
import entity.TaiKhoan;
import hibernateCfg.HibernateConfig;
import service.ITaiKhoanService;

public class SinhVienDaoImpl implements ISinhVienDao{
	
	private SessionFactory sessionFactory = null;

	public SinhVienDaoImpl() throws RemoteException {
		// TODO Auto-generated constructor stub
		sessionFactory = HibernateConfig.getInstance().getSessionFactory();
	}

	public List<SinhVien> getAllSV() {
		Session session = sessionFactory.openSession();
		Transaction tr = session.getTransaction();
		try {
			tr.begin();
			List<SinhVien> listSV = session.createNativeQuery("SELECT * FROM SinhVien", SinhVien.class).getResultList();
			tr.commit();
			return listSV;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		} finally {
			session.close();
		}
		return null;
	}

	public SinhVien getSinhVien(String maGV) {
		Session session = sessionFactory.openSession();
		Transaction tr = session.getTransaction();
		try {
			tr.begin();
			SinhVien sinhVien = session.find(SinhVien.class, maGV);
			tr.commit();
			return sinhVien;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		} finally {
			session.close();
		}
		return null;
	}

	public boolean addSinhVien(SinhVien sinhVien) {
		Session session = sessionFactory.openSession();
		Transaction tr = session.getTransaction();
		try {
			tr.begin();
			session.save(sinhVien);
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

	public boolean updateSinhVien(SinhVien sinhVien) {
		Session session = sessionFactory.openSession();
		Transaction tr = session.getTransaction();
		try {
			tr.begin();
			session.update(sinhVien);
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

	public boolean deleteSinhVien(String maSV) {
		Session session = sessionFactory.openSession();
		Transaction tr = session.getTransaction();
		try {
			tr.begin();
			session.delete(session.find(SinhVien.class, maSV));
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

	public List<SinhVien> getSinhVienVienByTen(String tenSV) {
		Session session = sessionFactory.openSession();
		Transaction tr = session.getTransaction();
		try {
			tr.begin();
			List<SinhVien> listGV = session.createNativeQuery("SELECT * FROM SinhVien WHERE TenSV LIKE '%" + tenSV + "%'", SinhVien.class).getResultList();
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

	public List<SinhVien> getSinhVienByMonHoc(String maMH) {
		Session session = sessionFactory.openSession();
		Transaction tr = session.getTransaction();
		try {
			tr.begin();
			List<SinhVien> listSV = session.createNativeQuery("select SinhVien.MaSV,SinhVien.SDT,SinhVien.Email,SinhVien.TenSV "
					+"from SinhVien join KetQua on SinhVien.MaSV = KetQua.maSV "
					+ "join MonHoc on KetQua.maMH = MonHoc.MaMH "
					+ "where MonHoc.MaMH = '" + maMH + "'", SinhVien.class).getResultList();
			tr.commit();
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
