package com.tuition.dao;

import java.util.List;

import com.tuition.beans.User;

public interface UserDAO {
	
	public List<User> getUsers();
	public void createUser(User user);
	public User getSingleUser(int user_id);

}
