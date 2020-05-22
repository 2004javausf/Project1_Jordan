package com.tuition.beans;

public class User {
	
	private int user_id;
	private String name;
	private String password;
	
	public User(int user_id, String name, String password) {
		super();
		this.user_id = user_id;
		this.name = name;
		this.password = password;
	}

	public User() {
		super();
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Users [user_id=" + user_id + ", name=" + name + ", password=" + password + "]";
	}
	
	
	
	
	
	
	
	
	
	

}
