package com.games.start.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.games.start.entities.Games;
import com.games.start.service.GameService;

import org.springframework.beans.factory.annotation.Autowired;

@RestController
@CrossOrigin
@RequestMapping("/api/games")
public class GameController {
	@Autowired
	GameService gameService;
	
	@PostMapping("/new")
	public Games newGames(@RequestBody Games games) {
		
		return games;
		
		
		
		
		
	}
	
	
	
	
	

}
