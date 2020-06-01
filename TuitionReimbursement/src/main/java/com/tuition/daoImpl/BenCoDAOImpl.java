package com.tuition.daoImpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.tuition.beans.BenCo;
import com.tuition.dao.BenCoDAO;
import com.tuition.util.ConnConfig;

public class BenCoDAOImpl implements BenCoDAO {
	ConnConfig cc = ConnConfig.getInstance();
	Connection connection = null;
	PreparedStatement stmt = null;
	CallableStatement call = null;

	@Override
	public BenCo getBenCo(String username, String password) {
		BenCo benco = new BenCo();
		try {
			connection = cc.getConnection();
			String sql = "SELECT * FROM BEN_CO WHERE USER_ID IN"
					+ "(SELECT USER_ID FROM USERS WHERE USER_NAME = ? AND PASSWORD = ? )";
			stmt = connection.prepareStatement(sql);
			stmt.setString(1, username.toUpperCase());
			stmt.setString(2, password.toUpperCase());
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				benco.setBenco_id(rs.getInt("benco_id"));
				benco.setFirst_name(rs.getString("first_name"));
				benco.setLast_name(rs.getString("last_name"));
				benco.setTuition_limit(rs.getDouble("tuition_limit"));
				benco.setDhead(rs.getString("dhead"));
				benco.setUser_id(rs.getInt("user_id"));
				benco.setDept_id(rs.getInt("dept_id"));
				
			}
		
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			closeResources();
		}
		
		return benco;
	}
	
	
	
	

//============================================================
//=====================Update Benco========================
//============================================================
	
	
	
	public void updateBencoTuition(BenCo benco) {
		
		try {
			connection = cc.getConnection();
			String sql ="UPDATE BEN_CO"
					+ " SET TUITION_LIMIT = ?";
			stmt.setDouble(1, benco.getTuition_limit());
			stmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			closeResources();
		}
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
