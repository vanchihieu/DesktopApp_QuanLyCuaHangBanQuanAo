package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ConnectDB.ConnectDB;
import entity.ChiTietHoaDon;
import entity.ChiTietPhieuDatHang;
import entity.PhieuDatHang;
import entity.SanPham;

public class ChiTietPhieuDatHang_Dao {
	public List<ChiTietPhieuDatHang> getAllChiTietPhieuDatHang(String maPDH){
		List<ChiTietPhieuDatHang> dsCTPDH = new ArrayList<ChiTietPhieuDatHang>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		try {
			String sql = "select * from ChiTietPhieuDatHang where maPhieuDatHang = '"+maPDH+"'";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				dsCTPDH.add(new ChiTietPhieuDatHang(new PhieuDatHang(rs.getString(1)),
						new SanPham(rs.getString(2)), rs.getInt(3), rs.getDouble(4)));
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return dsCTPDH;
	}
	public boolean create(ChiTietPhieuDatHang ctpdh) {
		Connection con = ConnectDB.getInstance().getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("insert into ChiTietPhieuDatHang values(?,?,?,?)");
			stmt.setString(1, ctpdh.getPhieuDatHang().getMaPhieuDatHang());
			stmt.setString(2, ctpdh.getSanPham().getMaSanPham());
			stmt.setInt(3, ctpdh.getSoLuong());
			stmt.setDouble(4, ctpdh.getDonGia());
			n = stmt.executeUpdate();
		}
		catch(SQLException e) {
			e.printStackTrace();
//			JOptionPane.showMessageDialog(null, "Mã hóa đơn này đã tồn tại!");
		}
		return n>0;
	}
}
