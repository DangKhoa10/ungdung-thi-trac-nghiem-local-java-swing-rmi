package entity;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "LoaiCauHoi")
public class LoaiCauHoi implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6347770098780740359L;
	
	@Id
	@Column(name="MaLoai")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int maLoai;
	
	@Column(name = "TenLoai",unique = true, nullable = false, columnDefinition = "nvarchar(45)")
	private String tenLoai;
	
	@OneToMany(mappedBy = "loaiCauHoi")
	private List<CauHoiThi> listCH;

	
	public List<CauHoiThi> getListCH() {
		return listCH;
	}

	public void setListCH(List<CauHoiThi> listCH) {
		this.listCH = listCH;
	}

	public int getMaLoai() {
		return maLoai;
	}

	public void setMaLoai(int maLoai) {
		this.maLoai = maLoai;
	}

	public String getTenLoai() {
		return tenLoai;
	}

	public void setTenLoai(String tenLoai) {
		this.tenLoai = tenLoai;
	}

	public LoaiCauHoi(int maLoai, String tenLoai) {
		super();
		this.maLoai = maLoai;
		this.tenLoai = tenLoai;
	}

	
	public LoaiCauHoi(String tenLoai) {
		super();
		this.tenLoai = tenLoai;
	}

	public LoaiCauHoi(int maLoai) {
		super();
		this.maLoai = maLoai;
	}

	public LoaiCauHoi() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "LoaiCauHoi [maLoai=" + maLoai + ", tenLoai=" + tenLoai + "]";
	}
	
	
	
	
}
