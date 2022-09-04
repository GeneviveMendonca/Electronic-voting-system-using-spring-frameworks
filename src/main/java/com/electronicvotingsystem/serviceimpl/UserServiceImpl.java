package com.electronicvotingsystem.serviceimpl;

import java.util.List;

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

	// validate Users
	@Override
	public User findByUserNameAndPassword(String userName, String password) {

		User User = userRepo.findByUserNameAndPassword(userName, password);
		if (User == null) {
			throw new UserNotFoundException("Invalid User");
		}
		return User;
	}

	// findByUserName
	@Override
	public User findByUserName(String userName) {
		return userRepo.findByUserName(userName);
	}

	// save
	@Override
	public User save(User user) {
		return userRepo.save(user);
	}

	// viewAllUser
	@Override
	public List<User> viewAllUser() {
		return userRepo.findAll();

	}

}
