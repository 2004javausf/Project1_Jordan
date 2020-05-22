package com.tuition.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnConfig {
	
	//private instance of itself
	private static ConnConfig cc = new ConnConfig();
	
	//make private constructor
	private ConnConfig () {
		super();
	}
	
	//get instance of self
	public static synchronized ConnConfig getInstance() {
		if(cc == null) {
			return cc = new ConnConfig();
		}
		return cc;
	}
	
	public Connection getConnection() {
		
		String url ="jdbc:oracle:thin:@car-dealership.cxszkh9udppk.us-east-2.rds.amazonaws.com:1521:ORCL";
		String userName = "jptuition";
		String password  = "park7937";
		
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, userName, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return conn;
	}
	
	

}