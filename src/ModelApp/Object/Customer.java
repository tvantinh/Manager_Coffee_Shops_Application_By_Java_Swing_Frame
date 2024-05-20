package ModelApp.Object;

import java.io.Serializable;

public class Customer implements Serializable{
	private static final long serialVersionUID = 1L;
	String IDKH;
	String tenKH;
	String gioiTinh;
	String SDT; 
	String diaChi;
	String email;
	public Customer(String iDKH, String tenKH, String gioiTinh, String sDT, String diaChi, String email) {
		super();
		IDKH = iDKH;
		this.tenKH = tenKH;
		this.gioiTinh = gioiTinh;
		SDT = sDT;
		this.diaChi = diaChi;
		this.email = email;
	}
	public String getIDKH() {
		return IDKH;
	}
	public void setIDKH(String iDKH) {
		IDKH = iDKH;
	}
	public String getTenKH() {
		return tenKH;
	}
	public void setTenKH(String tenKH) {
		this.tenKH = tenKH;
	}
	public String getGioiTinh() {
		return gioiTinh;
	}
	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}
	public String getSDT() {
		return SDT;
	}
	public void setSDT(String sDT) {
		SDT = sDT;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
