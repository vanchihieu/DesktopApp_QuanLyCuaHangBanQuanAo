package entity;

import java.util.Objects;

public class TaiKhoan {
	private String maTaiKhoan;
	private NhanVien nhanVien;
	private String tenTaiKhoan;
	private String matKhau;
	private String email;
	private String quyenHan;

	public TaiKhoan() {
		super();
	}

	public TaiKhoan(NhanVien nhanVien) {
		super();
		this.nhanVien = nhanVien;
	}
	
	public TaiKhoan(NhanVien nhanVien, String matKhau) {
		super();
		this.nhanVien = nhanVien;
		this.matKhau = matKhau;
	}

	public TaiKhoan(String maTaiKhoan, NhanVien nhanVien, String tenTaiKhoan, String matKhau, String email,
			String quyenHan) {
		super();
		this.maTaiKhoan = maTaiKhoan;
		this.nhanVien = nhanVien;
		this.tenTaiKhoan = tenTaiKhoan;
		this.matKhau = matKhau;
		this.email = email;
		this.quyenHan = quyenHan;
	}

	public String getMaTaiKhoan() {
		return maTaiKhoan;
	}

	public void setMaTaiKhoan(String maTaiKhoan) {
		this.maTaiKhoan = maTaiKhoan;
	}

	public NhanVien getNhanVien() {
		return nhanVien;
	}

	public void setMaNhanVien(NhanVien nhanVien) {
		this.nhanVien = nhanVien;
	}

	public String getTenTaiKhoan() {
		return tenTaiKhoan;
	}

	public void setTenTaiKhoan(String tenTaiKhoan) {
		this.tenTaiKhoan = tenTaiKhoan;
	}

	public String getMatKhau() {
		return matKhau;
	}

	public void setMatKhau(String mauKhau) {
		this.matKhau = mauKhau;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getQuyenHan() {
		return quyenHan;
	}

	public void setQuyenHan(String quyenHan) {
		this.quyenHan = quyenHan;
	}

	@Override
	public int hashCode() {
		return Objects.hash(email, maTaiKhoan, matKhau, nhanVien, quyenHan, tenTaiKhoan);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TaiKhoan other = (TaiKhoan) obj;
		return Objects.equals(email, other.email) && Objects.equals(maTaiKhoan, other.maTaiKhoan)
				&& Objects.equals(matKhau, other.matKhau) && Objects.equals(nhanVien, other.nhanVien)
				&& Objects.equals(quyenHan, other.quyenHan) && Objects.equals(tenTaiKhoan, other.tenTaiKhoan);
	}
}
