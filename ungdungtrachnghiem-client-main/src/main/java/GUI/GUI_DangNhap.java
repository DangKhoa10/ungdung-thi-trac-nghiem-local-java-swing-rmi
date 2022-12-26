package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import entity.TaiKhoan;
import service.ITaiKhoanService;
import view.util.RMIUrl;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;

public class GUI_DangNhap extends JFrame {
	
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 4019826907666323909L;
	private JPanel contentPane;
	private JTextField txtTaiKhoan;
	private JPasswordField txtMatKhau;
	private String rmiUrl = new RMIUrl().RMIUrl();
	private ITaiKhoanService taiKhoanService;
	static JFrame frame;

	
	/*
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public GUI_DangNhap() {
		
		try {
			taiKhoanService = (ITaiKhoanService) Naming.lookup("rmi://" + rmiUrl  + ":2910/iTaiKhoan");
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		setTitle("\u0110\u0103ng nh\u1EADp");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("T\u00E0i kho\u1EA3n");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(26, 62, 95, 14);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("M\u1EADt kh\u1EA9u");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(26, 111, 95, 14);
		contentPane.add(lblNewLabel_2);
		
		
		

		JButton btnDangNhap = new JButton("\u0110\u0103ng nh\u1EADp");
		btnDangNhap.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				if (txtTaiKhoan.getText().trim().isEmpty() || txtMatKhau.getText().trim().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Nhập đầy đủ thông tin", null, JOptionPane.ERROR_MESSAGE);
					return;
				}
			
				
						
						
						TaiKhoan tk;
						try {
							tk = taiKhoanService.getTaiKhoanByUserNamePassword(txtTaiKhoan.getText().trim(), txtMatKhau.getText().trim());
							if (tk == null) {
								new JOptionPane();
								JOptionPane.showMessageDialog(null, "Tài khoản không chính xác", null, JOptionPane.ERROR_MESSAGE);
								txtTaiKhoan.requestFocus();
							} else {
								if (txtMatKhau.getText().trim().equals(tk.getPassword())) {
									GUI_Main main = new GUI_Main(tk);
									main.setVisible(true);
									main.setLocationRelativeTo(null);
									setVisible(false);
								} else {

									new JOptionPane();
									JOptionPane.showMessageDialog(null, "Mật khẩu không chính xác", null,
											JOptionPane.ERROR_MESSAGE);
									txtMatKhau.requestFocus();
								}
							}
						} catch (RemoteException e2) {
							// TODO Auto-generated catch block
							e2.printStackTrace();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					
						
					
						
					

			}
				
		});
		btnDangNhap.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnDangNhap.setBounds(53, 166, 193, 46);
		contentPane.add(btnDangNhap);

		txtTaiKhoan = new JTextField();
		txtTaiKhoan.setBounds(114, 56, 283, 31);
		contentPane.add(txtTaiKhoan);
		txtTaiKhoan.setColumns(10);

		txtMatKhau = new JPasswordField();
		txtMatKhau.setBounds(114, 105, 283, 31);
		contentPane.add(txtMatKhau);

		JButton btnThoat = new JButton("Thoát");
		btnThoat.addActionListener(new ActionListener() {
			@SuppressWarnings("static-access")
			public void actionPerformed(ActionEvent e) {
				int question = new JOptionPane().showConfirmDialog(null, "Bạn có muốn thoát?", "Thông báo",
						JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
				if (question == JOptionPane.YES_OPTION)
					System.exit(0);

			}
		});
		btnThoat.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnThoat.setBounds(256, 166, 115, 46);
		contentPane.add(btnThoat);
		
		btnDangNhap.setBackground(new Color(204, 204, 153));
		btnThoat.setBackground(new Color(204, 204, 153));
		
		
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 204, 153));
		panel.setBounds(0, 0, 434, 43);
		contentPane.add(panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblngNhp = new JLabel("Đăng nhập");
		lblngNhp.setForeground(new Color(153, 0, 0));
		lblngNhp.setFont(new Font("Dialog", Font.BOLD, 25));
		panel.add(lblngNhp);
		
		getContentPane().setBackground(new Color(51, 153, 153));
	}
}
