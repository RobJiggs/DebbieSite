package com.games.start.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.games.start.entities.Users;

@Transactional
@Repository
public interface UserRepo extends JpaRepository<Users,Long> {

	Users findByUsername(String username);

	Users findByEmail(String email);
	

}
