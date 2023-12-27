package entity;

public class CaLam {
	private String maCaLam;
	private String buoi;
	private String thoiGianBatDau;
	private String thoiGianKetThuc;
	
	public CaLam(String maCaLam, String buoi, String thoiGianBatDau, String thoiGianKetThuc) {
		setMaCaLam(maCaLam);
		setBuoi(buoi);
		setThoiGianBatDau(thoiGianBatDau);
		setThoiGianKetThuc(thoiGianKetThuc);
	}

	public String getMaCaLam() {
		return maCaLam;
	}

	public void setMaCaLam(String maCaLam) {
		this.maCaLam = maCaLam;
	}

	public String getBuoi() {
		return buoi;
	}

	public void setBuoi(String buoi) {
		this.buoi = buoi;
	}

	public String getThoiGianBatDau() {
		return thoiGianBatDau;
	}

	public void setThoiGianBatDau(String thoiGianBatDau) {
		this.thoiGianBatDau = thoiGianBatDau;
	}

	public String getThoiGianKetThuc() {
		return thoiGianKetThuc;
	}

	public void setThoiGianKetThuc(String thoiGianKetThuc) {
		this.thoiGianKetThuc = thoiGianKetThuc;
	}
	
	
}
