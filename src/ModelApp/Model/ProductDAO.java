package ModelApp.Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ModelApp.Object.Product;
import ModelApp.Object.TypeProduct;



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
	public List<Product> searchProductList(String str) {
		List<Product> list = new ArrayList<>();
		String fm = "%" + str + "%";
		String select = "select * from ThucDon as l where l.TenSP like ?";
		
		try (Connection connection = DBConnect.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(select);) {
			preparedStatement.setString(1, fm);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				String productID = rs.getString("IDSanPham");
                String productname = rs.getString("TenSP");
                String productUnit = rs.getString("DonViTinh");
                String productDescribe = rs.getString("MoTa");
                int productPrice = rs.getInt("GiaBan");
                String productIDType = rs.getString("IDLoaiSP");
                int upsize = rs.getInt("GiaUpsize");
                list.add(new Product(productID,productname,productUnit,productDescribe,productPrice,productIDType,upsize));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	public void updateProduct(String id, String TenSp, String DonViTinh,int GiaBan, String IDLoaiSP,int GiaUpSize) {
        String sql = "UPDATE ThucDon set TenSP =  ?, DonViTinh = ?, GiaBan =  ?, IDLoaiSP = ?, GiaUpSize = ? where IDSanPham = ? ";

        try (Connection connection = DBConnect.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, TenSp);
            pstmt.setString(2, DonViTinh);
            pstmt.setInt(3, GiaBan);
            pstmt.setString(4, IDLoaiSP);
            pstmt.setInt(5, GiaUpSize);
            pstmt.setString(6, id);
            int rowsAffected = pstmt.executeUpdate();

            System.out.println("Số dòng được update: " + rowsAffected);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
	public void deleteProduct(String id) {
        String sql = "DELETE FROM ThucDon WHERE IDSanPham= ?; ";

        try (Connection connection = DBConnect.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {

            pstmt.setString(1, id);
            int rowsAffected = pstmt.executeUpdate();
            System.out.println("Số dòng được delete: " + rowsAffected);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
	public static void insertProduct(String IDSanPham,String TenSP,String DonViTinh,int GiaBan,String IDloaiSP,int GiaUpsize) 
	{
		try (Connection connection = DBConnect.getConnection()) {
            String sql = "INSERT INTO ThucDon (IDSanPham, TenSP, DonViTinh, GiaBan,IDloaiSP,GiaUpSize) VALUES (?, ?, ?, ?,?,?)";   
            try (PreparedStatement pstm = connection.prepareStatement(sql)) {
            		
                pstm.setString(1, IDSanPham);
                pstm.setString(2, TenSP);
                pstm.setString(3,DonViTinh);
                pstm.setInt(4, GiaBan);
                pstm.setString(5,IDloaiSP);
                pstm.setInt(6,GiaUpsize);

                int rowsInserted = pstm.executeUpdate();
                if (rowsInserted > 0) {
                	System.out.println("So dong duoc them vao: "+rowsInserted);
                }
            }
        } catch (SQLException ex) { 
            ex.printStackTrace();
        }
	}
}
