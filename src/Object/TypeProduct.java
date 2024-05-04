package Object;

import java.io.Serializable;

public class TypeProduct implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String IDLoaiSP;
	String tenLoai;
	
	public TypeProduct()
	{
		
	}
	public TypeProduct(String IDLoaiSP,String tenLoai)
	{
		this.IDLoaiSP = IDLoaiSP;
		this.tenLoai = tenLoai;
	}
	public String getIDLoaiSP() {
		return IDLoaiSP;
	}
	public void setIDLoaiSP(String iDLoaiSP) {
		IDLoaiSP = iDLoaiSP;
	}
	public String getTenLoai() {
		return tenLoai;
	}
	public void setTenLoai(String tenLoai) {
		this.tenLoai = tenLoai;
	}
	
}
