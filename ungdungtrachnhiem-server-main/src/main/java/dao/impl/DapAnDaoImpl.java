package dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import dao.IDapAnDao;
import entity.DapAn;
import entity.LoaiCauHoi;
import entity.TaiKhoan;
import hibernateCfg.HibernateConfig;

public class DapAnDaoImpl implements IDapAnDao{
	
	private SessionFactory sessionFactory = null;
	
	public DapAnDaoImpl() {
		sessionFactory = HibernateConfig.getInstance().getSessionFactory();
	} 
	
	
	@SuppressWarnings("deprecation")
	public boolean ThemDapAn(DapAn dapAn) {
		Session session = sessionFactory.openSession();
		Transaction tr = session.getTransaction();
		try {
			tr.begin();
			session.save(dapAn);
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

	

	public boolean XoaDapAn(DapAn dapAn) {
		Session session = sessionFactory.openSession();
		Transaction tr = session.getTransaction();
		try {
			tr.begin();
			session.remove(dapAn);
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

	public boolean XoaDapAnThuocCauHoi(String maCH) {
		Session session = sessionFactory.openSession();
		Transaction tr = session.getTransaction();
		try {
			tr.begin();
			session.createNativeQuery("DELETE FROM DAPAN where maCH = '"+ maCH + "'").executeUpdate();
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

	public List<DapAn> GetDapAnTheoCauHoi(String maCH) {
		Session session = sessionFactory.openSession();
		Transaction tr = session.getTransaction();
		try {
			tr.begin();
			List<DapAn> list =  session.createNativeQuery("select * FROM DAPAN where maCH = '"+ maCH + "'" ,DapAn.class).getResultList();
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


	public boolean SuaDapAn(DapAn dapAn) {
		Session session = sessionFactory.openSession();
		Transaction tr = session.getTransaction();
		try {
			tr.begin();
			session.update(dapAn);
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

	
}
