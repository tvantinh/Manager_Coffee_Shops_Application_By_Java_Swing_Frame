package ModelApp.Object;

import java.io.Serializable;

public class Order implements Serializable{

	private static final long serialVersionUID = 1L;
	private String IDSanPham;
	private String tenSanPham;
	private int soLuong;
	private String size;
	private String Ghichu;
	private int giaBan;
	private int giaUpsize;
	public String getIDSanPham() {
		return IDSanPham;
	}
	public void setIDSanPham(String iDSanPham) {
		IDSanPham = iDSanPham;
	}
	public String getTenSanPham() {
		return tenSanPham;
	}
	public void setTenSanPham(String tenSanPham) {
		this.tenSanPham = tenSanPham;
	}
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getGhichu() {
		return Ghichu;
	}
	public void setGhichu(String ghichu) {
		Ghichu = ghichu;
	}
	public int getGiaBan() {
		return giaBan;
	}
	public void setGiaBan(int giaBan) {
		this.giaBan = giaBan;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "Order [IDSanPham=" + IDSanPham + ", tenSanPham=" + tenSanPham + ", soLuong=" + soLuong + ", size="
				+ size + ", Ghichu=" + Ghichu + ", giaBan=" + giaBan + "]";
	}
	public Order(String iDSanPham, String tenSanPham, int soLuong, String size, String ghichu, int giaBan, int giaUpsize) {
		super();
		IDSanPham = iDSanPham;
		this.tenSanPham = tenSanPham;
		this.soLuong = soLuong;
		this.size = size;
		Ghichu = ghichu;
		this.giaBan = giaBan;
		this.giaUpsize = giaUpsize;
	}
	public int getGiaUpsize() {
		return giaUpsize;
	}
	public void setGiaUpsize(int giaUpsize) {
		this.giaUpsize = giaUpsize;
	}
	public Order() {
	}
}
