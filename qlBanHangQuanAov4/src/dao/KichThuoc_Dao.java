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
import entity.KichThuoc;
import entity.MauSac;


public class KichThuoc_Dao {
	public List<KichThuoc> getAllKichThuoc(){
		List<KichThuoc> dsKT = new ArrayList<KichThuoc>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		try {
			String sql = "select * from KichThuoc";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				dsKT.add(new KichThuoc(rs.getString(1), rs.getString(2)));
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return dsKT;
	}
	public boolean create(KichThuoc kt) {
		Connection con = ConnectDB.getInstance().getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("insert into KichThuoc values(?,?)");
			stmt.setString(1, kt.getMaKichThuoc());
			stmt.setString(2, kt.getTenKichThuoc());
			n = stmt.executeUpdate();
		}
		catch(SQLException e) {
//			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Mã kích thước này đã tồn tại!");
		}
		return n>0;
	}
}
