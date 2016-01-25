package lk.dialoglab.ezcash.util;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * DBInfo.java (UTF-8) This class is to set and get company specific database
 * information, which is used by the hibernate session factory
 * 
 * Mar 3, 2014, 10:40:32 PM
 * 
 * @version 1.0
 * @author Dewmini Premarathna
 */
@Component
@Scope("prototype")
public class DBInfo {
	
	

	// Following configuration details should be extracted from a property file.
//	private String server = "203.189.68.253";
//	private String server = "localhost";
	//private String port = "3306";
//	private String dbName = "cashatm";
	//private String username = "dialog";
	//private String password = "dialog123";
	//private String username = "hasala";
	private static final Logger logger = Logger.getLogger(DBInfo.class);
	
	private String server = "";
	private String port = "3306";
	private String dbName = "";
	private String username = "";
	private String password = "";
	
	
	private DBInfo(){
	
		logger.info("Get Database Information");
		//getDBCredintials();
		
		//username="hasala";
		//password="hasala123";
		//server ="localhost";
		//dbName ="cashatm";

		//getDBCredintials gb = new getDBCredintials (username,password,server,dbName);
		getDBCredintials gb = new getDBCredintials ();
		
		username=gb.getUsername();
		password=gb.getPassword();
		server = gb.getServer();
		dbName = gb.getDbName();

		logger.info("Database Information Received"+username+password+server+dbName);
		System.out.println("---------------------------------------");
	}
	
	

	public String getServer() {
		return server;
	}

	public void setServer(String server) {
		this.server = server;
	}

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}

	public String getDbName() {
		return dbName;
	}

	public void setDbName(String dbName) {
		this.dbName = dbName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	

}
