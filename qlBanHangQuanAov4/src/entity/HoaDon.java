package entity;

import java.time.LocalDate;

public class HoaDon {
	private String maHoaDon;
	private LocalDate ngayLap;
	private NhanVien nguoiLap;
	private KhachHang khachHang;
	
	public HoaDon(String maHoaDon, LocalDate ngayLap, NhanVien nguoiLap, KhachHang khachHang) {
		setMaHoaDon(maHoaDon);
		setNgayLap(ngayLap);
		setNguoiLap(nguoiLap);
		setKhachHang(khachHang);
	}
	public HoaDon(String maHoaDon) {
		setMaHoaDon(maHoaDon);
	}
	public String getMaHoaDon() {
		return maHoaDon;
	}

	public void setMaHoaDon(String maHoaDon) {
		this.maHoaDon = maHoaDon;
	}

	public LocalDate getNgayLap() {
		return ngayLap;
	}

	public void setNgayLap(LocalDate ngayLap) {
		this.ngayLap = ngayLap;
	}

	public NhanVien getNguoiLap() {
		return nguoiLap;
	}

	public void setNguoiLap(NhanVien nguoiLap) {
		this.nguoiLap = nguoiLap;
	}

	public KhachHang getKhachHang() {
		return khachHang;
	}

	public void setKhachHang(KhachHang khachHang) {
		this.khachHang = khachHang;
	}
	
}
