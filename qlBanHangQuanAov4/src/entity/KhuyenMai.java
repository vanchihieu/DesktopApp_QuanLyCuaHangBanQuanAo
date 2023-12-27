package entity;

import java.time.LocalDate;

public class KhuyenMai {
	private String maKhuyenMai;
	private String tenKhuyenMai;
	private LocalDate ngayBatDau;
	private LocalDate ngayKetThuc;
	
	public KhuyenMai(String maKhuyenMai, String tenKhuyenMai, LocalDate ngayBatDau, LocalDate ngayKetThuc) {
		setMaKhuyenMai(maKhuyenMai);
		setTenKhuyenMai(tenKhuyenMai);
		setNgayBatDau(ngayBatDau);
		setNgayKetThuc(ngayKetThuc);
	}
	public KhuyenMai(String maKhuyenMai) {
		setMaKhuyenMai(maKhuyenMai);
	}
	public String getMaKhuyenMai() {
		return maKhuyenMai;
	}

	public void setMaKhuyenMai(String maKhuyenMai) {
		this.maKhuyenMai = maKhuyenMai;
	}

	public String getTenKhuyenMai() {
		return tenKhuyenMai;
	}

	public void setTenKhuyenMai(String tenKhuyenMai) {
		this.tenKhuyenMai = tenKhuyenMai;
	}

	public LocalDate getNgayBatDau() {
		return ngayBatDau;
	}

	public void setNgayBatDau(LocalDate ngayBatDau) {
		this.ngayBatDau = ngayBatDau;
	}

	public LocalDate getNgayKetThuc() {
		return ngayKetThuc;
	}

	public void setNgayKetThuc(LocalDate ngayKetThuc) {
		this.ngayKetThuc = ngayKetThuc;
	}
	
}
