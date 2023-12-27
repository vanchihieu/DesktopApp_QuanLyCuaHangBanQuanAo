package entity;

public class KhachHang {
	private String maKhachHang;
	private String tenKhachHang;
	private boolean gioiTinh;
	private String diaChi;
	private String soDienThoai;
	private String email;
	
	public KhachHang(String maKhachHang, String tenKhachHang, boolean gioiTinh, String diaChi, String soDienThoai, String email) {
		setMaKhachHang(maKhachHang);
		setTenKhachHang(tenKhachHang);
		setGioiTinh(gioiTinh);
		setDiaChi(diaChi);
		setSoDienThoai(soDienThoai);
		setEmail(email);
	}
	public KhachHang(String maKhachHang) {
		setMaKhachHang(maKhachHang);
	}
	public String getMaKhachHang() {
		return maKhachHang;
	}

	public void setMaKhachHang(String maKhachHang) {
		this.maKhachHang = maKhachHang;
	}

	public String getTenKhachHang() {
		return tenKhachHang;
	}

	public void setTenKhachHang(String tenKhachHang) {
		this.tenKhachHang = tenKhachHang;
	}

	public boolean isGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(boolean gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getSoDienThoai() {
		return soDienThoai;
	}

	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
}
