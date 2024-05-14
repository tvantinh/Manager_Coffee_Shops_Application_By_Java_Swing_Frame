package Model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Object.Customer;
import Object.Employee;
import Object.Inventory;
import Object.Product;
import Object.Promotion;
import Object.TypeInventory;
import Object.TypeProduct;
import TableModel.InventoryTableModel;
import TableModel.ProductTableModel;
import TableModel.TypeProductTableModel;

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
	public List<TypeInventory> getDataTypeInventory() throws SQLException
	{
		String str = "select * from LoaiNguyenLieu";
		ResultSet rs = db.query(str);
		List<TypeInventory> listTypeInventory = new ArrayList<>();
		while(rs.next())
		{
			TypeInventory tp = new TypeInventory(rs.getString(1),rs.getString(2));
			listTypeInventory.add(tp);
		}
		return listTypeInventory;
	}
	public List<Employee> getDataEmployee() throws SQLException
	{
		String str = "select * from NhanVien";
		ResultSet rs = db.query(str);
		List<Employee> listEmployee = new ArrayList<>();
		while(rs.next())
		{
			Employee tp = new Employee(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9));
			listEmployee.add(tp);
		}
		return listEmployee;
	}
	public List<Customer> getDataCustomer() throws SQLException
	{
		String str = "select * from KhachHang";
		ResultSet rs = db.query(str);
		List<Customer> listCustomer = new ArrayList<>();
		while(rs.next())
		{
			Customer tp = new Customer(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6));
			listCustomer.add(tp);
		}
		return listCustomer;
	}
	public List<Promotion> getDataPromotion() throws SQLException
	{
		String str = "select * from KhuyenMai";
		ResultSet rs = db.query(str);
		List<Promotion> listPromotion = new ArrayList<>();
		while(rs.next())
		{
			Promotion tp = new Promotion(rs.getString(1),rs.getString(2),rs.getInt(3),rs.getString(4),rs.getString(5));
			listPromotion.add(tp);
		}
		return listPromotion;
	}
}
