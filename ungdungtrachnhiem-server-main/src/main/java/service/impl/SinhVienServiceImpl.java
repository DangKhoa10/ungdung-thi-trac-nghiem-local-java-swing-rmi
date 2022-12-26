package service.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import dao.IGiangVienDao;
import dao.ISinhVienDao;
import dao.ITaiKhoanDao;
import dao.impl.GiangVienDaoImpl;
import dao.impl.SinhVienDaoImpl;
import dao.impl.TaiKhoanDaoImpl;
import hibernateCfg.HibernateConfig;
import service.IGiangVienService;
import service.ISinhVienService;
import service.ITaiKhoanService;
import entity.GiangVien;
import entity.SinhVien;
import entity.TaiKhoan;

public class SinhVienServiceImpl extends UnicastRemoteObject implements ISinhVienService{
	
	
	private static final long serialVersionUID = -1479081236579346559L;
	private ISinhVienDao sinhVienDao;
	
	public SinhVienServiceImpl() throws RemoteException {
		super();
		sinhVienDao = (ISinhVienDao) new SinhVienDaoImpl();
	}
	/**
	 * 
	 */

	public List<SinhVien> getAllSV() throws RemoteException {
		// TODO Auto-generated method stub
		return sinhVienDao.getAllSV();
	}

	public SinhVien getSinhVien(String maSV) throws RemoteException {
		// TODO Auto-generated method stub
		return sinhVienDao.getSinhVien(maSV);
	}

	public List<SinhVien> getSinhVienVienByTen(String tenSV) throws RemoteException {
		// TODO Auto-generated method stub
		return sinhVienDao.getSinhVienVienByTen(tenSV);
	}

	public boolean addSinhVien(SinhVien sinhVien) throws RemoteException {
		// TODO Auto-generated method stub
		return sinhVienDao.addSinhVien(sinhVien);
	}

	public boolean updateSinhVien(SinhVien sinhVien) throws RemoteException {
		// TODO Auto-generated method stub
		return sinhVienDao.updateSinhVien(sinhVien);
	}

	public boolean deleteSinhVien(String sinhVien) throws RemoteException {
		// TODO Auto-generated method stub
		return sinhVienDao.deleteSinhVien(sinhVien);
	}
	public List<SinhVien> getSinhVienByMonHoc(String maMH) throws RemoteException {
		// TODO Auto-generated method stub
		return sinhVienDao.getSinhVienByMonHoc(maMH);
	}

	

	
	
}
