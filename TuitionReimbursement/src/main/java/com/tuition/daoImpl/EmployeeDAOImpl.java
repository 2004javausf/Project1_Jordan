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
			stmt.setString(1, username.toUpperCase());
			stmt.setString(2, password.toUpperCase());
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
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

//public Customer getCustomer(String userName, String password) {
//	Customer customer = new Customer();
//	
//	try {
//		connection = cc.getConnection();
//		String sql = "SELECT * FROM CUSTOMERS WHERE USER_ID IN"
//				+ "(SELECT USER_ID FROM DEALER_USERS WHERE USER_NAME = ? AND DEALER_PASSWORD = ? )";
//		stmt = connection.prepareStatement(sql);
//		stmt.setString(1, userName);
//		stmt.setString(2, password);
//		ResultSet rs = stmt.executeQuery();
//		if(rs.next()) {
//			
//			customer.setCustomer_id(rs.getInt("customer_id"));
//			customer.setFirstName(rs.getString("first_name"));
//			customer.setLastName(rs.getString("last_name"));
//			customer.setAddress_id(rs.getInt("address_id"));
//			customer.setUser_id(rs.getInt("user_id"));
//			customer.setCar_id(rs.getInt("car_id"));
//			customer.setOffer_id(rs.getInt("offer_id"));
//		}
//		
//		if(customer.getCustomer_id() == 0) {
//			throw new SQLException("Username or password does not exist.");
//		}
//		
//		DealershipLog.LogIt("info", "Customer has been retrieved from the database.");
//		
//		} catch(SQLException e) {
//			System.out.println(e.getMessage());
//			MainMenu.start();
//			
//		}finally {
//			closeResources();
//		}
//	return customer;
//}
