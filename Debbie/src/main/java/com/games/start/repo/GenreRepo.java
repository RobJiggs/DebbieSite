package com.games.start.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.games.start.entities.Genres;

@Transactional
@Repository
public interface GenreRepo extends JpaRepository<Genres,Long>{

}
