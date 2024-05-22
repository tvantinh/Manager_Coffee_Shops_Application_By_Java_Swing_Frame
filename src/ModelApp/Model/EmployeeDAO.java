package ModelApp.Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ModelApp.Object.Customer;
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
	public Employee login(String taikhoan,String matkhau) throws SQLException {
		Employee Employee = null;
		String Statement = "  SELECT * FROM nhanvien AS nv where nv.taikhoan = ? and nv.matkhau = ?";
		try (Connection connection = DBConnect.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(Statement);) {
			// Thiết lập các giá trị cho các tham số trong câu lệnh SQL
			preparedStatement.setString(1, taikhoan);
			preparedStatement.setString(2, matkhau);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				Employee = new Employee(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6),rs.getString(7), rs.getString(8), rs.getString(9),rs.getString(10), rs.getString(11));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Employee;
	}
	public static void insertEmployee1(String iDNhanVien, String tenNhanVien, String ngaySinh, String cCCD, String sDT, String gioiTinh, String anhDaiDien, String iDChucVu, String NgayBDLamViec, String TaiKhoan, String MatKhau) throws SQLException {
		Connection con = DBConnect.getConnection();
		String sql = "Insert Into NhanVien(IDNV, TenNV, NgaySinh, CCCD, SDT, GioiTinh, AnhDaiDien, IDChucVu, NgayBDLamViec, TaiKhoan, MatKhau) Values (?,?,?,?,?,?,?,?,?,?,?)";
		
		try(
				PreparedStatement ptsm = con.prepareStatement(sql);
				
				)
		
		{
			ptsm.setString(1, iDNhanVien);
			ptsm.setString(2, tenNhanVien);
			ptsm.setString(3,  ngaySinh);
			ptsm.setString(4, cCCD);
			ptsm.setString(5, sDT);
			ptsm.setString(6, gioiTinh);
			ptsm.setString(7, anhDaiDien);
			ptsm.setString(8, iDChucVu);
			ptsm.setString(9,  NgayBDLamViec);
			ptsm.setString(10, TaiKhoan);
			ptsm.setString(11, MatKhau);
			
			// Thực hiện câu lệnh SQL để chèn dữ liệu
            int rowsAffected = ptsm.executeUpdate();

            // Xuất kết quả
            System.out.println("Số dòng được thêm vào: " + rowsAffected);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}		
	}
	
	
	
	public static void updateEmployee(String iDNhanVien, String tenNhanVien, String ngaySinh, String cCCD, String sDT, String iDChucVu) throws SQLException
	{
		Connection con = DBConnect.getConnection();
		String sql = "UPDATE NhanVien SET TenNV = ?, NgaySinh = ?, CCCD = ?, SDT = ?,  IDChucVu = ?  WHERE IDNV = ?";
		
		try(
				PreparedStatement ptsm = con.prepareStatement(sql);
				
				)
		
		{
			
			ptsm.setString(1, tenNhanVien);
			ptsm.setString(2,  ngaySinh);
			ptsm.setString(3, cCCD);
			ptsm.setString(4, sDT);
			ptsm.setString(5, iDChucVu);
			ptsm.setString(6, iDNhanVien);
			
			// Thực hiện câu lệnh SQL để chèn dữ liệu
            int rowsAffected = ptsm.executeUpdate();

            // Xuất kết quả
            System.out.println("Số dòng được sửa vào: " + rowsAffected);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}	
	}
	
	public static void changePassword(String taiKhoan, String matKhau) throws SQLException
	{
		Connection con = DBConnect.getConnection();
		String sql = "UPDATE NhanVien SET MatKhau = ?  WHERE TaiKhoan = ?";
		
		try(
				PreparedStatement ptsm = con.prepareStatement(sql);
				)
		{
			ptsm.setString(1, matKhau);
			ptsm.setString(2, taiKhoan);
			int rowsAffected = ptsm.executeUpdate();
            // Xuất kết quả
            System.out.println("Số dòng được sửa vào: " + rowsAffected);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
