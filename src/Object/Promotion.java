package Object;

import java.io.Serializable;

public class Promotion implements Serializable {
	
	private static final long serialVersionUID = 1L;
	String IDKhuyenMai;
	String NoiDung;
	int GiaGiam;
	String NgayBD;
	String NgayKT;
	
	public Promotion() 
	{
		
	}
	public Promotion(String iDKhuyenMai, String noiDung, int giaGiam, String ngayBD, String ngayKT) {
		super();
		IDKhuyenMai = iDKhuyenMai;
		NoiDung = noiDung;
		GiaGiam = giaGiam;
		NgayBD = ngayBD;
		NgayKT = ngayKT;
	}
	public String getIDKhuyenMai() {
		return IDKhuyenMai;
	}
	public void setIDKhuyenMai(String iDKhuyenMai) {
		IDKhuyenMai = iDKhuyenMai;
	}
	public String getNoiDung() {
		return NoiDung;
	}
	public void setNoiDung(String noiDung) {
		NoiDung = noiDung;
	}
	public int getGiaGiam() {
		return GiaGiam;
	}
	public void setGiaGiam(int giaGiam) {
		GiaGiam = giaGiam;
	}
	public String getNgayBD() {
		return NgayBD;
	}
	public void setNgayBD(String ngayBD) {
		NgayBD = ngayBD;
	}
	public String getNgayKT() {
		return NgayKT;
	}
	public void setNgayKT(String ngayKT) {
		NgayKT = ngayKT;
	}
	
	
}
