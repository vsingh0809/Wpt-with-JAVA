package com.app.dao;

import java.time.LocalDate;
import java.util.List;

import com.app.entities.Role;
import com.app.entities.User;

public interface UserDao {
//add a method for user sign up
	String registerUser(User user);
	//add a method to get user details by it's id
	User getUserDetails(Long userId);
	//add methode to return users;
	List<User> getAllUser();
	List<User> getAllUserBYDob(LocalDate start, LocalDate finish, Role role);
	User login(String email,String password);
	String changePassword(String email,String password,String NewPassword);
	
}
