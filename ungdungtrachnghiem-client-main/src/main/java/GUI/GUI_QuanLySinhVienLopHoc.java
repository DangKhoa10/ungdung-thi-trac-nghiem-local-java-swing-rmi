package GUI;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import entity.KetQua;
import entity.MonHoc;
import entity.SinhVien;
import service.ICauHoiThiService;
import service.IDapAnService;
import service.IKetQuaService;
import service.ILoaiCauHoiService;
import service.IMonHocService;
import service.ISinhVienService;
import view.util.RMIUrl;

import javax.swing.JComboBox;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.TitledBorder;

public class GUI_QuanLySinhVienLopHoc extends JPanel implements ActionListener,MouseListener{
	private JTable table;
	private DefaultTableModel model;
	private JTextField txtSDT;
	private JTextField txtEmail;
	private JTextField txtTen;
	private JTextField txtMa;
	private JTextField txtTimMa;
	private JButton btnTimKiem;
	private JButton btnThem;
	private JButton btnXoa;
	private JComboBox<String> cboMonHoc;
	private IMonHocService monHocService;
	private ISinhVienService sinhVienService;
	private IKetQuaService ketQuaService;
	private List<SinhVien> listSV = new ArrayList<SinhVien>();
	private String rmiUrl = new RMIUrl().RMIUrl();
	private JButton btnLamMoi;
	/**
	 * Create the panel.
	 * @throws RemoteException 
	 */
	public GUI_QuanLySinhVienLopHoc() throws RemoteException {
		
		
		try {
			ketQuaService = (IKetQuaService) Naming.lookup("rmi://" + rmiUrl  + ":2910/iKetQua");
			sinhVienService = (ISinhVienService) Naming.lookup("rmi://" + rmiUrl  + ":2910/iSinhVien");
			monHocService = (IMonHocService) Naming.lookup("rmi://" + rmiUrl  + ":2910/iMonHoc");
		} catch (Exception e) {
			// TODO: handle exception
		}
		setLayout(null);
		setSize(1174,612);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 204, 153));
		panel.setBounds(0, 0, 1174, 43);
		add(panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblDanhSchSinh = new JLabel("Danh Sách Sinh Viên Môn Học");
		lblDanhSchSinh.setForeground(new Color(153, 0, 0));
		lblDanhSchSinh.setFont(new Font("Dialog", Font.BOLD, 25));
		panel.add(lblDanhSchSinh);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 41, 1174, 571);
		add(panel_1);
		panel_1.setLayout(null);
		
		String[] tb = new String[] { "STT" ,"Mã","Họ Tên", "SDT","Email"};
		model= new DefaultTableModel(tb,0);

		
		
		
		table = new JTable(model){
		      public boolean isCellEditable(int rowIndex, int colIndex) {
		          return false;   //Disallow the editing of any cell
		        }
		      };
		table.setBounds(10, 257, 1154, 303);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		JScrollPane jScrollPane = new JScrollPane(table);
		jScrollPane.setBounds(10, 292, 1154, 251);
		panel_1.add(jScrollPane);
		
		JLabel lblNewLabel = new JLabel("Chọn lớp học");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(10, 211, 90, 26);
		panel_1.add(lblNewLabel);
		
		cboMonHoc = new JComboBox();
		cboMonHoc.setBounds(110, 205, 244, 43);
		panel_1.add(cboMonHoc);
		
		JLabel lblNewLabel_1 = new JLabel("Danh sách học viên của lớp");
		lblNewLabel_1.setBounds(10, 267, 208, 20);
		panel_1.add(lblNewLabel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(459, 11, 705, 270);
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		
		
		TitledBorder title;
		title = BorderFactory.createTitledBorder("Thông tin sinh viên");
		panel_2.setBorder(title);
		
		txtSDT = new JTextField();
		txtSDT.setBounds(131, 115, 563, 29);
		panel_2.add(txtSDT);
		txtSDT.setColumns(10);
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(131, 161, 563, 29);
		panel_2.add(txtEmail);
		
		txtTen = new JTextField();
		txtTen.setColumns(10);
		txtTen.setBounds(131, 69, 563, 29);
		panel_2.add(txtTen);
		
		txtMa = new JTextField();
		txtMa.setColumns(10);
		txtMa.setBounds(131, 23, 563, 29);
		panel_2.add(txtMa);
		
		JLabel lblNewLabel_2 = new JLabel("Mã sinh viên");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(26, 17, 95, 35);
		panel_2.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Tên sinh viên");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2_1.setBounds(26, 63, 95, 35);
		panel_2.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("SDT");
		lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2_1_1.setBounds(26, 109, 95, 35);
		panel_2.add(lblNewLabel_2_1_1);
		
		JLabel lblNewLabel_2_1_2 = new JLabel("Email");
		lblNewLabel_2_1_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2_1_2.setBounds(26, 155, 95, 35);
		panel_2.add(lblNewLabel_2_1_2);
		
		 btnThem = new JButton("Thêm Vào Lớp");
		btnThem.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnThem.setBounds(427, 216, 122, 43);
		panel_2.add(btnThem);
		
		 btnXoa = new JButton("Xóa Khỏi Lớp");
		btnXoa.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnXoa.setBounds(572, 216, 122, 43);
		panel_2.add(btnXoa);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(10, 11, 435, 181);
		panel_1.add(panel_3);

		TitledBorder title2;
		title2 = BorderFactory.createTitledBorder("Tìm kiếm sinh viên thêm vào lớp học");
		panel_3.setBorder(title2);
		panel_3.setLayout(null);
		
		 btnTimKiem = new JButton("Tìm");
		btnTimKiem.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnTimKiem.setBounds(286, 123, 139, 46);
		panel_3.add(btnTimKiem);
		
		JLabel lblNewLabel_3 = new JLabel("Nhập mã sinh viên");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_3.setBounds(10, 41, 180, 25);
		panel_3.add(lblNewLabel_3);
		
		txtTimMa = new JTextField();
		txtTimMa.setBounds(10, 77, 415, 35);
		panel_3.add(txtTimMa);
		txtTimMa.setColumns(10);;
		
	
		btnThem.addActionListener(this);
		btnXoa.addActionListener(this);
		btnTimKiem.addActionListener(this);
		txtMa.setEditable(false);
		txtEmail.setEditable(false);
		txtSDT.setEditable(false);
		txtTen.setEditable(false);
		
		table.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 12));
		table.getTableHeader().setOpaque(false);
		table.getTableHeader().setBackground(new Color(32, 136, 203));
		table.getTableHeader().setForeground(new Color(255,255,255));
		table.setRowHeight(25);
		
		
		table.setIntercellSpacing(new java.awt.Dimension(0, 0));
		table.setRowHeight(25);
		table.setSelectionBackground(new java.awt.Color(232, 57, 95));
		table.setShowVerticalLines(false);
		
		panel_1.setBackground(new Color(51, 153, 153));
		panel_2.setBackground(new Color(51, 153, 153));
		panel_3.setBackground(new Color(51, 153, 153));
		
		table.addMouseListener(this);
		LoadCboMH();
		
		cboMonHoc.addItemListener(new ItemListener() {
			
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == ItemEvent.SELECTED) {
				String maMH = cboMonHoc.getSelectedItem().toString().substring(0, 6);
				try {
					listSV = sinhVienService.getSinhVienByMonHoc(maMH);
				} catch (RemoteException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				removeTable();
				try {
					LoadTable();
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}}
		});
		btnThem.setEnabled(false);
		
		btnLamMoi = new JButton("Làm mới");
		btnLamMoi.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnLamMoi.setBounds(359, 205, 90, 46);
		panel_1.add(btnLamMoi);
		btnLamMoi.addActionListener(this);
		btnThem.setBackground(new Color(204, 204, 153));
		btnTimKiem.setBackground(new Color(204, 204, 153));
		btnXoa.setBackground(new Color(204, 204, 153));
		btnLamMoi.setBackground(new Color(204, 204, 153));
		
		
		removeTable();
		LoadTable();
	}
	
	private void LoadCboMH() throws RemoteException {
		for(MonHoc mh : monHocService.getAllMH()) {
			cboMonHoc.addItem(mh.getMaMH() + " (" + mh.getTenMH() + ")");
		}
	}
	
	
	private void removeTable() {
		DefaultTableModel dtm = (DefaultTableModel) table.getModel();
		dtm.setRowCount(0);

	}
	private void LoadTable() throws RemoteException {
		String maMH = cboMonHoc.getSelectedItem().toString().substring(0, 6);
		List<SinhVien> list = sinhVienService.getSinhVienByMonHoc(maMH);
		for(int i = 0;i<list.size();i++) {
			model.addRow(new Object[] {
					i+1,list.get(i).getMaSV(),list.get(i).getTenSV(),list.get(i).getsDT(),list.get(i).getEmail()
			});
		}
	}

	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
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
		Object o = e.getSource();
		if(o.equals(btnTimKiem)) {
			String maT  = txtTimMa.getText().toString().trim();
			if(maT==null|| maT.isEmpty()) {
				JOptionPane.showMessageDialog(this, "Hãy nhập mã tìm kiếm");
				txtTimMa.requestFocus();

			}
			else {
				SinhVien sv = null;
				
				try {
					 sv =  sinhVienService.getSinhVien(maT);
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if(sv == null) {
					JOptionPane.showMessageDialog(this, "Không thấy sinh viên");
				}
				else {
					txtMa.setText(sv.getMaSV());
					txtEmail.setText(sv.getEmail());
					txtSDT.setText(sv.getsDT());
					txtTen.setText(sv.getTenSV());
					btnThem.setEnabled(true);
				}
			}
		}
		if(o.equals(btnThem)) {
			String maMH = cboMonHoc.getSelectedItem().toString().substring(0, 6);
			String ma = txtMa.getText().toString().trim();
			if(ma.isEmpty() || ma == null) {
				JOptionPane.showMessageDialog(this, "Vui lòng tìm sinh viên để thêm vào môn học !!!");
			}else {
				KetQua kq = new KetQua(-1);
				kq.setSinhVien(new SinhVien(ma));
				kq.setMonHoc(new MonHoc(maMH, ""));
				boolean check = false;
			
				try {
					for(SinhVien s :listSV) {
						if(s.getMaSV().toString().trim().equals(ma))
							check= true;
					}
					if(!check) {
						ketQuaService.themKQ(kq);
						listSV = sinhVienService.getSinhVienByMonHoc(maMH);
						txtMa.setText("");
						txtEmail.setText("");
						txtSDT.setText("");
						txtTen.setText("");
						removeTable();
		
						LoadTable();
						btnThem.setEnabled(false);
					}else {
						JOptionPane.showMessageDialog(this, "Sinh viên đã có trong môn học !!!");
						btnThem.setEnabled(false);
					}
					
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
		if(o.equals(btnXoa)) {
			String maMH = cboMonHoc.getSelectedItem().toString().substring(0, 6);
			int row = -1;
			row = table.getSelectedRow();
			if(row == -1) {
				JOptionPane.showMessageDialog(this, "Vui lòng chọn sinh viên muốn xóa khỏi môn học !!!");
			} else {
				int option = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn xóa sinh viên này khỏi môn học không?");
				if(option == JOptionPane.OK_OPTION) {
					
					try {
						ketQuaService.xoaKQ(maMH,listSV.get(row).getMaSV());
						listSV = sinhVienService.getSinhVienByMonHoc(maMH);
						
					} catch (RemoteException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
					
					
					removeTable();
					
	
					try {
						LoadTable();
					} catch (RemoteException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		}
		if(o.equals(btnLamMoi)) {
			cboMonHoc.removeAllItems();
			try {
				LoadCboMH();
			} catch (RemoteException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		
	}
}
