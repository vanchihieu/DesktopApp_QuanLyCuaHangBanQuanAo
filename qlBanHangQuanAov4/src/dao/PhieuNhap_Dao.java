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
import entity.NhanVien;
import entity.PhieuNhap;

public class PhieuNhap_Dao {
	public List<PhieuNhap> getAllPhieuNhap(){
		List<PhieuNhap> dsPN = new ArrayList<PhieuNhap>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		try {
			String sql = "select * from PhieuNhap\r\n"
					+ "order by ngayLap DESC";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				dsPN.add(new PhieuNhap(rs.getString(1),
						rs.getDate(2).toLocalDate(),
						new NhanVien(rs.getString(3)), rs.getString(4)));
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return dsPN;
	}
	public boolean create(PhieuNhap pn) {
		Connection con = ConnectDB.getInstance().getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("insert into PhieuNhap values(?,?,?,?)");
			stmt.setString(1, pn.getMaPhieuNhap());
			stmt.setString(3, pn.getNguoiLap().getMaNhanVien());
			stmt.setDate(2, java.sql.Date.valueOf(pn.getNgayLap()));
			stmt.setString(4, pn.getNhaCungCap());
			n = stmt.executeUpdate();
		}
		catch(SQLException e) {
//			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Mã phiếu nhập này đã tồn tại!");
		}
		return n>0;
	}
}
