package entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "TaiKhoan")
public class TaiKhoan implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1791028654919667523L;
	@Id
	@Column(name="Username",unique = true, nullable = false, columnDefinition = "varchar(50)")
	private String username;
	
	@Column(name = "Password", nullable = false, columnDefinition = "varchar(50)")
	private String password;
	
	@Column(name = "LoaiTK", nullable = false)
	private int loaiTK;
	
	@OneToOne()
	@JoinColumn(name="maSV")
	private SinhVien sinhVien;
	
	@OneToOne
	@JoinColumn(name="maGV")
	private GiangVien giangVien;
	

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getLoaiTK() {
		return loaiTK;
	}

	public void setLoaiTK(int loaiTK) {
		this.loaiTK = loaiTK;
	}
	

	public SinhVien getSinhVien() {
		return sinhVien;
	}

	public void setSinhVien(SinhVien sinhVien) {
		this.sinhVien = sinhVien;
	}

	public GiangVien getGiangVien() {
		return giangVien;
	}

	public void setGiangVien(GiangVien giangVien) {
		this.giangVien = giangVien;
	}

	public TaiKhoan(String username, String password, int loaiTK, SinhVien sinhVien, GiangVien giangVien) {
		super();
		this.username = username;
		this.password = password;
		this.loaiTK = loaiTK;
		this.sinhVien = sinhVien;
		this.giangVien = giangVien;
	}

	public TaiKhoan() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TaiKhoan(String username, String password, int loaiTK) {
		super();
		this.username = username;
		this.password = password;
		this.loaiTK = loaiTK;
	}

	@Override
	public String toString() {
		return "TaiKhoan [username=" + username + ", password=" + password + ", loaiTK=" + loaiTK + "]";
	}
	
	
	
	
}
