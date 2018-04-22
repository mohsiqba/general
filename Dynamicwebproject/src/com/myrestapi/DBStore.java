package com.myrestapi;
import java.io.Serializable;

public class DBStore implements Serializable{

	private static final long serialVersionUID = 1L;
	private String dbHostName;
	private String dbPort;
	private String dbServiceName;
	private String dbUsername;
	private String dbEncryptedPassword;
	
	public DBStore(String hostName, String port, String serviceName, String userName, String encryptedPassword){
		this.dbHostName = hostName;
		this.dbPort = port;
		this.dbServiceName = serviceName;
		this.dbUsername = userName;
		this.dbEncryptedPassword = encryptedPassword;
	}
	
	public DBStore() {
		// TODO Auto-generated constructor stub
	}

	public String getDbHostName() {
		return dbHostName;
	}
	public void setDbHostName(String dbHostName) {
		this.dbHostName = dbHostName;
	}
	public String getDbPort() {
		return dbPort;
	}
	public void setDbPort(String dbPort) {
		this.dbPort = dbPort;
	}
	public String getDbServiceName() {
		return dbServiceName;
	}
	public void setDbServiceName(String dbServiceName) {
		this.dbServiceName = dbServiceName;
	}
	public String getDbUsername() {
		return dbUsername;
	}
	public void setDbUsername(String dbUsername) {
		this.dbUsername = dbUsername;
	}
	public String getDbEncryptedPassword() {
		return dbEncryptedPassword;
	}
	public void setDbEncryptedPassword(String dbPassword) {
		this.dbEncryptedPassword = dbPassword;
	}
}
