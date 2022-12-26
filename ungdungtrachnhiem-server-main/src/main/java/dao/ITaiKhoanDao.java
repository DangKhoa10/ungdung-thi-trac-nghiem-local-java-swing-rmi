package dao;

import java.util.List;

import entity.TaiKhoan;

public interface ITaiKhoanDao {
	public TaiKhoan getTaiKhoan(String taiKhoan) ;
	public List<TaiKhoan> getAllTaiKhoan();
	public TaiKhoan getTaiKhoanByUserNamePassword(String taiKhoan, String matKhau);
	public boolean ThemTaiKhoan(TaiKhoan tk);
	public boolean XoaTaiKhoan(TaiKhoan tk);
	public boolean ResetMatKhau(TaiKhoan tk);
	public boolean DoiMatKhau(TaiKhoan tk);
}
