package Object;

import java.io.Serializable;

public class TypeInventory implements Serializable{
	private static final long serialVersionUID = 1L;
	String IDLoai;
	String tenLoai;
	
	public TypeInventory()
	{
		
	}
	public TypeInventory(String IDLoaiSP,String tenLoai)
	{
		this.IDLoai = IDLoaiSP;
		this.tenLoai = tenLoai;
	}
	public String getIDLoaiSP() {
		return IDLoai;
	}
	public void setIDLoaiSP(String iDLoaiSP) {
		IDLoai = iDLoaiSP;
	}
	public String getTenLoai() {
		return tenLoai;
	}
	public void setTenLoai(String tenLoai) {
		this.tenLoai = tenLoai;
	}
}
