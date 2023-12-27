package entity;

import java.time.LocalDate;
import java.util.Objects;

import entity.NhanVien.ChucVu;

public class NhanVien {
	public static enum ChucVu {
		NhanVien, QuanLy
	}
	private String maNhanVien;
	private String tenNhanVien;
	private LocalDate ngaySinh;
	private Boolean gioiTinh;
	private String diaChi;
	private String soDienThoai;
	private NhanVien quanLy;
	private String loaiNhanVien;
	private Double luong;
	private String caLam;
	
	public NhanVien() {
		this.maNhanVien = null;
	}
	

	public NhanVien(String maNhanVien) {
		setMaNhanVien(maNhanVien);
	}


	public NhanVien(String maNhanVien, String tenNhanVien, LocalDate ngaySinh, Boolean gioiTinh, String diaChi,
			String soDienThoai, NhanVien quanLy, String loaiNhanVien,Double luong,String caLam) {
		setMaNhanVien(maNhanVien);
		setTenNhanVien(tenNhanVien);
		setNgaySinh(ngaySinh);
		setGioiTinh(gioiTinh);
		setDiaChi(diaChi);
		setSoDienThoai(soDienThoai);
		setQuanLy(quanLy);
		setLoaiNhanVien(loaiNhanVien);
		setLuong(luong);
		setCaLam(caLam);
	}

	
	public String getMaNhanVien() {
		return maNhanVien;
	}


	public void setMaNhanVien(String maNhanVien) {
		this.maNhanVien = maNhanVien;
	}


	public String getTenNhanVien() {
		return tenNhanVien;
	}


	public void setTenNhanVien(String tenNhanVien) {
		this.tenNhanVien = tenNhanVien;
	}


	public LocalDate getNgaySinh() {
		return ngaySinh;
	}


	public void setNgaySinh(LocalDate ngaySinh) {
		this.ngaySinh = ngaySinh;
	}





	public Boolean getGioiTinh() {
		return gioiTinh;
	}


	public void setGioiTinh(Boolean gioiTinh) {
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


	public NhanVien getQuanLy() {
		return quanLy;
	}


	public void setQuanLy(NhanVien quanLy) {
		this.quanLy = quanLy;
	}


	public String getLoaiNhanVien() {
		return loaiNhanVien;
	}


	public void setLoaiNhanVien(String loaiNhanVien) {
		this.loaiNhanVien = loaiNhanVien;
	}


	public Double getLuong() {
		return luong;
	}


	public void setLuong(Double luong) {
		this.luong = luong;
	}


	public String getCaLam() {
		return caLam;
	}


	public void setCaLam(String caLam) {
		this.caLam = caLam;
	}


	@Override
	public int hashCode() {
		return Objects.hash(caLam, diaChi, gioiTinh, loaiNhanVien, luong, maNhanVien, ngaySinh, quanLy, soDienThoai,
				tenNhanVien);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof NhanVien))
			return false;
		NhanVien other = (NhanVien) obj;
		return Objects.equals(caLam, other.caLam) && Objects.equals(diaChi, other.diaChi)
				&& Objects.equals(gioiTinh, other.gioiTinh) && Objects.equals(loaiNhanVien, other.loaiNhanVien)
				&& Objects.equals(luong, other.luong) && Objects.equals(maNhanVien, other.maNhanVien)
				&& Objects.equals(ngaySinh, other.ngaySinh) && Objects.equals(quanLy, other.quanLy)
				&& Objects.equals(soDienThoai, other.soDienThoai) && Objects.equals(tenNhanVien, other.tenNhanVien);
	}



	
}
