package com.tuition.daoImpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.tuition.beans.Supervisor;
import com.tuition.dao.SupervisorDAO;
import com.tuition.util.ConnConfig;

public class SupervisorDAOImpl implements SupervisorDAO {
	ConnConfig cc = ConnConfig.getInstance();
	Connection connection = null;
	PreparedStatement stmt = null;
	CallableStatement call = null;

	@Override
	public Supervisor getSupervisor(String username, String password) {
		Supervisor supervisor = new Supervisor();
		try {
			connection = cc.getConnection();
			String sql = "SELECT * FROM SUPERVISORS WHERE USER_ID IN"
					+ "(SELECT USER_ID FROM USERS WHERE USER_NAME = ? AND PASSWORD = ? )";
			stmt = connection.prepareStatement(sql);
			stmt.setString(1, username.toUpperCase());
			stmt.setString(2, password.toUpperCase());
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				supervisor.setSupervisor_id(rs.getInt("supervisor_id"));
				supervisor.setFirst_name(rs.getString("first_name"));
				supervisor.setLast_name(rs.getString("last_name"));
				supervisor.setTuition_limit(rs.getDouble("tuition_limit"));
				supervisor.setDhead(rs.getString("dhead"));
				supervisor.setUser_id(rs.getInt("user_id"));
				supervisor.setDept_id(rs.getInt("dept_id"));
				
			}
		
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			closeResources();
		}
		
		return supervisor;
	}
	
	
	
//============================================================
//=====================Close Resources========================
//============================================================
	
	
	
	private void closeResources() {
		try {
			if (stmt != null)
				stmt.close();
		} catch (SQLException e) {
			System.out.println("Could not close statement!");
			e.printStackTrace();
		}
		
		try {
			if (connection != null)
				connection.close();
		} catch (SQLException e) {
			System.out.println("Could not close connection!");
			e.printStackTrace();
		}
	}
	
}
