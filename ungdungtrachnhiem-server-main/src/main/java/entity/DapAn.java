package entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "DapAn")
public class DapAn implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1945245752193916085L;
	@Id
	@Column(name="MaDA")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int maDA;
	
	@Column(name = "NoiDungDA", columnDefinition = "nvarchar(250)")
	private String noiDungDapAn;
	@Column(name = "DungSai")
	private boolean dungSai;
	
	@ManyToOne
	@JoinColumn(name="maCH")
	private CauHoiThi cauHoiThi;
	
	public int getMaDA() {
		return maDA;
	}
	public void setMaDA(int maDA) {
		this.maDA = maDA;
	}
	public String getNoiDungDapAn() {
		return noiDungDapAn;
	}
	public void setNoiDungDapAn(String noiDungDapAn) {
		this.noiDungDapAn = noiDungDapAn;
	}
	public boolean getDungSai() {
		return dungSai;
	}
	public void setDungSai(boolean dungSai) {
		this.dungSai = dungSai;
	}
	
	
	public CauHoiThi getCauHoiThi() {
		return cauHoiThi;
	}
	public void setCauHoiThi(CauHoiThi cauHoiThi) {
		this.cauHoiThi = cauHoiThi;
	}
	public DapAn(String noiDungDapAn, boolean dungSai, CauHoiThi cauHoiThi) {
		super();
		this.noiDungDapAn = noiDungDapAn;
		this.dungSai = dungSai;
		this.cauHoiThi = cauHoiThi;
	}
	public DapAn(int maDA, String noiDungDapAn, boolean dungSai) {
		super();
		this.maDA = maDA;
		this.noiDungDapAn = noiDungDapAn;
		this.dungSai = dungSai;
	}
	
	public DapAn(int maDA) {
		super();
		this.maDA = maDA;
	}
	public DapAn() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "DapAn [maDA=" + maDA + ", noiDungDapAn=" + noiDungDapAn + ", dungSai=" + dungSai + "]";
	}
	
	
	
}
