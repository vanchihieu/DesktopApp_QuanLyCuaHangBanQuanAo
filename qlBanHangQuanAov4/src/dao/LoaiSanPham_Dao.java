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

import entity.LoaiSanPham;

public class LoaiSanPham_Dao {
	public List<LoaiSanPham> getAllLoaiSanPham(){
		List<LoaiSanPham> dsLSP = new ArrayList<LoaiSanPham>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		try {
			String sql = "select * from LoaiSanPham";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				dsLSP.add(new LoaiSanPham(rs.getString(1), rs.getString(2)));
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return dsLSP;
	}
	public boolean create(LoaiSanPham lsp) {
		Connection con = ConnectDB.getInstance().getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("insert into LoaiSanPham values(?,?)");
			stmt.setString(1, lsp.getMaLoaiSanPham());
			stmt.setString(2, lsp.getTenLoaiSanPham());
			n = stmt.executeUpdate();
		}
		catch(SQLException e) {
//			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Mã loại sản phẩm này đã tồn tại!");
		}
		return n>0;
	}
}
