package ro.emanuel.oop.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class Church {

	public static void main(String[] args) throws SQLException {
		Properties connectionProperties = new Properties();
		connectionProperties.put("user", "root");
		connectionProperties.put("password", "");
		
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/oop2024", connectionProperties);
		
		Statement statement = connection.createStatement();
		
		// CREATE
		String name = "Biserica Baptista Speranta Oradea";
		String address = "Strada Thurzó Sándor 19, Oradea 417498";
		String denomination = "baptist";
		
		String sqlInsert = "insert into church (name, address, denomination) values (?, ?, ?)";
		PreparedStatement preparedStatement = connection.prepareStatement(sqlInsert);
		preparedStatement.setString(1, name);
		preparedStatement.setString(2, address);
		preparedStatement.setString(3, denomination);
		
		int result = preparedStatement.executeUpdate();
		System.out.println(result + " row(s) affected.");
		
		// READ
		ResultSet resultSet = statement.executeQuery("select * from church");
		while(resultSet.next()) {
			int id = resultSet.getInt("id");
			String churchName = resultSet.getString("name");
			String churchAddress = resultSet.getString("address");
			String churchDenomination = resultSet.getString("denomination");
			
			System.out.println(id + " " + churchName + " " + churchAddress + " " + churchDenomination);
		}
		
		// UPDATE
		String updatedName = "BBSO";
		String updatedAddress = "Str. Thurzó Sándor 19";
		
		String sqlUpdate = "update church set name = ?, address = ? where id = ?";
		PreparedStatement preparedStatementUpdate = connection.prepareStatement(sqlUpdate);
		preparedStatementUpdate.setString(1, updatedName);
		preparedStatementUpdate.setString(2, updatedAddress);
		preparedStatementUpdate.setInt(3, 2);
		
		result = preparedStatementUpdate.executeUpdate();
		System.out.println(result + " row(s) affected.");
		
		// READ
		resultSet = statement.executeQuery("select * from church");
		while(resultSet.next()) {
			int id = resultSet.getInt("id");
			String churchName = resultSet.getString("name");
			String churchAddress = resultSet.getString("address");
			String churchDenomination = resultSet.getString("denomination");
					
			System.out.println(id + " " + churchName + " " + churchAddress + " " + churchDenomination);
		}
				
		// DELETE
		String sqlDelete = "delete from church where id > ?";
		PreparedStatement preparedStatementDelete = connection.prepareStatement(sqlDelete);
		preparedStatementDelete.setInt(1, 2);
		
		result = preparedStatementDelete.executeUpdate();
		System.out.println(result + " row(s) affected.");
		
		// READ
		resultSet = statement.executeQuery("select * from church");
		while(resultSet.next()) {
			int id = resultSet.getInt("id");
			String churchName = resultSet.getString("name");
			String churchAddress = resultSet.getString("address");
			String churchDenomination = resultSet.getString("denomination");
					
			System.out.println(id + " " + churchName + " " + churchAddress + " " + churchDenomination);
		}
				
		connection.close();
		
	}

}
