package com.tuition.daoImpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.tuition.beans.Employee;
import com.tuition.dao.EmployeeDAO;
import com.tuition.util.ConnConfig;

public class EmployeeDAOImpl implements EmployeeDAO {
	
	ConnConfig cc = ConnConfig.getInstance();
	Connection connection = null;
	PreparedStatement stmt = null;
	CallableStatement call = null;

	@Override
	public Employee getEmployee(String username, String password) {
		Employee employee = new Employee();
		try {
		connection = cc.getConnection();
		String sql = "SELECT * FROM EMPLOYEES WHERE USER_ID IN"
				+ "(SELECT USER_ID FROM USERS WHERE USER_NAME = ? AND PASSWORD = ? )";
		stmt = connection.prepareStatement(sql);
		stmt.setString(1, username);
		stmt.setString(2, password);
		ResultSet rs = stmt.executeQuery();
		while(rs.next()) {
			employee.setEmployee_id(rs.getInt("employee_id"));
			employee.setFirst_name(rs.getString("first_name"));
			employee.setLast_name(rs.getString("last_name"));
			employee.setTuition_limit(rs.getDouble("tuition_limit"));
			employee.setUser_id(rs.getInt("user_id"));
			employee.setDept_id(rs.getInt("dept_id"));
		}
		
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			closeResources();
		}
		
		return employee;
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
