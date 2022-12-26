package dao;

import java.util.List;

import entity.GiangVien;
import entity.TaiKhoan;

public interface IGiangVienDao {
	public List<GiangVien> getAllGV();
	public GiangVien getGiangVien(String maGV);
	public List<GiangVien> getGiangVienByTen(String tenGV);
	public boolean addGiangVien(GiangVien giangVien);
	public boolean updateGiangVien(GiangVien giangVien);
	public boolean deleteGiangVien(String maGV);
}
