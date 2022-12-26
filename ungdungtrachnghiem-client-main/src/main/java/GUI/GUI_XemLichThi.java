package GUI;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import entity.KetQua;
import entity.MonHoc;
import entity.Thi;
import service.IKetQuaService;
import service.IMonHocService;
import service.IThiService;
import view.util.RMIUrl;

import java.awt.Button;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

public class GUI_XemLichThi extends JPanel implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3123133941923143427L;
	
	private List<Thi> lichThi = new ArrayList<Thi>();
	private IMonHocService monHocService;
	private IThiService thiService;
	private IKetQuaService ketQuaService;
	private String rmiUrl = new RMIUrl().RMIUrl();
	private String maSV = null;
	private JTable table;
	private DefaultTableModel model;
	private JButton btnVaoThi;

	private JButton btnLamMoi;

		
	public GUI_XemLichThi(String maSV) throws RemoteException{
		this.maSV = maSV;
		try {
			
			thiService = (IThiService) Naming.lookup("rmi://" + rmiUrl  + ":2910/iThi");
			monHocService = (IMonHocService) Naming.lookup("rmi://" + rmiUrl  + ":2910/iMonHoc");
			ketQuaService = (IKetQuaService) Naming.lookup("rmi://" + rmiUrl  + ":2910/iKetQua");
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		setSize(1174, 612);
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 204, 153));
		panel.setBounds(0, 0, 1174, 43);
		add(panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblLchThi = new JLabel("Lịch Thi");
		lblLchThi.setForeground(new Color(153, 0, 0));
		lblLchThi.setFont(new Font("Dialog", Font.BOLD, 25));
		panel.add(lblLchThi);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 44, 1174, 540);
		panel_1.setLayout(null);
		add(panel_1);
		
		String[] tb = new String[] { "STT", "Môn thi","Tên kỳ thi", "Thời gian mở để","Thời gian đóng đề","Thời gian làm bài","Số câu hỏi"};
		model = new DefaultTableModel(tb,0);
		table = new JTable(model){
		      public boolean isCellEditable(int rowIndex, int colIndex) {
		          return false;   //Disallow the editing of any cell
		        }
		      };
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setFont(new Font("Tahoma", Font.PLAIN, 13));
		table.setBounds(10, 11, 1154, 518);
		JScrollPane paneS = new JScrollPane(table);
		paneS.setBounds(10, 63, 1154, 466);
		panel_1.add(paneS);
		
		table.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 12));
		table.getTableHeader().setOpaque(false);
		table.getTableHeader().setBackground(new Color(32, 136, 203));
		table.getTableHeader().setForeground(new Color(255,255,255));
		table.setRowHeight(25);
		
		
		table.setIntercellSpacing(new java.awt.Dimension(0, 0));
		table.setRowHeight(25);
		table.setSelectionBackground(new java.awt.Color(232, 57, 95));
		//table.setShowVerticalLines(false);
		table.setFocusable(false);
		
		btnVaoThi = new JButton("Vào Thi");
		btnVaoThi.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnVaoThi.setBounds(1001, 11, 163, 41);
		panel_1.add(btnVaoThi);
		
		 btnLamMoi = new JButton("Làm mới lịch thi");
		btnLamMoi.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnLamMoi.setBounds(831, 11, 163, 41);
		panel_1.add(btnLamMoi);
		table.getTableHeader().setReorderingAllowed(false);
		

		
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");

		lichThi = thiService.GetThiTheoSinhVien(maSV);
		int i=0;
		
		
		for(Thi thi : lichThi) {
			MonHoc MH = monHocService.getMonHoc(thi.getMonHoc().getMaMH());
			model.addRow(new Object[] { 
					i+1,
					MH.getTenMH(),thi.getTenKyThi(),
					simpleDateFormat.format(thi.getThoiGianMoDe()) + " " + thi.getThoiGianMoDe().getHours() + " giờ " + thi.getThoiGianMoDe().getMinutes() + " phút",
					simpleDateFormat.format(thi.getThoiGianDongDe()) + " " + thi.getThoiGianDongDe().getHours() + " giờ " + thi.getThoiGianDongDe().getMinutes() + " phút",
					thi.getThoiGianLambai() + " phút", thi.getSoCauHoi()
			});
			i++;
		}
		
		


		 
		btnLamMoi.setBackground(new Color(204, 204, 153));
		btnVaoThi.setBackground(new Color(204, 204, 153));
		panel_1.setBackground(new Color(51, 153, 153));
		 btnVaoThi.addActionListener(this);
		 btnLamMoi.addActionListener(this);
		 
		 
		}



	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(o.equals(btnVaoThi)) {
			int row = -1;
			row = table.getSelectedRow();
			if(row == -1) {
				JOptionPane.showMessageDialog(this, "Vui lòng chọn môn muốn thi!!!");
				
			}else {
				Thi thi = lichThi.get(row);
				KetQua kq = null;
				try {
					kq = ketQuaService.getKQSVMH(thi.getMonHoc().getMaMH(), maSV);
				} catch (RemoteException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				if(kq.getDiemThi()==-1) {
					
					Date ngayhientai = new Date();
					if(ngayhientai.before(thi.getThoiGianMoDe())) {
						JOptionPane.showMessageDialog(this, "Vẫn chưa đến thời gian mở thi , vui lòng quay lại sau !!!");
					}else if(ngayhientai.after(thi.getThoiGianDongDe())) {
						JOptionPane.showMessageDialog(this, "Thời gian mở đề thi đã kết thúc !!!");
					}else {
						GUI_Thi gui_Thi;
						try {
							gui_Thi = new GUI_Thi(thi.getMaThi(),maSV);
							gui_Thi.setVisible(true);
						} catch (RemoteException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
					}
				}
				else {
					JOptionPane.showMessageDialog(this, "Bạn đã có kết quả thi!!!");
				}
				
			}
			
		}
		if(o.equals(btnLamMoi)) {
			DefaultTableModel dtm = (DefaultTableModel) table.getModel();
			dtm.setRowCount(0);
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");

			try {
				lichThi = thiService.GetThiTheoSinhVien(maSV);
			} catch (RemoteException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			int i=0;
			
			
			for(Thi thi : lichThi) {
				MonHoc MH = null;
				try {
					MH = monHocService.getMonHoc(thi.getMonHoc().getMaMH());
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				model.addRow(new Object[] { 
						i+1,
						MH.getTenMH(),thi.getTenKyThi(),
						simpleDateFormat.format(thi.getThoiGianMoDe()) + " " + thi.getThoiGianMoDe().getHours() + " giờ " + thi.getThoiGianMoDe().getMinutes() + " phút",
						simpleDateFormat.format(thi.getThoiGianDongDe()) + " " + thi.getThoiGianDongDe().getHours() + " giờ " + thi.getThoiGianDongDe().getMinutes() + " phút",
						thi.getThoiGianLambai() + " phút", thi.getSoCauHoi()
				});
				i++;
			}
			
			

		}
	}
}
