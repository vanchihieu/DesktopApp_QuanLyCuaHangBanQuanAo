package entity;

public class SanPham {

	private String maSanPham;
	private String tenSanPham;
	private String donVi;
	private Double donGia;
	private String nhaCungCap;
	private String hinhAnh;
	private String mauSac;
	private String kichThuoc;
	private int soLuong;
	private String loaiSanPham;
	
	public SanPham() {
		
	}
	public SanPham(String maSanPham) {
		setMaSanPham(maSanPham);
	}
	
	
	public SanPham(String maSanPham, String tenSanPham, String donVi, Double donGia, String nhaCungCap, String hinhAnh
			,String mauSac,String kichThuoc, int soLuong, String loaiSanPham) {
		setMaSanPham(maSanPham);
		setTenSanPham(tenSanPham);
		setDonVi(donVi);
		setDonGia(donGia);
		setNhaCungCap(nhaCungCap);
		setHinhAnh(hinhAnh);
		setMauSac(mauSac);
		setKichThuoc(kichThuoc);
		setSoLuong(soLuong);
		setLoaiSanPham(loaiSanPham);
	}
	public String getHinhAnh() {
		return hinhAnh;
	}
	public void setHinhAnh(String hinhAnh) {
		this.hinhAnh = hinhAnh;
	}
	public String getMaSanPham() {
		return maSanPham;
	}
	public void setMaSanPham(String maSanPham) {
		this.maSanPham = maSanPham;
	}
	public String getTenSanPham() {
		return tenSanPham;
	}
	public void setTenSanPham(String tenSanPham) {
		this.tenSanPham = tenSanPham;
	}
	public String getDonVi() {
		return donVi;
	}
	public void setDonVi(String donVi) {
		this.donVi = donVi;
	}
	public Double getDonGia() {
		return donGia;
	}
	public void setDonGia(Double donGia) {
		this.donGia = donGia;
	}
	public String getNhaCungCap() {
		return nhaCungCap;
	}
	public void setNhaCungCap(String nhaCungCap) {
		this.nhaCungCap = nhaCungCap;
	}
	public String getMauSac() {
		return mauSac;
	}
	public void setMauSac(String mauSac) {
		this.mauSac = mauSac;
	}
	public String getKichThuoc() {
		return kichThuoc;
	}
	public void setKichThuoc(String kichThuoc) {
		this.kichThuoc = kichThuoc;
	}
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	public String getLoaiSanPham() {
		return loaiSanPham;
	}
	public void setLoaiSanPham(String loaiSanPham) {
		this.loaiSanPham = loaiSanPham;
	}

	


}
