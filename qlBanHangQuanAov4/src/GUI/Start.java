package GUI;

import javax.swing.SwingUtilities;

public class Start {
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				BackGround backGound = new BackGround();
				DangNhap dangNhap = new DangNhap();

				backGound.setVisible(true);
				backGound.handleOpen(dangNhap);
			}
		});
	}
}
