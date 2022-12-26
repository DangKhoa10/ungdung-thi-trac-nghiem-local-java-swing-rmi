package dao;

import java.util.List;

import entity.SinhVien;

public interface ISinhVienDao {
	public List<SinhVien> getAllSV();
	public SinhVien getSinhVien(String maSV);
	public List<SinhVien> getSinhVienVienByTen(String tenSV);
	public boolean addSinhVien(SinhVien sinhVien);
	public boolean updateSinhVien(SinhVien sinhVien);
	public boolean deleteSinhVien(String sinhVien);
	public List<SinhVien> getSinhVienByMonHoc(String maMH);
}
