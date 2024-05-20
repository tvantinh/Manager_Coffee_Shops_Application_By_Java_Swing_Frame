package ModelApp.Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ModelApp.Object.Promotion;


public class PromotionDAO {
	private static final String SELECT_ALL= "SELECT * FROM KhuyenMai";
	public List<Promotion> getData() throws SQLException
	{
		List<Promotion> list = new ArrayList<>();
		try (Connection connection = DBConnect.getConnection();
	             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL);) {
	            ResultSet rs = preparedStatement.executeQuery();
	            while (rs.next()) {
	            	Promotion tp = new Promotion(rs.getString(1),rs.getString(2),rs.getInt(3),rs.getString(4),rs.getString(5));           
	            	list.add(tp);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
		return list;
	}
}
