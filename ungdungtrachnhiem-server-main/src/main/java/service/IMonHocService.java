package service;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;


import entity.MonHoc;


public interface IMonHocService extends Remote{
	public List<MonHoc> getAllMH() throws RemoteException;;
	public MonHoc getMonHoc(String maMH) throws RemoteException;;
	public List<MonHoc> getMonHocByGiangVien(String tenGV) throws RemoteException;;
	public boolean addMonHoc(MonHoc monHoc) throws RemoteException;;
	public boolean updateMonHoc(MonHoc monHoc) throws RemoteException;;
	public boolean deleteMonHoc(String maMonHoc) throws RemoteException;;
	public int getStudentsFromMonHoc(String maMonHoc) throws RemoteException;
	public List<MonHoc> getMonHocMaGiangVien(String maGV) throws RemoteException;
}
