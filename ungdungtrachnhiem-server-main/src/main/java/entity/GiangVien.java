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
@Table(name = "GiangVien")
public class GiangVien implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7719188295312713580L;
	@Id
	@Column(name="MaGV")
	private String maGV;
	
	
	@Column(name = "TenGV",nullable = false, columnDefinition = "nvarchar(50)")
	private String tenGV;
	
	@Column(name = "SDT",nullable = false, columnDefinition = "varchar(50)")
	private String sDT;
	
	@Column(name = "Email",nullable = false, columnDefinition = "varchar(50)")
	private String email;
	

	@OneToMany(mappedBy = "giangVien")
	private List<MonHoc> listMH;
	
	
	@OneToOne(mappedBy = "giangVien")
	private TaiKhoan taiKhoan;

	public String getMaGV() {
		return maGV;
	}

	public void setMaGV(String maGV) {
		this.maGV = maGV;
	}

	public String getTenGV() {
		return tenGV;
	}

	public void setTenGV(String tenGV) {
		this.tenGV = tenGV;
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
	
	

	public List<MonHoc> getListMH() {
		return listMH;
	}

	public void setListMH(List<MonHoc> listMH) {
		this.listMH = listMH;
	}

	public TaiKhoan getTaiKhoan() {
		return taiKhoan;
	}

	public void setTaiKhoan(TaiKhoan taiKhoan) {
		this.taiKhoan = taiKhoan;
	}

	public GiangVien(String maGV, String tenGV, String sDT, String email) {
		super();
		this.maGV = maGV;
		this.tenGV = tenGV;
		this.sDT = sDT;
		this.email = email;
	}

	public GiangVien() {
		super();
		// TODO Auto-generated constructor stub
	}

	public GiangVien(String tenGV, String sDT, String email) {
		super();
		this.tenGV = tenGV;
		this.sDT = sDT;
		this.email = email;
	}
	

	@Override
	public String toString() {
		return "GiangVien [maGV=" + maGV + ", tenGV=" + tenGV + ", sDT=" + sDT + ", email=" + email + "]";
	}
	
	
	
}
