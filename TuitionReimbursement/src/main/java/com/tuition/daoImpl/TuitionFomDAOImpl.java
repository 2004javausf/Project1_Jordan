package com.tuition.daoImpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.tuition.beans.TuitionForm;
import com.tuition.dao.TuitionFormDAO;
import com.tuition.util.ConnConfig;

public class TuitionFomDAOImpl implements TuitionFormDAO {
	ConnConfig cc = ConnConfig.getInstance();
	Connection connection = null;
	PreparedStatement stmt = null;
	CallableStatement call = null;

	@Override
	public void addForm(TuitionForm form) {
		try {
			connection = cc.getConnection();
			String sql ="INSERT INTO TUITION_FORM VALUES(null,?,?,?,?,?,?,?,?,?,?)"; 
			stmt = connection.prepareStatement(sql);
			stmt.setString(1, form.getFirst_name() );
			stmt.setString(2, form.getLast_name() );
			stmt.setDate(3, form.getStart_date() );
			stmt.setTimestamp(4, form.getStart_time() );
			stmt.setString(5, form.getLocation() );
			stmt.setString(6, form.getDescription());
			stmt.setDouble(7, form.getCost());
			stmt.setString(8, form.getEvent_type());
			stmt.setBlob(9, form.getAttachments());
			stmt.setInt(10, form.getUser_id() );
			stmt.execute();	
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
