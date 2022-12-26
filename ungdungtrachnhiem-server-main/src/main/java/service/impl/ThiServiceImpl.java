package service.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import dao.IThiDao;
import dao.impl.ThiDaoImpl;
import entity.Thi;
import service.IThiService;

public class ThiServiceImpl extends UnicastRemoteObject implements IThiService{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1845430414168374334L;
	private IThiDao thiDao;
	public ThiServiceImpl() throws RemoteException {
		thiDao = new ThiDaoImpl();
	}

	public boolean ThemLichThi(Thi thi) throws RemoteException {
		// TODO Auto-generated method stub
		return thiDao.ThemLichThi(thi);
	}

	public boolean XoaLichThi(Thi thi) throws RemoteException {
		// TODO Auto-generated method stub
		return thiDao.XoaLichThi(thi);
	}

	public boolean SuaLichThi(Thi thi) throws RemoteException {
		// TODO Auto-generated method stub
		return thiDao.SuaLichThi(thi);
	}

	public Thi GetLichThi(int ma) throws RemoteException {
		// TODO Auto-generated method stub
		return thiDao.GetLichThi(ma);
	}

	public List<Thi> GetAllLichThi() throws RemoteException {
		// TODO Auto-generated method stub
		return thiDao.GetAllLichThi();
	}

	public List<Thi> GetAllLichThiTheoMon(String maMH) throws RemoteException {
		// TODO Auto-generated method stub
		return thiDao.GetAllLichThiTheoMon(maMH);
	}

	public List<Thi> GetThiTheoSinhVien(String maSV) throws RemoteException {
		// TODO Auto-generated method stub
		return thiDao.GetThiTheoSinhVien(maSV);
	}

}
