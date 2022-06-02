package com.electronicvotingsystem.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.electronicvotingsystem.dao.UserRepository;
import com.electronicvotingsystem.entity.User;
import com.electronicvotingsystem.exception.UserNotFoundException;
import com.electronicvotingsystem.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepo;

	
	//validate Users
	@Override
	public User loginUser(String userName, String password)  {
		
		User User = userRepo.findByUserNameAndPassword(userName, password);
		if(User==null)
		{
			throw new UserNotFoundException("Invalid User");
		}
		return User;
	}
		
}
