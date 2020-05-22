package com.tuition.beans;

public class Employee {
	
	private int employee_id;
	private String first_name;
	private String last_name;
	private double tuition_limit;
	
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(int employee_id, String first_name, String last_name, double tuition_limit) {
		super();
		this.employee_id = employee_id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.tuition_limit = tuition_limit;
	}

	public int getEmployee_id() {
		return employee_id;
	}

	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public double getTuition_limit() {
		return tuition_limit;
	}

	public void setTuition_limit(double tuition_limit) {
		this.tuition_limit = tuition_limit;
	}

	@Override
	public String toString() {
		return "Employee [employee_id=" + employee_id + ", first_name=" + first_name + ", last_name=" + last_name
				+ ", tuition_limit=" + tuition_limit + "]";
	}
	
}
