package com.games.start.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.games.start.entities.Games;
import com.games.start.repo.GamesRepo;

@Service
public class GameService {

	@Autowired
	GamesRepo gameRepo;
	
	
	public void saveGame(Games game) {
		gameRepo.save(game);
		
		
		
		
	}
	
	
}
