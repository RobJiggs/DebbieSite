package com.games.start.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.games.start.entities.Users;
import com.games.start.service.UserService;



@RestController
@CrossOrigin
@RequestMapping("/api/user")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@PostMapping("/register")
	public Users Register(@RequestBody Users user) {
		Users u=new Users();
		u.setUserID(user.getUserID());
		u.setUsername(user.getUsername());
		u.setPassword(user.getPassword());
		
		System.out.print(user.getUsername()+"   hi   ");
	    u.setFirstname(user.getFirstname());
	    u.setLastname(user.getLastname());
		
		u.setEmail(user.getEmail());
		
		//u.setUserName("rob");
		//u.setPassWord("1234");
		//u.setFirstName("Robert");
		//u.setLastName("jay");
		//u.setPhoneNumber("213551512");
		//u.setEmail("gasgs");
		
		System.out.println(u.getUsername() +"user value is here");
		return userService.registerUser(u);
		
	}

}
