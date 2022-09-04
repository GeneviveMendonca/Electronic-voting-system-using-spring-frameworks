package com.electronicvotingsystem.service;

import java.util.List;

import com.electronicvotingsystem.entity.User;
import com.electronicvotingsystem.exception.UserNotFoundException;

public interface UserService {

	//user validation
	public User save(User user);
	
	//findByUserNameAndPassword
	public User findByUserNameAndPassword(String userName, String password)throws UserNotFoundException;
	
	//findByUserName
	public User findByUserName(String userName);
	
	//viewAllUser
	public List<User> viewAllUser();
	
		
}
