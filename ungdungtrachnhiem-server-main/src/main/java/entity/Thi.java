package entity;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Thi")
public class Thi implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="MaThi")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int maThi;
	
	@Column(name = "TenKyThi",nullable = false, columnDefinition = "nvarchar(50)")
	private String tenKyThi;
	
	@Column(name = "ThoiGianLambai",nullable = false)
	private int thoiGianLambai;
	
	@Column(name = "ThoiGianMoDe",nullable = false)
	private Date thoiGianMoDe;
	
	@Column(name = "ThoiGianDongDe",nullable = false)
	private Date thoiGianDongDe;
	
	@Column(name = "SoCauHoi",nullable = false)
	private int soCauHoi ;

	@Column(name = "PhanTramCauHoiKho",nullable = false)
	private int phanTramCauHoiKho ;

	@ManyToOne
	@JoinColumn(name="maMH")
	private MonHoc monHoc;
	
	
	
	public String getTenKyThi() {
		return tenKyThi;
	}

	public void setTenKyThi(String tenKyThi) {
		this.tenKyThi = tenKyThi;
	}

	public Date getThoiGianDongDe() {
		return thoiGianDongDe;
	}

	public void setThoiGianDongDe(Date thoiGianDongDe) {
		this.thoiGianDongDe = thoiGianDongDe;
	}

	public int getPhanTramCauHoiKho() {
		return phanTramCauHoiKho;
	}

	public void setPhanTramCauHoiKho(int phanTramCauHoiKho) {
		this.phanTramCauHoiKho = phanTramCauHoiKho;
	}

	public MonHoc getMonHoc() {
		return monHoc;
	}

	public void setMonHoc(MonHoc monHoc) {
		this.monHoc = monHoc;
	}

	public int getThoiGianLambai() {
		return thoiGianLambai;
	}

	public void setThoiGianLambai(int thoiGianLambai) {
		this.thoiGianLambai = thoiGianLambai;
	}

	public Date getThoiGianMoDe() {
		return thoiGianMoDe;
	}

	public void setThoiGianMoDe(Date thoiGianMoDe) {
		this.thoiGianMoDe = thoiGianMoDe;
	}

	public int getSoCauHoi() {
		return soCauHoi;
	}

	public void setSoCauHoi(int soCauHoi) {
		this.soCauHoi = soCauHoi;
	}

	public int getMaThi() {
		return maThi;
	}

	public void setMaThi(int maThi) {
		this.maThi = maThi;
	}

	public Thi() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Thi(String tenKyThi, int thoiGianLambai, Date thoiGianMoDe, Date thoiGianDongDe, int soCauHoi,
			int phanTramCauHoiKho, MonHoc monHoc) {
		super();
		this.tenKyThi = tenKyThi;
		this.thoiGianLambai = thoiGianLambai;
		this.thoiGianMoDe = thoiGianMoDe;
		this.thoiGianDongDe = thoiGianDongDe;
		this.soCauHoi = soCauHoi;
		this.phanTramCauHoiKho = phanTramCauHoiKho;
		this.monHoc = monHoc;
	}

	public Thi(int thoiGianLambai, Date thoiGianMoDe, int soCauHoi) {
		super();
		this.thoiGianLambai = thoiGianLambai;
		this.thoiGianMoDe = thoiGianMoDe;
		this.soCauHoi = soCauHoi;
	}

	@Override
	public String toString() {
		return "Thi [maThi=" + maThi + ", thoiGianLambai=" + thoiGianLambai + ", thoiGianMoDe=" + thoiGianMoDe
				+ ", soCauHoi=" + soCauHoi + "]";
	}
	
	
	
	
}
