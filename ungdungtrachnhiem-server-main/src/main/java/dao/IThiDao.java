package dao;

import java.util.List;

import entity.Thi;

public interface IThiDao {
	public boolean ThemLichThi(Thi thi);
	public boolean XoaLichThi(Thi thi);
	public boolean SuaLichThi(Thi thi);
	public Thi GetLichThi(int ma);
	public List<Thi> GetAllLichThi();
	public List<Thi> GetAllLichThiTheoMon(String maMH);
	public List<Thi> GetThiTheoSinhVien(String maSV);
}
