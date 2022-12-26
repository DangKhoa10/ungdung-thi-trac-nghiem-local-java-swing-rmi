package dto;

import java.io.Serializable;

public class KetQuaSinhVien implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8247205080312546445L;
	private String maSV;
	private String tenSV;
	private String sdt;
	private String email;
	private float diem;
	public String getMaSV() {
		return maSV;
	}
	public void setMaSV(String maSV) {
		this.maSV = maSV;
	}
	public String getTenSV() {
		return tenSV;
	}
	public void setTenSV(String tenSV) {
		this.tenSV = tenSV;
	}
	public String getSdt() {
		return sdt;
	}
	public void setSdt(String sdt) {
		this.sdt = sdt;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public float getDiem() {
		return diem;
	}
	public void setDiem(float diem) {
		this.diem = diem;
	}
	public KetQuaSinhVien(String maSV, String tenSV, String sdt, String email, float diem) {
		super();
		this.maSV = maSV;
		this.tenSV = tenSV;
		this.sdt = sdt;
		this.email = email;
		this.diem = diem;
	}
	
	
	public KetQuaSinhVien() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "KetQuaSinhVien [maSV=" + maSV + ", tenSV=" + tenSV + ", sdt=" + sdt + ", email=" + email + ", diem="
				+ diem + "]";
	}
	
	
}
