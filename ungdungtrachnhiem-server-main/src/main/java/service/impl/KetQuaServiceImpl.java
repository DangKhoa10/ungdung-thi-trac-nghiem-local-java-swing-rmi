package service.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import dao.IKetQuaDao;
import dao.impl.KetQuaDaoImpl;
import dto.KetQuaMonHoc;
import dto.KetQuaSinhVien;
import entity.KetQua;
import service.IKetQuaService;

public class KetQuaServiceImpl extends UnicastRemoteObject implements IKetQuaService{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7416333221508257576L;
	private IKetQuaDao ketQuaDao;

	public KetQuaServiceImpl() throws RemoteException {
		super();
		ketQuaDao = new KetQuaDaoImpl();
	}

	public boolean themKQ(KetQua ketQua) throws RemoteException {
		// TODO Auto-generated method stub
		return ketQuaDao.themKQ(ketQua);
	}

	public boolean xoaKQ(String maMH,String maSV) throws RemoteException {
		// TODO Auto-generated method stub
		return ketQuaDao.xoaKQ(maMH,maSV);
	}

	public boolean suaKQ(KetQua ketQua) throws RemoteException {
		// TODO Auto-generated method stub
		return ketQuaDao.suaKQ(ketQua);
	}

	public KetQua getKQSVMH(String maMH, String maSV) throws RemoteException {
		// TODO Auto-generated method stub
		return ketQuaDao.getKQSVMH(maMH, maSV);
	}

	public List<KetQuaMonHoc> getDiemMHcuaSV(String maSV) throws RemoteException {
		// TODO Auto-generated method stub
		return ketQuaDao.getDiemMHcuaSV(maSV);
	}

	public List<KetQuaSinhVien> getDiemSVcuaMH(String maMH) throws RemoteException {
		// TODO Auto-generated method stub
		return ketQuaDao.getDiemSVcuaMH(maMH);
	}

}
