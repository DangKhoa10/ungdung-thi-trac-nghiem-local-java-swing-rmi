package service;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import entity.TaiKhoan;

public interface ITaiKhoanService extends Remote{
	public TaiKhoan getTaiKhoan(String taiKhoan) throws RemoteException;
	public List<TaiKhoan> getAllTaiKhoan() throws RemoteException;
	public TaiKhoan getTaiKhoanByUserNamePassword(String taiKhoan, String matKhau) throws RemoteException;
	public boolean ThemTaiKhoan(TaiKhoan tk)throws RemoteException;
	public boolean XoaTaiKhoan(TaiKhoan tk)throws RemoteException;
	public boolean ResetMatKhau(TaiKhoan tk)throws RemoteException;
	public boolean DoiMatKhau(TaiKhoan tk)throws RemoteException;
}
