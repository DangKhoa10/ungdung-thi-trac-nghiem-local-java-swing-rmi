package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.rmi.Naming;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import entity.GiangVien;
import entity.SinhVien;
import entity.TaiKhoan;
import service.IGiangVienService;
import service.ISinhVienService;
import service.ITaiKhoanService;
import view.util.RMIUrl;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Font;

public class GUI_Main extends JFrame implements ActionListener {

	private JLabel lblNgayGio;
	
	private GUI_QuanLyGiangVien gui_QuanLyGiangVien= new GUI_QuanLyGiangVien();
	private GUI_QuanLyMonHoc gui_QuanLyMonHoc= new GUI_QuanLyMonHoc();
	private GUI_QuanLySinhVien gui_QuanLySinhVien= new GUI_QuanLySinhVien();
	private GUI_XemLichThi gui_XemLichThi;
	private GUI_TaoLichThi gui_TaoLichThi;
	private GUI_QuanLyCauHoi gui_QuanLyCauHoi;
	private GUI_XemDiemGiangVien gui_XemDiemGiangVien;
	private GUI_XemDiemSinhVien gui_XemDiemSinhVien;
	private GUI_QuanLySinhVienLopHoc gui_DSHVMH= new GUI_QuanLySinhVienLopHoc();
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5616653837360477958L;
	private JPanel contentPane;
	private String rmiUrl = new RMIUrl().RMIUrl();

	private IGiangVienService giangVienService;
	private ISinhVienService sinhVienService;

	private JMenu mnQuanLy;

	private JMenu mnGiangVien;

	private JMenu mnSinhVien;

	

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					GUI_Main frame = new GUI_Main();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
//	
	
	

	/**
	 * Create the frame.
	 * @throws IOException 
	 */
	public GUI_Main(TaiKhoan tk) throws IOException {
		
		try {
			giangVienService = (IGiangVienService) Naming.lookup("rmi://" + rmiUrl  + ":2910/iGiangVien");
			sinhVienService = (ISinhVienService) Naming.lookup("rmi://" + rmiUrl  + ":2910/iSinhVien");
		} catch (Exception e) {
			// TODO: handle exception
		}
		if(tk.getLoaiTK()==1) {
			gui_QuanLyCauHoi= new GUI_QuanLyCauHoi(tk.getGiangVien().getMaGV());
			gui_TaoLichThi= new GUI_TaoLichThi(tk.getGiangVien().getMaGV());
			gui_XemDiemGiangVien= new GUI_XemDiemGiangVien(tk.getGiangVien().getMaGV());
		}
		if(tk.getLoaiTK()==2) {
			gui_XemLichThi=  new GUI_XemLichThi(tk.getSinhVien().getMaSV());
			gui_XemDiemSinhVien= new GUI_XemDiemSinhVien(tk.getSinhVien().getMaSV());
		}
		
		
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 1200, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		
		
		final JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, BorderLayout.CENTER);
		
		JPanel p = new JPanel();
		p.setLayout(new BorderLayout());
		p.setSize(1174, 612);
		p.setBackground(new Color(51, 153, 153));
		JLabel lbl = new JLabel("???ng d???ng thi tr??ch nghi???m");
		lbl.setHorizontalAlignment(JLabel.CENTER);
		lbl.setVerticalAlignment(JLabel.CENTER);
		lbl.setForeground(new Color(153, 0, 0));
		lbl.setFont(new Font("Dialog", Font.BOLD, 25));
		p.add(lbl,BorderLayout.NORTH);
		JLabel lbl2 = new JLabel();
		lbl2.setHorizontalAlignment(JLabel.CENTER);
		lbl2.setVerticalAlignment(JLabel.CENTER);
		ImageIcon img = new ImageIcon(GUI_Main.class.getResource("../img/bg100.png"));
		lbl2.setIcon(img);
		
		
		p.add(lbl2,BorderLayout.CENTER);
		tabbedPane.add(p);
		
		

		
		JMenuBar menuBar = new JMenuBar();
		contentPane.add(menuBar, BorderLayout.NORTH);

		JMenu mnHeThong = new JMenu("H??? th???ng");
		menuBar.add(mnHeThong);
		
		JMenuItem mntmDoiMatKhau = new JMenuItem("?????i m???t kh???u");
		mntmDoiMatKhau.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				GUI_DoiMatKhau gui =  new GUI_DoiMatKhau(tk);
				gui.setVisible(true);
				gui.setLocationRelativeTo(null);
			}
		});
		mnHeThong.add(mntmDoiMatKhau);
		mntmDoiMatKhau.setIcon(new ImageIcon(GUI_Main.class.getResource("../img/pw16.png")));
		
		JSeparator separator_6 = new JSeparator();
		mnHeThong.add(separator_6);

		JMenuItem mntmDangXuat = new JMenuItem("????ng xu???t");
		mntmDangXuat.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				GUI_DangNhap dn = new GUI_DangNhap();
				dn.setVisible(true);
				setVisible(false);
				dn.setLocationRelativeTo(null);
			}
		});
		mnHeThong.add(mntmDangXuat);
		mntmDangXuat.setIcon(new ImageIcon(GUI_Main.class.getResource("../img/logout16.png")));

		JSeparator separator = new JSeparator();
		mnHeThong.add(separator);

		JMenuItem mntmThoat = new JMenuItem("Tho??t");
		mnHeThong.add(mntmThoat);
		mntmThoat.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				@SuppressWarnings("static-access")
				int question = new JOptionPane().showConfirmDialog(null, "B???n c?? mu???n tho??t?", "Th??ng b??o",
						JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
				if (question == JOptionPane.YES_OPTION)
					System.exit(0);
			}
		});
		mntmThoat.setIcon(new ImageIcon(GUI_Main.class.getResource("../img/turn-off16.png")));

		 mnQuanLy = new JMenu("Qu???n l??");
		menuBar.add(mnQuanLy);

		JMenuItem mntmQLGiangVien = new JMenuItem("Gi???ng vi??n");
		mnQuanLy.add(mntmQLGiangVien);
		mntmQLGiangVien.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				tabbedPane.remove(tabbedPane.getSelectedComponent());
				tabbedPane.add(gui_QuanLyGiangVien.pnQLGiangVien);
			}
		});
		mntmQLGiangVien.setIcon(new ImageIcon(GUI_Main.class.getResource("../img/gv16.png")));

		JSeparator separator_1 = new JSeparator();
		mnQuanLy.add(separator_1);

		JMenuItem mntmQLSinhVien = new JMenuItem("Sinh vi??n");
		mnQuanLy.add(mntmQLSinhVien);
		mntmQLSinhVien.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				tabbedPane.remove(tabbedPane.getSelectedComponent());
				tabbedPane.add(gui_QuanLySinhVien.pnQLSInhVien);

			}
		});
		mntmQLSinhVien.setIcon(new ImageIcon(GUI_Main.class.getResource("../img/sv16.png")));
		JSeparator separator_2 = new JSeparator();
		mnQuanLy.add(separator_2);

		JMenuItem mntmQLMonHoc = new JMenuItem("M??n h???c");
		mnQuanLy.add(mntmQLMonHoc);
		
		JSeparator separator_7 = new JSeparator();
		mnQuanLy.add(separator_7);
		
		JMenuItem mntmDSHVMH = new JMenuItem("Danh s??ch h???c vi??n trong m??n h???c");
		mnQuanLy.add(mntmDSHVMH);
		mntmDSHVMH.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				tabbedPane.remove(tabbedPane.getSelectedComponent());
				tabbedPane.add(gui_DSHVMH);
				
			}
		});
		mntmQLMonHoc.setIcon(new ImageIcon(GUI_Main.class.getResource("../img/mh16.png")));
		mntmDSHVMH.setIcon(new ImageIcon(GUI_Main.class.getResource("../img/class16.png")));
		
		mntmQLMonHoc.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				tabbedPane.remove(tabbedPane.getSelectedComponent());
				tabbedPane.add(gui_QuanLyMonHoc.pnQLMonHoc);
				
			}
		});

		 mnGiangVien = new JMenu("Gi???ng vi??n");
		menuBar.add(mnGiangVien);

		JMenuItem mntmGVTaoLichThi = new JMenuItem("T???o l???ch thi");
		mnGiangVien.add(mntmGVTaoLichThi);
		mntmGVTaoLichThi.addActionListener(new ActionListener() {

			
			public void actionPerformed(ActionEvent e) {
				tabbedPane.remove(tabbedPane.getSelectedComponent());
				tabbedPane.add(gui_TaoLichThi);

			}
		});
		mntmGVTaoLichThi.setIcon(new ImageIcon(GUI_Main.class.getResource("../img/new16.png")));

		JSeparator separator_3 = new JSeparator();
		mnGiangVien.add(separator_3);

		JMenuItem mntmGVQLCauHoi = new JMenuItem("Qu???n l?? ng??n h??ng c??u h???i");
		mnGiangVien.add(mntmGVQLCauHoi);
		mntmGVQLCauHoi.addActionListener(new ActionListener() {

			
			public void actionPerformed(ActionEvent e) {
				tabbedPane.remove(tabbedPane.getSelectedComponent());
				tabbedPane.add(gui_QuanLyCauHoi);
			}
		});
		mntmGVQLCauHoi.setIcon(new ImageIcon(GUI_Main.class.getResource("../img/question16.png")));

		JSeparator separator_4 = new JSeparator();
		mnGiangVien.add(separator_4);

		JMenuItem mntmGVXemDiem = new JMenuItem("Xem ??i???m");
		mnGiangVien.add(mntmGVXemDiem);
		mntmGVXemDiem.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				tabbedPane.remove(tabbedPane.getSelectedComponent());
				tabbedPane.add(gui_XemDiemGiangVien);

			}
		});
		mntmGVXemDiem.setIcon(new ImageIcon(GUI_Main.class.getResource("../img/p16.png")));

		 mnSinhVien = new JMenu("Sinh vi??n");
		menuBar.add(mnSinhVien);

		JMenuItem mntmSVThamGiaThi = new JMenuItem("Tham gia thi");
		mnSinhVien.add(mntmSVThamGiaThi);
		mntmSVThamGiaThi.addActionListener(new ActionListener() {

			
			public void actionPerformed(ActionEvent e) {
				tabbedPane.remove(tabbedPane.getSelectedComponent());
				tabbedPane.add(gui_XemLichThi);

			}
		});
		mntmSVThamGiaThi.setIcon(new ImageIcon(GUI_Main.class.getResource("../img/thi16.png")));

		JSeparator separator_5 = new JSeparator();
		mnSinhVien.add(separator_5);

		JMenuItem mntmSVXemDiem = new JMenuItem("Xem ??i???m");
		mnSinhVien.add(mntmSVXemDiem);
		mntmSVXemDiem.addActionListener(new ActionListener() {

			
			public void actionPerformed(ActionEvent e) {
				tabbedPane.remove(tabbedPane.getSelectedComponent());
				tabbedPane.add(gui_XemDiemSinhVien);

			}
		});
		mntmSVXemDiem.setIcon(new ImageIcon(GUI_Main.class.getResource("../img/p16.png")));
		phanQuyen(tk.getLoaiTK());
	

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.SOUTH);
		panel.setLayout(new GridLayout(0, 2, 0, 0));
		
		
	
		String ht = "";
		if(tk.getLoaiTK()==1) {
			GiangVien giangVien = giangVienService.getGiangVien(tk.getGiangVien().getMaGV());
			ht = "H??? t??n gi???ng vi??n: " + giangVien.getTenGV();
		}
		if(tk.getLoaiTK()==2) {
			SinhVien sinhVien = sinhVienService.getSinhVien(tk.getSinhVien().getMaSV());
			ht = "H??? t??n sinh vi??n: " + sinhVien.getTenSV();
		}
		if(tk.getLoaiTK()==0) {
			ht = "Qu???n l??";
		}
		JLabel lblHoTen = new JLabel(ht);
		lblHoTen.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panel.add(lblHoTen);

		lblNgayGio = new JLabel("hh:mm:ss dd/mm/yyyy");
		lblNgayGio.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panel.add(lblNgayGio);
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
		TimerTask timerTask = new TimerTask() {
	            @Override
	            public void run() {
	            	lblNgayGio.setText(simpleDateFormat.format(new Date())); 
	            }
	        };
        long delay = 1000L;
        Timer timer = new Timer("Timer");
        timer.schedule(timerTask, 0, delay);
		
	}
	
	private void phanQuyen(int loaiTK) {
		if(loaiTK==0) {
			mnGiangVien.setEnabled(false);
			mnSinhVien.setEnabled(false);
		}
		if(loaiTK==1) {
			mnQuanLy.setEnabled(false);
			mnSinhVien.setEnabled(false);
		}
		if(loaiTK==2) {
			mnGiangVien.setEnabled(false);
			mnQuanLy.setEnabled(false);
		}
	}

	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

}
