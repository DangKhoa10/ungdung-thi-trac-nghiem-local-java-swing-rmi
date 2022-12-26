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

public class GUI_QuanLyGiangVien extends JFrame implements ActionListener, MouseListener {

	public static JPanel pnQLGiangVien;
	private JTextField txtten;
	private JTextField txtsdt;
	private JTable table;
	private DefaultTableModel model;
	private JButton btntimkiem;
	private JButton btnlammoitk;
	private JButton btnlammoikh;
	private JButton btnxoa;
	private JButton btncapnhat;
	private JTextField txtTimKiemTheoMa;
	private JButton btnthem;
	private JTextField txtemail;
	private JTextField txtTimKiemTheoTen;
	private String rmiUrl = new RMIUrl().RMIUrl();
	private IGiangVienService giangVienService;
	private ITaiKhoanService taiKhoanService;
	private JTextField txtMa;
	private JButton btnthoat;
	private JButton btnResetPW;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_QuanLyGiangVien frame = new GUI_QuanLyGiangVien();
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
	public GUI_QuanLyGiangVien() throws RemoteException {
		
		try {
			giangVienService = (IGiangVienService) Naming.lookup("rmi://" + rmiUrl  + ":2910/iGiangVien");
			taiKhoanService = (ITaiKhoanService) Naming.lookup("rmi://" + rmiUrl  + ":2910/iTaiKhoan");
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 700);
		pnQLGiangVien = new JPanel();
		
		pnQLGiangVien.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(pnQLGiangVien);
		this.setLocationRelativeTo(null);
		this.setSize(1184, 632);
		pnQLGiangVien.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 204, 153));
		panel.setBounds(0, 0, 1256, 47);
		pnQLGiangVien.add(panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel = new JLabel("Quản lý giảng viên");
		lblNewLabel.setForeground(new Color(153, 0, 0));
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 25));
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(51, 153, 153));
		panel_1.setBounds(0, 46, 1168, 187);
		pnQLGiangVien.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("Họ Tên");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(38, 62, 63, 16);
		panel_1.add(lblNewLabel_3);
		
		txtten = new JTextField();
		txtten.setBounds(111, 58, 435, 26);
		panel_1.add(txtten);
		txtten.setColumns(10);
		
	
		
		JLabel lblNewLabel_5 = new JLabel("Số Điện Thoại");
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_5.setBounds(572, 62, 87, 16);
		panel_1.add(lblNewLabel_5);
		
		txtsdt = new JTextField();
		txtsdt.setBounds(669, 58, 435, 26);
		panel_1.add(txtsdt);
		txtsdt.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Email");
		lblNewLabel_7.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_7.setBounds(574, 27, 63, 19);
		panel_1.add(lblNewLabel_7);
		
		btnxoa = new JButton("Xóa");
		btnxoa.setBackground(new Color(204, 204, 153));
		
		btnxoa.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnxoa.setBounds(397, 144, 125, 26);
		panel_1.add(btnxoa);
		
		btncapnhat = new JButton("Cập Nhật");
		btncapnhat.setBackground(new Color(204, 204, 153));
		
		btncapnhat.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btncapnhat.setBounds(558, 144, 125, 26);
		panel_1.add(btncapnhat);
		
		btnlammoikh = new JButton("Làm Mới");
		btnlammoikh.setBackground(new Color(204, 204, 153));
		
		btnlammoikh.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnlammoikh.setBounds(963, 144, 120, 26);
		panel_1.add(btnlammoikh);
		
		btnthem = new JButton("Thêm");
		
		btnthem.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnthem.setBackground(new Color(204, 204, 153));
		btnthem.setBounds(237, 144, 125, 26);
		panel_1.add(btnthem);
		
		txtemail = new JTextField();
		txtemail.setBounds(669, 20, 435, 26);
		panel_1.add(txtemail);
		txtemail.setColumns(10);
		
		txtMa = new JTextField();
		txtMa.setColumns(10);
		txtMa.setBounds(111, 21, 435, 26);
		panel_1.add(txtMa);
		
		JLabel lblNewLabel_3_1 = new JLabel("Mã");
		lblNewLabel_3_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_3_1.setBounds(38, 30, 63, 16);
		panel_1.add(lblNewLabel_3_1);
		
		 btnResetPW = new JButton("Reset Mật Khẩu");
		btnResetPW.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnResetPW.setBackground(new Color(204, 204, 153));
		btnResetPW.setBounds(737, 144, 172, 26);
		panel_1.add(btnResetPW);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(51, 153, 153));
		panel_2.setBounds(0, 233, 1191, 246);
		pnQLGiangVien.add(panel_2);
		panel_2.setLayout(null);
		String[] tb = new String[] { "STT", "Mã ", "Họ Tên", "Số Điện Thoại","Email" };
		
		model = new DefaultTableModel(tb,0);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(10, 22, 1138, 213);
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
		panel_3.setBounds(0, 479, 1191, 114);
		pnQLGiangVien.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_8 = new JLabel("Tìm kiếm theo mã:");
		lblNewLabel_8.setFont(new Font("Dialog", Font.PLAIN, 20));
		lblNewLabel_8.setBounds(13, 11, 164, 26);
		panel_3.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("Tìm kiếm theo tên:");
		lblNewLabel_9.setFont(new Font("Dialog", Font.PLAIN, 20));
		lblNewLabel_9.setBounds(13, 48, 164, 20);
		panel_3.add(lblNewLabel_9);
		
		btntimkiem = new JButton("Tìm Kiếm");
		btntimkiem.setBackground(new Color(204, 204, 153));
		btntimkiem.setIcon(new ImageIcon("Img\\Search-icon (1).png"));
		btntimkiem.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btntimkiem.setBounds(549, 26, 141, 41);
		panel_3.add(btntimkiem);
		
		btnlammoitk = new JButton("Làm Mới");
		btnlammoitk.setBackground(new Color(204, 204, 153));
		btnlammoitk.setIcon(new ImageIcon("Img\\Refresh-icon (1).png"));
		btnlammoitk.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnlammoitk.setBounds(714, 26, 141, 41);
		panel_3.add(btnlammoitk);
		
		
		
		txtTimKiemTheoMa = new JTextField();
		txtTimKiemTheoMa.setBounds(203, 18, 180, 20);
		panel_3.add(txtTimKiemTheoMa);
		txtTimKiemTheoMa.setColumns(10);
		
		txtTimKiemTheoTen = new JTextField();
		txtTimKiemTheoTen.setBounds(203, 52, 180, 21);
		panel_3.add(txtTimKiemTheoTen);
		txtTimKiemTheoTen.setColumns(10);
//		scrollPane.setColumnHeaderView(table);
		
		table.addMouseListener(this);
		btnlammoikh.addActionListener(this);
		btnResetPW.addActionListener(this);
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
		loadGiangVien();
	}
	
	public void removeAllTable() {
		DefaultTableModel dtm = (DefaultTableModel) table.getModel();
		dtm.setRowCount(0);
	}

	
	public void loadGiangVien() throws RemoteException {
		DefaultTableModel dtm = (DefaultTableModel) table.getModel();
		dtm.setRowCount(0);
		int i = 1;
		List<GiangVien> listGiangVien = giangVienService.getAllGV();
		for(GiangVien gv : listGiangVien) {
			Vector vector = new Vector();
			vector.add(i);
			vector.add(gv.getMaGV());
			vector.add(gv.getTenGV());
			vector.add(gv.getsDT());
			vector.add(gv.getEmail());
			model.addRow(vector);
			i++;
		}
	}
	
	public void loadListGiangVien(List<GiangVien> giangViens) {
		DefaultTableModel dtm = (DefaultTableModel) table.getModel();
		dtm.setRowCount(0);
		int i = 1;
		for(GiangVien gv : giangViens) {
			Vector vector = new Vector();
			vector.add(i);
			vector.add(gv.getMaGV());
			vector.add(gv.getTenGV());
			vector.add(gv.getsDT());
			vector.add(gv.getEmail());
			model.addRow(vector);
			i++;
		}
	}
	
	private void disabled() {
		txtten.setEnabled(false);
		txtemail.setEnabled(false);
		txtsdt.setEnabled(false);
		btncapnhat.setEnabled(false);
		btnxoa.setEnabled(false);
	}
	
	private void enabled() {
		txtten.setEnabled(true);
		txtemail.setEnabled(true);
		txtsdt.setEnabled(true);
	}
	
	private String automatedCode() throws RemoteException {
		
		
		String maGV = "";
		List<GiangVien> listGiangVien = giangVienService.getAllGV();
         String  gvLast = listGiangVien.get(listGiangVien.size()-1).getMaGV();
         int so = Integer.parseInt(gvLast.substring(2)) + 1;
         if (so < 10)
        	 maGV = "GV000" + so;
         else if (so < 100)
        	 maGV = "GV00" + so;
         else if (so < 1000)
        	 maGV = "GV0" + so;
         else
        	 maGV = "GV" + so;
       
         return maGV;
		
		
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
			String maGV;
			try {
				if(txtten.getText().trim().length() == 0) {
					JOptionPane.showMessageDialog(this, "Vui lòng nhập tên giảng viên!!!");
					return;
				} else if(txtemail.getText().trim().length() == 0) {
					JOptionPane.showMessageDialog(this, "Vui lòng nhập email giảng viên!!!");
					return;
				} else if(txtsdt.getText().trim().length() == 0) {
					JOptionPane.showMessageDialog(this, "Vui lòng nhập số điện thoại giảng viên!!!");
					return;
				}
				maGV = automatedCode();
				String tenGV = txtten.getText();
				String email = txtemail.getText();
				String sdt = txtsdt.getText();
				GiangVien giangVien = new GiangVien(maGV, tenGV, sdt, email);
				giangVienService.addGiangVien(giangVien);
				TaiKhoan tk = new TaiKhoan(maGV, "123456", 1,null,giangVien);
				taiKhoanService.ThemTaiKhoan(tk);
				
				loadGiangVien();
			} catch (RemoteException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		} else if(o.equals(btnxoa)) {
			int row = table.getSelectedRow();
			if(row == -1) {
				JOptionPane.showMessageDialog(this, "Vui lòng chọn giảng viên muốn xóa!!!");
				return;
			} else {
				int option = JOptionPane.showConfirmDialog(this, "Bạn có muốn xóa giảng viên này không?");
				if(option == JOptionPane.OK_OPTION) {
					try {
						TaiKhoan tk = new TaiKhoan();
						tk.setGiangVien(new GiangVien(table.getValueAt(row, 1).toString(), null, null, null));
						taiKhoanService.XoaTaiKhoan(tk);
						boolean c = giangVienService.deleteGiangVien(table.getValueAt(row, 1).toString());
						if(c==false) {
							JOptionPane.showMessageDialog(this, "Không thể xóa giảng viên đã phụ trách môn học!!!");
							TaiKhoan tk2 = new TaiKhoan(table.getValueAt(row, 1).toString(), "123456", 1, null, new GiangVien(table.getValueAt(row, 1).toString(), null, null, null));
							taiKhoanService.ThemTaiKhoan(tk2);
						}
						loadGiangVien();
					} catch (RemoteException e1) {
						// TODO Auto-generated catch block
						
						e1.printStackTrace();
						
					}
					
				}
			}
			
			
		} else if(o.equals(btnResetPW)) {
			int row = table.getSelectedRow();
			if(row == -1) {
				JOptionPane.showMessageDialog(this, "Vui lòng chọn giảng viên muốn reset mật khẩu!!!");
				return;
			} else {
				int option = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn reset mật khẩu cho tài khoản của giảng viên này?");
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
			
			
		}else if(o.equals(btncapnhat)) {
			int row = table.getSelectedRow();
			if(row == -1) {
				JOptionPane.showMessageDialog(this, "Vui lòng chọn giảng viên muốn cập nhật!!!");
				return;
			} else {
				if(txtten.getText().trim().length() == 0) {
					JOptionPane.showMessageDialog(this, "Vui lòng nhập tên giảng viên!!!");
					return;
				} else if(txtemail.getText().trim().length() == 0) {
					JOptionPane.showMessageDialog(this, "Vui lòng nhập email giảng viên!!!");
					return;
				} else if(txtsdt.getText().trim().length() == 0) {
					JOptionPane.showMessageDialog(this, "Vui lòng nhập số điện thoại giảng viên!!!");
					return;
				}
				try {
					GiangVien giangVien = giangVienService.getGiangVien(table.getValueAt(row, 1).toString());
					giangVien.setTenGV(txtten.getText());
					giangVien.setEmail(txtemail.getText());
					giangVien.setsDT(txtsdt.getText());
					giangVienService.updateGiangVien(giangVien);
					loadGiangVien();
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		} else if(o.equals(btnlammoikh)) {
			try {
				loadGiangVien();
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
						GiangVien giangVien = giangVienService.getGiangVien(timKiemByMa);
						if(giangVien != null) {
							Vector vector = new Vector();
							int i = 1;
							vector.add(i);
							vector.add(giangVien.getMaGV());
							vector.add(giangVien.getTenGV());
							vector.add(giangVien.getsDT());
							vector.add(giangVien.getEmail());
							model.addRow(vector);
						} else {
							JOptionPane.showMessageDialog(this, "Không có mã giảng viên đã tìm kiếm");
						}
						
					} catch (RemoteException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				} else {
					try {
						removeAllTable();
						List<GiangVien> giangViens = giangVienService.getGiangVienByTen(timKiemByTen);
						if(giangViens != null) {
							loadListGiangVien(giangViens);
						} else {
							JOptionPane.showMessageDialog(this, "Không có tên giảng viên đã tìm kiếm");
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
				loadGiangVien();
			} catch (RemoteException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
	}
}
