package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import ConnectDB.ConnectDB;
import entity.HoaDon;
import entity.KhachHang;
import entity.NhanVien;
import entity.PhieuDatHang;

public class PhieuDatHang_Dao {
	public List<PhieuDatHang> getAllPhieuDatHang(){
		List<PhieuDatHang> dsPDH = new ArrayList<PhieuDatHang>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		try {
			String sql = "select * from PhieuDatHang";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				dsPDH.add(new PhieuDatHang(rs.getString(1)
						, rs.getDate(2).toLocalDate()
						, new NhanVien(rs.getString(3)),
						new KhachHang(rs.getString(4))));
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return dsPDH;
	}
	public boolean create(PhieuDatHang pdh) {
		Connection con = ConnectDB.getInstance().getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("insert into PhieuDatHang values(?,?,?,?)");
			stmt.setString(1, pdh.getMaPhieuDatHang());
			stmt.setString(3, pdh.getNguoiLap().getMaNhanVien());
			stmt.setDate(2, java.sql.Date.valueOf(pdh.getNgayLap()));
			stmt.setString(4, pdh.getKhachHang().getMaKhachHang());
			n = stmt.executeUpdate();
		}
		catch(SQLException e) {
//			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Mã phiếu đạt hàng này đã tồn tại!");
		}
		return n>0;
	}
	public boolean Delete(String maPDH) {
		Connection con = ConnectDB.getInstance().getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("delete from PhieuDatHang where maPhieuDatHang = ?");
			stmt.setString(1, maPDH);
			n = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n > 0;
	}
}
