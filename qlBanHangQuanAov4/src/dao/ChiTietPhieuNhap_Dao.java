package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ConnectDB.ConnectDB;
import entity.ChiTietPhieuNhap;
import entity.PhieuNhap;
import entity.SanPham;

public class ChiTietPhieuNhap_Dao {
	public List<ChiTietPhieuNhap> getAllChiTietHoaDon(String maPhieuLap){
		List<ChiTietPhieuNhap> dsCTPN = new ArrayList<ChiTietPhieuNhap>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		try {
			String sql = "select * from ChiTietPhieuNhap where maPhieuNhap = '"+ maPhieuLap +"'";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				dsCTPN.add(new ChiTietPhieuNhap(new PhieuNhap(rs.getString(1)),
						new SanPham(rs.getString(2)),
						rs.getInt(3)));
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return dsCTPN;
	}
	public boolean create(ChiTietPhieuNhap ctpn) {
		Connection con = ConnectDB.getInstance().getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("insert into ChiTietPhieuNhap values(?,?,?)");
			stmt.setString(1, ctpn.getPhieuNhap().getMaPhieuNhap());
			stmt.setString(2, ctpn.getSanPham().getMaSanPham());
			stmt.setInt(3, ctpn.getSoLuong());
			n = stmt.executeUpdate();
		}
		catch(SQLException e) {
			e.printStackTrace();
//			JOptionPane.showMessageDialog(null, "Mã hóa đơn này đã tồn tại!");
		}
		return n>0;
	}
}
