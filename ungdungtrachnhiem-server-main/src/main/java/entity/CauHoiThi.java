package entity;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "CauHoiThi")
public class CauHoiThi implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1997403998144653099L;
	@Id
	@Column(name="MaCH")
	private String maCH;
	
	@Column(name = "NoiDungCH",unique = true, nullable = false, columnDefinition = "nvarchar(250)")
	private String noiDungCH;
	
	@ManyToOne
	@JoinColumn(name="maLoai")
	private LoaiCauHoi loaiCauHoi;
	
	@ManyToOne
	@JoinColumn(name="maMH")
	private MonHoc monHoc;
	
	@OneToMany(mappedBy = "cauHoiThi")
	private List<DapAn> listDA;

	public String getMaCH() {
		return maCH;
	}
	

	public void setMaCH(String maCH) {
		this.maCH = maCH;
	}

	public String getNoiDungCH() {
		return noiDungCH;
	}

	public void setNoiDungCH(String noiDungCH) {
		this.noiDungCH = noiDungCH;
	}
	

	public LoaiCauHoi getLoaiCauHoi() {
		return loaiCauHoi;
	}

	public void setLoaiCauHoi(LoaiCauHoi loaiCauHoi) {
		this.loaiCauHoi = loaiCauHoi;
	}

	public MonHoc getMonHoc() {
		return monHoc;
	}

	public void setMonHoc(MonHoc monHoc) {
		this.monHoc = monHoc;
	}

	public List<DapAn> getListDA() {
		return listDA;
	}

	public void setListDA(List<DapAn> listDA) {
		this.listDA = listDA;
	}

	public CauHoiThi() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CauHoiThi(String maCH, String noiDungCH) {
		super();
		this.maCH = maCH;
		this.noiDungCH = noiDungCH;
	}
	

	public CauHoiThi(String maCH) {
		super();
		this.maCH = maCH;
	}


	

	@Override
	public String toString() {
		return "CauHoiThi [maCH=" + maCH + ", noiDungCH=" + noiDungCH + "]";
	}
	
	
}
