package dto;

import java.io.Serializable;

public class KetQuaMonHoc implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1221272639372552501L;
	private String maMH;
	private String tenMH;
	private float diem;
	public String getMaMH() {
		return maMH;
	}
	public void setMaMH(String maMH) {
		this.maMH = maMH;
	}
	public String getTenMH() {
		return tenMH;
	}
	public void setTenMH(String tenMH) {
		this.tenMH = tenMH;
	}
	public float getDiem() {
		return diem;
	}
	public void setDiem(float diem) {
		this.diem = diem;
	}
	public KetQuaMonHoc(String maMH, String tenMH, float diem) {
		super();
		this.maMH = maMH;
		this.tenMH = tenMH;
		this.diem = diem;
	}
	public KetQuaMonHoc() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "KetQuaMonHoc [maMH=" + maMH + ", tenMH=" + tenMH + ", diem=" + diem + "]";
	}
	
	
	
}
