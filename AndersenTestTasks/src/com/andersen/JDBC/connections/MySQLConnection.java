package com.andersen.JDBC.connections;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
 * Creates connection to MySQL database on simple localhost
 */

public class MySQLConnection {

	private static final String URL = "jdbc:mysql://";
	private static final String HOST_NAME = "localhost";
	private static final String PORT = ":3306/";
	private static final String DB_NAME = "roman_empire";
	private static final String USER_NAME = "root";
	private static final String PASSWORD = "";

	// Connect to MySQL
	public static Connection getMySQLConnection() throws SQLException, ClassNotFoundException {
		
		String connectionURL = URL + HOST_NAME + PORT + DB_NAME;
		Connection connection = DriverManager.getConnection(connectionURL, USER_NAME, PASSWORD);
		return connection;
	}
}
