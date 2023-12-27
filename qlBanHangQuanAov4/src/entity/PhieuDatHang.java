package entity;

import java.time.LocalDate;

public class PhieuDatHang {
	private String maPhieuDatHang;
	private LocalDate ngayLap;
	private NhanVien nguoiLap;
	private KhachHang khachHang;
	
	public PhieuDatHang(String maPhieuDatHang, LocalDate ngayLap, NhanVien nguoiLap, KhachHang khachHang) {
		setMaPhieuDatHang(maPhieuDatHang);
		setNgayLap(ngayLap);
		setNguoiLap(nguoiLap);
		setKhachHang(khachHang);
	}
	public PhieuDatHang(String maPhieuDatHang) {
		setMaPhieuDatHang(maPhieuDatHang);
	}
	public String getMaPhieuDatHang() {
		return maPhieuDatHang;
	}

	public void setMaPhieuDatHang(String maPhieuDatHang) {
		this.maPhieuDatHang = maPhieuDatHang;
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
