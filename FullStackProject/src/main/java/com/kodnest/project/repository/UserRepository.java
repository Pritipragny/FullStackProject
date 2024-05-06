package com.kodnest.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

//import com.kodnest.project.entity.Song;
import com.kodnest.project.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

	User findByEmail(String email);

//	void save(Song song);

//	boolean findByEmail(String email);

	

	

	

}