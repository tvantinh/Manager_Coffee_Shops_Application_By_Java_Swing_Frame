package ModelApp.Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ModelApp.Object.Inventory;


public class InventoryDAO {
	private static final String SELECT_ALL= "SELECT * FROM NguyenLieu";
	public List<Inventory> getData() throws SQLException
	{
		List<Inventory> list = new ArrayList<>();
		try (Connection connection = DBConnect.getConnection();
	             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL);) {
	            ResultSet rs = preparedStatement.executeQuery();
	            while (rs.next()) {
	            	Inventory tp = new Inventory(rs.getString(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getString(5),rs.getInt(6),rs.getString(7));	                
	            	list.add(tp);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
		return list;
	}
}
