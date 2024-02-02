package com.tune.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.tune.entity.Song;
import com.tune.service.SongService;

@Controller
public class SongConroller {
	
	@Autowired
	SongService service;
	
	@PostMapping("/addSong")
	public String addSong(@ModelAttribute Song song) {
		boolean songsStatus = service.songExists(song.getName());
		if(songsStatus==false) {
			

			service.addSong(song);
			System.out.println("song added succesfully");
		}
		else {
			System.out.println("song already exists");
		}

		
		return "admin";
		
	}
	
	@GetMapping("/viewSongs")
	public String viewSongs(Model model) {
		
		List<Song>songsList =service.fetchAllSongs();
		System.out.println(songsList);
		model.addAttribute("songs", songsList);
		return "displaysong";
	}
	
	
	@GetMapping("/playSongs")

	public String playSongs(Model model) {
		boolean premiumUser=true;
		if(premiumUser==true) {
			List<Song>songsList =service.fetchAllSongs();
			model.addAttribute("songs", songsList);
			return "displaysong";
			
		}
		else {
			return "makePayment";
		}
	}


}
