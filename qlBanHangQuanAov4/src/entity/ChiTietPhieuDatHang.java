package entity;

public class ChiTietPhieuDatHang {
	private PhieuDatHang phieuDatHang;
	private SanPham sanPham;
	private int soLuong;
	private Double donGia;
	
	public ChiTietPhieuDatHang(PhieuDatHang phieuDatHang, SanPham sanPham, int soLuong, Double donGia) {
		setPhieuDatHang(phieuDatHang);
		setSanPham(sanPham);
		setSoLuong(soLuong);
		setDonGia(donGia);
	}

	public PhieuDatHang getPhieuDatHang() {
		return phieuDatHang;
	}

	public void setPhieuDatHang(PhieuDatHang phieuDatHang) {
		this.phieuDatHang = phieuDatHang;
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

	public Double getDonGia() {
		return donGia;
	}

	public void setDonGia(Double donGia) {
		this.donGia = donGia;
	}
	
}
