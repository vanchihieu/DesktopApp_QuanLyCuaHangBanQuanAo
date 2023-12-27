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
import entity.ChiTietHoaDon;
import entity.HoaDon;
import entity.SanPham;



public class ChiTietHoaDon_Dao {
	public List<ChiTietHoaDon> getAllChiTietHoaDon(String maHoaDon){
		List<ChiTietHoaDon> dsCTHD = new ArrayList<ChiTietHoaDon>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		try {
			String sql = "select * from ChiTietHoaDon where maHoaDon = '"+maHoaDon+"'";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				dsCTHD.add(new ChiTietHoaDon(new HoaDon(rs.getString(1)),
						new SanPham(rs.getString(2)), rs.getInt(3), rs.getDouble(4)));
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return dsCTHD;
	}
	public List<ChiTietHoaDon> getAllChiTietHoaDon(){
		List<ChiTietHoaDon> dsCTHD = new ArrayList<ChiTietHoaDon>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		try {
			String sql = "select * from ChiTietHoaDon";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				dsCTHD.add(new ChiTietHoaDon(new HoaDon(rs.getString(1)),
						new SanPham(rs.getString(2)), rs.getInt(3), rs.getDouble(4)));
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return dsCTHD;
	}
	public boolean create(ChiTietHoaDon cthd) {
		Connection con = ConnectDB.getInstance().getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("insert into ChiTietHoaDon values(?,?,?,?)");
			stmt.setString(1, cthd.getHoaDon().getMaHoaDon());
			stmt.setString(2, cthd.getSanPham().getMaSanPham());
			stmt.setInt(3, cthd.getSoLuong());
			stmt.setDouble(4, cthd.getDonGia());
			n = stmt.executeUpdate();
		}
		catch(SQLException e) {
			e.printStackTrace();
//			JOptionPane.showMessageDialog(null, "Mã hóa đơn này đã tồn tại!");
		}
		return n>0;
	}
}
