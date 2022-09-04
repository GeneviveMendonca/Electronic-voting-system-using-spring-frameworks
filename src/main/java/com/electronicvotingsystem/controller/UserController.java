package com.electronicvotingsystem.controller;

import java.util.Date;

import javax.servlet.ServletException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.electronicvotingsystem.entity.User;
import com.electronicvotingsystem.serviceimpl.UserServiceImpl;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@CrossOrigin(origins = "http://localhost", maxAge = 3600)
@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserServiceImpl userService;
	
	@GetMapping("/message")
	public String returnMessage() {
		return "Welcome!";
	}
	
	
//	  @PostMapping(path="/login",consumes =
//	  {MediaType.APPLICATION_FORM_URLENCODED_VALUE} , produces=
//	  {MediaType.APPLICATION_JSON_VALUE})
	 
	@PostMapping(path="/login")
	public String validate(@RequestBody User user) throws ServletException{
		String jwtToken = "";

		if (user.getUserName() == null || user.getPassword() == null) {
			throw new ServletException("Please fill in username and password");
		}

		String userName = user.getUserName();
		String password = user.getPassword();

		user = userService.findByUserNameAndPassword(userName, password);
		if (user == null) {
			throw new ServletException("UserName not found.");
		}

		String pwd = user.getPassword();

		if (!password.equals(pwd)) {
			throw new ServletException("Invalid login. Please check your name and password.");
		}

		jwtToken = Jwts.builder().setSubject(userName).claim("roles", "user").setIssuedAt(new Date())
				.signWith(SignatureAlgorithm.HS256, "secretkey").compact();

		return jwtToken;
	}
}