package entity;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "MonHoc")
public class MonHoc implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6998625235358362537L;
	@Id
	@Column(name="MaMH")
	private String maMH;
	
	@Column(name = "TenMH",nullable = false, columnDefinition = "nvarchar(50)")
	private String tenMH;
	
	
	@OneToMany(mappedBy = "monHoc")
	private List<CauHoiThi> listCHT;
	
	@ManyToOne
	@JoinColumn(name="maGV")
	private GiangVien giangVien;
	

	
	@OneToMany(mappedBy = "monHoc")
	private List<KetQua> listKQ;
	
	@OneToMany(mappedBy = "monHoc")
	private List<Thi> listThi;

	

	

	public List<Thi> getListThi() {
		return listThi;
	}


	public void setListThi(List<Thi> listThi) {
		this.listThi = listThi;
	}


	public List<KetQua> getListKQ() {
		return listKQ;
	}


	public void setListKQ(List<KetQua> listKQ) {
		this.listKQ = listKQ;
	}





	

	public MonHoc(String maMH, String tenMH) {
		super();
		this.maMH = maMH;
		this.tenMH = tenMH;
	}


	public MonHoc() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "MonHoc [maMH=" + maMH + ", tenMH=" + tenMH + ", listCHT=" + listCHT + ", giangVien=" + giangVien + "]";
	}

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

	public List<CauHoiThi> getListCHT() {
		return listCHT;
	}

	public void setListCHT(List<CauHoiThi> listCHT) {
		this.listCHT = listCHT;
	}
	

	public GiangVien getGiangVien() {
		return giangVien;
	}

	public void setGiangVien(GiangVien giangVien) {
		this.giangVien = giangVien;
	}
	
	
	
	
}
