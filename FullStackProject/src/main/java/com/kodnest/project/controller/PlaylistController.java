package com.kodnest.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.kodnest.project.entity.Playlist;
import com.kodnest.project.entity.Song;
import com.kodnest.project.service.PlaylistService;
import com.kodnest.project.service.SongService;


@Controller
public class PlaylistController {
 @Autowired
  PlaylistService playlistService;
 @Autowired
 SongService songService;
 
  @GetMapping("/createplaylists")
  public String createPlaylist(Model model) {
	  List<Song> songList=songService.fetchAllSongs();
	  model.addAttribute( "songs",songList);
	  return "createplaylist";
	  
  }
  @PostMapping("/addplaylist")
  public String addPlayList(@ModelAttribute Playlist playlist) {
	  System.out.println(playlist);
	  playlistService.addPlaylist(playlist);
	return "createplaylist";
	  
  }
  @GetMapping("/playlist")
  public String viewPlaylist(Model model) {
      List<Playlist> fetchAllPlaylist = playlistService.fetchAllPlaylist();
       model.addAttribute("playlists",fetchAllPlaylist);
       return "viewplaylist";
  }

  
}
