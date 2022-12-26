package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Vector;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import entity.GiangVien;
import entity.SinhVien;
import entity.TaiKhoan;
import service.IGiangVienService;
import service.ISinhVienService;
import service.ITaiKhoanService;
import view.util.RMIUrl;

import javax.swing.border.EtchedBorder;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;



import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import java.awt.TextField;
import java.awt.FlowLayout;

public class GUI_QuanLySinhVien extends JFrame implements ActionListener, MouseListener {

	public static JPanel pnQLSInhVien;
	private JTextField txtten;
	private JTextField txtsdt;
	private JTable table;
	private DefaultTableModel model;
	private JButton btntimkiem;
	private JButton btnlammoitk;
	private ButtonGroup buttonGroupTim;
	private JButton btnlammoikh;
	private JButton btnxoa;
	private JButton btncapnhat;
	private JTextField txtTimKiemTheoMa;
	private JButton btnthem;
	private JTextField txtemail;
	private JTextField txtTimKiemTheoTen;
	private String rmiUrl = new RMIUrl().RMIUrl();
	private ISinhVienService sinhVienService;
	private ITaiKhoanService taiKhoanService;
	private JButton btnResetMK;
	private JTextField txtMa;
	private JLabel lblNewLabel_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_QuanLySinhVien frame = new GUI_QuanLySinhVien();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws RemoteException 
	 */
	public GUI_QuanLySinhVien() throws RemoteException {
		
		try {
			sinhVienService = (ISinhVienService) Naming.lookup("rmi://" + rmiUrl  + ":2910/iSinhVien");
			taiKhoanService = (ITaiKhoanService) Naming.lookup("rmi://" + rmiUrl  + ":2910/iTaiKhoan");
		} catch (Exception e) {
			// TODO: handle exception
		}
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1013, 706);
		pnQLSInhVien = new JPanel();
		
		pnQLSInhVien.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(pnQLSInhVien);
		this.setLocationRelativeTo(null);
		this.setSize(1186, 623);
		pnQLSInhVien.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 204, 153));
		panel.setBounds(0, 0, 1256, 47);
		pnQLSInhVien.add(panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel = new JLabel("Quản lý sinh viên");
		lblNewLabel.setForeground(new Color(153, 0, 0));
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 25));
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(51, 153, 153));
		panel_1.setBounds(0, 47, 1170, 184);
		pnQLSInhVien.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("Tên");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(50, 61, 36, 16);
		panel_1.add(lblNewLabel_3);
		
		txtten = new JTextField();
		txtten.setBounds(96, 57, 435, 26);
		panel_1.add(txtten);
		txtten.setColumns(10);
		
	
		
		JLabel lblNewLabel_5 = new JLabel("Số Điện Thoại");
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_5.setBounds(570, 61, 87, 16);
		panel_1.add(lblNewLabel_5);
		
		txtsdt = new JTextField();
		txtsdt.setBounds(667, 57, 435, 26);
		panel_1.add(txtsdt);
		txtsdt.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Email");
		lblNewLabel_7.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_7.setBounds(570, 28, 63, 19);
		panel_1.add(lblNewLabel_7);
		
		btnxoa = new JButton("Xóa");
		btnxoa.setBackground(new Color(204, 204, 153));
		
		btnxoa.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnxoa.setBounds(271, 143, 141, 26);
		panel_1.add(btnxoa);
		
		btncapnhat = new JButton("Cập Nhật");
		btncapnhat.setBackground(new Color(204, 204, 153));
		
		btncapnhat.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btncapnhat.setBounds(463, 143, 141, 26);
		panel_1.add(btncapnhat);
		
		btnlammoikh = new JButton("Làm Mới");
		btnlammoikh.setBackground(new Color(204, 204, 153));
		
		btnlammoikh.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnlammoikh.setBounds(923, 143, 141, 26);
		panel_1.add(btnlammoikh);
		
		btnthem = new JButton("Thêm");
		
		btnthem.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnthem.setBackground(new Color(204, 204, 153));
		btnthem.setBounds(111, 143, 111, 26);
		panel_1.add(btnthem);
		
		txtemail = new JTextField();
		txtemail.setBounds(667, 26, 435, 26);
		panel_1.add(txtemail);
		txtemail.setColumns(10);
		
		btnResetMK = new JButton("Reset Mật Khẩu");
		btnResetMK.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnResetMK.setBackground(new Color(204, 204, 153));
		btnResetMK.setBounds(688, 143, 191, 26);
		panel_1.add(btnResetMK);
		
		txtMa = new JTextField();
		txtMa.setColumns(10);
		txtMa.setBounds(96, 24, 435, 26);
		panel_1.add(txtMa);
		
		lblNewLabel_1 = new JLabel("Mã");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(50, 28, 36, 16);
		panel_1.add(lblNewLabel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(51, 153, 153));
		panel_2.setBounds(0, 230, 1170, 245);
		pnQLSInhVien.add(panel_2);
		panel_2.setLayout(null);
		String[] tb = new String[] { "STT", "Mã Sinh Viên","Họ Tên", "Số Điện Thoại","Email" };
		
		model = new DefaultTableModel(tb,0);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(10, 22, 1138, 212);
		panel_2.add(scrollPane);
		
		table = new JTable(model){
		      public boolean isCellEditable(int rowIndex, int colIndex) {
		          return false;   //Disallow the editing of any cell
		        }
		      };
		      
		      table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(table);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(51, 153, 153));
		panel_3.setBounds(0, 475, 1170, 109);
		pnQLSInhVien.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_8 = new JLabel("Tìm kiếm theo mã:");
		lblNewLabel_8.setFont(new Font("Dialog", Font.PLAIN, 16));
		lblNewLabel_8.setBounds(10, 6, 153, 31);
		panel_3.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("Tìm kiếm theo tên:");
		lblNewLabel_9.setFont(new Font("Dialog", Font.PLAIN, 16));
		lblNewLabel_9.setBounds(10, 53, 164, 21);
		panel_3.add(lblNewLabel_9);
		
		btntimkiem = new JButton("Tìm Kiếm");
		btntimkiem.setBackground(new Color(204, 204, 153));
		btntimkiem.setIcon(new ImageIcon("Img\\Search-icon (1).png"));
		btntimkiem.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btntimkiem.setBounds(549, 26, 141, 41);
		panel_3.add(btntimkiem);
		
		buttonGroupTim = new ButtonGroup();
		
		btnlammoitk = new JButton("Làm Mới");
		btnlammoitk.setBackground(new Color(204, 204, 153));
		btnlammoitk.setIcon(new ImageIcon("Img\\Refresh-icon (1).png"));
		btnlammoitk.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnlammoitk.setBounds(714, 26, 141, 41);
		panel_3.add(btnlammoitk);
		
		txtTimKiemTheoMa = new JTextField();
		txtTimKiemTheoMa.setBounds(165, 11, 300, 26);
		panel_3.add(txtTimKiemTheoMa);
		txtTimKiemTheoMa.setColumns(10);
		
		txtTimKiemTheoTen = new JTextField();
		txtTimKiemTheoTen.setColumns(10);
		txtTimKiemTheoTen.setBounds(165, 53, 300, 26);
		panel_3.add(txtTimKiemTheoTen);
//		scrollPane.setColumnHeaderView(table);
		
		table.addMouseListener(this);
		btnlammoikh.addActionListener(this);
		btnResetMK.addActionListener(this);
		btnxoa.addActionListener(this);
		btncapnhat.addActionListener(this);
		btntimkiem.addActionListener(this);
		btnlammoitk.addActionListener(this);
		btnthem.addActionListener(this);
		table.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 12));
		table.getTableHeader().setOpaque(false);
		table.getTableHeader().setBackground(new Color(32, 136, 203));
		table.getTableHeader().setForeground(new Color(255,255,255));
		table.setRowHeight(25);
		
		
		table.setIntercellSpacing(new java.awt.Dimension(0, 0));
		table.setRowHeight(25);
		table.setSelectionBackground(new java.awt.Color(232, 57, 95));
		table.setShowVerticalLines(false);
		txtMa.setEditable(false);
		loadSinhVien();
	}
	
	public void removeAllTable() {
		DefaultTableModel dtm = (DefaultTableModel) table.getModel();
		dtm.setRowCount(0);
	}

	
	public void loadSinhVien() throws RemoteException {
		DefaultTableModel dtm = (DefaultTableModel) table.getModel();
		dtm.setRowCount(0);
		int i = 1;
		List<SinhVien> listSinhVien = sinhVienService.getAllSV();
		for(SinhVien sv : listSinhVien) {
			Vector vector = new Vector();
			vector.add(i);
			vector.add(sv.getMaSV());
			vector.add(sv.getTenSV());
			vector.add(sv.getsDT());
			vector.add(sv.getEmail());
			model.addRow(vector);
			i++;
		}
	}
	
	private String automatedCode() throws RemoteException {

		
		String maSV = "";
		List<SinhVien> listSinhVien = sinhVienService.getAllSV();
         String  svLast = listSinhVien.get(listSinhVien.size()-1).getMaSV();
         int so = Integer.parseInt(svLast.substring(2)) + 1;
         if (so < 10)
        	 maSV = "SV000" + so;
         else if (so < 100)
        	 maSV = "SV00" + so;
         else if (so < 1000)
        	 maSV = "SV0" + so;
         else
        	 maSV = "SV" + so;
       
         return maSV;
		
         

	}
	
	public void loadListSinhVien(List<SinhVien> sinhViens) {
		DefaultTableModel dtm = (DefaultTableModel) table.getModel();
		dtm.setRowCount(0);
		int i = 1;
		for(SinhVien sv : sinhViens) {
			Vector vector = new Vector();
			vector.add(i);
			vector.add(sv.getMaSV());
			vector.add(sv.getTenSV());
			vector.add(sv.getsDT());
			vector.add(sv.getEmail());
			model.addRow(vector);
			i++;
		}
	}

	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		int row = table.getSelectedRow();
		txtemail.setText(table.getValueAt(row, 4).toString());
		txtsdt.setText(table.getValueAt(row, 3).toString());
		txtten.setText(table.getValueAt(row, 2).toString());
		txtMa.setText(table.getValueAt(row, 1).toString());
	}

	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if(o.equals(btnthem)) {
			String maSV;
			try {
				if(txtten.getText().trim().length() == 0) {
					JOptionPane.showMessageDialog(this, "Vui lòng nhập tên sinh viên!!!");
					return;
				} else if(txtemail.getText().trim().length() == 0) {
					JOptionPane.showMessageDialog(this, "Vui lòng nhập email sinh viên!!!");
					return;
				} else if(txtsdt.getText().trim().length() == 0) {
					JOptionPane.showMessageDialog(this, "Vui lòng nhập số điện thoại sinh viên!!!");
					return;
				}
				maSV = automatedCode();
				String tenGV = txtten.getText();
				String email = txtemail.getText();
				String sdt = txtsdt.getText();
				SinhVien sinhVien = new SinhVien(maSV, tenGV, sdt, email);
				sinhVienService.addSinhVien(sinhVien);
				TaiKhoan tk = new TaiKhoan(maSV, "123456", 2, sinhVien, null);
				taiKhoanService.ThemTaiKhoan(tk);
				loadSinhVien();
				btnlammoikh.doClick();
			} catch (RemoteException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		} else if(o.equals(btnResetMK)) {
			int row = table.getSelectedRow();
			if(row == -1) {
				JOptionPane.showMessageDialog(this, "Vui lòng chọn sinh viên muốn reset mật khẩu!!!");
				return;
			} else {
				int option = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn reset mật khẩu cho tài khoản của sinh viên này?");
				if(option == JOptionPane.OK_OPTION) {
					try {
						TaiKhoan tk = new TaiKhoan();
						tk.setUsername(table.getValueAt(row, 1).toString());
						boolean check = taiKhoanService.ResetMatKhau(tk);
						if(check) {
							JOptionPane.showMessageDialog(this, "Reset mật khẩu thành công , mật khẩu mặc định là 123456!!!");
						}
					} catch (RemoteException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
			
			
		}else if(o.equals(btnxoa)) {
			int row = table.getSelectedRow();
			if(row == -1) {
				JOptionPane.showMessageDialog(this, "Vui lòng chọn sinh viên muốn xóa!!!");
				return;
			} else {
				int option = JOptionPane.showConfirmDialog(this, "Bạn có muốn xóa sinh viên này không?");
				if(option == JOptionPane.OK_OPTION) {
					try {
						TaiKhoan tk = new TaiKhoan();
						tk.setSinhVien(new SinhVien(table.getValueAt(row, 1).toString()));
						taiKhoanService.XoaTaiKhoan(tk);
						boolean c =sinhVienService.deleteSinhVien(table.getValueAt(row, 1).toString());
						if(c==false) {
							JOptionPane.showMessageDialog(this, "Không thể xóa sinh viên khi đã tham gia lớp học!!!");
							TaiKhoan tk2 = new TaiKhoan(table.getValueAt(row, 1).toString(), "123456", 2, new SinhVien(table.getValueAt(row, 1).toString()), null);
							taiKhoanService.ThemTaiKhoan(tk2);
						}
						loadSinhVien();
						btnlammoikh.doClick();
					} catch (RemoteException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
						
					}
				}
			}
			
			
		} else if(o.equals(btncapnhat)) {
			int row = table.getSelectedRow();
			if(row == -1) {
				JOptionPane.showMessageDialog(this, "Vui lòng chọn sinh viên muốn cập nhật!!!");
				return;
			} else {
				if(txtten.getText().trim().length() == 0) {
					JOptionPane.showMessageDialog(this, "Vui lòng nhập tên sinh viên!!!");
					return;
				} else if(txtemail.getText().trim().length() == 0) {
					JOptionPane.showMessageDialog(this, "Vui lòng nhập email sinh viên!!!");
					return;
				} else if(txtsdt.getText().trim().length() == 0) {
					JOptionPane.showMessageDialog(this, "Vui lòng nhập số điện thoại sinh viên!!!");
					return;
				}
				try {
					SinhVien sinhVien = sinhVienService.getSinhVien(table.getValueAt(row, 1).toString());
					sinhVien.setTenSV(txtten.getText());
					sinhVien.setEmail(txtemail.getText());
					sinhVien.setsDT(txtsdt.getText());
					sinhVienService.updateSinhVien(sinhVien);
					loadSinhVien();
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		} else if(o.equals(btnlammoikh)) {
			try {
				loadSinhVien();
				txtemail.setText("");
				txtsdt.setText("");
				txtten.setText("");
				table.clearSelection();
			} catch (RemoteException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			
		} else if(o.equals(btntimkiem)) {
			String timKiemByMa = txtTimKiemTheoMa.getText();
			String timKiemByTen = txtTimKiemTheoTen.getText();
			
			if(timKiemByMa.trim().length() > 0 && timKiemByTen.trim().length() > 0) {
				JOptionPane.showMessageDialog(this, "Vui lòng chọn tìm kiếm theo mã hoặc tên!!!");
				return;
			} else {
				if(timKiemByMa.trim().length() > 0) {
					try {
						removeAllTable();
						SinhVien sinhVien = sinhVienService.getSinhVien(timKiemByMa);
						if(sinhVien != null) {
							Vector vector = new Vector();
							int i = 1;
							vector.add(i);
							vector.add(sinhVien.getMaSV());
							vector.add(sinhVien.getTenSV());
							vector.add(sinhVien.getsDT());
							vector.add(sinhVien.getEmail());
							model.addRow(vector);
						} else {
							JOptionPane.showMessageDialog(this, "Không có mã sinh viên đã tìm kiếm");
						}
						
					} catch (RemoteException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				} else {
					try {
						removeAllTable();
						List<SinhVien> sinhViens = sinhVienService.getSinhVienVienByTen(timKiemByTen);
						if(sinhViens != null) {
							loadListSinhVien(sinhViens);
						} else {
							JOptionPane.showMessageDialog(this, "Không có tên sinh viên đã tìm kiếm");
						}
						
					} catch (RemoteException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		} else if(o.equals(btnlammoitk)) {
			txtTimKiemTheoMa.setText("");
			txtTimKiemTheoTen.setText("");
			try {
				loadSinhVien();
			} catch (RemoteException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	
	
}
