package com.tuition.dao;

import com.tuition.beans.Employee;

public interface EmployeeDAO {
	public Employee getEmployee(String username, String password);
}
