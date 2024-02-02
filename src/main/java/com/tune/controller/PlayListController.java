package com.tune.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.tune.entity.PlayList;
import com.tune.entity.Song;
import com.tune.service.PlayListService;
import com.tune.service.SongService;

@Controller
public class PlayListController {

	@Autowired
	SongService songservice;
	
	@Autowired
	PlayListService playlistService;
	
	@GetMapping("/createPlayList")
	public String createPlayList(Model model) {
		
		List<Song> songList = songservice.fetchAllSongs();
		model.addAttribute("songs", songList);
		
		return "createPlayList";
	}
	
	@PostMapping("/addPlayList")
	public String addPlayList(@ModelAttribute PlayList playlist) {
		
		playlistService.addPlayList(playlist);
		
		List<Song> songList = playlist.getSongs();
		for(Song s: songList) {
			s.getPlaylists().add(playlist);
			songservice.updateSong(s);
		}
		return "admin";
	}
	
	@GetMapping("/viewPlayList")
	public String viewPlayLists(Model model) {
		List<PlayList>allPlaylists=playlistService.fetchAllPlayLists();
		model.addAttribute("allPlaylists", allPlaylists);

     	return "displayPlayLists";
	
	}
}

