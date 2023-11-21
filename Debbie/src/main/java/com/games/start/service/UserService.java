package com.games.start.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.games.start.entities.Users;
import com.games.start.repo.UserRepo;



@Service
public class UserService {
	
	@Autowired
	UserRepo userRepo;
	
	@Autowired
	PasswordEncoder pwencoder;

	
	
	
	
	
	public List<Users> getAllUsers() {
		return userRepo.findAll();

	}
	
	public Users registerUser(Users user) {
		String encoderpw= pwencoder.encode(user.getPassword());
		user.setPassword(encoderpw);
		
		
		
		return userRepo.save(user);
		
		
		
	}
	
	public String returnpw(String password) {
		
		
		return pwencoder.encode(password);
		
		
	}
	public void saveUser(Users user) {
		
		userRepo.save(user);
		
		
		
	}
	
	public Users getUsersByid(Long UsersId) {
		return userRepo.findById(UsersId).get();
	}
	public Users getUserByUsername(String Username) {
		
		return userRepo.findByUsername(Username);
		
		
	}
	
public Users getUserByEmail(String Email) {
		
		return userRepo.findByEmail(Email);
		
		
	}

public void updatePassword(Users user, String newPassword) {
    // Update the user's password with the new password
    user.setPassword(newPassword);
    
    // Save the updated user entity to the database
    userRepo.save(user);
}
	

	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = userRepo.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        return new org.springframework.security.core.userdetails.User(
                user.getUsername(), user.getPassword(), new ArrayList<>()
        );
    }

   public boolean authenticateUser(String username, String password) {
        UserDetails userDetails = loadUserByUsername(username);
        return pwencoder.matches(password, userDetails.getPassword());
    }
   
   
   public UserDetails loadUserByEmail(String email) throws UsernameNotFoundException {
	    Users user = userRepo.findByEmail(email);
	    if (user == null) {
	        throw new UsernameNotFoundException("Invalid email or password.");
	    }
	    return new org.springframework.security.core.userdetails.User(
	            user.getEmail(), user.getPassword(), new ArrayList<>()
	    );
	}

	public boolean authenticateUserEmail(String email, String password) {
	    UserDetails userDetails = loadUserByEmail(email);
	    return pwencoder.matches(password, userDetails.getPassword());
	}

}
