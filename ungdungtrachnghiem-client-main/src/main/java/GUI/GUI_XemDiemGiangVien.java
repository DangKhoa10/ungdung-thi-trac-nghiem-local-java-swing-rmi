package GUI;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import dto.KetQuaSinhVien;
import entity.MonHoc;
import entity.SinhVien;
import service.IKetQuaService;
import service.IMonHocService;
import service.ISinhVienService;
import view.util.RMIUrl;

import javax.swing.JComboBox;
import javax.swing.JButton;

public class GUI_XemDiemGiangVien extends JPanel implements ActionListener{
	private JTable table;
	private DefaultTableModel model;

	private IMonHocService monHocService;
	private IKetQuaService ketQuaService;
	private String rmiUrl = new RMIUrl().RMIUrl();
	private String maGV = null;
	private JComboBox cboMonHoc;
	private JButton btnLamMoi;
	/**
	 * Create the panel.
	 * @throws RemoteException 
	 */
	public GUI_XemDiemGiangVien(String maGV) throws RemoteException {
		this.maGV = maGV;
		try {
			ketQuaService = (IKetQuaService) Naming.lookup("rmi://" + rmiUrl  + ":2910/iKetQua");
			monHocService = (IMonHocService) Naming.lookup("rmi://" + rmiUrl  + ":2910/iMonHoc");
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
		
		JLabel lblimThi = new JLabel("Điểm Thi");
		lblimThi.setForeground(new Color(153, 0, 0));
		lblimThi.setFont(new Font("Dialog", Font.BOLD, 25));
		panel.add(lblimThi);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBounds(0, 45, 1174, 556);
		add(panel_1);
		
		String[] tb = new String[] { "STT","Mã" ,"Họ Tên","SDT","Email", "Điểm"};
		model= new DefaultTableModel(tb,0);
		table = new JTable(model){
		      public boolean isCellEditable(int rowIndex, int colIndex) {
		          return false;   //Disallow the editing of any cell
		        }
		      };
		table.setBounds(10, 71, 1154, 474);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 12));
		table.getTableHeader().setOpaque(false);
		table.getTableHeader().setBackground(new Color(32, 136, 203));
		table.getTableHeader().setForeground(new Color(255,255,255));
		table.setRowHeight(25);
		
		
		table.setIntercellSpacing(new java.awt.Dimension(0, 0));
		table.setRowHeight(25);
		table.setSelectionBackground(new java.awt.Color(232, 57, 95));
		table.setShowVerticalLines(false);
		
		JScrollPane jScrollPane = new JScrollPane(table);
		jScrollPane.setBounds(10, 71, 1154, 455);
		panel_1.add(jScrollPane);
		
		JLabel lblNewLabel = new JLabel("Môn học");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel.setBounds(10, 26, 87, 21);
		panel_1.add(lblNewLabel);
		
		 cboMonHoc = new JComboBox();
		cboMonHoc.setBounds(86, 25, 223, 29);
		panel_1.add(cboMonHoc);
		
		 btnLamMoi = new JButton("Làm mới kết quả");
		btnLamMoi.setBounds(998, 26, 166, 34);
		panel_1.add(btnLamMoi);
		
		panel_1.setBackground(new Color(51, 153, 153));
		btnLamMoi.setBackground(new Color(204, 204, 153));
		
		btnLamMoi.addActionListener(this);
		cboMonHoc.addActionListener(this);
		
		LoadCboMH();
		LoadTable();
	}
	
	private void LoadCboMH() throws RemoteException {
		cboMonHoc.removeAllItems();
		for(MonHoc mh : monHocService.getMonHocMaGiangVien(maGV)) {
			cboMonHoc.addItem(mh.getMaMH() + " (" + mh.getTenMH() + ")");
		}
	}
	
	private void removeTable() {
		DefaultTableModel dtm = (DefaultTableModel) table.getModel();
		dtm.setRowCount(0);

	}
	private void LoadTable() throws RemoteException {
		removeTable();
		String maMH = cboMonHoc.getSelectedItem().toString().substring(0, 6);
		List<KetQuaSinhVien> list = ketQuaService.getDiemSVcuaMH(maMH);
		for(int i = 0;i<list.size();i++) {
			String diem = "Chưa có điểm";
			if(list.get(i).getDiem()!=-1)
				diem = list.get(i).getDiem()+"";
			model.addRow(new Object[] {
					i+1,list.get(i).getMaSV(),list.get(i).getTenSV(),list.get(i).getSdt(),list.get(i).getEmail(),diem
			});
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(o.equals(btnLamMoi)) {
			try {
				LoadTable();
			} catch (RemoteException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if(o.equals(cboMonHoc)) {
			try {
				LoadTable();
			} catch (RemoteException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
	}

}
