package dao;

import java.util.List;

import dto.KetQuaMonHoc;
import dto.KetQuaSinhVien;
import entity.KetQua;

public interface IKetQuaDao {
	public boolean themKQ(KetQua ketQua);
	public boolean xoaKQ(String maMH,String maSV);
	public boolean suaKQ(KetQua ketQua);
	public KetQua getKQSVMH(String maMH,String maSV);
	public List<KetQuaMonHoc> getDiemMHcuaSV(String maSV);
	public List<KetQuaSinhVien> getDiemSVcuaMH(String maMH);
}
