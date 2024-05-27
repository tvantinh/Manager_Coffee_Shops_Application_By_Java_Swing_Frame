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
	public static boolean checkIDKH(String IDKH) throws SQLException {
		String Statement = "  SELECT * FROM KHACHHANG AS KH where KH.IDKH = ?";
		try (Connection connection = DBConnect.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(Statement);) {
			preparedStatement.setString(1, IDKH);
			boolean rs = preparedStatement.execute();
			if (rs == true)
				return false;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
	}
	public static void insertCustomer(Customer cs) throws SQLException {
		Connection con = DBConnect.getConnection();
		String sql = "Insert Into KhachHang(IDKH, TenKH, Gioitinh, SDT, DiaChi, Email) Values (?,?,?,?,?,?)";
		
		try(
				PreparedStatement ptsm = con.prepareStatement(sql);
				
				)
		
		{
			ptsm.setString(1, cs.getIDKH());
			ptsm.setString(2, cs.getTenKH());
			ptsm.setString(3,  cs.getGioiTinh());
			ptsm.setString(4, cs.getSDT());
			ptsm.setString(5, cs.getDiaChi());
			ptsm.setString(6, cs.getEmail());
            int rowsAffected = ptsm.executeUpdate();
            System.out.println("Số dòng được thêm vào: " + rowsAffected);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}		
	}
	public static void insertCustomer(String iDKH, String tenKH, String gioiTinh, String sDT, String diaChi, String email) throws SQLException
	{
		Connection con = DBConnect.getConnection();
		String sqlCount = "Select COUNT(*) As count From KhachHang";
		String sql = "Insert Into KhachHang (IDKH, TenKH, GIoitinh, SDT , DiaChi, Email) Values (?,?,?,?,?,?)";
		try(
				PreparedStatement ptsmCount = con.prepareStatement(sqlCount);
				ResultSet rsCount = ptsmCount.executeQuery();
				PreparedStatement ptsm = con.prepareStatement(sql);
				)
		{
			if(rsCount.next())
			{
				int count = rsCount.getInt("count");
				iDKH = "KH00" + (count+1);
				ptsm.setString(1, iDKH);
				ptsm.setString(2, tenKH);
				ptsm.setString(3, gioiTinh);
				ptsm.setString(4, sDT);
				ptsm.setString(5, diaChi);
				ptsm.setString(6, email);
			}
			int row = ptsm.executeUpdate();
			System.out.println("So dong duoc them" + row);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static List<Customer> findCustomer(String name) throws SQLException
	{
		Connection con = DBConnect.getConnection();
		List<Customer> listCustomer = new ArrayList<Customer>();
		String sql = "Select * from KhachHang where TenKH like ?";
		try(
				PreparedStatement ptsm = con.prepareStatement(sql);
				)
		{
			ptsm.setString(1, "%"+name+"%");
			ResultSet rs = ptsm.executeQuery();
			while(rs.next())
			{
				Customer cr = new Customer();
				cr.setIDKH(rs.getString("IDKH"));
				cr.setTenKH(rs.getString("TenKH"));
				cr.setEmail(rs.getString("Email"));
				cr.setSDT(rs.getString("SDT"));
				cr.setDiaChi(rs.getString("DiaChi"));
				listCustomer.add(cr);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return listCustomer;
	}
	
	public static List<Customer> findCustomerByPhoneNum(String phoneNum) throws SQLException
	{
		Connection con = DBConnect.getConnection();
		List<Customer> listCustomer = new ArrayList<Customer>();
		String sql = "Select * from KhachHang where SDT like ?";
		try(
				PreparedStatement ptsm = con.prepareStatement(sql);
				)
		{
			ptsm.setString(1, "%"+phoneNum+"%");
			ResultSet rs = ptsm.executeQuery();
			while(rs.next())
			{
				Customer cr = new Customer();
				cr.setIDKH(rs.getString("IDKH"));
				cr.setTenKH(rs.getString("TenKH"));
				cr.setEmail(rs.getString("Email"));
				cr.setSDT(rs.getString("SDT"));
				cr.setDiaChi(rs.getString("DiaChi"));
				listCustomer.add(cr);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return listCustomer;
	}
	
	public static void updateCustomer(String iDKH, String tenKH, String sDT, String diaChi, String email) throws SQLException
	{
		Connection con = DBConnect.getConnection();
		String sql = "UPDATE KhachHang SET TenKH = ?, Email = ?, SDT = ?, DiaChi = ? WHERE IDKH = ?";		
		try(
				PreparedStatement ptsm = con.prepareStatement(sql);
				)
		
		{
			ptsm.setString(1, tenKH);
			ptsm.setString(2,  sDT);
			ptsm.setString(3, diaChi);
			ptsm.setString(4, email);
			ptsm.setString(5, iDKH);
			// Thực hiện câu lệnh SQL để chèn dữ liệu
            int rowsAffected = ptsm.executeUpdate();
            // Xuất kết quả
            System.out.println("Số dòng được sửa vào: " + rowsAffected);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}	
	}
	
	public static void deleteCustomer(String id) throws SQLException
	{
		
		Connection con = DBConnect.getConnection();
		String sql ="DELETE FROM KhachHang WHERE IDKH = ?";
		try(
				PreparedStatement ptsm = con.prepareStatement(sql)
				) 
		{
			ptsm.setString(1, id);
			int rowsAffected = ptsm.executeUpdate();
			System.out.println("Số dòng bị xóa: " + rowsAffected);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
}
