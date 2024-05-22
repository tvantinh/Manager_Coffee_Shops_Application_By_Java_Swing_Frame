package ModelApp.Object;

import java.io.Serializable;

public class Product implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String IDSanPham;
	String tenSanPham;
	String donViTinh;
	String moTa;
	int giaBan;
	String IDLoaiSP;
	int upsize;
	
	public Product()
	{
		
	}
	public Product(String IDSanPham,String tenSanPham, String donViTinh, String moTa, int giaBan, String IDLoaiSP,int upsize)
	{
		this.IDSanPham = IDSanPham;
		this.tenSanPham = tenSanPham;
		this.donViTinh = donViTinh;
		this.moTa = moTa;
		this.giaBan = giaBan;
		this.IDLoaiSP = IDLoaiSP;
		this.upsize = upsize;
	}
	public int getUpsize() {
		return upsize;
	}
	public void setUpsize(int upsize) {
		this.upsize = upsize;
	}
	public String getIDSanPham() {
        return IDSanPham;
    }

    public void setIDSanPham(String IDSanPham) {
        this.IDSanPham = IDSanPham;
    }

    public String getTenSanPham() {
        return tenSanPham;
    }

    public void setTenSanPham(String tenSanPham) {
        this.tenSanPham = tenSanPham;
    }

    public String getDonViTinh() {
        return donViTinh;
    }

    public void setDonViTinh(String donViTinh) {
        this.donViTinh = donViTinh;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public int getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(int giaBan) {
        this.giaBan = giaBan;
    }

    public String getIDLoaiSP() {
        return IDLoaiSP;
    }

    public void setIDLoaiSP(String IDLoaiSP) {
        this.IDLoaiSP = IDLoaiSP;
    }
}
