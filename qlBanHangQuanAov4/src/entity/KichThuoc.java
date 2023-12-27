package entity;

public class KichThuoc {
	private String maKichThuoc;
	private String tenKichThuoc;
	
	public KichThuoc(String maKichThuoc, String tenKichThuoc) {
		setMaKichThuoc(maKichThuoc);
		setTenKichThuoc(tenKichThuoc);
	}

	public String getMaKichThuoc() {
		return maKichThuoc;
	}

	public void setMaKichThuoc(String maKichThuoc) {
		this.maKichThuoc = maKichThuoc;
	}

	public String getTenKichThuoc() {
		return tenKichThuoc;
	}

	public void setTenKichThuoc(String tenKichThuoc) {
		this.tenKichThuoc = tenKichThuoc;
	}
	
}
