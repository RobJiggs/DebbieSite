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
public class Platform {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(nullable = false)
	private long platform_id;
	
	private String platform_name;
	@ManyToMany
    @JoinTable(name = "game_platforms",
               joinColumns = @JoinColumn(name = "platform_id"),
               inverseJoinColumns = @JoinColumn(name = "games_id"))
	private Set<Games> games;
	public long getPlatform_id() {
		return platform_id;
	}
	public void setPlatform_id(long platform_id) {
		this.platform_id = platform_id;
	}
	public String getPlatform_name() {
		return platform_name;
	}
	public void setPlatform_name(String platform_name) {
		this.platform_name = platform_name;
	}
	public Set<Games> getGames() {
		return games;
	}
	public void setGames(Set<Games> games) {
		this.games = games;
	}
	public Platform() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Platform(long platform_id, String platform_name, Set<Games> games) {
		super();
		this.platform_id = platform_id;
		this.platform_name = platform_name;
		this.games = games;
	}
	
	
	
	
}
