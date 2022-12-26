package service;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import entity.LoaiCauHoi;

public interface ILoaiCauHoiService extends Remote{
	public List<LoaiCauHoi> getAllLoaiCauHoi() throws RemoteException;
	public LoaiCauHoi getLoaiCauHoi(int ma)throws RemoteException;
}
