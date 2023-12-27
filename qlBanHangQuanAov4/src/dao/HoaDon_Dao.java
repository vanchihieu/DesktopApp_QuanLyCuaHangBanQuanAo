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
import entity.HoaDon;
import entity.KhachHang;
import entity.NhanVien;


public class HoaDon_Dao {
	public List<HoaDon> getAllHoaDon(){
		List<HoaDon> dsHD = new ArrayList<HoaDon>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		try {
			String sql = "select * from HoaDon";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				dsHD.add(new HoaDon(rs.getString(1), 
						rs.getDate(2).toLocalDate()
						, new NhanVien(rs.getString(3)),
						new KhachHang(rs.getString(4))));
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return dsHD;
	}
	public boolean create(HoaDon hd) {
		Connection con = ConnectDB.getInstance().getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("insert into HoaDon values(?,?,?,?)");
			stmt.setString(1, hd.getMaHoaDon());
			stmt.setString(3, hd.getNguoiLap().getMaNhanVien());
			stmt.setDate(2, java.sql.Date.valueOf(hd.getNgayLap()));
			stmt.setString(4, hd.getKhachHang().getMaKhachHang());
			n = stmt.executeUpdate();
		}
		catch(SQLException e) {
//			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Mã hóa đơn này đã tồn tại!");
		}
		return n>0;
	}
}
