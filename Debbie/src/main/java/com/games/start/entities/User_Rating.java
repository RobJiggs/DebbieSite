package com.games.start.entities;

import org.hibernate.annotations.LazyGroup;


import com.fasterxml.jackson.annotation.JsonIgnore;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

@Entity
public class User_Rating {
	
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(nullable = false)
	private long user_ratingId;
	
	@Min(value = 1, message = "Rating should not be less than 1")
    @Max(value = 5, message = "Rating should not be greater than 5")
	private int rating;
	
	private String description;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", referencedColumnName = "userID",nullable=true)
 
	@LazyGroup("user")
    @JsonIgnore
    private Users user;
	
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "game_id", referencedColumnName = "gameId",nullable=true)
 
	@LazyGroup("game")
    @JsonIgnore
    private Games game;


	public long getUser_ratingId() {
		return user_ratingId;
	}


	public void setUser_ratingId(long user_ratingId) {
		this.user_ratingId = user_ratingId;
	}


	public int getRating() {
		return rating;
	}


	public void setRating(int rating) {
		this.rating = rating;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public Users getUser() {
		return user;
	}


	public void setUser(Users user) {
		this.user = user;
	}


	public Games getGame() {
		return game;
	}


	public void setGame(Games game) {
		this.game = game;
	}


	public User_Rating(long user_ratingId,
			@Min(value = 1, message = "Rating should not be less than 1") @Max(value = 5, message = "Rating should not be greater than 5") int rating,
			String description, Users user, Games game) {
		super();
		this.user_ratingId = user_ratingId;
		this.rating = rating;
		this.description = description;
		this.user = user;
		this.game = game;
	}


	public User_Rating() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
	

}
