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
import entity.KhuyenMai;

public class KhuyenMai_Dao {
	public List<KhuyenMai> getAllKhuyenMai(){
		List<KhuyenMai> dsKM = new ArrayList<KhuyenMai>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		try {
			String sql = "select * from KhuyenMai";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				dsKM.add(new KhuyenMai(rs.getString(1),
						rs.getString(2),
						rs.getDate(3).toLocalDate(),
						rs.getDate(4).toLocalDate()));
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return dsKM;
	}
	public boolean create(KhuyenMai km) {
		Connection con = ConnectDB.getInstance().getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("insert into KhuyenMai values(?,?,?,?)");
			stmt.setString(1, km.getMaKhuyenMai());
			stmt.setString(2, km.getTenKhuyenMai());
			stmt.setDate(3, java.sql.Date.valueOf(km.getNgayBatDau()));
			stmt.setDate(4, java.sql.Date.valueOf(km.getNgayKetThuc()));
			n = stmt.executeUpdate();
		}
		catch(SQLException e) {
//			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Mã khuyến mãi này đã tồn tại!");
		}
		return n>0;
	}
	public boolean Delete(String maKM) {
		Connection con = ConnectDB.getInstance().getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("delete from KhuyenMai where maKhuyenMai = ?");
			stmt.setString(1, maKM);
			n = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n > 0;
	}
	public boolean Update(KhuyenMai km) {
		Connection con = ConnectDB.getInstance().getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("update KhuyenMai\r\n"
					+ "set tenKhuyenMai = ?, ngayBatDau = ?, ngayKetThuc = ? where maKhuyenMai = ?");
			stmt.setString(4, km.getMaKhuyenMai());
			stmt.setString(1, km.getTenKhuyenMai());
			stmt.setDate(2, java.sql.Date.valueOf(km.getNgayBatDau()));
			stmt.setDate(3, java.sql.Date.valueOf(km.getNgayKetThuc()));
			n = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n > 0;
	}
}
