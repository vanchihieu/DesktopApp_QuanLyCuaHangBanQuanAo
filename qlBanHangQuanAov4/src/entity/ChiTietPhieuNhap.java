package entity;

public class ChiTietPhieuNhap {
	private PhieuNhap phieuNhap;
	private SanPham sanPham;
	private int soLuong;
	
	public ChiTietPhieuNhap(PhieuNhap phieuNhap, SanPham sanPham, int soLuong) {
		setPhieuNhap(phieuNhap);
		setSanPham(sanPham);
		setSoLuong(soLuong);
	}

	public PhieuNhap getPhieuNhap() {
		return phieuNhap;
	}

	public void setPhieuNhap(PhieuNhap phieuNhap) {
		this.phieuNhap = phieuNhap;
	}

	public SanPham getSanPham() {
		return sanPham;
	}

	public void setSanPham(SanPham sanPham) {
		this.sanPham = sanPham;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

}
