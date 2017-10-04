package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	
	public static final String USERNAME = "root";
	public static final String PASSWORD = "mysql81!!";
	public static final String CONN = "jdbc:mysql://localhost/phonebook?useSSL=false";
	
	public DBConnection() {
		
	}

	public static Connection getConnection() throws SQLException {
		
		return  DriverManager.getConnection(CONN, USERNAME, PASSWORD);
		
	}

}
