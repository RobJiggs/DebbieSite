package com.games.start.entities;

import java.util.Set;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.LazyGroup;


import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Users {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(nullable = false)
	
	private long userID;

	@Column(nullable = false, unique = true)
	private String username;
	
	@Column(nullable = false)
	private String password;
	
	private String firstname;

	private String lastname;
	

	@OneToOne(mappedBy = "user")
    private PasswordResetToken passwordResetToken;

	@Column(unique=true)
	private String email;
	
	@OneToOne(mappedBy = "user")
	@LazyGroup("rating")
	@JsonIgnore
	@Fetch(FetchMode.JOIN)
	private User_Rating rating;
	
	
	@ManyToMany(mappedBy = "users")
    
    
    private Set<Games> games;


	public long getUserID() {
		return userID;
	}


	public void setUserID(long userID) {
		this.userID = userID;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getFirstname() {
		return firstname;
	}


	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}


	public String getLastname() {
		return lastname;
	}


	public void setLastname(String lastname) {
		this.lastname = lastname;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public User_Rating getRating() {
		return rating;
	}


	public void setRating(User_Rating rating) {
		this.rating = rating;
	}


	public Set<Games> getGames() {
		return games;
	}


	public void setGames(Set<Games> games) {
		this.games = games;
	}



	public PasswordResetToken getPasswordResetToken() {
		return passwordResetToken;
	}


	public void setPasswordResetToken(PasswordResetToken passwordResetToken) {
		this.passwordResetToken = passwordResetToken;
	}


	public Users(long userID, String username, String password, String firstname, String lastname,
			PasswordResetToken passwordResetToken, String email, User_Rating rating, Set<Games> games) {
		super();
		this.userID = userID;
		this.username = username;
		this.password = password;
		this.firstname = firstname;
		this.lastname = lastname;
		this.passwordResetToken = passwordResetToken;
		this.email = email;
		this.rating = rating;
		this.games = games;
	}


	public Users() {
		super();
	}


	
	
	
	
	
	
	
	
	
	
}
