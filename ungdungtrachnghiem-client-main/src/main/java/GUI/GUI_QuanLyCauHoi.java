package GUI;

import javax.swing.JPanel;
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
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.Component;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import entity.CauHoiThi;
import entity.DapAn;
import entity.LoaiCauHoi;
import entity.MonHoc;
import service.ICauHoiThiService;
import service.IDapAnService;
import service.ILoaiCauHoiService;
import service.IMonHocService;
import view.util.RMIUrl;

import javax.swing.JButton;
import javax.swing.JTextArea;

public class GUI_QuanLyCauHoi extends JPanel implements ActionListener,MouseListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8735014626585446494L;
	private JTextField txtDA1;
	private JTextField txtDA3;
	private JTextField txtDA2;
	private JTextField txtDA4;
	private DefaultTableModel model;
	private JTable table;
	private String rmiUrl = new RMIUrl().RMIUrl();
	private ICauHoiThiService cauHoiThiService;
	private IDapAnService dapAnService;
	private ILoaiCauHoiService loaiCauHoiService;
	private IMonHocService monHocService;
	private JComboBox<String> cboMonHoc;
	private JButton btnThem;
	private JButton btnXoa;
	private JButton btnSua;
	private JButton btnLuu;
	private JComboBox<String> cboDapAnDung;
	private JComboBox<String> cboLoaiCauHoi;
	private JTextArea txtNoiDungCauHoi;
	private List<CauHoiThi> listCH;
	private boolean checkThem = false;
	private boolean checkSua = false;
	private String maGV = null;
	/**
	 * Create the panel.
	 * @throws RemoteException 
	 */
	public GUI_QuanLyCauHoi(String maGV) throws RemoteException {
		this.maGV = maGV;
		try {
			cauHoiThiService = (ICauHoiThiService) Naming.lookup("rmi://" + rmiUrl  + ":2910/iCauHoiThi");
			dapAnService = (IDapAnService) Naming.lookup("rmi://" + rmiUrl  + ":2910/iDapAn");
			loaiCauHoiService = (ILoaiCauHoiService) Naming.lookup("rmi://" + rmiUrl  + ":2910/iLoaiCauHoi");
			monHocService = (IMonHocService) Naming.lookup("rmi://" + rmiUrl  + ":2910/iMonHoc");
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		setSize(1174, 602);
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 204, 153));
		panel.setBounds(0, 0, 1174, 43);
		add(panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblQunLNgn = new JLabel("Quản lý ngân hàng câu hỏi");
		lblQunLNgn.setForeground(new Color(153, 0, 0));
		lblQunLNgn.setFont(new Font("Dialog", Font.BOLD, 25));
		panel.add(lblQunLNgn);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBounds(0, 42, 1174, 560);
		add(panel_1);
		panel_1.setBackground(new Color(51, 153, 153));
		
		JLabel lblNewLabel = new JLabel("Chọn môn học");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(10, 11, 99, 20);
		panel_1.add(lblNewLabel);
		
		cboMonHoc = new JComboBox();
		cboMonHoc.setBounds(119, 8, 426, 31);
		panel_1.add(cboMonHoc);
		
		
		
		
		String[] tb = new String[] { "STT", "Câu hỏi","Loại câu hỏi", "Đáp án 1","Đáp án 2","Đáp án 3","Đáp án 4","Đáp án đúng"};
		model= new DefaultTableModel(tb,0);
		table = new JTable(model){
		      public boolean isCellEditable(int rowIndex, int colIndex) {
		          return false;   //Disallow the editing of any cell
		        }
		      };
		table.setBounds(10, 293, 1154, 256);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 293, 1154, 239);
		panel_1.add(scrollPane);
		
		JLabel lblNewLabel_1 = new JLabel("Đáp án 1");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(645, 70, 68, 31);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Đáp án 2");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(645, 112, 68, 25);
		panel_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Đáp áp 3");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(645, 151, 68, 25);
		panel_1.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Đáp án 4");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_4.setBounds(645, 192, 68, 22);
		panel_1.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Nội dung câu hỏi");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_5.setBounds(10, 42, 130, 22);
		panel_1.add(lblNewLabel_5);
		
		txtDA1 = new JTextField();
		txtDA1.setColumns(10);
		txtDA1.setBounds(726, 69, 438, 32);
		panel_1.add(txtDA1);
		
		txtDA3 = new JTextField();
		txtDA3.setColumns(10);
		txtDA3.setBounds(726, 149, 438, 32);
		panel_1.add(txtDA3);
		
		txtDA2 = new JTextField();
		txtDA2.setColumns(10);
		txtDA2.setBounds(726, 109, 438, 32);
		panel_1.add(txtDA2);
		
		txtDA4 = new JTextField();
		txtDA4.setColumns(10);
		txtDA4.setBounds(726, 189, 438, 32);
		panel_1.add(txtDA4);
		
		JLabel lblpnng = new JLabel("Đáp án đúng");
		lblpnng.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblpnng.setBounds(10, 201, 99, 20);
		panel_1.add(lblpnng);
		
		cboDapAnDung = new JComboBox();
		cboDapAnDung.setBounds(105, 193, 440, 31);
		panel_1.add(cboDapAnDung);
		cboDapAnDung.addItem("Đáp án 1");
		cboDapAnDung.addItem("Đáp án 2");
		cboDapAnDung.addItem("Đáp án 3");
		cboDapAnDung.addItem("Đáp án 4");
		
		btnThem = new JButton("Thêm");
		btnThem.setBounds(115, 239, 148, 43);
		btnThem.setBackground(new Color(204, 204, 153));
		panel_1.add(btnThem);
	
		
		btnXoa = new JButton("Xóa");
		btnXoa.setBounds(367, 239, 148, 43);
		panel_1.add(btnXoa);
		
		 btnSua = new JButton("Sửa");
		btnSua.setBounds(634, 239, 148, 43);
		panel_1.add(btnSua);
		
		btnLuu = new JButton("Lưu");
		btnLuu.setBounds(895, 239, 148, 43);
		panel_1.add(btnLuu);
		
		 cboLoaiCauHoi = new JComboBox();
		cboLoaiCauHoi.setBounds(726, 30, 437, 31);
		panel_1.add(cboLoaiCauHoi);
		
		JLabel lblNewLabel_1_1 = new JLabel("Loại câu hỏi");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1.setBounds(626, 28, 87, 31);
		panel_1.add(lblNewLabel_1_1);
		
		
		btnSua.setBackground(new Color(204, 204, 153));
		btnLuu.setBackground(new Color(204, 204, 153));
		btnXoa.setBackground(new Color(204, 204, 153));
		txtNoiDungCauHoi = new JTextArea();
		txtNoiDungCauHoi.setBounds(10, 73, 535, 106);
		panel_1.add(txtNoiDungCauHoi);
		
		cboMonHoc.addItemListener(new ItemListener() {
			
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == ItemEvent.SELECTED) {
					try {
						loadTable();
					} catch (RemoteException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				
			}
		});
		
		btnThem.addActionListener(this);
		btnSua.addActionListener(this);
		btnLuu.addActionListener(this);
		btnXoa.addActionListener(this);
		
		table.addMouseListener(this);
		table.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 12));
		table.getTableHeader().setOpaque(false);
		table.getTableHeader().setBackground(new Color(32, 136, 203));
		table.getTableHeader().setForeground(new Color(255,255,255));
		table.setRowHeight(25);
		
		
		table.setIntercellSpacing(new java.awt.Dimension(0, 0));
		table.setRowHeight(25);
		table.setSelectionBackground(new java.awt.Color(232, 57, 95));
		table.setShowVerticalLines(false);
		
		btnLuu.setEnabled(false);
		noEditText();
		LoadCboLoaiCauHoi();
		LoadCboMH();
	}
	
	private void LoadCboLoaiCauHoi() throws RemoteException {
		for(LoaiCauHoi lch : loaiCauHoiService.getAllLoaiCauHoi()) {
			cboLoaiCauHoi.addItem(lch.getMaLoai() + " (" + lch.getTenLoai() + ")");
		}
	}
	private void LoadCboMH() throws RemoteException {
		for(MonHoc mh : monHocService.getMonHocMaGiangVien(maGV)) {
			cboMonHoc.addItem(mh.getMaMH() + " (" + mh.getTenMH() + ")");
		}
	}
	private void noEditText() {
		txtNoiDungCauHoi.setEditable(false);
		txtDA1.setEditable(false);
		txtDA2.setEditable(false);
		txtDA3.setEditable(false);
		txtDA4.setEditable(false);
		cboLoaiCauHoi.setEnabled(false);
		cboDapAnDung.setEnabled(false);
	}
	
	private void setEditText() {
		
		txtNoiDungCauHoi.setEditable(true);
		txtDA1.setEditable(true);
		txtDA2.setEditable(true);
		txtDA3.setEditable(true);
		txtDA4.setEditable(true);
		cboLoaiCauHoi.setEnabled(true);
		cboDapAnDung.setEnabled(true);
	}
	private void clearText() {
		txtDA1.setText("");
		txtNoiDungCauHoi.setText("");
		txtDA2.setText("");
		txtDA3.setText("");
		txtDA4.setText("");
	}
	
	private boolean checkText(String noidung,String da1,String da2,String da3,String da4) {
		
		if(noidung.isEmpty() || noidung == null) {
			JOptionPane.showMessageDialog(this, "Hãy nhập nội dung câu hỏi");
			txtNoiDungCauHoi.requestFocus();
			return false;
		}
		if(da1.isEmpty() || da1 == null) {
			JOptionPane.showMessageDialog(this, "Hãy nhập đáp án 1");
			txtDA1.requestFocus();
			return false;
		}
		if(da2.isEmpty() || da2 == null) {
			JOptionPane.showMessageDialog(this, "Hãy nhập đáp án 2");
			txtDA2.requestFocus();
			return false;
		}
		if(da3.isEmpty() || da3 == null) {
			JOptionPane.showMessageDialog(this, "Hãy nhập đáp án 3");
			txtDA3.requestFocus();
			return false;
		}
		if(da4.isEmpty() || da4 == null) {
			JOptionPane.showMessageDialog(this, "Hãy nhập đáp án 4");
			txtDA4.requestFocus();
			return false;
		}
		return true;
	}
	private String automatedCode() throws RemoteException {
		List<CauHoiThi> listCHT = cauHoiThiService.GetAllCauHoiThi();
		
		int i = listCHT.size() + 1;
		String maMH = "";
		
		if (listCHT.size() < 10) {
			maMH = "CH000" + i;
		} else if(listCHT.size() > 10 && listCHT.size() < 100){
			maMH = "CH00" + i;
		} else if(listCHT.size() > 100 && listCHT.size() < 1000) {
			maMH = "CH0" + i;
		} else {
			maMH = "CH" + i;
		}
		
		CauHoiThi cht = cauHoiThiService.GetCauHoiThiTheoMa(maMH);
		if(cht != null) {
			i++;
			if (listCHT.size() < 10) {
				maMH = "CH000" + i;
			} else if(listCHT.size() > 10 && listCHT.size() < 100){
				maMH = "CH00" + i;
			} else if(listCHT.size() > 100 && listCHT.size() < 1000) {
				maMH = "CH0" + i;
			} else {
				maMH = "CH" + i;
			}
		}
		
		return maMH;
	}
	private void removeTable() {
		DefaultTableModel dtm = (DefaultTableModel) table.getModel();
		dtm.setRowCount(0);

	}
	private void loadTable() throws RemoteException {
	
		String maMH = cboMonHoc.getSelectedItem().toString().substring(0, 6);
		listCH = cauHoiThiService.GetCauHoiThiTheoMonHoc(maMH);
		removeTable();
			int i = 1;
			for(CauHoiThi c : listCH) {
				LoaiCauHoi lch = loaiCauHoiService.getLoaiCauHoi(c.getLoaiCauHoi().getMaLoai());
				List<DapAn> listDA = dapAnService.GetDapAnTheoCauHoi(c.getMaCH());
				String DADung = "";
				for(DapAn da : listDA) {
					if(da.getDungSai())
						DADung = da.getNoiDungDapAn();
				}
				model.addRow(new Object[] {
					i, c.getNoiDungCH(),lch.getTenLoai(),listDA.get(0).getNoiDungDapAn(),
					listDA.get(1).getNoiDungDapAn(),listDA.get(2).getNoiDungDapAn(),
					listDA.get(3).getNoiDungDapAn(),DADung
				});
				i++;
			}
		
		
	}
	
	
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(o.equals(btnThem)) {
			if(!checkThem) {
				checkThem = true;
				btnThem.setText("Hủy");
				setEditText();
				clearText();
				btnLuu.setEnabled(true);
				btnSua.setEnabled(false);
				btnXoa.setEnabled(false);
			}else {
				checkThem = false;
				btnThem.setText("Thêm");
				noEditText();
				clearText();
				btnLuu.setEnabled(false);
				btnSua.setEnabled(true);
				btnXoa.setEnabled(true);
			}
		}
		if(o.equals(btnXoa)) {
			int row = table.getSelectedRow();
			if(row == -1) {
				JOptionPane.showMessageDialog(this, "Vui lòng chọn câu hỏi muốn xóa!!!");
			} else {
				int option = JOptionPane.showConfirmDialog(this, "Bạn có muốn xóa câu hỏi này không?");
				if(option == JOptionPane.OK_OPTION) {
					try {
						dapAnService.XoaDapAnThuocCauHoi(listCH.get(row).getMaCH());
						cauHoiThiService.XoaCauHoiThi(listCH.get(row));
						loadTable();
						
					} catch (RemoteException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		}
		if(o.equals(btnSua)) {
			int row = table.getSelectedRow();
			if(row == -1) {
				JOptionPane.showMessageDialog(this, "Vui lòng chọn đáp án muốn sửa!!!");
				return;
			} else {
				if(!checkSua) {
					checkSua = true;
					btnSua.setText("Hủy");
					setEditText();
					btnLuu.setEnabled(true);
					btnThem.setEnabled(false);
					btnXoa.setEnabled(false);
					cboMonHoc.setEnabled(false);
				}else {
					checkSua = false;
					btnSua.setText("Sửa");
					noEditText();
					btnLuu.setEnabled(false);
					btnThem.setEnabled(true);
					btnXoa.setEnabled(true);
					cboMonHoc.setEnabled(true);
				}
			}
			
		}
		if(o.equals(btnLuu)) {
			if(checkThem) {
				String maCH = "";
				try {
					maCH = automatedCode();
				} catch (RemoteException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				String noidung = txtNoiDungCauHoi.getText().trim();
				String da1 = txtDA1.getText().trim();
				String da2 = txtDA2.getText().trim();
				String da3 = txtDA3.getText().trim();
				String da4 = txtDA4.getText().trim();
				String daDung = cboDapAnDung.getSelectedItem().toString();
				String maLoai = cboLoaiCauHoi.getSelectedItem().toString().substring(0, 1);
				String maMH = cboMonHoc.getSelectedItem().toString().substring(0, 6);
				boolean ds1 = false;
				boolean ds2 = false;
				boolean ds3 = false;
				boolean ds4 = false;
				if(daDung == "Đáp án 1")
					ds1 = true;
				if(daDung == "Đáp án 2")
					ds2 = true;
				if(daDung == "Đáp án 3")
					ds3 = true;
				if(daDung == "Đáp án 4")
					ds4 = true;
				
				if(checkText(noidung,da1,da2,da3,da4)) {
					
					CauHoiThi cht = new CauHoiThi(maCH, noidung);
					cht.setLoaiCauHoi(new LoaiCauHoi(Integer.parseInt(maLoai)));
					cht.setMonHoc(new MonHoc(maMH,""));
					
					DapAn daA = new DapAn(da1,ds1,cht);
					DapAn daB = new DapAn(da2,ds2,cht);
					DapAn daC = new DapAn(da3,ds3,cht);
					DapAn daD = new DapAn(da4,ds4,cht);
					
					try {
						cauHoiThiService.ThemCauHoiThi(cht);
						dapAnService.ThemDapAn(daA);
						dapAnService.ThemDapAn(daB);
						dapAnService.ThemDapAn(daC);
						dapAnService.ThemDapAn(daD);
						loadTable();
					} catch (RemoteException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					
					checkThem = false;
					btnThem.setText("Thêm");
					noEditText();
					clearText();
					btnLuu.setEnabled(false);
					btnSua.setEnabled(true);
					btnXoa.setEnabled(true);
				}
			}
			if(checkSua) {
				
				int row = table.getSelectedRow();
				String maCH = listCH.get(row).getMaCH();
				String noidung = txtNoiDungCauHoi.getText().trim();
				String da1 = txtDA1.getText().trim();
				String da2 = txtDA2.getText().trim();
				String da3 = txtDA3.getText().trim();
				String da4 = txtDA4.getText().trim();
				String maMH = cboMonHoc.getSelectedItem().toString().substring(0, 6);
				String daDung = cboDapAnDung.getSelectedItem().toString();
				String maLoai = cboLoaiCauHoi.getSelectedItem().toString().substring(0, 1);
				boolean ds1 = false;
				boolean ds2 = false;
				boolean ds3 = false;
				boolean ds4 = false;
				if(daDung == "Đáp án 1")
					ds1 = true;
				if(daDung == "Đáp án 2")
					ds2 = true;
				if(daDung == "Đáp án 3")
					ds3 = true;
				if(daDung == "Đáp án 4")
					ds4 = true;
				
				if(checkText(noidung,da1,da2,da3,da4)) {
					
					
					CauHoiThi cht = new CauHoiThi(maCH, noidung);
					cht.setLoaiCauHoi(new LoaiCauHoi(Integer.parseInt(maLoai)));
					cht.setMonHoc(new MonHoc(maMH,""));
					DapAn daA = new DapAn(da1,ds1,cht);
					DapAn daB = new DapAn(da2,ds2,cht);
					DapAn daC = new DapAn(da3,ds3,cht);
					DapAn daD = new DapAn(da4,ds4,cht);
					
					try {
						dapAnService.XoaDapAnThuocCauHoi(maCH);
						cauHoiThiService.SuaCauHoiThi(cht);
						dapAnService.ThemDapAn(daA);
						dapAnService.ThemDapAn(daB);
						dapAnService.ThemDapAn(daC);
						dapAnService.ThemDapAn(daD);
						loadTable();
					} catch (RemoteException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					checkSua = false;
					btnSua.setText("Sửa");
					noEditText();
					btnLuu.setEnabled(false);
					btnThem.setEnabled(true);
					btnXoa.setEnabled(true);
					cboMonHoc.setEnabled(true);
				}
			}
		}
		
	}

	public void mouseClicked(MouseEvent e) {
		int row = table.getSelectedRow();
		txtNoiDungCauHoi.setText(listCH.get(row).getNoiDungCH());
		
		List<DapAn> listDA = null;
		try {
			listDA = dapAnService.GetDapAnTheoCauHoi(listCH.get(row).getMaCH());
		} catch (RemoteException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		int DADung = -1;
		int i=0;
		for(DapAn da : listDA) {
			if(da.getDungSai())
				DADung = i;
			i++;
		}
		LoaiCauHoi lch = null;
		try {
			 lch = loaiCauHoiService.getLoaiCauHoi(listCH.get(row).getLoaiCauHoi().getMaLoai());
		} catch (RemoteException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String loai =lch.getMaLoai() + " (" + lch.getTenLoai() + ")"; 
		
		txtDA1.setText(listDA.get(0).getNoiDungDapAn());
		txtDA2.setText(listDA.get(1).getNoiDungDapAn());
		txtDA3.setText(listDA.get(2).getNoiDungDapAn());
		txtDA4.setText(listDA.get(3).getNoiDungDapAn());
		cboLoaiCauHoi.setSelectedItem(loai);
		
		String dapAn = "Đáp án " + (DADung + 1);
		cboDapAnDung.setSelectedItem(dapAn);
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

}
