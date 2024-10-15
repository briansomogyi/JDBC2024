package ro.emanuel.oop.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class MenuDAO {
	
	public static Menu getMenuById(int id) {
		return null;
		
	}
	
	public static ArrayList<Menu> getAllMenus() throws SQLException {
		Connection connection = DBHelper.getConnection();
		
		String query = "select * from menu";
		Statement statement = connection.createStatement();
		
		ArrayList<Menu> menuList = new ArrayList<>();
		ResultSet resultSet = statement.executeQuery(query);
		while(resultSet.next()) {
			int id = resultSet.getInt("id");
			String fel1 = resultSet.getString("fel1");
			String fel2 = resultSet.getString("fel2");
			String desert = resultSet.getString("desert");
			int price = resultSet.getInt("price");
			Menu menu = new Menu(id, fel1, fel2, desert, price);
			menuList.add(menu);
		}
		
		DBHelper.closeConnection();
		return menuList;
	}

}
