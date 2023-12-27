package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ConnectDB.ConnectDB;
import entity.LoaiNhanVien;
import entity.NhanVien;

public class LoaiNhanVien_Dao {
	public List<LoaiNhanVien> getAllLoaiNhanVien(){
		List<LoaiNhanVien> dsLNV = new ArrayList<LoaiNhanVien>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		try {
			String sql = "select * from LoaiNhanVien";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				dsLNV.add(new LoaiNhanVien(rs.getString(1), rs.getString(2)));
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return dsLNV;
	}
}
