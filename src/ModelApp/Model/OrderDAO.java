package ModelApp.Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import ModelApp.Object.Customer;
import ModelApp.Object.Employee;
import ModelApp.Object.Order;
import ModelApp.Object.Promotion;

public class OrderDAO {

	public static void insertHoaDon(String IDHoaDon, String NgayLap, int TongTien, String IDNV, String IDKH,
			String IDKhuyenMai, String GhiChu) {
		String sql = "INSERT INTO HoaDon (IDHoaDon, NgayLap, TongTien, IDNV, IDKH, IDKhuyenMai, GhiChu) VALUES (?, ?, ?, ?, ?, ?, ?)";
		try (Connection connection = DBConnect.getConnection();
				PreparedStatement pstmt = connection.prepareStatement(sql);) {

			// Thiết lập các giá trị cho các tham số trong câu lệnh SQL
			pstmt.setString(1, IDHoaDon);
			pstmt.setString(2, NgayLap);
			pstmt.setInt(3, TongTien);
			pstmt.setString(4, IDNV);
			pstmt.setString(5, IDKH);
			pstmt.setString(6, IDKhuyenMai);
			pstmt.setString(7, GhiChu);

			// Thực hiện câu lệnh SQL để chèn dữ liệu
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

			// Thiết lập các giá trị cho các tham số trong câu lệnh SQL
			pstmt.setString(1, IDHoaDon);
			pstmt.setString(2, IDSanPham);
			pstmt.setInt(3, SoLuong);
			pstmt.setString(4, GhiChu);
			pstmt.setString(5, Size);

			// Thực hiện câu lệnh SQL để chèn dữ liệu
			int rowsAffected = pstmt.executeUpdate();
			System.out.println("Số dòng được thêm vào: " + rowsAffected);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void insert(Employee em, String IDHoaDon, String NgayLap, int Total, Customer cs, Promotion pr,
			String GhiChu, List<Order> list) {
		try {
			insertHoaDon(IDHoaDon, NgayLap, Total, em.getIDNhanVien(), cs.getIDKH(), pr.getIDKhuyenMai(), GhiChu);
			for (Order i : list) {
				insertChiTietHoaDon(IDHoaDon, i.getIDSanPham(), i.getSoLuong(), i.getGhichu(), i.getSize());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
