package dao;

import java.util.List;

import entity.LoaiCauHoi;


public interface ILoaiCauHoiDao {
	public List<LoaiCauHoi> getAllLoaiCauHoi();
	public LoaiCauHoi getLoaiCauHoi(int ma);
}
