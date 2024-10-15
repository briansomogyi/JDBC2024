package ro.emanuel.oop.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class Main {

	public static void main(String[] args) throws SQLException {
		
		Properties connectionProperties = new Properties();
		connectionProperties.put("user", "root");
		connectionProperties.put("password", "");
		
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/oop2024", connectionProperties);
		
		Statement statement = connection.createStatement();
		
		// INSERT
		String bName = "Banca Transilvania";
		String bAddress = "Romania";
		String bSwift = "BTRL";
		
		/*
		 * final String commandInsert =
		 * "insert into bank (name, address, swift) values ('" + bName + "', '" +
		 * bAddress + "', '" + bSwift + "')"; int rowsAffected =
		 * statement.executeUpdate(commandInsert); System.out.println(rowsAffected +
		 * " row(s) affected.");
		 */
		
		String sqlInsert = "insert into bank (name, address, swift) values (?, ?, ?)";
		PreparedStatement preparedStatement = connection.prepareStatement(sqlInsert);
		preparedStatement.setString(1, bName);
		preparedStatement.setString(2, bAddress);
		preparedStatement.setString(3, bSwift);
		
		preparedStatement.executeUpdate();
		
		//UPDATE
		String updatedName = "BTMic Oradea";
		String updatedAddress = "Str. Nufărului, nr. 28 E, ORADEA";
		
		String sqlUpdate = "update bank set name = ?, address = ? where id = ?";
		PreparedStatement preparedStatementUpdate = connection.prepareStatement(sqlUpdate);
		preparedStatementUpdate.setString(1, updatedName);
		preparedStatementUpdate.setString(2, updatedAddress);
		preparedStatementUpdate.setInt(3, 1);
		
		preparedStatementUpdate.executeUpdate();
		
		// DELETE
		String sqlDelete = "delete from bank where id > ?";
		PreparedStatement preparedStatementDelete = connection.prepareStatement(sqlDelete);
		preparedStatementDelete.setInt(1, 2);
		
		int result = preparedStatementDelete.executeUpdate();
		System.out.println(result + " row(s) affected.");
				
		ResultSet resultSet = statement.executeQuery("select * from bank");
		while(resultSet.next()) {
			int id = resultSet.getInt("id");
			String bankName = resultSet.getString("name");
			String bankAddress = resultSet.getString("address");
			String bankSwift = resultSet.getString("swift");
			
			System.out.println(id + " " + bankName + " " + bankAddress + " " + bankSwift);
		}
		
		connection.close();
		
	}

}
