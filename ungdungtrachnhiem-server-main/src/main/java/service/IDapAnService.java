package service;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import entity.DapAn;

public interface IDapAnService extends Remote{
	public boolean ThemDapAn(DapAn dapAn) throws RemoteException;
	public boolean SuaDapAn(DapAn dapAn) throws RemoteException;
	public boolean XoaDapAn(DapAn dapAn)throws RemoteException;
	public boolean XoaDapAnThuocCauHoi(String maCH)throws RemoteException;
	public List<DapAn> GetDapAnTheoCauHoi(String maCH)throws RemoteException;
}
