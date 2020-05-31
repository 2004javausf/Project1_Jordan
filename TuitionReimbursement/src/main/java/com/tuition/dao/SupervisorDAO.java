package com.tuition.dao;

import com.tuition.beans.Supervisor;

public interface SupervisorDAO {
	
	public Supervisor getSupervisor(String username, String password);
	
}
