package entity;

import java.time.LocalDate;

public class PhieuNhap {
	private String maPhieuNhap;
	private LocalDate ngayLap;
	private NhanVien nguoiLap;
	private String nhaCungCap;
	
	public PhieuNhap(String maPhieuNhap, LocalDate ngayLap, NhanVien nguoiLap, String nhaCungCap) {
		setMaPhieuNhap(maPhieuNhap);
		setNgayLap(ngayLap);
		setNguoiLap(nguoiLap);
		setNhaCungCap(nhaCungCap);
	}
	public PhieuNhap(String maPhieuNhap) {
		setMaPhieuNhap(maPhieuNhap);
	}
	public String getMaPhieuNhap() {
		return maPhieuNhap;
	}

	public void setMaPhieuNhap(String maPhieuNhap) {
		this.maPhieuNhap = maPhieuNhap;
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
	public String getNhaCungCap() {
		return nhaCungCap;
	}

	public void setNhaCungCap(String nhaCungCap) {
		this.nhaCungCap = nhaCungCap;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
}
