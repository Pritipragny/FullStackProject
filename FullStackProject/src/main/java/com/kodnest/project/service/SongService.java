package com.kodnest.project.service;

import java.util.List;

import com.kodnest.project.entity.Song;

public interface SongService {

	void saveSong(Song song);
	boolean songExists(String name);
	List<Song> fetchAllSongs();


}