package com.games.start.entities;

import java.sql.Date;
import java.util.HashSet;
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
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Games {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(nullable = false)
	private long gameId;
	
	private String game_name;
	private String game_series;
	private Date intial_release;
	private double avgrating;
	
	
	
	@ManyToMany(mappedBy="games")
	private Set<Genres> genres;
	
	@ManyToMany(mappedBy="games")
	private Set<Platform> platforms;
	
	
	
	
	@OneToOne(mappedBy = "game")
	@LazyGroup("rating")
	@JsonIgnore
	@Fetch(FetchMode.JOIN)
	private User_Rating rating;
	
	
	@ManyToMany
    @JoinTable(name = "user_games",
               joinColumns = @JoinColumn(name = "game_id"),
               inverseJoinColumns = @JoinColumn(name = "user_id"))

	private Set<Users> users = new HashSet<>();


	public long getGameId() {
		return gameId;
	}


	public void setGameId(long gameId) {
		this.gameId = gameId;
	}


	public String getGame_name() {
		return game_name;
	}


	public void setGame_name(String game_name) {
		this.game_name = game_name;
	}


	public String getGame_series() {
		return game_series;
	}


	public void setGame_series(String game_series) {
		this.game_series = game_series;
	}


	public Date getIntial_release() {
		return intial_release;
	}


	public void setIntial_release(Date intial_release) {
		this.intial_release = intial_release;
	}


	public double getAvgrating() {
		return avgrating;
	}


	public void setAvgrating(double avgrating) {
		this.avgrating = avgrating;
	}


	public Set<Genres> getGenres() {
		return genres;
	}


	public void setGenres(Set<Genres> genres) {
		this.genres = genres;
	}


	public Set<Platform> getPlatforms() {
		return platforms;
	}


	public void setPlatforms(Set<Platform> platforms) {
		this.platforms = platforms;
	}


	public User_Rating getRating() {
		return rating;
	}


	public void setRating(User_Rating rating) {
		this.rating = rating;
	}


	public Set<Users> getUsers() {
		return users;
	}


	public void setUsers(Set<Users> users) {
		this.users = users;
	}


	public Games(long gameId, String game_name, String game_series, Date intial_release, double avgrating,
			Set<Genres> genres, Set<Platform> platforms, User_Rating rating, Set<Users> users) {
		super();
		this.gameId = gameId;
		this.game_name = game_name;
		this.game_series = game_series;
		this.intial_release = intial_release;
		this.avgrating = avgrating;
		this.genres = genres;
		this.platforms = platforms;
		this.rating = rating;
		this.users = users;
	}


	public Games() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
	
	
	
	

}
