package dao.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import dao.ITaiKhoanDao;
import entity.TaiKhoan;
import hibernateCfg.HibernateConfig;
import service.ITaiKhoanService;

public class TaiKhoanDaoImpl implements ITaiKhoanDao{
	
	private SessionFactory sessionFactory = null;

	public TaiKhoanDaoImpl() throws RemoteException {
		// TODO Auto-generated constructor stub
		sessionFactory = HibernateConfig.getInstance().getSessionFactory();
	}

	
	
	public TaiKhoan getTaiKhoan(String taiKhoan) {
		Session session = sessionFactory.openSession();
		Transaction tr = session.getTransaction();
		try {
			tr.begin();
			TaiKhoan khoan = session.find(TaiKhoan.class, taiKhoan);
			tr.commit();
			return khoan;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		} finally {
			session.close();
		}
		return null;
	}

	public List<TaiKhoan> getAllTaiKhoan() {
		Session session = sessionFactory.openSession();
		Transaction tr = session.getTransaction();
		try {
			tr.begin();
			List<TaiKhoan> listTK = session.createNativeQuery("SELECT * FROM TAIKHOAN", TaiKhoan.class).getResultList();
			tr.commit();
			return listTK;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		} finally {
			session.close();
		}
		return null;
	}

	public TaiKhoan getTaiKhoanByUserNamePassword(String taiKhoan, String matKhau) {
		Session session = sessionFactory.openSession();
		Transaction tr = session.getTransaction();
		try {
			tr.begin();
			TaiKhoan tk = session.createNativeQuery("SELECT * FROM TAIKHOAN WHERE Username = '" + taiKhoan +  "' and Password = '" + matKhau + "'", TaiKhoan.class).getSingleResult();
			tr.commit();
			return tk;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		} finally {
			session.close();
		}
		return null;
	}
	
	public boolean ThemTaiKhoan(TaiKhoan tk) {
		Session session = sessionFactory.openSession();
		Transaction tr = session.getTransaction();
		try {
			tr.begin();
			if(tk.getGiangVien()==null) {
				session.createNativeQuery("insert into TaiKhoan (Username, Password,LoaiTK,maSV) values (?1,?2,?3,?4)")
				.setParameter(1, tk.getUsername())
				.setParameter(2, tk.getPassword())
				.setParameter(3, tk.getLoaiTK())
				.setParameter(4, tk.getSinhVien().getMaSV())
				.executeUpdate();
			}
			if(tk.getSinhVien()==null) {
				session.createNativeQuery("insert into TaiKhoan (Username, Password,LoaiTK,maGV) values (?1,?2,?3,?4)")
				.setParameter(1, tk.getUsername())
				.setParameter(2, tk.getPassword())
				.setParameter(3, tk.getLoaiTK())
				.setParameter(4, tk.getGiangVien().getMaGV())
				.executeUpdate();
			}
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



	public boolean XoaTaiKhoan(TaiKhoan tk) {
		Session session = sessionFactory.openSession();
		Transaction tr = session.getTransaction();
		try {
			tr.begin();
			if(tk.getGiangVien()==null) {
				session.createNativeQuery("delete TaiKhoan where maSV = '" + tk.getSinhVien().getMaSV()+"'")
				.executeUpdate();
			}
			if(tk.getSinhVien()==null) {
				session.createNativeQuery("delete TaiKhoan where maGV = '" + tk.getGiangVien().getMaGV()+"'")
				.executeUpdate();
			}
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



	public boolean ResetMatKhau(TaiKhoan tk) {
		Session session = sessionFactory.openSession();
		Transaction tr = session.getTransaction();
		try {
			tr.begin();
				session.createNativeQuery("update  TaiKhoan set Password = '123456' where Username = '" + tk.getUsername()+"'")
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



	public boolean DoiMatKhau(TaiKhoan tk) {
		Session session = sessionFactory.openSession();
		Transaction tr = session.getTransaction();
		try {
			tr.begin();
				session.createNativeQuery("update  TaiKhoan set Password = '"+tk.getPassword()+"' where Username = '" + tk.getUsername()+"'")
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

}
