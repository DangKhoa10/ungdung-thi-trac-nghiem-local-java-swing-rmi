package entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "KetQua")
@IdClass(KetQuaPK.class)
public class KetQua implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5828666369376943644L;
	@Id
	@Column(name="MaKQ")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int maKQ;
	
	@Column(name = "DiemThi",nullable=true)
	private float diemThi;

	@Id
	@ManyToOne
	@JoinColumn(name="maMH")
	private MonHoc monHoc;
	
	@Id
	@ManyToOne
	@JoinColumn(name="maSV")
	private SinhVien sinhVien;



	public float getDiemThi() {
		return diemThi;
	}

	public void setDiemThi(float diemThi) {
		this.diemThi = diemThi;
	}

	public MonHoc getMonHoc() {
		return monHoc;
	}

	public void setMonHoc(MonHoc monHoc) {
		this.monHoc = monHoc;
	}

	public SinhVien getSinhVien() {
		return sinhVien;
	}

	public void setSinhVien(SinhVien sinhVien) {
		this.sinhVien = sinhVien;
	}

	public KetQua(float diemThi) {
		super();
		this.diemThi = diemThi;
	}

	public KetQua() {
		super();
	}

	public int getMaKQ() {
		return maKQ;
	}

	public void setMaKQ(int maKQ) {
		this.maKQ = maKQ;
	}

	@Override
	public String toString() {
		return "KetQua [maKQ=" + maKQ + ", diemThi=" + diemThi + "]";
	}

	

	
	
	
}
