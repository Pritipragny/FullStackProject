package com.kodnest.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kodnest.project.entity.Playlist;
@Repository
public interface PlaylistRepository  extends JpaRepository<Playlist, Integer>{

	Playlist findByName(String name);



}
