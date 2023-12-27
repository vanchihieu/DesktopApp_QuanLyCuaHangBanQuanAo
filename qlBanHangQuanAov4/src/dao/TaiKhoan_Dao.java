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
import entity.NhanVien;
import entity.TaiKhoan;

public class TaiKhoan_Dao {
	public boolean isTaiKhoan(TaiKhoan taiKhoan) {
		PreparedStatement statement;
		try {
			statement = ConnectDB.getConnection()
					.prepareStatement("SELECT * FROM TaiKhoan WHERE maNhanVien = ? AND matKhau = ?");
			statement.setString(1, taiKhoan.getNhanVien().getMaNhanVien());
			statement.setString(2, taiKhoan.getMatKhau());
			ResultSet resultSet = statement.executeQuery();

			return resultSet.next();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}
	public List<TaiKhoan> getAllTaiKhoan() {
		List<TaiKhoan> dstk = new ArrayList<TaiKhoan>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		try {
			String sql = "select * from TaiKhoan";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				dstk.add(new TaiKhoan(rs.getString(1)
						, new NhanVien(rs.getString(2)),
						rs.getString(3),
						rs.getString(4),
						rs.getString(5),
						rs.getString(6)));
			}
	}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return dstk;
	}
	public boolean create(TaiKhoan tk) {
		Connection con = ConnectDB.getInstance().getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("insert into TaiKhoan values(?,?,?,?,?,?)");
			stmt.setString(1, tk.getMaTaiKhoan());
			stmt.setString(2,tk.getNhanVien().getMaNhanVien());
			stmt.setString(3, tk.getTenTaiKhoan());;
			stmt.setString(4, tk.getMatKhau());
			stmt.setString(5, tk.getEmail());
			stmt.setString(6, tk.getQuyenHan());
			n = stmt.executeUpdate();
		}
		catch(SQLException e) {
//			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Mã tài khoản này đã tồn tại!");
		}
		return n>0;
	}
	public boolean updateMatKhau(String maTK, String matKhauMoi) {
		Connection con = ConnectDB.getInstance().getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("update TaiKhoan \r\n"
					+ "set matKhau = ?\r\n"
					+ "where maTaiKhoan = ?");
			
			stmt.setString(1, matKhauMoi);
			stmt.setString(2, maTK);
			n = stmt.executeUpdate();
		}
		catch(SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error");
		}
		return n>0;
	}
	public boolean updateEmail(String maTK, String email) {
		Connection con = ConnectDB.getInstance().getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("update TaiKhoan \r\n"
					+ "set email = ?\r\n"
					+ "where maTaiKhoan = ?");
			
			stmt.setString(1, email);
			stmt.setString(2, maTK);
			n = stmt.executeUpdate();
		}
		catch(SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error");
		}
		return n>0;
	}
//	public String getMatKhau(String maTK) {
//		Connection con = ConnectDB.getInstance().getConnection();
//		PreparedStatement stmt = null;
//		String matKhau = "";
//		try {
//			stmt = con.prepareStatement("select matKhau FROM TaiKhoan where maTaiKhoan = ?");
//			stmt.setString(1, maTK); 
//			ResultSet rs = stmt.executeQuery();
//			while(rs.next()) {
//				matKhau = rs.getString(1);
//			}
//		}
//		catch(SQLException e) {
//			e.printStackTrace();
//		}
//		return matKhau;
//	}
}
