package com.cognizant.racegarden;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DbConnection {

	private static String url = "jdbc:mysql://localhost:3306/race_garden";
	private static String username = "root";  
	private static String password = "root";
	private static String db = "race_garden";
	
	
	
	public static Connection getConnection() throws SQLException {
//		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, username, password);
		

		
		
		
		
		return con;
	}
	
	
	
	
	
}
