package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import entity.TaiKhoan;
import service.ITaiKhoanService;
import view.util.RMIUrl;

import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.rmi.Naming;
import java.rmi.RemoteException;

import javax.swing.JPasswordField;
import javax.swing.JButton;

public class GUI_DoiMatKhau extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JPasswordField txtMKCu;
	private JPasswordField txtMKMoi;
	private JPasswordField txtNhapLaiMKMoi;
	private String rmiUrl = new RMIUrl().RMIUrl();
	private ITaiKhoanService taiKhoanService;
	private JButton btnDoiMatKhau;
	private JButton btnThoat;
	private TaiKhoan taiKhoan;
	

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public GUI_DoiMatKhau(TaiKhoan tk) {
		
		taiKhoan = tk;
		

		try {
			taiKhoanService = (ITaiKhoanService) Naming.lookup("rmi://" + rmiUrl  + ":2910/iTaiKhoan");
		} catch (Exception e) {
			// TODO: handle exception
		}
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 204, 153));
		panel.setBounds(0, 0, 434, 43);
		contentPane.add(panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblQunLNgn = new JLabel("Đổi mật khẩu");
		lblQunLNgn.setForeground(new Color(153, 0, 0));
		lblQunLNgn.setFont(new Font("Dialog", Font.BOLD, 25));
		panel.add(lblQunLNgn);
		
		txtMKCu = new JPasswordField();
		txtMKCu.setBounds(166, 54, 230, 33);
		contentPane.add(txtMKCu);
		
		txtMKMoi = new JPasswordField();
		txtMKMoi.setBounds(166, 98, 230, 33);
		contentPane.add(txtMKMoi);
		
		
		
		txtNhapLaiMKMoi = new JPasswordField();
		txtNhapLaiMKMoi.setBounds(166, 142, 230, 33);
		contentPane.add(txtNhapLaiMKMoi);
		
		JLabel lblNewLabel = new JLabel("Mật khẩu cũ");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel.setBounds(20, 62, 103, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblMtKhuMi = new JLabel("Mật khẩu mới");
		lblMtKhuMi.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblMtKhuMi.setBounds(20, 106, 103, 14);
		contentPane.add(lblMtKhuMi);
		
		JLabel lblNewLabel_1_1 = new JLabel("Nhập lại mật khẩu mới");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_1.setBounds(20, 151, 136, 14);
		contentPane.add(lblNewLabel_1_1);
		
		 btnDoiMatKhau = new JButton("Đổi mật khẩu");
		btnDoiMatKhau.setBounds(92, 197, 128, 33);
		contentPane.add(btnDoiMatKhau);
		btnDoiMatKhau.addActionListener(this);
		
		 btnThoat = new JButton("Thoát");
		btnThoat.setBounds(230, 197, 128, 33);
		contentPane.add(btnThoat);
		btnThoat.addActionListener(this);
		
		contentPane.setBackground(new Color(51, 153, 153));
	}
	
	private boolean check(String mktk,String mkc,String mkm,String mkmnl) {
		
		
		if(mkc.isEmpty() || mkc == null) {
			JOptionPane.showMessageDialog(this, "Chưa nhập mật khẩu cũ");
			txtMKCu.requestFocus();
			return false;
		}
		if(!mktk.equals(mkc)) {
			JOptionPane.showMessageDialog(this, "Mật khẩu cũ không đúng");
			return false;
		}
		if(mkm.isEmpty() || mkm == null) {
			JOptionPane.showMessageDialog(this, "Chưa nhập mật khẩu mới");
			txtMKMoi.requestFocus();
			return false;
		}
		if(mkmnl.isEmpty() || mkmnl == null) {
			JOptionPane.showMessageDialog(this, "Nhập lại mật khẩu mới");
			txtNhapLaiMKMoi.requestFocus();
			return false;
		}
		if(!mkmnl.equals(mkm)) {
			JOptionPane.showMessageDialog(this, "Mật khẩu mới chưa trùng khớp");
			return false;
		}
		
		
		return true;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(o.equals(btnDoiMatKhau)) {
			String mkCu = txtMKCu.getText().toString().trim();
			String mkMoi = txtMKMoi.getText().toString().trim();
			String mkMoiNL = txtNhapLaiMKMoi.getText().toString().trim();
			String mk=taiKhoan.getPassword().toString();
			if(check(mk,mkCu, mkMoi, mkMoiNL)) {
				TaiKhoan tk = new TaiKhoan();
				tk.setUsername(taiKhoan.getUsername());
				tk.setPassword(mkMoi);
				try {
					boolean ok = taiKhoanService.DoiMatKhau(tk);
					if(ok) {
						JOptionPane.showMessageDialog(this, "Đổi mật khẩu thành công");
						dispose();
					}
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		}
		if(o.equals(btnThoat)) {
			int option = JOptionPane.showConfirmDialog(this, "Bạn có muốn đóng?");
			if(option == JOptionPane.OK_OPTION) {
				dispose();
			}
		}
		
	}
}
