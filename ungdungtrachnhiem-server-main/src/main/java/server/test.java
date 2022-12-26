package server;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import dto.KetQuaMonHoc;
import dto.KetQuaSinhVien;
import entity.CauHoiThi;
import entity.GiangVien;
import entity.KetQua;
import entity.MonHoc;
import entity.SinhVien;
import entity.TaiKhoan;
import entity.Thi;
import service.ICauHoiThiService;
import service.IDapAnService;
import service.IGiangVienService;
import service.IKetQuaService;
import service.IMonHocService;
import service.ITaiKhoanService;
import service.IThiService;
import service.impl.CauHoiThiServiceImpl;
import service.impl.DapAnServiceImpl;
import service.impl.GiangVienServiceImpl;
import service.impl.KetQuaServiceImpl;
import service.impl.MonHocServiceImpl;
import service.impl.TaiKhoanServiceImpl;
import service.impl.ThiServiceImpl;

public class test {

	public static void main(String[] args) throws RemoteException {
		// TODO Auto-generated method stub
//		ITaiKhoanService taiKhoanService = new TaiKhoanServiceImpl();
//		TaiKhoan tk = new  TaiKhoan();
//		tk.setSinhVien(new SinhVien("SV0003"));
//		taiKhoanService.XoaTaiKhoan(tk);
		
		IKetQuaService ketQuaService =new KetQuaServiceImpl();
		for(KetQuaSinhVien k: ketQuaService.getDiemSVcuaMH("MH0001"))
			System.out.println(k);
		
		
	
		
	}

}
