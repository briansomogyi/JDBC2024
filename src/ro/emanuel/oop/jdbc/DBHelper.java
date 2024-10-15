package ro.emanuel.oop.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBHelper {
	public static Connection getConnection() throws SQLException {
		Properties connectionProperties = new Properties();
		connectionProperties.put("user", "root");
		connectionProperties.put("password", "");
		
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/oop2024", connectionProperties);
		return connection;
		
		
	}
	
	public static void closeConnection() {
		
	}

}
