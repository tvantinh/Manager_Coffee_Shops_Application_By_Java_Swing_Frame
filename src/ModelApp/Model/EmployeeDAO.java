package ModelApp.Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ModelApp.Object.Employee;


public class EmployeeDAO {
	private static final String SELECT_ALL_EMPLOYEE = "SELECT * FROM NhanVien";
	public List<Employee> getData() throws SQLException
	{
		List<Employee> listEmployee = new ArrayList<>();
		try (Connection connection = DBConnect.getConnection();
	             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_EMPLOYEE);) {
	            ResultSet rs = preparedStatement.executeQuery();
	            while (rs.next()) {
	    			Employee tp = new Employee(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11));
	                listEmployee.add(tp);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
		return listEmployee;
	}
	
}
