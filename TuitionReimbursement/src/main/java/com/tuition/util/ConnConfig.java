package com.tuition.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnConfig {
	private static ConnConfig cc = new ConnConfig();
	private static final String url = "jdbc:oracle:thin:@car-dealership.cxszkh9udppk.us-east-2.rds.amazonaws.com:1521:ORCL";
	private static final String user = "jptuition";
	private static final String password = "park7937";
	
	private ConnConfig() {
		super();
	}
	
	public static synchronized ConnConfig getInstance() {
		if(cc == null) {
			cc = new ConnConfig();
		}
		return cc;
	}
	
	public Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return conn;
	}
}
