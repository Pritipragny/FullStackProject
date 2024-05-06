package com.kodnest.project.serviceimpl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.kodnest.project.entity.Playlist;
import com.kodnest.project.repository.PlaylistRepository;
import com.kodnest.project.service.PlaylistService;
@Service
public class PlaylistServiceimpl implements PlaylistService {
	@Autowired
	PlaylistRepository playlistRepository;
	
	@Override
	public void addPlaylist(Playlist playlist) {
		playlistRepository.save(playlist);
		
	}

	@Override
	public void playlistExists(Playlist playlist) {
					Playlist exixtingplaylist=playlistRepository.findByName(playlist.getName());
			if(exixtingplaylist==null) {
				
				playlistRepository.save(playlist);
			}
			else {
				System.out.println("playlist already exist");;
			}
		
	}

	@Override
	public List<Playlist> fetchAllPlaylist() {
		List<Playlist> allplaylist = playlistRepository.findAll();
	     return allplaylist;
			}

	
	}

	
