package entity;

public class ChiTietKhuyenMai {
	private KhuyenMai khuyenMai;
	private SanPham sanPham;
	private Double phanTramKhuyenMai;
	
	public ChiTietKhuyenMai(KhuyenMai khuyenMai, SanPham sanPham, Double phanTramKhuyenMai) {
		setKhuyenMai(khuyenMai);
		setSanPham(sanPham);
		setPhanTramKhuyenMai(phanTramKhuyenMai);
	}

	public KhuyenMai getKhuyenMai() {
		return khuyenMai;
	}

	public void setKhuyenMai(KhuyenMai khuyenMai) {
		this.khuyenMai = khuyenMai;
	}

	public SanPham getSanPham() {
		return sanPham;
	}

	public void setSanPham(SanPham sanPham) {
		this.sanPham = sanPham;
	}

	public Double getPhanTramKhuyenMai() {
		return phanTramKhuyenMai;
	}

	public void setPhanTramKhuyenMai(Double phanTramKhuyenMai) {
		this.phanTramKhuyenMai = phanTramKhuyenMai;
	}
	
}
