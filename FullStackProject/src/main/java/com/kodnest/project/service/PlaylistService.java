package com.kodnest.project.service;

import java.util.List;

import com.kodnest.project.entity.Playlist;

public interface PlaylistService {

	void addPlaylist(Playlist playlist);

	void playlistExists(Playlist playlist);

	List<Playlist> fetchAllPlaylist();

	


}
