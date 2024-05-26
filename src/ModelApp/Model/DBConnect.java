package ModelApp.Model;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class DBConnect {

	static String cn = "jdbc:sqlserver://DESKTOP-HRMC28G:1433;databaseName=QuanLyQuanCF;user=sa;password=123;integratedSecurity=false;encrypt=true;trustServerCertificate=true;";

	public static Connection getConnection() throws SQLException
	{
			return DriverManager.getConnection(cn);
	}
}
