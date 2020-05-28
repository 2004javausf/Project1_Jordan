package com.tuition.daoImpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.tuition.beans.TuitionForm;
import com.tuition.dao.TuitionFormDAO;
import com.tuition.util.ConnConfig;

public class TuitionFormDAOImpl implements TuitionFormDAO {
	ConnConfig cc = ConnConfig.getInstance();
	Connection connection = null;
	PreparedStatement stmt = null;
	CallableStatement call = null;

	@Override
	public void addForm(TuitionForm form) {
		try {
			connection = cc.getConnection();
			String sql ="INSERT INTO TUITION_FORM VALUES(null,?,?,?,?,?,?,?,?,NULL,?,1)"; 
			stmt = connection.prepareStatement(sql);
			stmt.setString(1, form.getFirst_name() );
			stmt.setString(2, form.getLast_name() );
			stmt.setString(3, form.getStart_date() );
			stmt.setString(4, form.getStart_time() );
			stmt.setString(5, form.getLocation() );
			stmt.setString(6, form.getDescription());
			stmt.setDouble(7, form.getCost());
			stmt.setString(8, form.getEvent_type());
			//stmt.setBlob(9, form.getAttachments());
			stmt.setInt(9, form.getUser_id() );
			//stmt.setInt(10,  form.getGrade_id());
			stmt.execute();	
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			closeResources();
		}
	}
//============================================================
//=====================Retrieve Form==========================
//============================================================

	public TuitionForm getFormById(int user_id) {
		TuitionForm tf = new TuitionForm();
		try {
			connection = cc.getConnection();
			String sql = "SELECT * FROM TUITION_FORM WHERE USER_ID = ?";
			stmt = connection.prepareStatement(sql);
			stmt.setInt(1, user_id);
			ResultSet rs = stmt.executeQuery();
			
			if(rs.next()) {
				tf.setForm_id(rs.getInt("form_id"));
				tf.setFirst_name(rs.getString("first_name"));
				tf.setLast_name(rs.getString("last_name"));
				tf.setStart_date(rs.getString("start_date"));
				tf.setStart_time(rs.getString("start_time"));
				tf.setLocation(rs.getString("location"));
				tf.setDescription(rs.getString("description"));
				tf.setCost(rs.getDouble("cost"));
				tf.setEvent_type(rs.getString("event_type"));
				tf.setUser_id(rs.getInt("user_id"));;
				tf.setGrade_id(rs.getInt("grade_id"));
			}	
		}catch(SQLException e) {
			
		}finally {
			closeResources();
		}
		return tf;
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
