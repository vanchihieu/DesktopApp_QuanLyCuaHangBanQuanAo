package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import components.button.Button;
import components.textField.TextField;
import dao.KichThuoc_Dao;
import entity.KichThuoc;
import entity.MauSac;
import utils.Utils;

public class Form_ThemKichThuoc extends JDialog implements ActionListener{
	private final int widthPnlContainer = 500;
	private TextField txtTenKichThuoc;
	private Button btnThem;
	private Button btnHuy;
	private QuanLySanPham qlSP;
	private KichThuoc_Dao KichThuoc_dao;
	public Form_ThemKichThuoc(JPanel parent) {
		setSize(500, 300);
		setTitle("Thêm kích thước");
		setLocationRelativeTo(null);
		setLayout(null);
		qlSP = (QuanLySanPham)parent;
		KichThuoc_dao = new KichThuoc_Dao();
		
		int topPnlControl = Utils.getBodyHeight() - 80;
		
		JPanel pnlContainer = new JPanel();
		pnlContainer.setBackground(new Color(203, 239, 255));
		pnlContainer.setBounds(0, 0, widthPnlContainer, 220);
		pnlContainer.setLayout(null);
		this.add(pnlContainer);
		
		JPanel pnlHeader = new JPanel();
		pnlHeader.setBackground(new Color(203, 239, 255));
		pnlHeader.setBounds(16, 18, 1000, 50);
		pnlContainer.add(pnlHeader);
		pnlHeader.setLayout(null);
		
		JLabel lblTitle = new JLabel("Thêm kích thước");
		lblTitle.setBounds(100, 10, 500, 30);
		lblTitle.setFont(new Font("Segoe UI", Font.PLAIN, 26));
		pnlHeader.add(lblTitle);
		
		JPanel pnlRow1 = new JPanel();
		pnlRow1.setBackground(new Color(203, 239, 255));
		pnlRow1.setBounds(100, 100, 550, 55);
		add(pnlRow1);
		pnlRow1.setLayout(null);
		
		txtTenKichThuoc = new TextField();
		txtTenKichThuoc.setLabelText("Tên kích thước:");
		txtTenKichThuoc.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		txtTenKichThuoc.setBackground(new Color(203, 239, 255));
		txtTenKichThuoc.setBounds(0, 0, 250, 55);
		pnlRow1.add(txtTenKichThuoc);
		
		JPanel pnlActions = new JPanel();
		pnlActions.setBackground(new Color(203, 239, 255));
		pnlActions.setBounds(0, 220, 500, 60);
//		top += padding + 55;
		add(pnlActions);
		pnlActions.setLayout(null);
		
		btnThem = new Button("Thêm");
		btnThem.setFocusable(false);
		btnThem.setIcon(Utils.getImageIcon("plus.png"));
		btnThem.setRadius(4);
		btnThem.setForeground(Color.WHITE);
		btnThem.setColor(new Color(134, 229, 138));
		btnThem.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		btnThem.setBounds(904, -2, 150, 40);
		btnThem.setBorderColor(Utils.secondaryColor);
		btnThem.setColorOver(new Color(134, 229, 138));
		btnThem.setColorClick(new Color(59, 238, 66));
		btnThem.setBorder(new EmptyBorder(0, 0, 0, 0));
		btnThem.setBounds(70, 0, 150, 40);

		pnlActions.add(btnThem);
		
		
		btnHuy = new Button("Hủy");
		btnHuy.setIcon(Utils.getImageIcon("close_16X16.png"));
		btnHuy.setRadius(4);
		btnHuy.setForeground(Color.WHITE);
		btnHuy.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		btnHuy.setColorOver(Utils.primaryColor);
		btnHuy.setColorClick(new Color(161, 184, 186));
		btnHuy.setColor(Utils.primaryColor);
		btnHuy.setBorderColor(Utils.secondaryColor);
		btnHuy.setBorder(new EmptyBorder(0, 0, 0, 0));
		btnHuy.setBounds(280, 0, 150, 40);
		pnlActions.add(btnHuy);
		
		btnThem.addActionListener(this);
		btnHuy.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object src = e.getSource();
		if(src.equals(btnThem)) {
//			JOptionPane.showMessageDialog(this, taoMaLoaiSanPham());
			String makt = taoMaKichThuoc();
			String tenkt = txtTenKichThuoc.getText();
			KichThuoc kt = new KichThuoc(makt, tenkt);
			if(KichThuoc_dao.create(kt)) {
				JOptionPane.showMessageDialog(this, "Thêm thành công");
				qlSP.resetcboKT();
				setVisible(false);
			}
		}
		else if(src.equals(btnHuy)) {
			setVisible(false);
		}
	}
	public String taoMaKichThuoc() {
		ArrayList<String> dsmaKT = new ArrayList<String>();
		for (KichThuoc kt : KichThuoc_dao.getAllKichThuoc()) {
			dsmaKT.add(kt.getMaKichThuoc());
		}
		for(int i = 1;i < 100;i++) {
			String ma = "";
			if(i<10)
				ma = "KT0"+i;
			else if(i<100)
				ma = "KT"+i;
			if(dsmaKT.contains(ma) == false)
				return ma;
			else
				continue;
		}
		return null;
	}
}