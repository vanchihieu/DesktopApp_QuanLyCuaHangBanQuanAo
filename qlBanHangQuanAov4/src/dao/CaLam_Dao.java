package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ConnectDB.ConnectDB;
import entity.CaLam;


public class CaLam_Dao {
	public List<CaLam> getAllCaLam(){
		List<CaLam> dsCL = new ArrayList<CaLam>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		try {
			String sql = "select * from CaLam";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				dsCL.add(new CaLam(rs.getString(1),
						rs.getString(2),
						rs.getString(3),
						rs.getString(4)));
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return dsCL;
	}
}
