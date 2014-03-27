package vm2014;
import java.sql.*;
public class DatabaseConnection {
	private static Connection conn;
	public static Connection connect() {
		String url = "jdbc:mysql://localhost:3306/";
		String dbName = "VM2014";
		String driver = "com.mysql.jdbc.Driver";
		String userName = "root";
		String password = "root";
		try {
			Class.forName(driver).newInstance();
			conn = DriverManager.getConnection(url+dbName,userName,password);
			System.out.println("Connected");
			return conn;
		} catch (Exception e) {
			e.printStackTrace();
			return conn;
		}
	}
	public static void disconnect(Connection conn) throws SQLException{
		conn.close();
	}
	
}
