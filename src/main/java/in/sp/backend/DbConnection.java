package in.sp.backend;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
	static String USER_NAME = "root";
	static String PASSWORD = "gaganeswar145";
	static String URL = "jdbc:mysql://localhost:3306/servletdb";
	static String DRIVER = "com.mysql.cj.jdbc.Driver";
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		Connection conn = null;
		Class.forName(DRIVER);
		conn = DriverManager.getConnection(URL,USER_NAME,PASSWORD);
		return conn;
	}
}
