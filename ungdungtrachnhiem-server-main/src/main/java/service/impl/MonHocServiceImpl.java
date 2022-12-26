package service.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import dao.IGiangVienDao;
import dao.IMonHocDao;
import dao.ITaiKhoanDao;
import dao.impl.GiangVienDaoImpl;
import dao.impl.MonHocDaoImpl;
import dao.impl.TaiKhoanDaoImpl;
import hibernateCfg.HibernateConfig;
import service.IGiangVienService;
import service.IMonHocService;
import service.ITaiKhoanService;
import entity.GiangVien;
import entity.MonHoc;
import entity.TaiKhoan;

public class MonHocServiceImpl extends UnicastRemoteObject implements IMonHocService{
	
	
	private static final long serialVersionUID = -1479081236579346559L;
	private IGiangVienDao giangVienDao;
	private IMonHocDao monHocDao;
	
	public MonHocServiceImpl() throws RemoteException {
		super();
		monHocDao = (IMonHocDao) new MonHocDaoImpl();
	}
	/**
	 * 
	 */

	public List<MonHoc> getAllMH() throws RemoteException {
		// TODO Auto-generated method stub
		return monHocDao.getAllMH();
	}

	public MonHoc getMonHoc(String maMH) throws RemoteException {
		// TODO Auto-generated method stub
		return monHocDao.getMonHoc(maMH);
	}

	public List<MonHoc> getMonHocByGiangVien(String tenGV) throws RemoteException {
		// TODO Auto-generated method stub
		return monHocDao.getMonHocByGiangVien(tenGV);
	}

	public boolean addMonHoc(MonHoc monHoc) throws RemoteException {
		// TODO Auto-generated method stub
		return monHocDao.addMonHoc(monHoc);
	}

	public boolean updateMonHoc(MonHoc monHoc) throws RemoteException {
		// TODO Auto-generated method stub
		return monHocDao.updateMonHoc(monHoc);
	}

	public boolean deleteMonHoc(String maMonHoc) throws RemoteException {
		// TODO Auto-generated method stub
		return monHocDao.deleteMonHoc(maMonHoc);
	}
	public int getStudentsFromMonHoc(String maMonHoc) throws RemoteException {
		// TODO Auto-generated method stub
		return monHocDao.getStudentsFromMonHoc(maMonHoc);
	}
	public List<MonHoc> getMonHocMaGiangVien(String maGV) throws RemoteException {
		// TODO Auto-generated method stub
		return monHocDao.getMonHocMaGiangVien(maGV);
	}

	

	
	
}
