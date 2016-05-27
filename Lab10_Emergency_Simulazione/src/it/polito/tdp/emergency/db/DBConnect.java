package it.polito.tdp.emergency.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {

	static private final String jdbcUrl = "jdbc:mysql://localhost/emergency?user=root";
	Connection conn = null;

	public static Connection getConnection() {
		try {
			Connection conn = DriverManager.getConnection(jdbcUrl);
			return conn;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("Cannot get connection " + jdbcUrl, e);
		}
	}

}
