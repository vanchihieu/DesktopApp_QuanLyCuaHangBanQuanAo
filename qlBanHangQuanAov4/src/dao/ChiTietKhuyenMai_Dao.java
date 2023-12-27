package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ConnectDB.ConnectDB;
import entity.ChiTietKhuyenMai;
import entity.KhuyenMai;
import entity.SanPham;

public class ChiTietKhuyenMai_Dao {
	public List<ChiTietKhuyenMai> getAllChiTietKhuyenMai(String maKhuyenMai){
		List<ChiTietKhuyenMai> dsCTKM = new ArrayList<ChiTietKhuyenMai>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		try {
			String sql = "select * from ChiTietKhuyenMai where maKhuyenMai = '"+maKhuyenMai+"'";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				dsCTKM.add(new ChiTietKhuyenMai(new KhuyenMai(rs.getString(1)), new SanPham(rs.getString(2)), rs.getDouble(3)));
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return dsCTKM;
	}
	public List<ChiTietKhuyenMai> getAllChiTietKhuyenMai(){
		List<ChiTietKhuyenMai> dsCTKM = new ArrayList<ChiTietKhuyenMai>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		try {
			String sql = "select * from ChiTietKhuyenMai";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				dsCTKM.add(new ChiTietKhuyenMai(new KhuyenMai(rs.getString(1)), new SanPham(rs.getString(2)), rs.getDouble(3)));
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return dsCTKM;
	}
	public boolean create(ChiTietKhuyenMai ctkm) {
		Connection con = ConnectDB.getInstance().getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("insert into ChiTietKhuyenMai values(?,?,?)");
			stmt.setString(1, ctkm.getKhuyenMai().getMaKhuyenMai());
			stmt.setString(2, ctkm.getSanPham().getMaSanPham());
			stmt.setDouble(3, ctkm.getPhanTramKhuyenMai());
			n = stmt.executeUpdate();
		}
		catch(SQLException e) {
			e.printStackTrace();
//			JOptionPane.showMessageDialog(null, "Mã hóa đơn này đã tồn tại!");
		}
		return n>0;
	}
	public boolean Update(ChiTietKhuyenMai ctkm) {
		Connection con = ConnectDB.getInstance().getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("update ChiTietKhuyenMai\r\n"
					+ "set phanTramKhuyenMai = ? where maKhuyenMai = ? and maSanPham = ?");
			stmt.setString(2, ctkm.getKhuyenMai().getMaKhuyenMai());
			stmt.setString(3, ctkm.getSanPham().getMaSanPham());
			stmt.setDouble(1, ctkm.getPhanTramKhuyenMai());
			n = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n > 0;
	}
	public boolean Delete(String maKM, String maSP) {
		Connection con = ConnectDB.getInstance().getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("delete from ChiTietKhuyenMai where maKhuyenMai = ? and maSanPham = ?");
			stmt.setString(1, maKM);
			stmt.setString(2, maSP);
			n = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n > 0;
	}
	public boolean Delete(String maKM) {
		Connection con = ConnectDB.getInstance().getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("delete from ChiTietKhuyenMai where maKhuyenMai = ?");
			stmt.setString(1, maKM);
			n = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n > 0;
	}
}
