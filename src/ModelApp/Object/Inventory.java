package ModelApp.Object;

public class Inventory {

	String IDNguyenLieu;
	String tenNguyenLieu;
	String date;
	int soLuong;
	String donVi;
	int giaNhap;
	String IDLoai;
	
	public Inventory()
	{
		
	}
	
	public Inventory(String iDNguyenLieu, String tenNguyenLieu, String date, int soLuong, String donVi, int giaNhap, String iDLoai) {
		this.IDNguyenLieu = iDNguyenLieu;
		this.tenNguyenLieu = tenNguyenLieu;
		this.date = date;
		this.soLuong = soLuong;
		this.donVi = donVi;
		this.giaNhap = giaNhap;
		this.IDLoai = iDLoai;
	}
	public String getIDNguyenLieu() {
		return IDNguyenLieu;
	}
	public void setIDNguyenLieu(String iDNguyenLieu) {
		IDNguyenLieu = iDNguyenLieu;
	}
	public String getTenNguyenLieu() {
		return tenNguyenLieu;
	}
	public void setTenNguyenLieu(String tenNguyenLieu) {
		this.tenNguyenLieu = tenNguyenLieu;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	public String getDonVi() {
		return donVi;
	}
	public void setDonVi(String donVi) {
		this.donVi = donVi;
	}
	public int getGiaNhap() {
		return giaNhap;
	}
	public void setGiaNhap(int giaNhap) {
		this.giaNhap = giaNhap;
	}
	public String getIDLoai() {
		return IDLoai;
	}
	public void setIDLoai(String iDLoai) {
		IDLoai = iDLoai;
	}
}
