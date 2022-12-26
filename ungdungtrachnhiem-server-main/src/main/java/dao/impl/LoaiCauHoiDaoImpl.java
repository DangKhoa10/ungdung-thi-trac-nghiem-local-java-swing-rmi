package dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import dao.ILoaiCauHoiDao;
import entity.CauHoiThi;
import entity.LoaiCauHoi;
import hibernateCfg.HibernateConfig;

public class LoaiCauHoiDaoImpl implements ILoaiCauHoiDao{

	private SessionFactory sessionFactory = null;
	
	public LoaiCauHoiDaoImpl() {
		sessionFactory = HibernateConfig.getInstance().getSessionFactory();
	}
	
	public List<LoaiCauHoi> getAllLoaiCauHoi() {
		Session session = sessionFactory.openSession();
		Transaction tr = session.getTransaction();
		try {
			tr.begin();
			List<LoaiCauHoi> listLCH = session.createNativeQuery("SELECT * FROM LoaiCauHoi", LoaiCauHoi.class).getResultList();
			tr.commit();
			return listLCH;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		} finally {
			session.close();
		}
		return null;
	}

	public LoaiCauHoi getLoaiCauHoi(int ma) {
		Session session = sessionFactory.openSession();
		Transaction tr = session.getTransaction();
		try {
			tr.begin();
			LoaiCauHoi cht = session.find(LoaiCauHoi.class, ma);
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
