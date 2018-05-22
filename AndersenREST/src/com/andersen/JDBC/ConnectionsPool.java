package com.andersen.JDBC;

import javax.sql.DataSource;
import org.apache.commons.dbcp.ConnectionFactory;
import org.apache.commons.dbcp.DriverManagerConnectionFactory;
import org.apache.commons.dbcp.PoolableConnectionFactory;
import org.apache.commons.dbcp.PoolingDataSource;
import org.apache.commons.pool.impl.GenericObjectPool;

/*
 * 	Classic implementation of the Apache Connection pool
 * 		*genericPool holds connections
 * 		*connectionsFactory produces connections
 *		*poolableConFactory is a wrapper
 * 
 */

public class ConnectionsPool {

	private static final String JDBC_DB_URL = "jdbc:mysql://localhost:3306/roman_empire";
	private static final String USER_NAME = "root";
	private static final String PASSWORD = "";
	private static final int MAX_ACTIVE_CONNECTIONS = 5;
	private static GenericObjectPool genericPool = null;

	@SuppressWarnings("unused")
	public DataSource setUpPool() {
		 try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		genericPool = new GenericObjectPool();
		genericPool.setMaxActive(MAX_ACTIVE_CONNECTIONS);
		ConnectionFactory connectionsFactory = new DriverManagerConnectionFactory(JDBC_DB_URL, USER_NAME, PASSWORD);
		PoolableConnectionFactory poolableConFactory = new PoolableConnectionFactory(connectionsFactory, genericPool,
				null, null, false, true);
	
		return new PoolingDataSource(genericPool);
	}

	public GenericObjectPool getConnectionPool() {
		return genericPool;
	}

	// This Method Is Used To Print The Connection Pool Status
	public void printDbStatus() {
		System.out.println("Max.: " + getConnectionPool().getMaxActive() + "; Active: "
				+ getConnectionPool().getNumActive() + "; Idle: " + getConnectionPool().getNumIdle());
	}
}

