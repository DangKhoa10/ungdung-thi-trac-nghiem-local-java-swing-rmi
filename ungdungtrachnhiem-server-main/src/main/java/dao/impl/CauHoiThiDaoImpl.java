package dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import dao.ICauHoiThiDao;
import entity.CauHoiThi;
import entity.MonHoc;
import hibernateCfg.HibernateConfig;

public class CauHoiThiDaoImpl implements ICauHoiThiDao{
private SessionFactory sessionFactory = null;
	
	public CauHoiThiDaoImpl() {
		sessionFactory = HibernateConfig.getInstance().getSessionFactory();
	}

	public boolean ThemCauHoiThi(CauHoiThi cauHoiThi) {
		Session session = sessionFactory.openSession();
		Transaction tr = session.getTransaction();
		try {
			tr.begin();
			session.save(cauHoiThi);
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

	public boolean XoaCauHoiThi(CauHoiThi cauHoiThi) {
		Session session = sessionFactory.openSession();
		Transaction tr = session.getTransaction();
		try {
			tr.begin();
			session.remove(cauHoiThi);
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

	public boolean SuaCauHoiThi(CauHoiThi cauHoiThi) {
		Session session = sessionFactory.openSession();
		Transaction tr = session.getTransaction();
		try {
			tr.begin();
			session.update(cauHoiThi);
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

	public List<CauHoiThi> GetCauHoiThiTheoMonHoc(String maMH) {
		Session session = sessionFactory.openSession();
		Transaction tr = session.getTransaction();
		try {
			tr.begin();
			List<CauHoiThi> list = session.createNativeQuery("select * from CauHoiThi where maMH = '" + maMH + "'",CauHoiThi.class).getResultList();
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

	public List<CauHoiThi> GetAllCauHoiThi() {
		Session session = sessionFactory.openSession();
		Transaction tr = session.getTransaction();
		try {
			tr.begin();
			List<CauHoiThi> list = session.createNativeQuery("select * from CauHoiThi",CauHoiThi.class).getResultList();
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

	public CauHoiThi GetCauHoiThiTheoMa(String maCH) {
		Session session = sessionFactory.openSession();
		Transaction tr = session.getTransaction();
		try {
			tr.begin();
			CauHoiThi cht = session.find(CauHoiThi.class, maCH);
			tr.commit();
			return cht;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		} finally {
			session.close();
		}
		return null;
	}
}
