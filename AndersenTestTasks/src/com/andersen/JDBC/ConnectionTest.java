package com.andersen.JDBC;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;
import com.andersen.JDBC.connections.ConnectionsPool;

/*
 * Tests basic operations with MySQL database : INSERT/UPDATE/DELETE/SELECT
 * Connection is provided by Apache Connections Pool
 */

public class ConnectionTest {

	public static void main(String[] args) throws SQLException, ClassNotFoundException{
		
			ConnectionsPool connectionsPool = new ConnectionsPool();
			DataSource dataSource = connectionsPool.setUpPool();
			Connection connection = dataSource.getConnection();
			
			addData(connection);
			updateData(connection);
			deleteData(connection);
			selectData(connection );
			
			connection.close();
			connectionsPool.printDbStatus();
			
	}
	//with  CallableStatement
	private static void addData(Connection connection) throws ClassNotFoundException, SQLException {

		String sql = "INSERT INTO leaders ( leader_name, leader_power, leader_money) VALUES (?, ?, ?)";

		CallableStatement statement = connection.prepareCall("add_roman__leader_procedure");
		System.out.println("Inserted successfully!");
	}
	//with classic PreparedStatement (accepts parameters at runtime)
	private static void updateData(Connection connection) throws ClassNotFoundException, SQLException {

		String sql = "UPDATE  leaders SET  leader_power=?, leader_money=? WHERE leader_name=?";

		PreparedStatement statement = connection.prepareStatement(sql);	
		statement.setInt(1, 10);
		statement.setInt(2, 700000);
		statement.setString(3, " Gaius Pupidius");

		System.out.println("Updated successfully!");
	}
	//with classic PreparedStatement (accepts parameters at runtime)
	private static void deleteData(Connection connection) throws ClassNotFoundException, SQLException {

		String sql = "DELETE FROM  leaders  WHERE leader_name=?";

		PreparedStatement statement = connection.prepareStatement(sql);	
		statement.setString(1, "Gaius Pupidius");

		System.out.println("Deleted successfully!");
	}
	//with simple Statement (it can not hold parameters!)
	private static void selectData(Connection connection) throws ClassNotFoundException, SQLException {

		String sql = "SELECT leader_id, leader_name, leader_power, leader_money FROM leaders";
		Statement statement = connection.prepareStatement(sql);	
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
