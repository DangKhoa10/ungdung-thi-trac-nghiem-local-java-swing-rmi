package service.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import dao.ICauHoiThiDao;
import dao.impl.CauHoiThiDaoImpl;
import entity.CauHoiThi;
import service.ICauHoiThiService;

public class CauHoiThiServiceImpl extends UnicastRemoteObject implements ICauHoiThiService{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4133772548111799168L;
	private ICauHoiThiDao cauHoiThiDao;
	
	public CauHoiThiServiceImpl() throws RemoteException {
		cauHoiThiDao = new CauHoiThiDaoImpl();
	}

	public boolean ThemCauHoiThi(CauHoiThi cauHoiThi) throws RemoteException {
		// TODO Auto-generated method stub
		return cauHoiThiDao.ThemCauHoiThi(cauHoiThi);
	}

	public boolean XoaCauHoiThi(CauHoiThi cauHoiThi) throws RemoteException {
		// TODO Auto-generated method stub
		return cauHoiThiDao.XoaCauHoiThi(cauHoiThi);
	}

	public boolean SuaCauHoiThi(CauHoiThi cauHoiThi) throws RemoteException {
		// TODO Auto-generated method stub
		return cauHoiThiDao.SuaCauHoiThi(cauHoiThi);
	}

	public List<CauHoiThi> GetCauHoiThiTheoMonHoc(String maMH) throws RemoteException {
		// TODO Auto-generated method stub
		return cauHoiThiDao.GetCauHoiThiTheoMonHoc(maMH);
	}

	public List<CauHoiThi> GetAllCauHoiThi() throws RemoteException {
		// TODO Auto-generated method stub
		return cauHoiThiDao.GetAllCauHoiThi();
	}

	public CauHoiThi GetCauHoiThiTheoMa(String maCH) throws RemoteException {
		// TODO Auto-generated method stub
		return cauHoiThiDao.GetCauHoiThiTheoMa(maCH);
	}

}
