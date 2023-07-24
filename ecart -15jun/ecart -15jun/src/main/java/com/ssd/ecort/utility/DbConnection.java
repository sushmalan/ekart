package com.ssd.ecort.utility;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnection {

	private static Connection conn = null;

	public static Connection getDbConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecart", "root", "root");
		} catch (Exception e) {
			// TODO: handle exception
		}
		return conn;
	}

}
