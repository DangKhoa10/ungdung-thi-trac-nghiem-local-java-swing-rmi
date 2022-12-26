package service;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import dto.KetQuaMonHoc;
import dto.KetQuaSinhVien;
import entity.KetQua;

public interface IKetQuaService extends Remote{
	public boolean themKQ(KetQua ketQua) throws RemoteException;
	public boolean xoaKQ(String maMH,String maSV)throws RemoteException;
	public boolean suaKQ(KetQua ketQua)throws RemoteException;
	public KetQua getKQSVMH(String maMH, String maSV) throws RemoteException;
	public List<KetQuaMonHoc> getDiemMHcuaSV(String maSV)throws RemoteException;
	public List<KetQuaSinhVien> getDiemSVcuaMH(String maMH)throws RemoteException;
}
