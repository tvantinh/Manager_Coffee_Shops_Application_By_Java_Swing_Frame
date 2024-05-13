package Model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Object.Inventory;
import Object.Product;
import Object.TypeProduct;

public class Model {

	public ProductTableModel productModel = new ProductTableModel();
	public TypeProductTableModel typeProductModel = new TypeProductTableModel();
	public InventoryTableModel InventoryModel = new InventoryTableModel();
	DBConnect db = new DBConnect();
	
	
	public List<Product> getDataProduct() throws SQLException
	{
		String getListProduct = "select * from ThucDon";
		ResultSet rs = db.query(getListProduct);
		List<Product> listProduct = new ArrayList<>();
		while(rs.next())
		{
			Product pd = new Product();
			pd.setIDSanPham(rs.getString(1));
			pd.setTenSanPham(rs.getString(2));
			pd.setDonViTinh(rs.getString(3));
			pd.setMoTa(rs.getString(4));
			pd.setGiaBan(rs.getInt(5));
			pd.setIDLoaiSP(rs.getString(6));
			listProduct.add(pd);
		}
		return listProduct;
	}
	public List<TypeProduct> getDataTypeProduct() throws SQLException
	{
		String str = "select * from LoaiSanPham";
		ResultSet rs = db.query(str);
		List<TypeProduct> listTypeProduct = new ArrayList<>();
		while(rs.next())
		{
			TypeProduct tp = new TypeProduct(rs.getString(1),rs.getString(2));
			listTypeProduct.add(tp);
		}
		return listTypeProduct;
	}
	public List<Inventory> getDataInventory() throws SQLException
	{
		String getListInventory = "select * from NguyenLieu";
		ResultSet rs = db.query(getListInventory);
		List<Inventory> listInventory = new ArrayList<>();
		while(rs.next())
		{
			Inventory IV = new Inventory(rs.getString(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getString(5),rs.getInt(6),rs.getString(7));
			listInventory.add(IV);
		}
		return listInventory;
		
	}
}
