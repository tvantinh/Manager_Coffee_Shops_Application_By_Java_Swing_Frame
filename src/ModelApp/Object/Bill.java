package ModelApp.Object;

import java.io.Serializable;

public class Bill implements Serializable {
	private static final long serialVersionUID = 1L;
	String IDHoaDon;
	String NgayLap;
	int TongTien;
	String IDNV;
	String IDKH;
	String IDKhuyenMai;
	String GhiChu;
	public Bill(String iDHoaDon, String ngayLap, int tongTien, String iDNV, String iDKH, String iDKhuyenMai,
			String ghiChu) {
		super();
		IDHoaDon = iDHoaDon;
		NgayLap = ngayLap;
		TongTien = tongTien;
		IDNV = iDNV;
		IDKH = iDKH;
		IDKhuyenMai = iDKhuyenMai;
		GhiChu = ghiChu;
	}
	public String getIDHoaDon() {
		return IDHoaDon;
	}
	public void setIDHoaDon(String iDHoaDon) {
		IDHoaDon = iDHoaDon;
	}
	public String getNgayLap() {
		return NgayLap;
	}
	public void setNgayLap(String ngayLap) {
		NgayLap = ngayLap;
	}
	public int getTongTien() {
		return TongTien;
	}
	public void setTongTien(int tongTien) {
		TongTien = tongTien;
	}
	public String getIDNV() {
		return IDNV;
	}
	public void setIDNV(String iDNV) {
		IDNV = iDNV;
	}
	public String getIDKH() {
		return IDKH;
	}
	public void setIDKH(String iDKH) {
		IDKH = iDKH;
	}
	public String getIDKhuyenMai() {
		return IDKhuyenMai;
	}
	public void setIDKhuyenMai(String iDKhuyenMai) {
		IDKhuyenMai = iDKhuyenMai;
	}
	public String getGhiChu() {
		return GhiChu;
	}
	public void setGhiChu(String ghiChu) {
		GhiChu = ghiChu;
	}
	
}
