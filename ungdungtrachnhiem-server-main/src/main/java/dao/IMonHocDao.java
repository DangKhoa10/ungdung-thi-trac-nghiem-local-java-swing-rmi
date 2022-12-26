package dao;

import java.util.List;

import entity.GiangVien;
import entity.MonHoc;
import entity.SinhVien;
import entity.TaiKhoan;

public interface IMonHocDao {
	public List<MonHoc> getAllMH();
	public MonHoc getMonHoc(String maMH);
	public List<MonHoc> getMonHocByGiangVien(String tenGV);
	public boolean addMonHoc(MonHoc monHoc);
	public boolean updateMonHoc(MonHoc monHoc);
	public boolean deleteMonHoc(String maMonHoc);
	public int getStudentsFromMonHoc(String maMonHoc);
	public List<MonHoc> getMonHocMaGiangVien(String maGV);
}
