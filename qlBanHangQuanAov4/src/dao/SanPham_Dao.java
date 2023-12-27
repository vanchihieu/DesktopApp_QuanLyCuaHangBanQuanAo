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
import entity.NhanVien;
import entity.SanPham;


public class SanPham_Dao {
	public List<SanPham> getAllSanPham(){
		List<SanPham> dsSP = new ArrayList<SanPham>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		try {
			String sql = "select * from SanPham";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				dsSP.add(new SanPham(rs.getString(1),
						rs.getString(2),
						rs.getString(3),
						rs.getDouble(10),
						rs.getString(4),
						rs.getString(5),
						rs.getString(6),
						rs.getString(7),
						rs.getInt(8),
						rs.getString(9)));
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return dsSP;
	}
	public List<SanPham> getAllSanPhamTheoNhaCungCap(String nhaCungCap){
		List<SanPham> dsSP = new ArrayList<SanPham>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		try {
			String sql = "select * from SanPham where nhaCungCap = N'"+nhaCungCap+"' or nhaCungcap = N''";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				dsSP.add(new SanPham(rs.getString(1),
						rs.getString(2),
						rs.getString(3),
						rs.getDouble(10),
						rs.getString(4),
						rs.getString(5),
						rs.getString(6),
						rs.getString(7),
						rs.getInt(8),
						rs.getString(9)));
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return dsSP;
	}
	public List<SanPham> Find(String sql) {
		List<SanPham> dsFind = new ArrayList<SanPham>();
		Connection con = ConnectDB.getInstance().getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				dsFind.add(new SanPham(rs.getString(1),
						rs.getString(2),
						rs.getString(3),
						rs.getDouble(10),
						rs.getString(4),
						rs.getString(5),
						rs.getString(6),
						rs.getString(7),
						rs.getInt(8),
						rs.getString(9)));
			}
		}
		catch(SQLException e) {
			JOptionPane.showMessageDialog(null, "không tìm được!");
		}
		return dsFind;
	}
	public boolean UpdateSoLuong(String masp, int soluong) {
		Connection con = ConnectDB.getInstance().getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("update SanPham\r\n"
					+ "set soLuong = ? where maSanPham = ?");
			stmt.setInt(1, soluong);
			stmt.setString(2, masp);
			
			n = stmt.executeUpdate();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return n>0;
	}
	public boolean UpdateNhaCungCap(String masp, String nhaCungCap) {
		Connection con = ConnectDB.getInstance().getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("update SanPham\r\n"
					+ "set nhaCungCap = ? where maSanPham = ?");
			stmt.setString(1, nhaCungCap);
			stmt.setString(2, masp);
			
			n = stmt.executeUpdate();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return n>0;
	}
	public boolean create(SanPham sp) {
		Connection con = ConnectDB.getInstance().getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("insert into SanPham values(?,?,?,?,?,?,?,?,?,?)");
			stmt.setString(1, sp.getMaSanPham());
			stmt.setString(2, sp.getTenSanPham());
			stmt.setString(3, sp.getDonVi());
			stmt.setString(4, sp.getNhaCungCap());
			stmt.setString(5, sp.getHinhAnh());
			stmt.setString(6, sp.getMauSac());
			stmt.setString(7, sp.getKichThuoc());
			stmt.setInt(8, sp.getSoLuong());
			stmt.setString(9, sp.getLoaiSanPham());
			stmt.setDouble(10, sp.getDonGia());

			n = stmt.executeUpdate();
		} catch (SQLException e) {
//			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Mã sản phẩm này đã tồn tại!");
		}
		return n > 0;
	}

	public boolean Delete(String maSP) {
		Connection con = ConnectDB.getInstance().getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("delete from SanPham where maSanPham = ?");
			stmt.setString(1, maSP);
			n = stmt.executeUpdate();
		} catch (SQLException e) {
//			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Sản phẩm này đã trong hóa đơn");
		}
		return n > 0;
	}

	public boolean Update(SanPham sp) {
		Connection con = ConnectDB.getInstance().getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("update SanPham\r\n"
					+ "set tenSanPham = ?, donVi = ?, nhaCungCap = ?, hinhAnh = ?, mauSac = ?,kichThuoc = ?,\r\n"
					+ "soLuong = ?, maLoaiSanPham = ?, donGia = ?\r\n" + "where maSanPham = ?");
			stmt.setString(1, sp.getTenSanPham());
			stmt.setString(2, sp.getDonVi());
			stmt.setString(3, sp.getNhaCungCap());
			stmt.setString(4, sp.getHinhAnh());
			stmt.setString(5, sp.getMauSac());
			stmt.setString(6, sp.getKichThuoc());
			stmt.setInt(7, sp.getSoLuong());
			stmt.setString(8, sp.getLoaiSanPham());
			stmt.setDouble(9, sp.getDonGia());
			stmt.setString(10, sp.getMaSanPham());

			n = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n > 0;
	}
}
