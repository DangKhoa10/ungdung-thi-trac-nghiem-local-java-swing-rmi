package service.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import dao.IGiangVienDao;
import dao.ITaiKhoanDao;
import dao.impl.GiangVienDaoImpl;
import dao.impl.TaiKhoanDaoImpl;
import hibernateCfg.HibernateConfig;
import service.IGiangVienService;
import service.ITaiKhoanService;
import entity.GiangVien;
import entity.TaiKhoan;

public class GiangVienServiceImpl extends UnicastRemoteObject implements IGiangVienService{
	
	
	private static final long serialVersionUID = -1479081236579346559L;
	private IGiangVienDao giangVienDao;
	
	public GiangVienServiceImpl() throws RemoteException {
		super();
		giangVienDao = (IGiangVienDao) new GiangVienDaoImpl();
	}
	/**
	 * 
	 */

	public List<GiangVien> getAllGV() throws RemoteException {
		// TODO Auto-generated method stub
		return giangVienDao.getAllGV();
	}

	public GiangVien getGiangVien(String maGV) throws RemoteException {
		// TODO Auto-generated method stub
		return giangVienDao.getGiangVien(maGV);
	}

	public boolean addGiangVien(GiangVien giangVien) throws RemoteException {
		// TODO Auto-generated method stub
		return giangVienDao.addGiangVien(giangVien);
	}

	public boolean updateGiangVien(GiangVien giangVien) throws RemoteException {
		// TODO Auto-generated method stub
		return giangVienDao.updateGiangVien(giangVien);
	}

	public boolean deleteGiangVien(String maGV) throws RemoteException {
		// TODO Auto-generated method stub
		return giangVienDao.deleteGiangVien(maGV);
	}
	public List<GiangVien> getGiangVienByTen(String tenGV) throws RemoteException {
		// TODO Auto-generated method stub
		return giangVienDao.getGiangVienByTen(tenGV);
	}
	

	
	
}
