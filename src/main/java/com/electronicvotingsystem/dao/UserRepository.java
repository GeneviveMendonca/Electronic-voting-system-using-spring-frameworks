package com.electronicvotingsystem.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.electronicvotingsystem.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User,Integer>{
	
	//findByUserName
	public User findByUserName(String userName);
	
	//findByUserNameAndPassword
	public User findByUserNameAndPassword(String username,String password);
	
	//existsByUserName
	public boolean existsByUserName(String userName);
	
	
	

}
