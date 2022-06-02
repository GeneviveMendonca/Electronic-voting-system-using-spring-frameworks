package com.electronicvotingsystem.service;

import com.electronicvotingsystem.entity.User;
import com.electronicvotingsystem.exception.UserNotFoundException;

public interface UserService {

	//user validation
	public User loginUser(String userName, String password)throws UserNotFoundException;
		
}
