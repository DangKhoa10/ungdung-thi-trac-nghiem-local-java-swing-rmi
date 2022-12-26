package app;

import java.awt.EventQueue;

import GUI.GUI_DangNhap;


public class App {
	public static void main(String[] args) {
		
		
			
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						GUI_DangNhap frame = new GUI_DangNhap();
						frame.setVisible(true);
						frame.setLocationRelativeTo(null);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		
		
	}
}
