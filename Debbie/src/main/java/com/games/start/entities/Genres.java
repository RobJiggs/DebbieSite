package com.games.start.entities;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity
public class Genres {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(nullable = false)
	private long genreId;
	
	private String genre_name;
	
	
	@ManyToMany
    @JoinTable(name = "games_genres",
               joinColumns = @JoinColumn(name = "genre_id"),
               inverseJoinColumns = @JoinColumn(name = "games_id"))
	private Set<Games> games;


	public long getGenreId() {
		return genreId;
	}


	public void setGenreId(long genreId) {
		this.genreId = genreId;
	}


	public String getGenre_name() {
		return genre_name;
	}


	public void setGenre_name(String genre_name) {
		this.genre_name = genre_name;
	}


	public Set<Games> getGames() {
		return games;
	}


	public void setGames(Set<Games> games) {
		this.games = games;
	}


	public Genres(long genreId, String genre_name, Set<Games> games) {
		super();
		this.genreId = genreId;
		this.genre_name = genre_name;
		this.games = games;
	}


	public Genres() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
	
	

}
