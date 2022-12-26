package service.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import dao.IDapAnDao;
import dao.impl.DapAnDaoImpl;
import entity.DapAn;
import service.IDapAnService;

public class DapAnServiceImpl extends UnicastRemoteObject implements IDapAnService{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1603176519929597586L;
	private IDapAnDao dapAnDao;
	
	public DapAnServiceImpl() throws RemoteException {
		dapAnDao = new DapAnDaoImpl();
	}

	public boolean ThemDapAn(DapAn dapAn) throws RemoteException {
		
		return dapAnDao.ThemDapAn(dapAn);
	}

	public boolean XoaDapAn(DapAn dapAn) throws RemoteException {
		// TODO Auto-generated method stub
		return dapAnDao.XoaDapAn(dapAn);
	}

	public boolean XoaDapAnThuocCauHoi(String maCH) throws RemoteException {
		// TODO Auto-generated method stub
		return dapAnDao.XoaDapAnThuocCauHoi(maCH);
	}

	public List<DapAn> GetDapAnTheoCauHoi(String maCH) throws RemoteException {
		// TODO Auto-generated method stub
		return dapAnDao.GetDapAnTheoCauHoi(maCH);
	}

	public boolean SuaDapAn(DapAn dapAn) throws RemoteException {
		// TODO Auto-generated method stub
		return dapAnDao.SuaDapAn(dapAn);
	}

}
