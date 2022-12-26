package dao;

import java.util.List;

import entity.DapAn;

public interface IDapAnDao {
	public boolean ThemDapAn(DapAn dapAn);
	public boolean SuaDapAn(DapAn dapAn);
	public boolean XoaDapAn(DapAn dapAn);
	public boolean XoaDapAnThuocCauHoi(String maCH);
	public List<DapAn> GetDapAnTheoCauHoi(String maCH);
}
