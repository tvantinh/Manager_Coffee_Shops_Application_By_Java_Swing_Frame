package ModelApp.Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ModelApp.Object.TypeProduct;

public class TypeProductDAO {
	private static final String SELECT_ALL = "SELECT * FROM LoaiSanPham";

	public List<TypeProduct> getData() throws SQLException {
		List<TypeProduct> list = new ArrayList<>();
		try (Connection connection = DBConnect.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL);) {
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				TypeProduct tp = new TypeProduct(rs.getString(1), rs.getString(2));
				list.add(tp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public List<TypeProduct> searchTypeList(String str) {
		List<TypeProduct> list = new ArrayList<>();
		String fm = "%" + str + "%";
		String select = "select * from LoaiSanPham as l where l.TenLoaiSP like ?";
		
		try (Connection connection = DBConnect.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(select);) {
			preparedStatement.setString(1, fm);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				TypeProduct tp = new TypeProduct(rs.getString(1), rs.getString(2));
				list.add(tp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public void updateType(String id, String name) {
        String sql = "UPDATE LoaiSanPham set TenLoaiSP =  ? where IDLoaiSP = ? ";

        try (Connection connection = DBConnect.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.setString(2, id);
            int rowsAffected = pstmt.executeUpdate();

            System.out.println("Số dòng được update: " + rowsAffected);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
	public void deleteType(String id) {
        String sql = "DELETE FROM LoaiSanPham WHERE IDLoaiSP= ?; ";

        try (Connection connection = DBConnect.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {

            pstmt.setString(1, id);
            int rowsAffected = pstmt.executeUpdate();
            System.out.println("Số dòng được delete: " + rowsAffected);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
	
	public static void insertTypetProduct(String IDLoaiSP,String TenLoaiSP) 
	{
		try (Connection connection = DBConnect.getConnection()) {
            String sql = "INSERT INTO LoaiSanPham (IDLoaiSP, TenLoaiSP) VALUES (?, ?)";       
            try (PreparedStatement pstm = connection.prepareStatement(sql)) {
            		
                pstm.setString(1, IDLoaiSP);
                pstm.setString(2, TenLoaiSP);
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
