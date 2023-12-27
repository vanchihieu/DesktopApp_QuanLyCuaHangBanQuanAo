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
import entity.MauSac;

public class MauSac_Dao {
	public List<MauSac> getAllMauSac(){
		List<MauSac> dsMS = new ArrayList<MauSac>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		try {
			String sql = "select * from MauSac";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				dsMS.add(new MauSac(rs.getString(1), rs.getString(2)));
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return dsMS;
	}
	public boolean create(MauSac ms) {
		Connection con = ConnectDB.getInstance().getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("insert into MauSac values(?,?)");
			stmt.setString(1, ms.getMaMauSac());
			stmt.setString(2, ms.getTenMauSac());
			n = stmt.executeUpdate();
		}
		catch(SQLException e) {
//			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Mã màu sắc này đã tồn tại!");
		}
		return n>0;
	}
}
