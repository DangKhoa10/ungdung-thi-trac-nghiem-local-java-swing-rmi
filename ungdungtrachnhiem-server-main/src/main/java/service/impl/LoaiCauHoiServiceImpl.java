package service.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import dao.ILoaiCauHoiDao;
import dao.impl.LoaiCauHoiDaoImpl;
import dao.impl.TaiKhoanDaoImpl;
import entity.LoaiCauHoi;
import service.ILoaiCauHoiService;

public class LoaiCauHoiServiceImpl extends UnicastRemoteObject implements ILoaiCauHoiService{
	/**
	 * 
	 */
	private static final long serialVersionUID = -9184572293154391283L;
	private ILoaiCauHoiDao loaiCauHoiDao;
	
	public LoaiCauHoiServiceImpl() throws RemoteException{
		loaiCauHoiDao = (ILoaiCauHoiDao) new LoaiCauHoiDaoImpl();
	}
	
	public List<LoaiCauHoi> getAllLoaiCauHoi() throws RemoteException {
		
		return loaiCauHoiDao.getAllLoaiCauHoi();
	}

	public LoaiCauHoi getLoaiCauHoi(int ma) throws RemoteException {
		// TODO Auto-generated method stub
		return loaiCauHoiDao.getLoaiCauHoi(ma);
	}

}
