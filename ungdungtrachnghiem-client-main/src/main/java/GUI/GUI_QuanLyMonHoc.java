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

import org.hibernate.Hibernate;

import entity.GiangVien;
import entity.MonHoc;
import entity.SinhVien;
import service.IGiangVienService;
import service.IMonHocService;
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

public class GUI_QuanLyMonHoc extends JFrame implements ActionListener, MouseListener {

	public static JPanel pnQLMonHoc;
	private JTextField txtten;
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
	private JTextField txtTimKiemTheoTen;
	private JComboBox cboGiangVien;
	private JLabel lblNewLabel_1;
	private String rmiUrl = new RMIUrl().RMIUrl();
	private IGiangVienService giangVienService;
	private IMonHocService monHocService;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_QuanLyMonHoc frame = new GUI_QuanLyMonHoc();
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
	public GUI_QuanLyMonHoc() throws RemoteException {
		try {
			giangVienService = (IGiangVienService) Naming.lookup("rmi://" + rmiUrl  + ":2910/iGiangVien");
			monHocService = (IMonHocService) Naming.lookup("rmi://" + rmiUrl  + ":2910/iMonHoc");
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1174, 602);
		pnQLMonHoc = new JPanel();
		
		pnQLMonHoc.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(pnQLMonHoc);
		this.setLocationRelativeTo(null);
		this.setSize(1184, 625);
		pnQLMonHoc.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 204, 153));
		panel.setBounds(0, 0, 1191, 47);
		pnQLMonHoc.add(panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel = new JLabel("Quản lý môn học");
		lblNewLabel.setForeground(new Color(153, 0, 0));
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 25));
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(51, 153, 153));
		panel_1.setBounds(0, 48, 1191, 173);
		pnQLMonHoc.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("Tên môn học");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(48, 30, 105, 16);
		panel_1.add(lblNewLabel_3);
		
		txtten = new JTextField();
		txtten.setBounds(163, 26, 379, 26);
		panel_1.add(txtten);
		txtten.setColumns(10);
		
		btnxoa = new JButton("Xóa");
		btnxoa.setBackground(new Color(204, 204, 153));
		
		btnxoa.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnxoa.setBounds(401, 114, 141, 41);
		panel_1.add(btnxoa);
		
		btncapnhat = new JButton("Cập Nhật");
		btncapnhat.setBackground(new Color(204, 204, 153));
		
		btncapnhat.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btncapnhat.setBounds(552, 114, 141, 41);
		panel_1.add(btncapnhat);
		
		btnlammoikh = new JButton("Làm Mới");
		btnlammoikh.setBackground(new Color(204, 204, 153));
		
		btnlammoikh.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnlammoikh.setBounds(703, 114, 141, 41);
		panel_1.add(btnlammoikh);
		
		btnthem = new JButton("Thêm");
		
		btnthem.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnthem.setBackground(new Color(204, 204, 153));
		btnthem.setBounds(250, 114, 141, 41);
		panel_1.add(btnthem);
		
		cboGiangVien = new JComboBox();
		cboGiangVien.setBounds(756, 26, 348, 26);
		panel_1.add(cboGiangVien);
		
		lblNewLabel_1 = new JLabel("Giảng viên phụ trách");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(605, 25, 141, 26);
		panel_1.add(lblNewLabel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(51, 153, 153));
		panel_2.setBounds(0, 217, 1191, 257);
		pnQLMonHoc.add(panel_2);
		panel_2.setLayout(null);
		String[] tb = new String[] { "STT", "Mã ","Tên môn học","Giảng viên giảng dạy","Số sinh viên đăng kí"};
		
		model = new DefaultTableModel(tb,0);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(10, 22, 1127, 199);
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
		panel_3.setBounds(0, 465, 1191, 121);
		pnQLMonHoc.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_8 = new JLabel("Tìm kiếm theo mã:");
		lblNewLabel_8.setFont(new Font("Dialog", Font.PLAIN, 20));
		lblNewLabel_8.setBounds(13, 28, 182, 21);
		panel_3.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("Tìm kiếm theo tên:");
		lblNewLabel_9.setFont(new Font("Dialog", Font.PLAIN, 20));
		lblNewLabel_9.setBounds(13, 60, 164, 21);
		panel_3.add(lblNewLabel_9);
		
		btntimkiem = new JButton("Tìm Kiếm");
		btntimkiem.setBackground(new Color(204, 204, 153));
		btntimkiem.setIcon(new ImageIcon("Img\\Search-icon (1).png"));
		btntimkiem.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btntimkiem.setBounds(601, 27, 101, 31);
		panel_3.add(btntimkiem);
		
		buttonGroupTim = new ButtonGroup();
		
		btnlammoitk = new JButton("Làm Mới");
		btnlammoitk.setBackground(new Color(204, 204, 153));
		btnlammoitk.setIcon(new ImageIcon("Img\\Refresh-icon (1).png"));
		btnlammoitk.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnlammoitk.setBounds(714, 26, 101, 33);
		panel_3.add(btnlammoitk);
		
		txtTimKiemTheoMa = new JTextField();
		txtTimKiemTheoMa.setBounds(205, 32, 222, 21);
		panel_3.add(txtTimKiemTheoMa);
		txtTimKiemTheoMa.setColumns(10);
		
		txtTimKiemTheoTen = new JTextField();
		txtTimKiemTheoTen.setColumns(10);
		txtTimKiemTheoTen.setBounds(205, 60, 222, 21);
		panel_3.add(txtTimKiemTheoTen);
//		scrollPane.setColumnHeaderView(table);
		
		table.addMouseListener(this);
		btnlammoikh.addActionListener(this);
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
		
		
		loadMonHoc();
		loadGiangVien();
	}
	
	public void loadGiangVien() throws RemoteException {
		cboGiangVien.removeAllItems();
		List<GiangVien> listGV = giangVienService.getAllGV();
		for(GiangVien gv : listGV) {
			cboGiangVien.addItem(gv.getMaGV() + " (" + gv.getTenGV() + ")");
		}
	}
	
	public void loadMonHoc() throws RemoteException {
		List<MonHoc> listMonHocs = monHocService.getAllMH();
		DefaultTableModel dtm = (DefaultTableModel) table.getModel();
		dtm.setRowCount(0);
		int i = 1;
		if(listMonHocs != null) {
			for(MonHoc mh : listMonHocs) {
				GiangVien giangVien = giangVienService.getGiangVien(mh.getGiangVien().getMaGV());
				int soHocSinh = monHocService.getStudentsFromMonHoc(mh.getMaMH().toString());
				Vector vector = new Vector();
				vector.add(i);
				vector.add(mh.getMaMH());
				vector.add(mh.getTenMH());
				vector.add(giangVien.getTenGV());
				vector.add(soHocSinh + "");
				model.addRow(vector);
				i++;
			}
		}
		
	}
	
	public void loadMonHoc(List<MonHoc> listMH) throws RemoteException {
		DefaultTableModel dtm = (DefaultTableModel) table.getModel();
		dtm.setRowCount(0);
		int i = 1;
		if(listMH != null) {
			for(MonHoc mh : listMH) {
				GiangVien giangVien = giangVienService.getGiangVien(mh.getGiangVien().getMaGV());
				Vector vector = new Vector();
				vector.add(i);
				vector.add(mh.getMaMH());
				vector.add(mh.getTenMH());
				vector.add(giangVien.getTenGV());
				model.addRow(vector);
				i++;
			}
		}
		
	}
	private String automatedCode() throws RemoteException {
		
		
		String maMH = "";
		List<MonHoc> listMonHoc = monHocService.getAllMH();
         String  mhLast = listMonHoc.get(listMonHoc.size()-1).getMaMH();
         int so = Integer.parseInt(mhLast.substring(2)) + 1;
         if (so < 10)
        	 maMH = "MH000" + so;
         else if (so < 100)
        	 maMH = "MH00" + so;
         else if (so < 1000)
        	 maMH = "MH0" + so;
         else
        	 maMH = "MH" + so;
       
         return maMH;
		
	}

	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		int row = table.getSelectedRow();
		txtten.setText(table.getValueAt(row, 2).toString());
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
	
	public void removeAllTable() {
		DefaultTableModel dtm = (DefaultTableModel) table.getModel();
		dtm.setRowCount(0);
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if(o.equals(btnthem)) {
			try {
				String maGV = cboGiangVien.getSelectedItem().toString().split("\\s")[0];
				String maMH = automatedCode();
				String tenMH = txtten.getText();
				MonHoc monHoc = new MonHoc(maMH, tenMH);
				monHoc.setGiangVien(new GiangVien(maGV, null, null, null));
				monHocService.addMonHoc(monHoc);
				loadMonHoc();
				btnlammoikh.doClick();
			} catch (RemoteException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			
		} else if(o.equals(btnlammoikh)) {
			try {
				loadGiangVien();
				loadMonHoc();
				txtten.setText("");
				table.clearSelection();
			} catch (RemoteException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			
		} else if(o.equals(btncapnhat)) {
			
			try {
				String maGV = cboGiangVien.getSelectedItem().toString().split("\\s")[0];
				GiangVien giangVien;
				giangVien = giangVienService.getGiangVien(maGV);
				int row = table.getSelectedRow();
				String maMH = table.getValueAt(row, 1).toString();
				String tenMH = txtten.getText();
				MonHoc monHoc = monHocService.getMonHoc(maMH);
				monHoc.setTenMH(tenMH);
				monHoc.setGiangVien(giangVien);
				monHocService.updateMonHoc(monHoc);
				loadMonHoc();
				btnlammoikh.doClick();
			} catch (RemoteException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		} else if(o.equals(btnxoa)) {
			int row = table.getSelectedRow();
			if(row == -1) {
				JOptionPane.showMessageDialog(this, "Vui lòng chọn môn học muốn xóa!!!");
				return;
			} else {
				int option = JOptionPane.showConfirmDialog(this, "Bạn có muốn xóa môn học này không?");
				if(option == JOptionPane.OK_OPTION) {
					try {
						monHocService.deleteMonHoc(table.getValueAt(row, 1).toString());
						loadMonHoc();
						btnlammoikh.doClick();
					} catch (RemoteException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
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
						MonHoc monHoc = monHocService.getMonHoc(timKiemByMa);
						GiangVien giangVien = giangVienService.getGiangVien(monHoc.getGiangVien().getMaGV());
						if(monHoc != null) {
							Vector vector = new Vector();
							int i = 1;
							vector.add(i);
							vector.add(monHoc.getMaMH());
							vector.add(monHoc.getTenMH());
							vector.add(giangVien.getTenGV());
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
						List<MonHoc> monHocs = monHocService.getMonHocByGiangVien(timKiemByTen);
						if(monHocs != null) {
							loadMonHoc(monHocs);
						} else {
							JOptionPane.showMessageDialog(this, "Không có tên môn học đã tìm kiếm");
						}
						
					} catch (RemoteException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		}
	}
	
	
}
