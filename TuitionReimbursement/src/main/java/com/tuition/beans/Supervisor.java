package com.tuition.beans;

public class Supervisor {
	
	private int supervisor_id;
	private String first_name;
	private String last_name;
	private double tuition_limit;
	private String dhead;
	private int user_id;
	private int dept_id;
	
	public Supervisor() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Supervisor(int supervisor_id, String first_name, String last_name, double tuition_limit, String dhead,
			int user_id, int dept_id) {
		super();
		this.supervisor_id = supervisor_id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.tuition_limit = tuition_limit;
		this.dhead = dhead;
		this.user_id = user_id;
		this.dept_id = dept_id;
	}

	public int getSupervisor_id() {
		return supervisor_id;
	}

	public void setSupervisor_id(int supervisor_id) {
		this.supervisor_id = supervisor_id;
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

	public String getDhead() {
		return dhead;
	}

	public void setDhead(String dhead) {
		this.dhead = dhead;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public int getDept_id() {
		return dept_id;
	}

	public void setDept_id(int dept_id) {
		this.dept_id = dept_id;
	}

	@Override
	public String toString() {
		return "Supervisor [supervisor_id=" + supervisor_id + ", first_name=" + first_name + ", last_name=" + last_name
				+ ", tuition_limit=" + tuition_limit + ", dhead=" + dhead + ", user_id=" + user_id + ", dept_id="
				+ dept_id + "]";
	}
	

}
