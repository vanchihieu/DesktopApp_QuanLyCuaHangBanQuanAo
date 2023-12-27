package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;

import ConnectDB.ConnectDB;
import entity.NhanVien;

public class NhanVien_Dao {
	public List<NhanVien> getAllNhanVien(){
		List<NhanVien> dsNV = new ArrayList<NhanVien>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		try {
			String sql = "select * from NhanVien";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				dsNV.add(new NhanVien(rs.getString(1),
						rs.getString(2),
						rs.getDate(3).toLocalDate(),
						rs.getString(4).equals("nam")?true:false,
						rs.getString(5),
						rs.getString(6),
						rs.getString(7)==null?new NhanVien():new NhanVien(rs.getString(7)),
						rs.getString(8),
						rs.getDouble(9),
						rs.getString(10)));
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return dsNV;
	}
	public List<NhanVien> getAllNhanVienQuanLy(){
		List<NhanVien> dsNV = new ArrayList<NhanVien>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		try {
			String sql = "select * from NhanVien where maLoaiNhanVien = '"+"LNV001"+"'";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				dsNV.add(new NhanVien(rs.getString(1),
						rs.getString(2),
						rs.getDate(3).toLocalDate(),
						rs.getString(4).equals("nam")?true:false,
						rs.getString(5),
						rs.getString(6),
						rs.getString(7)==null?new NhanVien():new NhanVien(rs.getString(7)),
						rs.getString(8),
						rs.getDouble(9),
						rs.getString(10)));
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return dsNV;
	}
	public boolean create(NhanVien nv) {
		Connection con = ConnectDB.getInstance().getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("insert into NhanVien values(?,?,?,?,?,?,?,?,?,?)");
			stmt.setString(1, nv.getMaNhanVien());
			stmt.setString(2, nv.getTenNhanVien());
			stmt.setDate(3, java.sql.Date.valueOf(nv.getNgaySinh()));
			stmt.setString(4, nv.getGioiTinh()?"nam":"nu");
			stmt.setString(5, nv.getDiaChi());
			stmt.setString(6, nv.getSoDienThoai());
			stmt.setString(7, nv.getQuanLy().getMaNhanVien());
			stmt.setString(8, nv.getLoaiNhanVien());
			stmt.setDouble(9, nv.getLuong());
			stmt.setString(10, nv.getCaLam());
			n = stmt.executeUpdate();
		}
		catch(SQLException e) {
//			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Mã nhân viên này đã tồn tại!");
		}
		return n>0;
	}
	public boolean Delete(String maNV) {
		Connection con = ConnectDB.getInstance().getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("delete from NhanVien where maNhanVien = ?");
			stmt.setString(1, maNV);
			n = stmt.executeUpdate();
		}
		catch(SQLException e) {
//			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Nhân viên này đã lập hóa đơn");
		}
		return n>0;
	}
	public boolean Update(NhanVien nv) {
		Connection con = ConnectDB.getInstance().getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("update NhanVien\r\n"
					+ "set tenNhanVien = ?, ngaySinh = ?, gioiTinh = ?, diaChi = ?,soDienThoai = ?,\r\n"
					+ "quanLy = ?, maLoaiNhanVien = ?, luong = ?, caLam = ?\r\n"
					+ "where maNhanVien = ?");
			stmt.setString(1, nv.getTenNhanVien());
			stmt.setDate(2, java.sql.Date.valueOf(nv.getNgaySinh()));
			stmt.setString(3, nv.getGioiTinh()?"nam":"nu");
			stmt.setString(4, nv.getDiaChi());
			stmt.setString(5, nv.getSoDienThoai());
			stmt.setString(6, nv.getQuanLy().getMaNhanVien());
			stmt.setString(7, nv.getLoaiNhanVien());
			stmt.setDouble(8, nv.getLuong());
			stmt.setString(9, nv.getCaLam());
			stmt.setString(10, nv.getMaNhanVien());
			n = stmt.executeUpdate();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return n>0;
	}
	public List<NhanVien> Find(String sql) {
		List<NhanVien> dsFind = new ArrayList<NhanVien>();
		Connection con = ConnectDB.getInstance().getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				dsFind.add(new NhanVien(rs.getString(1),
						rs.getString(2),
						rs.getDate(3).toLocalDate(),
						rs.getString(4).equals("nam")?true:false,
						rs.getString(5),
						rs.getString(6),
						rs.getString(7)==null?new NhanVien():new NhanVien(rs.getString(7)),
						rs.getString(8),
						rs.getDouble(9),
						rs.getString(10)));
			}
		}
		catch(SQLException e) {
			JOptionPane.showMessageDialog(null, "không tìm được!");
		}
		return dsFind;
	}
	public boolean UpdateTTCN(String maNV,String ten, String diaChi, String soDienThoai, LocalDate ngaySinh, boolean gioiTinh) {
		Connection con = ConnectDB.getInstance().getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("update NhanVien\r\n"
					+ "set tenNhanVien = ?, ngaySinh = ?, gioiTinh = ?, diaChi = ?,soDienThoai = ?\r\n"
					+ "where maNhanVien = ?");
			stmt.setString(1, ten);
			stmt.setDate(2, java.sql.Date.valueOf(ngaySinh));
			stmt.setString(3, gioiTinh?"nam":"nu");
			stmt.setString(4, diaChi);
			stmt.setString(5, soDienThoai);
			stmt.setString(6, maNV);
			n = stmt.executeUpdate();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return n>0;
	}
}
