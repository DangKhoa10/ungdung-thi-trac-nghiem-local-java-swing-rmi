package entity;

import java.util.Objects;

import jakarta.persistence.Embeddable;

@Embeddable
public class KetQuaPK {
	
	private int maKQ;
	private String sinhVien;
	private String monHoc;
	
	public KetQuaPK() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + maKQ;
		result = prime * result + ((monHoc == null) ? 0 : monHoc.hashCode());
		result = prime * result + ((sinhVien == null) ? 0 : sinhVien.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		KetQuaPK other = (KetQuaPK) obj;
		if (maKQ != other.maKQ)
			return false;
		if (monHoc == null) {
			if (other.monHoc != null)
				return false;
		} else if (!monHoc.equals(other.monHoc))
			return false;
		if (sinhVien == null) {
			if (other.sinhVien != null)
				return false;
		} else if (!sinhVien.equals(other.sinhVien))
			return false;
		return true;
	}

	

	

	
	
}
