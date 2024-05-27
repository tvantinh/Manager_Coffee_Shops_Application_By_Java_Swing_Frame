package ModelApp.Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ModelApp.Object.Promotion;

public class PromotionDAO {
	private static final String SELECT_ALL = "SELECT * FROM KhuyenMai";

	public List<Promotion> getData() throws SQLException {
		List<Promotion> list = new ArrayList<>();
		try (Connection connection = DBConnect.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL);) {
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				Promotion tp = new Promotion(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getString(4),
						rs.getString(5));
				list.add(tp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public static List<Promotion> findPromotion(String IDKhuyenMai, String NoiDung) {
		List<Promotion> listPromotion = new ArrayList<>();
		try (Connection connection = DBConnect.getConnection()) {
			String sql = "SELECT * FROM khuyenmai WHERE IDKhuyenMai LIKE ? OR NoiDung LIKE ?";
			try (PreparedStatement statement = connection.prepareStatement(sql)) {
				statement.setString(1, "%" + IDKhuyenMai + "%");
				statement.setString(2, "%" + NoiDung + "%");

				ResultSet rs = statement.executeQuery();
				while (rs.next()) {
					Promotion pm = new Promotion();
					pm.setIDKhuyenMai(rs.getString("IDKhuyenMai"));
					pm.setNoiDung(rs.getString("NoiDung"));
					pm.setGiaGiam(rs.getInt("GiamGia"));
					pm.setNgayBD(rs.getString("NgayBD"));
					pm.setNgayKT(rs.getString("NgayKT"));
					listPromotion.add(pm);
				}
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return listPromotion;
	}

	public static void updatePromotion(String IDKhuyenMai, String NoiDung, int GiamGia, String NgayBD, String NgayKT) {
		try (Connection connection = DBConnect.getConnection()) {
			String sql = "update khuyenmai SET NoiDung = ?, GiamGia = ?, NgayBD = ?, NgayKT = ? WHERE IDKhuyenMai=?";
			try (PreparedStatement pstm = connection.prepareStatement(sql)) {
				pstm.setString(1, NoiDung);
				pstm.setInt(2, GiamGia);
				pstm.setString(3, NgayBD);
				pstm.setString(4, NgayKT);
				pstm.setString(5, IDKhuyenMai);

				int rowsUpdated = pstm.executeUpdate();
				if (rowsUpdated > 0) {

					System.out.println("Added data successfully " + rowsUpdated);
				} else {
					System.out.println("Data has failed to be updated.");
				}
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	public static void insertPromotion(String IDKhuyenMai, String NoiDung, int GiamGia, String NgayBD, String NgayKT) {
		try (Connection connection = DBConnect.getConnection()) {
			String sql = "INSERT INTO KhuyenMai (IDKhuyenMai, NoiDung, GiamGia, NgayBD, NgayKT) VALUES (?, ?, ?, ?, ?)";

			try (PreparedStatement pstm = connection.prepareStatement(sql)) {

				pstm.setString(1, IDKhuyenMai);
				pstm.setString(2, NoiDung);
				pstm.setInt(3, GiamGia);
				pstm.setString(4, NgayBD);
				pstm.setString(5, NgayKT);

				int rowsInserted = pstm.executeUpdate();
				if (rowsInserted > 0) {
					System.out.println("So dong duoc them vao: " + rowsInserted);
				}
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	public static void deletePromotion(String IDKhuyenMai) {
		try (Connection connection = DBConnect.getConnection()) {
			String sql = "DELETE FROM khuyenmai WHERE IDKhuyenMai = ?";
			try (PreparedStatement statement = connection.prepareStatement(sql)) {
				statement.setString(1, IDKhuyenMai);
				int rowsAffected = statement.executeUpdate();
				if (rowsAffected > 0) {
					System.out.println("So dong duoc xoa: " + rowsAffected);
				}
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
}
