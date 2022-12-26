package entity;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "SinhVien")
public class SinhVien implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7913581815268796837L;
	@Id
	@Column(name="MaSV")
	private String maSV;
	
	@Column(name = "TenSV",nullable = false, columnDefinition = "nvarchar(50)")
	private String tenSV;
	
	@Column(name = "SDT",nullable = false, columnDefinition = "varchar(50)")
	private String sDT;
	
	@Column(name = "Email",nullable = false, columnDefinition = "varchar(50)")
	private String email;
	
	
	@OneToOne(mappedBy = "sinhVien")
	private TaiKhoan taiKhoan;
	
	@OneToMany(mappedBy = "sinhVien")
	private List<KetQua> listKQ;

	
	
	
	public List<KetQua> getListKQ() {
		return listKQ;
	}


	public void setListKQ(List<KetQua> listKQ) {
		this.listKQ = listKQ;
	}


	public String getMaSV() {
		return maSV;
	}
	

	public TaiKhoan getTaiKhoan() {
		return taiKhoan;
	}


	public void setTaiKhoan(TaiKhoan taiKhoan) {
		this.taiKhoan = taiKhoan;
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

	public String getsDT() {
		return sDT;
	}

	public void setsDT(String sDT) {
		this.sDT = sDT;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public SinhVien(String maSV) {
		super();
		this.maSV = maSV;
	}

	public SinhVien(String maSV, String tenSV, String sDT, String email) {
		super();
		this.maSV = maSV;
		this.tenSV = tenSV;
		this.sDT = sDT;
		this.email = email;
	}

	public SinhVien(String tenSV, String sDT, String email) {
		super();
		this.tenSV = tenSV;
		this.sDT = sDT;
		this.email = email;
	}

	public SinhVien() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	@Override
	public String toString() {
		return "SinhVien [maSV=" + maSV + ", tenSV=" + tenSV + ", sDT=" + sDT + ", email=" + email + "]";
	}
	
	
	
}
