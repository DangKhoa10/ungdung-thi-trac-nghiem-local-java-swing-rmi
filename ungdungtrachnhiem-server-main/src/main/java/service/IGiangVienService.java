package service;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import entity.GiangVien;

public interface IGiangVienService extends Remote{
	public List<GiangVien> getAllGV() throws RemoteException;
	public GiangVien getGiangVien(String maGV) throws RemoteException;
	public List<GiangVien> getGiangVienByTen(String tenGV) throws RemoteException;
	public boolean addGiangVien(GiangVien giangVien) throws RemoteException;
	public boolean updateGiangVien(GiangVien giangVien) throws RemoteException;
	public boolean deleteGiangVien(String maGV) throws RemoteException;
}
