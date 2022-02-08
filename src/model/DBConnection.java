package model;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
	public static Connection con;
	public static final String USERNAME = "root";
	public static final String PASSWORD = "Hamza1575";
	private static final String URL = "jdbc:mysql://localhost:3306/BloodDonationSystem";

	private DBConnection() {
	}

	public static Connection getConnection() {
		if (con == null)
			initializeConnection();
		return con;
	}

	private static void initializeConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		} catch (Exception e) {
			con = null;
		}
	}
}
