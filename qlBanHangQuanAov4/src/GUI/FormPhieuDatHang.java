package GUI;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;

import com.raven.datechooser.DateChooser;

import components.scrollbarCustom.ScrollBarCustom;
import components.textField.TextField;
import dao.ChiTietPhieuDatHang_Dao;
import dao.KhachHang_Dao;
import dao.NhanVien_Dao;
import dao.PhieuDatHang_Dao;
import dao.SanPham_Dao;
import entity.ChiTietPhieuDatHang;
import entity.KhachHang;
import entity.NhanVien;
import entity.PhieuDatHang;
import entity.SanPham;
import utils.Utils;

public class FormPhieuDatHang extends JFrame{
	private final int widthPnlContainer = 1060;
	private String maPDH;
	private TextField txtMaPDH;
	private TextField txtNguoiLap;
	private TextField txtNgayLap;
	private DateChooser dateChoose;
	private TextField txtTenKhachHang;
	private TextField txtTongTien;
	private JTable tblCTPDH;
	private DefaultTableModel tableModelCTPDH;
	private NhanVien_Dao NhanVien_Dao;
	private KhachHang_Dao KhachHang_dao;
	private PhieuDatHang_Dao PhieuDatHang_dao;
	private ChiTietPhieuDatHang_Dao ChiTietPhieuDatHang_dao;
	private ArrayList<SanPham> dsSP;
	private SanPham_Dao SanPham_dao;
	public FormPhieuDatHang(String maPDH) {
		this.maPDH = maPDH;
		setSize(1060, 700);
		setTitle("Thông tin phiếu đặt hàng");
		setLocationRelativeTo(null);
		setLayout(null);
		PhieuDatHang_dao = new PhieuDatHang_Dao();
		ChiTietPhieuDatHang_dao = new ChiTietPhieuDatHang_Dao();
		
		int topPnlControl = Utils.getBodyHeight() - 80;
		
		JPanel pnlContainer = new JPanel();
		pnlContainer.setBackground(new Color(203, 239, 255));
		pnlContainer.setBounds(0, 0, widthPnlContainer, 275);
		pnlContainer.setLayout(null);
		this.add(pnlContainer);
		
		JPanel pnlHeader = new JPanel();
		pnlHeader.setBackground(new Color(203, 239, 255));
		pnlHeader.setBounds(16, 18, 1000, 50);
		pnlContainer.add(pnlHeader);
		pnlHeader.setLayout(null);
		
		JLabel lblTitle = new JLabel("Thông tin phiếu đặt hàng");
		lblTitle.setBounds(380, 10, 400, 30);
		lblTitle.setFont(new Font("Segoe UI", Font.PLAIN, 26));
		pnlHeader.add(lblTitle);
		
		JPanel pnlRow1 = new JPanel();
		pnlRow1.setBackground(new Color(203, 239, 255));
		pnlRow1.setBounds(80, 100, 792, 55);
		add(pnlRow1);
		pnlRow1.setLayout(null);
		
		txtMaPDH = new TextField();
		txtMaPDH.setEditable(false);
		txtMaPDH.setLabelText("Mã phiếu đặt hàng:");
		txtMaPDH.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		txtMaPDH.setBackground(new Color(203, 239, 255));
		txtMaPDH.setBounds(0, 0, 371, 55);
		pnlRow1.add(txtMaPDH);

		txtNgayLap = new TextField();
		txtNgayLap.setIcon(Utils.getImageIcon("add-event 2.png"));
		txtNgayLap.setLineColor(new Color(149, 166, 248));
		txtNgayLap.setLabelText("Ngày lập:");
		txtNgayLap.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		txtNgayLap.setColumns(10);
		txtNgayLap.setBackground(new Color(203, 239, 255));
		txtNgayLap.setBounds(421, 0, 371, 55);
		pnlRow1.add(txtNgayLap);
		dateChoose = new DateChooser();
		dateChoose.setDateFormat("yyyy-MM-dd");
		dateChoose.setTextRefernce(txtNgayLap);
		
		JPanel pnlRow2 = new JPanel();
		pnlRow2.setBackground(new Color(203, 239, 255));
		pnlRow2.setBounds(80, 160, 792, 55);
		add(pnlRow2);
		pnlRow2.setLayout(null);
		
		txtNguoiLap = new TextField();
		txtNguoiLap.setLabelText("Người lập:");
		txtNguoiLap.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		txtNguoiLap.setBackground(new Color(203, 239, 255));
		txtNguoiLap.setBounds(0, 0, 371, 55);
		pnlRow2.add(txtNguoiLap);
		
		txtTenKhachHang = new TextField();
		txtTenKhachHang.setLabelText("Khách hàng:");
		txtTenKhachHang.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		txtTenKhachHang.setBackground(new Color(203, 239, 255));
		txtTenKhachHang.setBounds(421, 0, 371, 55);
		pnlRow2.add(txtTenKhachHang);
		
		JPanel pnlRow3 = new JPanel();
		pnlRow3.setBackground(new Color(203, 239, 255));
		pnlRow3.setBounds(80, 220, 792, 55);
		add(pnlRow3);
		pnlRow3.setLayout(null);
		
		txtTongTien = new TextField();
		txtTongTien.setLabelText("Tổng tiền:");
		txtTongTien.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		txtTongTien.setBackground(new Color(203, 239, 255));
		txtTongTien.setBounds(0, 0, 371, 55);
		pnlRow3.add(txtTongTien);
		
		JPanel pnlRow4 = new JPanel();
		pnlRow4.setBackground(new Color(203, 239, 255));
		pnlRow4.setBounds(0, 275, widthPnlContainer, 425);
		add(pnlRow4);
		pnlRow4.setLayout(null);
		
		JScrollPane scrCTPDH = new JScrollPane();
		scrCTPDH.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrCTPDH.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrCTPDH.setBounds(80, 25, 750, 250);
		scrCTPDH.setBackground(Utils.primaryColor);
		scrCTPDH.setBorder(BorderFactory.createTitledBorder("Chi tiết phiếu đặt hàng"));
		scrCTPDH.getViewport().setBackground(Color.WHITE);
		pnlRow4.add(scrCTPDH);

		ScrollBarCustom scpCTPDH = new ScrollBarCustom();
//		Set color scrollbar thumb
		scpCTPDH.setScrollbarColor(new Color(203, 203, 203));
		scrCTPDH.setVerticalScrollBar(scpCTPDH);
//		this.add(scrCTPDH);

		tblCTPDH = new JTable() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}

			@Override
			/**
			 * Set màu từng dòng cho Table
			 */
			public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
				Component c = super.prepareRenderer(renderer, row, column);
				if (isRowSelected(row))
					c.setBackground(Utils.getRGBA(96, 96, 96, 0.5f));
				else
					c.setBackground(Color.WHITE);
				return c;
			}
		};
		tblCTPDH.setForeground(Utils.getOpacity(Color.BLACK, 0.55f));
		tblCTPDH.setAutoCreateRowSorter(true);  //tự động tạo 1 bộ sắp xếp cho tất cả các cột trong bảng
		JTableHeader tblHeaderCTPDH = tblCTPDH.getTableHeader();
		TableColumnModel tableColumnModelCTHD = tblCTPDH.getColumnModel();

		tableModelCTPDH = new DefaultTableModel(new String[] { "Mã sản phẩm", "Tên sản phẩm","Số lượng","Đơn giá","Thành tiền" }, 0);
		tblCTPDH.setModel(tableModelCTPDH);
		tblCTPDH.setFocusable(false);
		tblHeaderCTPDH.setBackground(Utils.primaryColor);
		tblCTPDH.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		tblCTPDH.setBackground(Color.WHITE);
		tblCTPDH.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

		tableColumnModelCTHD.getColumn(0).setPreferredWidth(150);
		tableColumnModelCTHD.getColumn(1).setPreferredWidth(150);
		tableColumnModelCTHD.getColumn(2).setPreferredWidth(150);
		tableColumnModelCTHD.getColumn(3).setPreferredWidth(150);
		tableColumnModelCTHD.getColumn(4).setPreferredWidth(150);
		
		tblHeaderCTPDH.setPreferredSize(new Dimension((int) tblHeaderCTPDH.getPreferredSize().getWidth(), 36));
		tblHeaderCTPDH.setFont(new Font("Segoe UI", Font.BOLD, 20));
		tblHeaderCTPDH.setForeground(Utils.getOpacity(Color.BLACK, 0.55f));
		tblCTPDH.setRowHeight(36);
		scrCTPDH.setViewportView(tblCTPDH);
		
		dsSP = new ArrayList<SanPham>();
		SanPham_dao = new SanPham_Dao();
		for (SanPham sanPham : SanPham_dao.getAllSanPham()) {
			dsSP.add(sanPham);
		}
		
		NhanVien_Dao = new NhanVien_Dao();
		KhachHang_dao = new KhachHang_Dao();
		Double tongTien = 0.0;
		for (PhieuDatHang pdh : PhieuDatHang_dao.getAllPhieuDatHang()) {
			if(pdh.getMaPhieuDatHang().equals(maPDH)) {
				txtMaPDH.setText(maPDH);;
				txtNgayLap.setText(pdh.getNgayLap().toString());
				for (KhachHang kh : KhachHang_dao.getAllKhachHang()) {
					if(kh.getMaKhachHang().equals(pdh.getKhachHang().getMaKhachHang())) {
						txtTenKhachHang.setText(kh.getTenKhachHang());
						break;
					}			
				}
				for (NhanVien nv : NhanVien_Dao.getAllNhanVien()) {
					if(nv.getMaNhanVien().equals(pdh.getNguoiLap().getMaNhanVien())) {
						txtNguoiLap.setText(nv.getTenNhanVien());
						break;
					}
				}
				for (ChiTietPhieuDatHang ctpdh : ChiTietPhieuDatHang_dao.getAllChiTietPhieuDatHang(pdh.getMaPhieuDatHang())) {
					Object[] data = {ctpdh.getSanPham().getMaSanPham(),getTenSP(ctpdh.getSanPham().getMaSanPham()), ctpdh.getSoLuong(),
							ctpdh.getDonGia(),
							Integer.valueOf(ctpdh.getSoLuong())*Double.valueOf(ctpdh.getDonGia())};
					tableModelCTPDH.addRow(data);
					tongTien += ctpdh.getSoLuong()*ctpdh.getDonGia();
				}
				txtTongTien.setText(tongTien.toString());
				break;
			}
		}
	}
	public String getTenSP(String maSP) {
		for (SanPham sanPham : dsSP) {
			if(sanPham.getMaSanPham().equals(maSP))
				return sanPham.getTenSanPham();
		}
		return null;
	}
}
