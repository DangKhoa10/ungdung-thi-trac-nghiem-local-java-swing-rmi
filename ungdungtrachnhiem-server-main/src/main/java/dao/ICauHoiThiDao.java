package dao;

import java.util.List;

import entity.CauHoiThi;

public interface ICauHoiThiDao {
	public boolean ThemCauHoiThi(CauHoiThi cauHoiThi);
	public boolean XoaCauHoiThi(CauHoiThi cauHoiThi);
	public boolean SuaCauHoiThi(CauHoiThi cauHoiThi);
	public List<CauHoiThi> GetCauHoiThiTheoMonHoc(String maMH);
	public List<CauHoiThi> GetAllCauHoiThi();
	public CauHoiThi GetCauHoiThiTheoMa(String maCH);
}
