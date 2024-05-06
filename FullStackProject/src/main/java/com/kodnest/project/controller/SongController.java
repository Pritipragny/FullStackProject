package com.kodnest.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.kodnest.project.entity.Song;
import com.kodnest.project.service.SongService;

@Controller
public class SongController {
	
	@Autowired
	SongService songService;
	
	@PostMapping("/addsongs")
	public String addSong(@ModelAttribute Song song) {
		String name=song.getName();
		boolean songExists=songService.songExists(name);
		if(songExists==false){
			songService.saveSong(song);
		}
		else {
			System.out.println("Duplicate entry");
		}
//		songService.saveSong(song);
		return "song";
	}
	@GetMapping("/viewsongs")
	public String viewsongs(Model model) {
		boolean paymentstatus=true;
		if(paymentstatus) {
			List<Song> songslist = songService.fetchAllSongs();
			 model.addAttribute( "songs",songslist);
			System.out.println(songslist);
			return "viewsongs";
		}
		else {
			return "paymentform";
		}
		
		 
	}
	
}