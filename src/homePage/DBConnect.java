package homePage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class DBConnect {

	String cn = "jdbc:sqlserver://DESKTOP-CAAQMG8\\SQLEXPRESS:1433;databaseName=QuanLyQuanCF;user=sa;password=123;integratedSecurity=false;encrypt=true;trustServerCertificate=true;";
	private Connection  con;
	public DBConnect()
	{
		try {
			this.con = DriverManager.getConnection(cn);
			System.out.println("connect success");
		}
		catch(Exception e){
			System.out.println("c");
			e.printStackTrace();
		}
	}
	public ResultSet query(String qr)
	{
		try {
			Statement stm = this.con.createStatement();
			ResultSet rs = stm.executeQuery(qr);
			return rs;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
		
	}
}
