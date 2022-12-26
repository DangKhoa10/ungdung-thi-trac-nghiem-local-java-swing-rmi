package service.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import dao.ITaiKhoanDao;
import dao.impl.TaiKhoanDaoImpl;
import hibernateCfg.HibernateConfig;
import service.ITaiKhoanService;
import entity.TaiKhoan;

public class TaiKhoanServiceImpl extends UnicastRemoteObject implements ITaiKhoanService{
	
	
	private static final long serialVersionUID = -1479081236579346559L;
	private ITaiKhoanDao taiKhoanDao;
	
	public TaiKhoanServiceImpl() throws RemoteException {
		super();
		taiKhoanDao = (ITaiKhoanDao) new TaiKhoanDaoImpl();
	}
	/**
	 * 
	 */
	
	public TaiKhoan getTaiKhoan(String taiKhoan) throws RemoteException {
		return taiKhoanDao.getTaiKhoan(taiKhoan);
	}
	public List<TaiKhoan> getAllTaiKhoan() throws RemoteException {
		return taiKhoanDao.getAllTaiKhoan();
	}
	public TaiKhoan getTaiKhoanByUserNamePassword(String taiKhoan, String matKhau) throws RemoteException {
		return taiKhoanDao.getTaiKhoanByUserNamePassword(taiKhoan, matKhau);
	}
	public boolean ThemTaiKhoan(TaiKhoan tk) throws RemoteException {
		// TODO Auto-generated method stub
		return taiKhoanDao.ThemTaiKhoan(tk);
	}
	public boolean XoaTaiKhoan(TaiKhoan tk) throws RemoteException {
		// TODO Auto-generated method stub
		return taiKhoanDao.XoaTaiKhoan(tk);
	}
	public boolean ResetMatKhau(TaiKhoan tk) throws RemoteException {
		// TODO Auto-generated method stub
		return taiKhoanDao.ResetMatKhau(tk);
	}
	public boolean DoiMatKhau(TaiKhoan tk) throws RemoteException {
		// TODO Auto-generated method stub
		return taiKhoanDao.DoiMatKhau(tk);
	}
	
	
}
