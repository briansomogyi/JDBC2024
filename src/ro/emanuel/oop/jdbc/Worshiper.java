package ro.emanuel.oop.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class Worshiper {

	public static void main(String[] args) throws SQLException {
		Properties connectionProperties = new Properties();
		connectionProperties.put("user", "root");
		connectionProperties.put("password", "");
		
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/oop2024", connectionProperties);
		
		Statement statement = connection.createStatement();
		
		// CREATE
		String name = "Brian Somogyi";
		String address = "Str. Galileo Galilei Nr. 3";
		String domain = "lirics";
		
		String sqlInsert = "insert into worshipers (name, address, worship_domain) values (?, ?, ?)";
		PreparedStatement preparedStatement = connection.prepareStatement(sqlInsert);
		preparedStatement.setString(1, name);
		preparedStatement.setString(2, address);
		preparedStatement.setString(3, domain);
		
		preparedStatement.executeUpdate();
		
		// READ
		ResultSet resultSet = statement.executeQuery("select * from worshipers");
		while(resultSet.next()) {
			int id = resultSet.getInt("id");
			String worshiperName = resultSet.getString("name");
			String worshiperAddress = resultSet.getString("address");
			String worshipDomain = resultSet.getString("worship_domain");
			
			System.out.println(id + " " + worshiperName + " " + worshiperAddress + " " + worshipDomain);
		}
		
		connection.close();
		
		
		
	}

}
