package com.myrestapi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;




public class DBConnector {
	private String dbUsername;
	private String dbPassword;
	public static DBStore dbInformation;

	public DBConnector(String dbUsername, String dbPassword) {
		this.dbUsername = dbUsername;
		this.dbPassword = dbPassword;
	}
	public void Initialize( String hostName, String port, String serviceName) {
		try {

			String encryptedPassword = Security.encrypt(this.dbPassword);
			dbInformation = new DBStore(hostName, port, serviceName, this.dbUsername, encryptedPassword);

			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public Connection connect() {
		System.out.println("-------- Oracle JDBC Connection ------");
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		}
		System.out.println("-------- Oracle JDBC Driver Registered ------");
		Connection connection = null;
		try {
			String hostName = dbInformation.getDbHostName().toString();
			String port = dbInformation.getDbPort().toString();
			String serviceName = dbInformation.getDbServiceName().toString();
			String userName = dbInformation.getDbUsername().toString();
			String password = Security.decrypt(dbInformation.getDbEncryptedPassword().toString());
			
			connection = DriverManager.getConnection("jdbc:oracle:thin:@"+ hostName + ":" + port + "/" + serviceName + "", userName, password);

		} catch (Exception e) {
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
			return null;
		}
		return connection;
	}
	public ResultSet execute(Connection connection, String query) {
		Statement stmt;
		ResultSet rs = null;
		try {
			stmt = connection.createStatement();
			rs = stmt.executeQuery(query);
		} catch (SQLException e) {
			System.out.println("Failed to Execute Query");
			e.printStackTrace();
			return null;
		}
		return rs;
	}
}
