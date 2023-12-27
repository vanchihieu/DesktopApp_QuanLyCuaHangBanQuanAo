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
import entity.KhachHang;


public class KhachHang_Dao {
	public List<KhachHang> getAllKhachHang(){
		List<KhachHang> dsKH = new ArrayList<KhachHang>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		try {
			String sql = "select * from KhachHang";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				dsKH.add(new KhachHang(rs.getString(1), rs.getString(2), rs.getString(3).equals("nam")?true:false
						, rs.getString(4),
						rs.getString(5),
						rs.getString(6)));
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return dsKH;
	}
	public boolean create(KhachHang kh) {
		Connection con = ConnectDB.getInstance().getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("insert into KhachHang values(?,?,?,?,?,?)");
			stmt.setString(1, kh.getMaKhachHang());
			stmt.setString(2, kh.getTenKhachHang());
			stmt.setString(3, kh.isGioiTinh()?"nam":"nu");
			stmt.setString(4, kh.getDiaChi());
			stmt.setString(5, kh.getSoDienThoai());
			stmt.setString(6, kh.getEmail());
			n = stmt.executeUpdate();
		}
		catch(SQLException e) {
//			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Mã khách hàng này đã tồn tại!");
		}
		return n>0;
	}
	
	public boolean update(KhachHang kh) {
		Connection con = ConnectDB.getInstance().getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("update KhachHang \r\n"
					+ "set tenKhachHang = ?,\r\n"
					+ "gioiTinh = ?, diaChi = ?,\r\n"
					+ "soDienThoai = ?, email = ?\r\n"
					+ "where maKhachHang = ?");
			
			stmt.setString(1, kh.getTenKhachHang());
			stmt.setString(2, kh.isGioiTinh()?"nam":"nu");
			stmt.setString(3, kh.getDiaChi());
			stmt.setString(4, kh.getSoDienThoai());
			stmt.setString(5, kh.getEmail());
			stmt.setString(6, kh.getMaKhachHang());
			n = stmt.executeUpdate();
		}
		catch(SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error");
		}
		return n>0;
	}
	
	public boolean delete(String maKhachHang) {
		Connection con = ConnectDB.getInstance().getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("delete from KhachHang where maKhachHang = ?");
			stmt.setString(1, maKhachHang);
			n = stmt.executeUpdate();
		}
		catch(SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error");
		}
		return n>0;
	}

	public List<KhachHang> Find(String sql) {
		List<KhachHang> dsFind = new ArrayList<KhachHang>();
		Connection con = ConnectDB.getInstance().getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				dsFind.add(new KhachHang(rs.getString(1), rs.getString(2), rs.getString(3).equals("nam")?true:false
						, rs.getString(4),
						rs.getString(5),
						rs.getString(6)));
			}
		}
		catch(SQLException e) {
			JOptionPane.showMessageDialog(null, "không tìm được!");
		}
		return dsFind;
	}
}
