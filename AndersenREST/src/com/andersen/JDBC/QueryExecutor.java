package com.andersen.JDBC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

/*
 * Establishes connection and executes query to the Data Base
 */

public class QueryExecutor {

	public static String findLegionById(int legionId) {
		String legionName = null;
		try {
			ConnectionsPool connectionsPool = new ConnectionsPool();
			DataSource dataSource = connectionsPool.setUpPool();
			Connection connection = dataSource.getConnection();
			String sql = "SELECT legio_name FROM legions WHERE legio_id=" + legionId;
			Statement statement = connection.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery(sql);

			while (resultSet.next()) {
				legionName = resultSet.getString(1);
			}
			connection.close();
			connectionsPool.printDbStatus();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		if (legionName == null) {
			legionName = "No legion with such ID";
		}
		return legionName;
	}
}
