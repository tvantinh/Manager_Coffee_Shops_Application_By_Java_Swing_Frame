package ModelApp.Model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import ModelApp.Object.Customer;
import ModelApp.Object.Employee;
import ModelApp.Object.Order;
import ModelApp.Object.Promotion;

public class OrderDAO {

	public static void insertHoaDon(String IDHoaDon, Timestamp time, int TongTien, String IDNV, String IDKH,
			String IDKhuyenMai, String GhiChu) {
		String sql = "INSERT INTO HoaDon (IDHoaDon, NgayLap, TongTien, IDNV, IDKH, IDKhuyenMai, GhiChu) VALUES (?, ?, ?, ?, ?, ?, ?)";
		try (Connection connection = DBConnect.getConnection();
				PreparedStatement pstmt = connection.prepareStatement(sql);) {

			pstmt.setString(1, IDHoaDon);
			pstmt.setTimestamp(2, time);
			pstmt.setInt(3, TongTien);
			pstmt.setString(4, IDNV);
			pstmt.setString(5, IDKH);
			pstmt.setString(6, IDKhuyenMai);
			pstmt.setString(7, GhiChu);

			int rowsAffected = pstmt.executeUpdate();
			System.out.println("Số dòng được thêm vào: " + rowsAffected);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void insertChiTietHoaDon(String IDHoaDon, String IDSanPham, int SoLuong, String GhiChu, String Size) {
		String sql = "INSERT INTO ChiTietHoaDon (IDHoaDon, IDSanPham, SoLuong, GhiChu, Size) VALUES (?, ?, ?, ?, ?)";
		try (Connection connection = DBConnect.getConnection();
				PreparedStatement pstmt = connection.prepareStatement(sql);) {

			pstmt.setString(1, IDHoaDon);
			pstmt.setString(2, IDSanPham);
			pstmt.setInt(3, SoLuong);
			pstmt.setString(4, GhiChu);
			pstmt.setString(5, Size);

			int rowsAffected = pstmt.executeUpdate();
			System.out.println("Số dòng được thêm vào: " + rowsAffected);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void insert(Employee em, String IDHoaDon, Timestamp time, int Total, Customer cs, Promotion pr, String GhiChu, List<Order> list) {
		try {
			insertHoaDon(IDHoaDon, time, Total, em.getIDNhanVien(), cs.getIDKH(), pr.getIDKhuyenMai(), GhiChu);
			for (Order i : list) {
				insertChiTietHoaDon(IDHoaDon, i.getIDSanPham(), i.getSoLuong(), i.getGhichu(), i.getSize());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
