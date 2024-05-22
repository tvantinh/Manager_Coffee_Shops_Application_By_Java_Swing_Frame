package ModelApp.Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ModelApp.Object.Bill;

public class BillDAO {
	private static final String SELECT_ALL_BILL = "Select*from HoaDon";

	public List<Bill> getData() throws SQLException {
		List<Bill> listBill = new ArrayList<>();
		try (Connection connection = DBConnect.getConnection();
				PreparedStatement pstm = connection.prepareStatement(SELECT_ALL_BILL);) {
			ResultSet rs = pstm.executeQuery();
			while (rs.next()) {
				Bill bl = new Bill(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5),rs.getString(6),rs.getString(7));
				listBill.add(bl);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listBill;
	}
}

