package com.games.start.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.games.start.entities.Games;

@Transactional
@Repository
public interface GamesRepo extends JpaRepository<Games,Long> {

}
