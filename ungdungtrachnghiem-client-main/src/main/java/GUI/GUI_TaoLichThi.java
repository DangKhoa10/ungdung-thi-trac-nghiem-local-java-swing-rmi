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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;

import javax.swing.JComboBox;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;

import java.awt.Choice;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JDayChooser;
import com.toedter.components.JSpinField;

import entity.CauHoiThi;
import entity.DapAn;
import entity.LoaiCauHoi;
import entity.MonHoc;
import entity.Thi;
import service.ICauHoiThiService;
import service.IDapAnService;
import service.IKetQuaService;
import service.ILoaiCauHoiService;
import service.IMonHocService;
import service.IThiService;
import view.util.RMIUrl;

import com.toedter.calendar.JYearChooser;
import com.toedter.calendar.JMonthChooser;
import com.toedter.calendar.JCalendar;
import com.toedter.components.JLocaleChooser;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

public class GUI_TaoLichThi extends JPanel implements ActionListener,MouseListener{
	private JTable table;
	private DefaultTableModel model;
	private JComboBox<String> cboCauHoiKho;
	private JDateChooser dateChooserDongDe;
	private JSpinner spinnerGioDongDe;
	private JSpinner spinnerPhutDongDe;
	private JButton btnTaoLich;
	private JButton btnXoa;
	private JButton btnSua;
	private JButton btnLuu;
	private JComboBox<String> cboMonHoc;
	private JDateChooser dateChooserMoDe;
	private JSpinner spinnerGioMoDe;
	private JSpinner spinnerPhutMoDe;
	private JSpinner spinnerPhutLamBai;
	private String rmiUrl = new RMIUrl().RMIUrl();
	private JSpinner spinnerSoCauHoi;
	private IMonHocService monHocService;
	private IThiService thiService;
	private ICauHoiThiService cauHoiThiService;
	private String maGV = null;
	private List<Thi> listThi;
	private boolean checkThem = false;
	private boolean checkSua = false;
	private JTextField txtTenKyThi;
	private JButton btnLM;
	/**
	 * Create the panel.
	 * @throws RemoteException 
	 */
	public GUI_TaoLichThi(String maGV) throws RemoteException {
		this.maGV = maGV;
		
		try {
			
			thiService = (IThiService) Naming.lookup("rmi://" + rmiUrl  + ":2910/iThi");
			monHocService = (IMonHocService) Naming.lookup("rmi://" + rmiUrl  + ":2910/iMonHoc");
			cauHoiThiService = (ICauHoiThiService) Naming.lookup("rmi://" + rmiUrl  + ":2910/iCauHoiThi");
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		setLayout(null);
		setSize(1174, 612);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 204, 153));
		panel.setBounds(0, 0, 1174, 43);
		add(panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblToLchThi = new JLabel("T???o L???ch Thi");
		lblToLchThi.setForeground(new Color(153, 0, 0));
		lblToLchThi.setFont(new Font("Dialog", Font.BOLD, 25));
		panel.add(lblToLchThi);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(51, 153, 153));
		panel_1.setBounds(0, 43, 1174, 559);
		add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Ch???n m??n h???c");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel.setBounds(85, 29, 127, 31);
		panel_1.add(lblNewLabel);
		
		cboMonHoc = new JComboBox();
		cboMonHoc.setBounds(241, 32, 501, 31);
		panel_1.add(cboMonHoc);
		
		JLabel lblNewLabel_1 = new JLabel("Th???i gian m??? ?????");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_1.setBounds(85, 122, 134, 31);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Th???i gian l??m b??i");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_1_1.setBounds(85, 206, 145, 23);
		panel_1.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("S??? c??u h???i");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_1_2.setBounds(376, 206, 87, 23);
		panel_1.add(lblNewLabel_1_2);
		
		 dateChooserMoDe = new JDateChooser();
		dateChooserMoDe.setBounds(241, 122, 276, 31);
		panel_1.add(dateChooserMoDe);
		
		JLabel lblNewLabel_2 = new JLabel("gi???");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_2.setBounds(604, 127, 32, 23);
		panel_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("ph??t");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_3.setBounds(701, 126, 46, 25);
		panel_1.add(lblNewLabel_3);
		
		spinnerGioMoDe = new JSpinner();
		
		spinnerGioMoDe.setModel(new SpinnerNumberModel(6, 0, 23, 1));
		spinnerGioMoDe.setBounds(549, 122, 45, 31);
		panel_1.add(spinnerGioMoDe);
		
		 spinnerPhutMoDe = new JSpinner();
		spinnerPhutMoDe.setModel(new SpinnerNumberModel(0, 0, 45, 15));
		spinnerPhutMoDe.setBounds(646, 122, 45, 31);
		panel_1.add(spinnerPhutMoDe);
		
		 spinnerPhutLamBai = new JSpinner();
		spinnerPhutLamBai.setModel(new SpinnerNumberModel(15, 15, 150, 15));
		spinnerPhutLamBai.setBounds(241, 205, 45, 31);
		panel_1.add(spinnerPhutLamBai);
		
		JLabel lblNewLabel_3_1 = new JLabel("ph??t");
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_3_1.setBounds(296, 205, 46, 25);
		panel_1.add(lblNewLabel_3_1);
		
		 spinnerSoCauHoi = new JSpinner();
		spinnerSoCauHoi.setModel(new SpinnerNumberModel(5, 5, 250, 5));
		spinnerSoCauHoi.setBounds(472, 205, 45, 31);
		panel_1.add(spinnerSoCauHoi);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("S??? l?????ng c??u h???i kh??");
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_1_2_1.setBounds(549, 206, 192, 23);
		panel_1.add(lblNewLabel_1_2_1);
		
		 cboCauHoiKho = new JComboBox<String>();
		cboCauHoiKho.setBounds(725, 205, 127, 31);
		panel_1.add(cboCauHoiKho);
		cboCauHoiKho.addItem("0%");
		cboCauHoiKho.addItem("10%");
		cboCauHoiKho.addItem("20%");
		cboCauHoiKho.addItem("30%");
		cboCauHoiKho.addItem("40%");
		cboCauHoiKho.addItem("50%");
		cboCauHoiKho.addItem("60%");
		cboCauHoiKho.addItem("70%");
		cboCauHoiKho.addItem("80%");
		cboCauHoiKho.addItem("90%");
		cboCauHoiKho.addItem("100%");
		
		JLabel lblNewLabel_1_3 = new JLabel("Th???i gian ????ng ?????");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_1_3.setBounds(85, 164, 140, 31);
		panel_1.add(lblNewLabel_1_3);
		
		 dateChooserDongDe = new JDateChooser();
		dateChooserDongDe.setBounds(241, 164, 276, 31);
		panel_1.add(dateChooserDongDe);
		
		 spinnerGioDongDe = new JSpinner();
		 spinnerGioDongDe.setModel(new SpinnerNumberModel(6, 0, 23, 1));
		spinnerGioDongDe.setBounds(549, 164, 45, 31);
		panel_1.add(spinnerGioDongDe);
		
		JLabel lblNewLabel_2_1 = new JLabel("gi???");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_2_1.setBounds(604, 169, 32, 23);
		panel_1.add(lblNewLabel_2_1);
		
		 spinnerPhutDongDe = new JSpinner();
		 spinnerPhutDongDe.setModel(new SpinnerNumberModel(0, 0, 45, 15));
		spinnerPhutDongDe.setBounds(646, 164, 45, 31);
		panel_1.add(spinnerPhutDongDe);
		
		JLabel lblNewLabel_3_2 = new JLabel("ph??t");
		lblNewLabel_3_2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_3_2.setBounds(701, 168, 46, 25);
		panel_1.add(lblNewLabel_3_2);
		
		 btnTaoLich = new JButton("T???o");
		btnTaoLich.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnTaoLich.setBounds(85, 240, 145, 48);
		panel_1.add(btnTaoLich);
		
		 btnXoa = new JButton("X??a");
		btnXoa.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnXoa.setBounds(296, 240, 145, 48);
		panel_1.add(btnXoa);
		
		 btnSua = new JButton("S???a");
		btnSua.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnSua.setBounds(504, 240, 145, 48);
		panel_1.add(btnSua);
		
		 btnLuu = new JButton("L??u");
		btnLuu.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnLuu.setBounds(713, 240, 145, 48);
		panel_1.add(btnLuu);
		
		String[] tb = new String[] { "STT" ,"K??? Thi", "Th???i gian m??? ?????","Th???i gian ????ng ?????","Th???i gian l??m b??i","S??? c??u h???i","Ph???n tr??m c??u h???i kh??"};
		model= new DefaultTableModel(tb,0);
		table = new JTable(model){
		      public boolean isCellEditable(int rowIndex, int colIndex) {
		          return false;   //Disallow the editing of any cell
		        }
		      };
		table.setBounds(85, 299, 1009, 249);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		JScrollPane jScrollPane = new JScrollPane(table);
		jScrollPane.setBounds(85, 299, 1009, 238);
		panel_1.add(jScrollPane);
		
		spinnerGioMoDe.setEditor(new JSpinner.DefaultEditor(spinnerGioMoDe));
		spinnerSoCauHoi.setEditor(new JSpinner.DefaultEditor(spinnerSoCauHoi));
		spinnerPhutLamBai.setEditor(new JSpinner.DefaultEditor(spinnerPhutLamBai));
		spinnerGioDongDe.setEditor(new JSpinner.DefaultEditor(spinnerGioDongDe));
		spinnerPhutDongDe.setEditor(new JSpinner.DefaultEditor(spinnerPhutDongDe));
		spinnerPhutMoDe.setEditor(new JSpinner.DefaultEditor(spinnerPhutMoDe));
		
		JLabel lblNewLabel_1_4 = new JLabel("T??n k??? thi");
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_1_4.setBounds(85, 80, 134, 31);
		panel_1.add(lblNewLabel_1_4);
		
		txtTenKyThi = new JTextField();
		txtTenKyThi.setBounds(241, 80, 501, 31);
		panel_1.add(txtTenKyThi);
		txtTenKyThi.setColumns(10);
		
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
		
		btnTaoLich.setBackground(new Color(204, 204, 153));
		btnLuu.setBackground(new Color(204, 204, 153));
		btnXoa.setBackground(new Color(204, 204, 153));
		btnSua.setBackground(new Color(204, 204, 153));
		
		
		btnTaoLich.addActionListener(this);
		btnLuu.addActionListener(this);
		btnXoa.addActionListener(this);
		btnSua.addActionListener(this);
		
		
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
		
		btnLM = new JButton("L??m M???i");
		btnLM.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnLM.setBackground(new Color(204, 204, 153));
		btnLM.setBounds(914, 240, 145, 48);
		panel_1.add(btnLM);
		
		
		btnLM.addActionListener(this);
		LoadCboMH();
		loadTable();
		noEditText();
	}
	private void removeTable() {
		DefaultTableModel dtm = (DefaultTableModel) table.getModel();
		dtm.setRowCount(0);

	}
	private void loadTable() throws RemoteException {
		removeTable();
		listThi = null;
		String maMH = "";
		if(cboMonHoc.getSelectedItem()!=null)
		 maMH = cboMonHoc.getSelectedItem().toString().substring(0, 6);
		listThi = thiService.GetAllLichThiTheoMon(maMH);
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");

		int i = 1;
		for(Thi thi : listThi) {
			Vector<Comparable> vector = new Vector<Comparable>();
			vector.add(i);
			vector.add(thi.getTenKyThi());
			
			
			vector.add(simpleDateFormat.format(thi.getThoiGianMoDe()) + " " + thi.getThoiGianMoDe().getHours() + " gi??? " + thi.getThoiGianMoDe().getMinutes() + " ph??t");
			vector.add(simpleDateFormat.format(thi.getThoiGianDongDe()) + " " + thi.getThoiGianDongDe().getHours() + " gi??? " + thi.getThoiGianDongDe().getMinutes() + " ph??t");
			vector.add(thi.getThoiGianLambai());
			vector.add(thi.getSoCauHoi());
			vector.add(thi.getPhanTramCauHoiKho());
			model.addRow(vector);
			i++;
		}
		
		
	}

	private void noEditText() {
		txtTenKyThi.setEditable(false);
		spinnerSoCauHoi.setEnabled(false);
		spinnerPhutLamBai.setEnabled(false);
		spinnerGioDongDe.setEnabled(false);
		spinnerGioMoDe.setEnabled(false);
		spinnerPhutDongDe.setEnabled(false);
		spinnerPhutMoDe.setEnabled(false);
		dateChooserDongDe.setEnabled(false);
		dateChooserMoDe.setEnabled(false);
		cboCauHoiKho.setEnabled(false);
	}

	
	private void setEditText() {
		txtTenKyThi.setEditable(true);
		spinnerSoCauHoi.setEnabled(true);
		spinnerPhutLamBai.setEnabled(true);
		spinnerGioDongDe.setEnabled(true);
		spinnerGioMoDe.setEnabled(true);
		spinnerPhutDongDe.setEnabled(true);
		spinnerPhutMoDe.setEnabled(true);
		dateChooserDongDe.setEnabled(true);
		dateChooserMoDe.setEnabled(true);
		cboCauHoiKho.setEnabled(true);
	}
	private void clearText() {
		txtTenKyThi.setText("");
	}
	@SuppressWarnings("deprecation")
	private boolean checkText(Date ngayMD,int gioMD,int phutMD,Date ngayDD,int gioDD,int phutDD,String tenKT,int phutLamBai,int phantram,int soCauHoi,String maMH) {
		if(tenKT.isEmpty() || tenKT == null) {
			JOptionPane.showMessageDialog(this, "H??y nh???p t??n k??? thi");
			txtTenKyThi.requestFocus();
			return false;
		}
		if( ngayMD == null) {
			JOptionPane.showMessageDialog(this, "H??y ch???n ng??y m??? ?????");
			return false;
		}
		if( ngayDD == null) {
			JOptionPane.showMessageDialog(this, "H??y ch???n ng??y ????ng ?????");
			return false;
		}
		Date now = new Date();
		
		
		ngayMD.setHours(gioMD);
		ngayMD.setMinutes(phutMD);
		ngayMD.setSeconds(0);
		ngayDD.setHours(gioDD);
		ngayDD.setMinutes(phutDD);
		ngayDD.setSeconds(0);
		
		if( ngayMD.before(now)) {
			JOptionPane.showMessageDialog(this, "Th???i gian m??? ????? ph???i sau th???i gian hi???n t???i");
			return false;
		}
		if( ngayDD.before(now)) {
			JOptionPane.showMessageDialog(this, "Th???i gian ????ng ????? ph???i sau th???i gian hi???n t???i");
			return false;
		}
		
		if(ngayMD.after(ngayDD)) {
			JOptionPane.showMessageDialog(this, "Th???i gian m??? ????? ph???i tr?????c th???i gian ????ng ?????");
			return false;
		}
		
		
		
		

		int h = phutLamBai/60;
		int m = phutLamBai%60;
		ngayMD.setHours(gioMD+h);
		ngayMD.setMinutes(phutMD+m);
		ngayMD.setSeconds(0);
		if(ngayMD.after(ngayDD)) {
			JOptionPane.showMessageDialog(this, "Kho???ng th???i gian t??? m??? ????? ?????n ????ng ????? ph???i ????? th???i gian l??m b??i");
			return false;
		}
		
		
		
		
	
		int soCauKho = Math.round((phantram*soCauHoi)/100);
		int soCauDe = soCauHoi - soCauKho;
		
		ArrayList<CauHoiThi> cauhoiAll = new ArrayList<>();
		ArrayList<CauHoiThi> cauhoiKho = new ArrayList<>();
		ArrayList<CauHoiThi> cauhoiDe = new ArrayList<>();
		try {
			cauhoiAll = (ArrayList<CauHoiThi>) cauHoiThiService.GetCauHoiThiTheoMonHoc(maMH);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(CauHoiThi c : cauhoiAll) {
			if(c.getLoaiCauHoi().getMaLoai() == 1)
				cauhoiKho.add(c);
			else
				cauhoiDe.add(c);
		}
		
		if(cauhoiKho.size()<soCauKho) {
			JOptionPane.showMessageDialog(this, "S??? c??u h???i kh?? kh??ng ????? " + soCauKho + " c??u trong b??? c??u h???i , vui l??ng b??? sung th??m c??u h???i kh?? cho m??n h???c !!!");
			return false;
		}
		if(cauhoiDe.size()<soCauDe) {
			JOptionPane.showMessageDialog(this, "S??? c??u h???i d??? kh??ng ????? " + soCauDe + " c??u trong b??? c??u h???i , vui l??ng b??? sung th??m c??u h???i d??? cho m??n h???c !!!");
			return false;
		}
		
		
		
		
		return true;
	}
	
	private void LoadCboMH() throws RemoteException {
		for(MonHoc mh : monHocService.getMonHocMaGiangVien(maGV)) {
			cboMonHoc.addItem(mh.getMaMH() + " (" + mh.getTenMH() + ")");
		}
	}
	
	public void mouseClicked(MouseEvent e) {
		int row = table.getSelectedRow();
		Thi thi = listThi.get(row);
		txtTenKyThi.setText(thi.getTenKyThi());
		dateChooserMoDe.setDate(thi.getThoiGianMoDe());
		dateChooserDongDe.setDate(thi.getThoiGianDongDe());
		spinnerGioMoDe.setValue(thi.getThoiGianMoDe().getHours());
		spinnerGioDongDe.setValue(thi.getThoiGianDongDe().getHours());
		spinnerPhutDongDe.setValue(thi.getThoiGianDongDe().getMinutes());
		spinnerPhutMoDe.setValue(thi.getThoiGianMoDe().getMinutes());
		spinnerPhutLamBai.setValue(thi.getThoiGianLambai());
		spinnerSoCauHoi.setValue(thi.getSoCauHoi());
		cboCauHoiKho.setSelectedItem(thi.getPhanTramCauHoiKho()+"%");
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

	@SuppressWarnings("deprecation")
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(o.equals(btnTaoLich)) {
	
			
				if(!checkThem) {
					checkThem = true;
					btnTaoLich.setText("H???y");
					setEditText();
					clearText();
					btnLuu.setEnabled(true);
					btnSua.setEnabled(false);
					btnXoa.setEnabled(false);
				}else {
					checkThem = false;
					btnTaoLich.setText("T???o L???ch");
					noEditText();
					clearText();
					btnLuu.setEnabled(false);
					btnSua.setEnabled(true);
					btnXoa.setEnabled(true);
				}
			}
			
			
		
		if(o.equals(btnSua)) {
			int row = table.getSelectedRow();
			if(row == -1) {
				JOptionPane.showMessageDialog(this, "Vui l??ng ch???n ????p ??n mu???n s???a!!!");
				return;
			} else {
				if(!checkSua) {
					checkSua = true;
					btnSua.setText("H???y");
					setEditText();
					btnLuu.setEnabled(true);
					btnTaoLich.setEnabled(false);
					btnXoa.setEnabled(false);
					cboMonHoc.setEnabled(false);
				}else {
					checkSua = false;
					btnSua.setText("S???a");
					noEditText();
					btnLuu.setEnabled(false);
					btnTaoLich.setEnabled(true);
					btnXoa.setEnabled(true);
					cboMonHoc.setEnabled(true);
				}
			}
			
		}
		if(o.equals(btnLuu)) {
			if(checkThem) {
				String maMH = cboMonHoc.getSelectedItem().toString().substring(0, 6);
				String ten = txtTenKyThi.getText().trim();
				
				Date ngayMoDe = dateChooserMoDe.getDate();
				int gioMoDe = (Integer) spinnerGioMoDe.getValue();
				int phutMoDe = (Integer) spinnerPhutMoDe.getValue();
				
				Date ngayDongDe = dateChooserDongDe.getDate();
				
				int gioDongDe = (Integer) spinnerGioDongDe.getValue();
				int phutDongDe = (Integer) spinnerPhutDongDe.getValue();

				int soCauHoi = (Integer) spinnerSoCauHoi.getValue();
				
				int phutLamBai = (Integer) spinnerPhutLamBai.getValue();
				
				String[] ptram = cboCauHoiKho.getSelectedItem().toString().split("\\%");
				
				int phantram = Integer.parseInt(ptram[0]);
				
				if(checkText(ngayMoDe,gioMoDe,phutMoDe,ngayDongDe,gioDongDe,phutDongDe,ten,phutLamBai,phantram,soCauHoi,maMH)) {
					
					ngayMoDe.setHours(gioMoDe);
					ngayMoDe.setMinutes(phutMoDe);
					ngayMoDe.setSeconds(0);
					ngayDongDe.setHours(gioDongDe);
					ngayDongDe.setMinutes(phutDongDe);
					ngayDongDe.setSeconds(0);
					Thi thi = new Thi(ten,phutLamBai,ngayMoDe,ngayDongDe,soCauHoi,phantram,new MonHoc(maMH, ""));
					
					try {
						thiService.ThemLichThi(thi);
						loadTable();
					} catch (RemoteException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					checkThem = false;
					btnTaoLich.setText("T???o L???ch");
					noEditText();
					clearText();
					btnLuu.setEnabled(false);
					btnSua.setEnabled(true);
					btnXoa.setEnabled(true);
				}
			}
			if(checkSua) {
				String maMH = cboMonHoc.getSelectedItem().toString().substring(0, 6);
				String ten = txtTenKyThi.getText().trim();
				int row = table.getSelectedRow();
				int maThi = listThi.get(row).getMaThi();
				Date ngayMoDe = dateChooserMoDe.getDate();
				int gioMoDe = (Integer) spinnerGioMoDe.getValue();
				int phutMoDe = (Integer) spinnerPhutMoDe.getValue();
				
				Date ngayDongDe = dateChooserDongDe.getDate();
				
				int gioDongDe = (Integer) spinnerGioDongDe.getValue();
				int phutDongDe = (Integer) spinnerPhutDongDe.getValue();

				int soCauHoi = (Integer) spinnerSoCauHoi.getValue();
				
				int phutLamBai = (Integer) spinnerPhutLamBai.getValue();
				
				String[] ptram = cboCauHoiKho.getSelectedItem().toString().split("\\%");
				
				int phantram = Integer.parseInt(ptram[0]);
				
				if(checkText(ngayMoDe,gioMoDe,phutMoDe,ngayDongDe,gioDongDe,phutDongDe,ten,phutLamBai,phantram,soCauHoi,maMH)) {
					
					ngayMoDe.setHours(gioMoDe);
					ngayMoDe.setMinutes(phutMoDe);
					ngayMoDe.setSeconds(0);
					ngayDongDe.setHours(gioDongDe);
					ngayDongDe.setMinutes(phutDongDe);
					ngayDongDe.setSeconds(0);
					Thi thi = new Thi(ten,phutLamBai,ngayMoDe,ngayDongDe,soCauHoi,phantram,new MonHoc(maMH, ""));
					thi.setMaThi(maThi);
					try {
						thiService.SuaLichThi(thi);
						loadTable();
					} catch (RemoteException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					checkSua = false;
					btnSua.setText("S???a");
					noEditText();
					btnLuu.setEnabled(false);
					btnTaoLich.setEnabled(true);
					btnXoa.setEnabled(true);
					cboMonHoc.setEnabled(true);
				}
			}
		}
		if(o.equals(btnXoa)) {
			int row = table.getSelectedRow();
			if(row == -1) {
				JOptionPane.showMessageDialog(this, "Vui l??ng ch???n l???ch thi mu???n x??a!!!");
				return;
			} else {
				int option = JOptionPane.showConfirmDialog(this, "B???n c?? ch???c ch???n mu???n x??a l???ch thi n??y kh??ng?");
				if(option == JOptionPane.OK_OPTION) {
					try {
						thiService.XoaLichThi(listThi.get(row));
						loadTable();
					} catch (RemoteException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				
			}
		}
		if(o.equals(btnLM)) {
			try {
				cboMonHoc.removeAllItems();
				LoadCboMH();
				
			} catch (RemoteException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				loadTable();
			} catch (RemoteException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
		
	}
}
