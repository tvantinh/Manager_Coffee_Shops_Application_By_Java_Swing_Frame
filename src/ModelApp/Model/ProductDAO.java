package ModelApp.Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ModelApp.Object.Product;



public class ProductDAO {
	private static final String SELECT_ALL_PRODUCT = "SELECT * FROM thucdon";
	public List<Product> getData() throws SQLException
	{
		List<Product> listProduct = new ArrayList<>();
		try (Connection connection = DBConnect.getConnection();
	             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_PRODUCT);) {
	            ResultSet rs = preparedStatement.executeQuery();
	            while (rs.next()) {
	                String productID = rs.getString("IDSanPham");
	                String productname = rs.getString("TenSP");
	                String productUnit = rs.getString("DonViTinh");
	                String productDescribe = rs.getString("MoTa");
	                int productPrice = rs.getInt("GiaBan");
	                String productIDType = rs.getString("IDLoaiSP");
	                int upsize = rs.getInt("GiaUpsize");
	                listProduct.add(new Product(productID,productname,productUnit,productDescribe,productPrice,productIDType,upsize));
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
		return listProduct;
	}
}
