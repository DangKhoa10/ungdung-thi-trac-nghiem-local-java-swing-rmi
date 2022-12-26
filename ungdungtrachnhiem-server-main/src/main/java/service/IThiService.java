package service;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import entity.Thi;

public interface IThiService extends Remote{
	public boolean ThemLichThi(Thi thi) throws RemoteException;
	public boolean XoaLichThi(Thi thi)throws RemoteException;
	public boolean SuaLichThi(Thi thi)throws RemoteException;
	public Thi GetLichThi(int ma)throws RemoteException;
	public List<Thi> GetAllLichThi()throws RemoteException;
	public List<Thi> GetAllLichThiTheoMon(String maMH)throws RemoteException;
	public List<Thi> GetThiTheoSinhVien(String maSV)throws RemoteException;
}
