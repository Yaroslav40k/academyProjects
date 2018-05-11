package com.andersen.JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.andersen.JDBC.connections.MySQLConnection;

/*
 * Tests basic operations with MySQL database : INSERT/UPDATE/DELETE/SELECT
 */

public class ConnectionTest {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		
		Connection connection = MySQLConnection.getMySQLConnection();
		
		//addData(connection);
		//selectData(connection );
		//updateData(connection);
		//deleteData(connection);
		
		connection.close();
	}

	private static void addData(Connection connection) throws ClassNotFoundException, SQLException {

		String sql = "INSERT INTO leaders ( leader_name, leader_power, leader_money) VALUES (?, ?, ?)";

		PreparedStatement statement = connection.prepareStatement(sql);	
		statement.setString(1, "Gaius Pupidius");
		statement.setInt(2, 10);
		statement.setInt(3, 999999);

		int rowsInserted = statement.executeUpdate();
		if (rowsInserted > 0) {
			System.out.println("Inserted successfully!");
		}
	}
	
	private static void updateData(Connection connection) throws ClassNotFoundException, SQLException {

		String sql = "UPDATE  leaders SET  leader_power=?, leader_money=? WHERE leader_name=?";

		PreparedStatement statement = connection.prepareStatement(sql);	
		statement.setInt(1, 10);
		statement.setInt(2, 700000);
		statement.setString(3, " Gaius Pupidius");

		int rowsUpdated = statement.executeUpdate();
		if (rowsUpdated > 0) {
			System.out.println("Updated successfully!");
		}
	}
	
	private static void deleteData(Connection connection) throws ClassNotFoundException, SQLException {

		String sql = "DELETE FROM  leaders  WHERE leader_name=?";

		PreparedStatement statement = connection.prepareStatement(sql);	
		statement.setString(1, "Gaius Pupidius");

		int rowsDeleted = statement.executeUpdate();
		if (rowsDeleted > 0) {
			System.out.println("Deleted successfully!");
		}
	}

	private static void selectData(Connection connection) throws ClassNotFoundException, SQLException {

		String sql = "SELECT leader_id, leader_name, leader_power, leader_money FROM leaders";
		PreparedStatement statement = connection.prepareStatement(sql);	
		ResultSet resultSet = statement.executeQuery(sql);

		while ( resultSet.next()) {
			int leaderId =  resultSet.getInt(1);
			String leaderName =  resultSet.getString(2);
			int leaderPower =  resultSet.getInt(3);
			int leaderMoney =  resultSet.getInt(4);
			System.out.println("--------------------");
			System.out.println("leaderId:" + leaderId);
			System.out.println("leaderName:" + leaderName);
			System.out.println("leaderPower:" + leaderPower);
			System.out.println("leaderMoney:" + leaderMoney);
		}
	}
}
