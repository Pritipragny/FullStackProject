package com.kodnest.project.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodnest.project.entity.Song;
import com.kodnest.project.repository.SongRepository;
import com.kodnest.project.service.SongService;

@Service
public class SongServiceimpl implements SongService{

	@Autowired
	SongRepository songRepository;

	@Override
	public void saveSong(Song song) {
		songRepository.save(song);
	}

	@Override
	public boolean songExists(String name) {
		 Song song=songRepository.findByName(name);
		 if(song!=null) {
			 return true;
		 }
		 
		 else {
			 return false;
		 }
		
	}

	@Override
	public List<Song> fetchAllSongs() {
		 List<Song> songs = songRepository.findAll();
		return songs;
	}
	
}