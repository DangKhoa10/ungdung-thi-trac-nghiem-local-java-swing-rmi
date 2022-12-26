package GUI;

import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.Timer;

import entity.CauHoiThi;
import entity.DapAn;
import entity.KetQua;
import entity.MonHoc;
import entity.SinhVien;
import entity.Thi;
import service.ICauHoiThiService;
import service.IDapAnService;
import service.IKetQuaService;
import service.IMonHocService;
import service.IThiService;
import view.util.RMIUrl;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.Font;
import java.awt.Color;
import java.awt.FlowLayout;

public class GUI_Thi extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6144188789097558779L;

	private ArrayList<CauHoiThi> cauhoiAll = new ArrayList<>();
	private ArrayList<CauHoiThi> cauhoiKho = new ArrayList<>();
	private ArrayList<CauHoiThi> cauhoiDe = new ArrayList<>();
	private ArrayList<CauHoiThi> cauhoiThi = new ArrayList<>();
	private ArrayList<DapAn> dapAn = new ArrayList<>();
	private ArrayList<DapAn> dapAnNopBai = new ArrayList<>();
	
	private IThiService thiService;
	private ICauHoiThiService cauHoiThiService;
	private IKetQuaService ketQuaService;
	private IMonHocService monHocService;
	private IDapAnService dapAnService;
	private String rmiUrl = new RMIUrl().RMIUrl();
	private int maThi = -1;
	private String maSV= null;
	private String maMH = null;
	private float diem = 0;
	private JLabel lblMonThi;

	private JLabel lblTime;


	private JLabel lblKyThi;

	private Timer timer;
	private int phut;
	private int giay;

	private JButton btnNop;
	
	
	private ArrayList<JPanel> panelR = new ArrayList<JPanel>();
	private ArrayList<ButtonGroup> groupR = new ArrayList<ButtonGroup>();
	private ArrayList<JLabel> lblCauHoiR = new ArrayList<JLabel>();
	

	

	
	/**
	 * Create the panel.
	 * @throws RemoteException 
	 */
	public GUI_Thi(int maThi,String maSV) throws RemoteException {
		
		
		for(int i=0;i<200;i++) {
			panelR.add(new JPanel());
			groupR.add(new ButtonGroup());
			lblCauHoiR.add(new JLabel());
		}
		
		
		this.maThi = maThi;
		this.maSV = maSV;
		try {
			
			thiService = (IThiService) Naming.lookup("rmi://" + rmiUrl  + ":2910/iThi");
			cauHoiThiService = (ICauHoiThiService) Naming.lookup("rmi://" + rmiUrl  + ":2910/iCauHoiThi");
			ketQuaService = (IKetQuaService) Naming.lookup("rmi://" + rmiUrl  + ":2910/iKetQua");
			monHocService = (IMonHocService) Naming.lookup("rmi://" + rmiUrl  + ":2910/iMonHoc");
			dapAnService = (IDapAnService) Naming.lookup("rmi://" + rmiUrl  + ":2910/iDapAn");
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		getContentPane().setLayout(null);
		setSize(1174, 602);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1174, 76);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(204, 204, 153));
		panel_2.setBounds(0, 0, 1164, 32);
		panel.add(panel_2);
		panel_2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		 lblMonThi = new JLabel("Môn thi: ");
		 panel_2.add(lblMonThi);
		 lblMonThi.setForeground(new Color(153, 0, 0));
		 lblMonThi.setFont(new Font("Dialog", Font.BOLD, 15));
		 
		
		 
		 lblKyThi = new JLabel("Kỳ thi:");
		 lblKyThi.setFont(new Font("Tahoma", Font.PLAIN, 15));
		 lblKyThi.setBounds(10, 41, 255, 23);
		 panel.add(lblKyThi);
		
		 lblTime = new JLabel("60:00");
		lblTime.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTime.setBounds(592, 41, 45, 23);
		panel.add(lblTime);
		
		
	
		
	   btnNop = new JButton("Nộp bài");
	   btnNop.setBounds(997, 38, 152, 32);
		panel.add(btnNop);
		
		btnNop.setBackground(new Color(204, 204, 153));
		
		JLabel lblNewLabel = new JLabel("Thời gian còn lại");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(473, 39, 109, 27);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 70, 1142, 532);
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.Y_AXIS));
		
		JScrollPane scrollPane = new JScrollPane(panel_1);
		scrollPane.setBounds(10, 77, 1138, 475);
		getContentPane().add(scrollPane);
		
		//lấy thông tin thi
		Thi thi = thiService.GetLichThi(maThi);
		
		maMH = thi.getMonHoc().getMaMH();
		
		int phutLamBai = thi.getThoiGianLambai();
	
		
		//kiểm tra thời gian vào làm bài cho đến thời gian đóng đề có đủ thời gian làm bài không
		//set thời gian làm bài kết thúc đúng lúc thời gian đóng đề
		Date nht = new Date();
		
		int h = phutLamBai/60;
		int m = phutLamBai%60;
		nht.setHours(nht.getHours()+h);
		nht.setMinutes(nht.getMinutes()+m);
		nht.setSeconds(0);
		
		Date nht2 = new Date();
		if(nht.after(thi.getThoiGianDongDe())) {
			phutLamBai = Math.round((thi.getThoiGianDongDe().getTime() - nht2.getTime())/60000);
		}
		
		
		phut = phutLamBai-1;
		giay = 59;
		 
	        timer = new Timer(1000,new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					giay--;
				
					lblTime.setText(phut + ":" + giay);
					
					if(giay==-1) {
						giay = 59;
						phut--;
					
						lblTime.setText(phut + ":" + giay);
					}
					if(phut==0 && giay==0) {
						timer.stop();
						lblTime.setText("hết giờ");
						try {
							ChamBai();
						} catch (RemoteException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
		                
		               
		            
					
				}
			});
	        timer.setInitialDelay(0);
	        timer.start();//bắt đầu đếm ngược thời gian khi bắt đầu vào form thi
	        
	       
				
			

		
		

		lblMonThi.setText("Môn thi: "+thi.getMonHoc().getTenMH());
		lblKyThi.setText("Kỳ thi: " + thi.getTenKyThi());
		
		 
		int phantram = thi.getPhanTramCauHoiKho();
		int soCauHoi = thi.getSoCauHoi();
		int soCauKho = Math.round((phantram*soCauHoi)/100);
		int soCauDe = soCauHoi - soCauKho;
		
	
	
		
		
		//lấy câu hỏi thuộc môn học
		cauhoiAll = (ArrayList<CauHoiThi>) cauHoiThiService.GetCauHoiThiTheoMonHoc(thi.getMonHoc().getMaMH());
		
		
		if(cauhoiAll.size()==0)
			JOptionPane.showMessageDialog(this, "Môn học vẫn chưa có câu hỏi thi , liên hệ giáo viên bộ môn !!!");
		else {
			//phân loại câu hỏi 
			for(CauHoiThi c : cauhoiAll) {
				if(c.getLoaiCauHoi().getMaLoai() == 1)
					cauhoiKho.add(c);
				else
					cauhoiDe.add(c);
			}
			
			
			//tráo câu hỏi
			for (int i = 0; i < cauhoiKho.size(); i++) {
	            Collections.swap(cauhoiKho, new Random().nextInt(cauhoiKho.size()), new Random().nextInt(cauhoiKho.size()));
	        }
			for (int i = 0; i < cauhoiDe.size(); i++) {
	            Collections.swap(cauhoiDe, new Random().nextInt(cauhoiDe.size()), new Random().nextInt(cauhoiDe.size()));
	        }
			
			
			for (int i = 0; i < soCauKho; i++) {
	            cauhoiThi.add(cauhoiKho.get(i));
	        }
			for (int i = 0; i < soCauDe; i++) {
	            cauhoiThi.add(cauhoiDe.get(i));
	        }
			
			 for (int i = 0; i < this.cauhoiThi.size(); i++) {
				 
				 List<DapAn> listDA = dapAnService.GetDapAnTheoCauHoi(cauhoiThi.get(i).getMaCH());
		            createPanelCauHoi(i, panelR.get(i), groupR.get(i) , lblCauHoiR.get(i) , cauhoiThi.get(i).getNoiDungCH(),
		            		listDA.get(0), listDA.get(1),
		            		listDA.get(2), listDA.get(3));
		            panel_1.add(panelR.get(i));
		     }
		}
		
	
		btnNop.addActionListener(this);
		
	}
	

	
	private void createPanelCauHoi(int i, JPanel panel1, ButtonGroup group, JLabel lblNewLabel, String cauhoi, DapAn dapan1, DapAn dapan2, DapAn dapan3, DapAn dapan4) {

	
		
        panel1.setLayout(new GridLayout(0, 1, 0, 0));
        lblNewLabel.setText("Câu hỏi " + (i + 1) + " : " + cauhoi);
        panel1.add(lblNewLabel);

        JRadioButton rad1 = new JRadioButton(dapan1.getNoiDungDapAn());
        rad1.setActionCommand(dapan1.getMaDA()+"");
        panel1.add(rad1);

        JRadioButton rad2 = new JRadioButton(dapan2.getNoiDungDapAn());
        rad2.setActionCommand(dapan2.getMaDA()+"");
        panel1.add(rad2);

        JRadioButton rad3 = new JRadioButton(dapan3.getNoiDungDapAn());
        rad3.setActionCommand(dapan3.getMaDA()+"");
        panel1.add(rad3);

        JRadioButton rad4 = new JRadioButton(dapan4.getNoiDungDapAn());
        rad4.setActionCommand(dapan4.getMaDA()+"");
        panel1.add(rad4);

        group.add(rad1);
        group.add(rad2);
        group.add(rad3);
        group.add(rad4);

    }


	private void ChamBai() throws RemoteException {
		int cauDung = 0;
		for(CauHoiThi c : cauhoiThi) {
			try {
				List<DapAn> das = dapAnService.GetDapAnTheoCauHoi(c.getMaCH());
				for(DapAn da : das) {
					if(da.getDungSai())
						dapAn.add(da);
				}
			} catch (RemoteException e1) {
				e1.printStackTrace();
			}
		}
		
		for(int i=0;i<cauhoiThi.size();i++) {
			String gt = "-1";
			if(groupR.get(i).getSelection()!=null)
			  gt = groupR.get(i).getSelection().getActionCommand();
			dapAnNopBai.add(new DapAn(Integer.parseInt(gt)));
		}
		for(int i=0;i<cauhoiThi.size();i++) {
			if(dapAnNopBai.get(i).getMaDA()==dapAn.get(i).getMaDA())
				cauDung++;
		}
		diem =  Math.round(((cauDung*10)/cauhoiThi.size())*100)/100;
		JOptionPane.showMessageDialog(this, "Số câu đúng: " + cauDung + " Điểm: "+diem);
		KetQua kq = new KetQua(diem);
		kq.setMonHoc(new MonHoc(maMH,null));
		kq.setSinhVien(new SinhVien(maSV));
		ketQuaService.suaKQ(kq);
		dispose();
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o=e.getSource();
		if(o.equals(btnNop)) {
			int option = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn nộp bài thi không?");
			if(option == JOptionPane.OK_OPTION) {
				
				
				
				try {
					ChamBai();
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				
			}
		}
		
	}
}
