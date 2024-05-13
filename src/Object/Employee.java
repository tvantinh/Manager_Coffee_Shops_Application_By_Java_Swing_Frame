package Object;

import java.io.Serializable;

public class Employee implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String IDNhanVien;
	String tenNhanVien;
	String ngaySinh;
	String CCCD;
	String SDT;
	String GioiTinh;
	String anhDaiDien;
	String IDChucVu;
	String ngayBatDauLamViec;
	public Employee() {
		
	}
	public String getIDNhanVien() {
		return IDNhanVien;
	}
	public void setIDNhanVien(String iDNhanVien) {
		IDNhanVien = iDNhanVien;
	}
	public Employee(String iDNhanVien, String tenNhanVien, String ngaySinh, String cCCD, String sDT, String gioiTinh,
			String anhDaiDien, String iDChucVu, String ngayBatDauLamViec) {
		super();
		IDNhanVien = iDNhanVien;
		this.tenNhanVien = tenNhanVien;
		this.ngaySinh = ngaySinh;
		CCCD = cCCD;
		SDT = sDT;
		GioiTinh = gioiTinh;
		this.anhDaiDien = anhDaiDien;
		IDChucVu = iDChucVu;
		this.ngayBatDauLamViec = ngayBatDauLamViec;
	}
	public String getTenNhanVien() {
		return tenNhanVien;
	}
	public void setTenNhanVien(String tenNhanVien) {
		this.tenNhanVien = tenNhanVien;
	}
	public String getNgaSinh() {
		return ngaySinh;
	}
	public void setNgaSinh(String ngaSinh) {
		this.ngaySinh = ngaSinh;
	}
	public String getCCCD() {
		return CCCD;
	}
	public void setCCCD(String cCCD) {
		CCCD = cCCD;
	}
	public String getSDT() {
		return SDT;
	}
	public void setSDT(String sDT) {
		SDT = sDT;
	}
	public String getGioiTinh() {
		return GioiTinh;
	}
	public void setGioiTinh(String gioiTinh) {
		GioiTinh = gioiTinh;
	}
	public String getAnhDaiDien() {
		return anhDaiDien;
	}
	public void setAnhDaiDien(String anhDaiDien) {
		this.anhDaiDien = anhDaiDien;
	}
	public String getIDChucVu() {
		return IDChucVu;
	}
	public void setIDChucVu(String iDChucVu) {
		IDChucVu = iDChucVu;
	}
	public String getNgayBatDauLamViec() {
		return ngayBatDauLamViec;
	}
	public void setNgayBatDauLamViec(String ngayBatDauLamViec) {
		this.ngayBatDauLamViec = ngayBatDauLamViec;
	}
	
	
	
	
	
}
