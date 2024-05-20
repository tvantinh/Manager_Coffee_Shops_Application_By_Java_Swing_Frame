package ModelApp.Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ModelApp.Object.TypeInventory;




public class TypeInventoryDAO {
	private static final String SELECT_ALL= "SELECT * FROM LoaiNguyenLieu";
	public List<TypeInventory> getData() throws SQLException
	{
		List<TypeInventory> list = new ArrayList<>();
		try (Connection connection = DBConnect.getConnection();
	             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL);) {
	            ResultSet rs = preparedStatement.executeQuery();
	            while (rs.next()) {
	            	TypeInventory tp = new TypeInventory(rs.getString(1),rs.getString(2));          
	            	list.add(tp);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
		return list;
	}
}
