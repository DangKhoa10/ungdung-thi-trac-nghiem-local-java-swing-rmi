package server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.MalformedURLException;
import java.net.ServerSocket;
import java.net.Socket;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import entity.TaiKhoan;
import service.ICauHoiThiService;
import service.IDapAnService;
import service.IGiangVienService;
import service.IKetQuaService;
import service.ILoaiCauHoiService;
import service.IMonHocService;
import service.ISinhVienService;
import service.ITaiKhoanService;
import service.IThiService;
import service.impl.CauHoiThiServiceImpl;
import service.impl.DapAnServiceImpl;
import service.impl.GiangVienServiceImpl;
import service.impl.KetQuaServiceImpl;
import service.impl.LoaiCauHoiServiceImpl;
import service.impl.MonHocServiceImpl;
import service.impl.SinhVienServiceImpl;
import service.impl.TaiKhoanServiceImpl;
import service.impl.ThiServiceImpl;


public class Server {
		public Server(String host) throws RemoteException, NamingException {
			SecurityManager securityManager= System.getSecurityManager();
			if(securityManager==null) {
				System.setProperty("java.security.policy", "myrmi/myrmi.policy");
				System.setSecurityManager(new SecurityManager());
			}

			ITaiKhoanService iTaiKhoan = new TaiKhoanServiceImpl();
			IGiangVienService iGiangVien = new GiangVienServiceImpl();
			ISinhVienService iSinhVien = new SinhVienServiceImpl();
			IMonHocService iMonHoc = new MonHocServiceImpl();
			IDapAnService iDapAn = new DapAnServiceImpl();
			ICauHoiThiService iCauHoiThi = new CauHoiThiServiceImpl();
			ILoaiCauHoiService iLoaiCauHoi = new LoaiCauHoiServiceImpl();
			IThiService iThi = new ThiServiceImpl();
			IKetQuaService iKetQua = new KetQuaServiceImpl();
			LocateRegistry.createRegistry(2910);
			Context context=new  InitialContext();
			context.bind("rmi://"+host+":2910/iTaiKhoan", iTaiKhoan);
			context.bind("rmi://"+host+":2910/iGiangVien", iGiangVien);
			context.bind("rmi://"+host+":2910/iSinhVien", iSinhVien);
			context.bind("rmi://"+host+":2910/iMonHoc", iMonHoc);
			context.bind("rmi://"+host+":2910/iDapAn", iDapAn);
			context.bind("rmi://"+host+":2910/iCauHoiThi", iCauHoiThi);
			context.bind("rmi://"+host+":2910/iLoaiCauHoi", iLoaiCauHoi);
			context.bind("rmi://"+host+":2910/iThi", iThi);
			context.bind("rmi://"+host+":2910/iKetQua", iKetQua);
			System.out.println(host);
			System.out.println("ready");
		}
		public static void main(String[] args) throws RemoteException, NamingException, MalformedURLException, NotBoundException {
			new Server("192.168.0.106");

		}
		public static void shotDown(String host) throws RemoteException, MalformedURLException, NotBoundException {
			
		}

}


