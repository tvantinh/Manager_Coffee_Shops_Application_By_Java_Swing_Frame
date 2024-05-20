package ModelApp.Object;

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
	String taiKhoan;
	String matKhau;
	public Employee() {
		
	}
	
	public Employee(String iDNhanVien, String tenNhanVien, String ngaySinh, String cCCD, String sDT, String gioiTinh,
			String anhDaiDien, String iDChucVu, String ngayBatDauLamViec, String taiKhoan, String matKhau) {
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
		this.taiKhoan = taiKhoan;
		this.matKhau = matKhau;
	}

	public String getNgaySinh() {
		return ngaySinh;
	}
	public void setNgaySinh(String ngaySinh) {
		this.ngaySinh = ngaySinh;
	}
	public String getTaiKhoan() {
		return taiKhoan;
	}
	public void setTaiKhoan(String taiKhoan) {
		this.taiKhoan = taiKhoan;
	}
	public String getMatKhau() {
		return matKhau;
	}
	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}
	public String getIDNhanVien() {
		return IDNhanVien;
	}
	public void setIDNhanVien(String iDNhanVien) {
		IDNhanVien = iDNhanVien;
	}
	
	public String getTenNhanVien() {
		return tenNhanVien;
	}
	public void setTenNhanVien(String tenNhanVien) {
		this.tenNhanVien = tenNhanVien;
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
