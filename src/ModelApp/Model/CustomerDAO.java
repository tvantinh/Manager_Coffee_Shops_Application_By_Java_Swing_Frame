package ModelApp.Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ModelApp.Object.Customer;

public class CustomerDAO {
	private static final String SELECT_ALL_CUSTOMER = "SELECT * FROM KhachHang";

	public List<Customer> getData() throws SQLException {
		List<Customer> listCustomer = new ArrayList<>();
		try (Connection connection = DBConnect.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CUSTOMER);) {
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				Customer tp = new Customer(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6));
				listCustomer.add(tp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listCustomer;
	}

	public Customer SelectCustomerToPhone(String numberPhone) throws SQLException {
		Customer customer = null;
		String Statement = "  SELECT * FROM KHACHHANG AS KH where KH.SDT = ?";
		try (Connection connection = DBConnect.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(Statement);) {
			// Thiết lập các giá trị cho các tham số trong câu lệnh SQL
			preparedStatement.setString(1, numberPhone);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				customer = new Customer(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return customer;
	}
}
