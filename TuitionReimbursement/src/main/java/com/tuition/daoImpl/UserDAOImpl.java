package com.tuition.daoImpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tuition.beans.User;
import com.tuition.dao.UserDAO;
import com.tuition.util.ConnConfig;

public class UserDAOImpl implements UserDAO {
	ConnConfig cc = ConnConfig.getInstance();
	Connection connection = null;
	PreparedStatement stmt = null;
	CallableStatement call = null;

	@Override
	public List<User> getUsers() {
		List<User> users = new ArrayList<User>();
		try {
			connection = cc.getConnection();
			String sql = "SELECT * FROM USERS";
			stmt = connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				User user = new User();
				user.setUser_id(rs.getInt("USER_ID"));
				user.setName(rs.getString("NAME"));
				user.setPassword(rs.getString("PASSWORD"));
				
				users.add(user);
			}
		
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			closeResources();
		}
		return users;
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



