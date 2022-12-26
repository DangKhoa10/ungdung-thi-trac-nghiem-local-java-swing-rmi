package service;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import entity.CauHoiThi;

public interface ICauHoiThiService extends Remote{
	public boolean ThemCauHoiThi(CauHoiThi cauHoiThi) throws RemoteException;
	public boolean XoaCauHoiThi(CauHoiThi cauHoiThi) throws RemoteException;
	public boolean SuaCauHoiThi(CauHoiThi cauHoiThi) throws RemoteException;
	public List<CauHoiThi> GetCauHoiThiTheoMonHoc(String maMH) throws RemoteException;
	public List<CauHoiThi> GetAllCauHoiThi() throws RemoteException;
	public CauHoiThi GetCauHoiThiTheoMa(String maCH) throws RemoteException;
}
