package entity;

public class MauSac {
	private String maMauSac;
	private String tenMauSac;
	
	public MauSac(String maMauSac, String tenMauSac) {
		setMaMauSac(maMauSac);
		setTenMauSac(tenMauSac);
	}

	public String getMaMauSac() {
		return maMauSac;
	}

	public void setMaMauSac(String maMauSac) {
		this.maMauSac = maMauSac;
	}

	public String getTenMauSac() {
		return tenMauSac;
	}

	public void setTenMauSac(String tenMauSac) {
		this.tenMauSac = tenMauSac;
	}
}
