package com.games.start.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.games.start.entities.User_Rating;

@Transactional
@Repository
public interface RatingRepo extends JpaRepository<User_Rating,Long> {

}
