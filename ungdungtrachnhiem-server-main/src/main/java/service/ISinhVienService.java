package service;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import entity.SinhVien;

public interface ISinhVienService extends Remote {
	public List<SinhVien> getAllSV() throws RemoteException;

	public SinhVien getSinhVien(String maSV) throws RemoteException;

	public List<SinhVien> getSinhVienVienByTen(String tenSV) throws RemoteException;

	public boolean addSinhVien(SinhVien sinhVien) throws RemoteException;

	public boolean updateSinhVien(SinhVien sinhVien) throws RemoteException;

	public boolean deleteSinhVien(String sinhVien) throws RemoteException;
	public List<SinhVien> getSinhVienByMonHoc(String maMH)throws RemoteException;
}
