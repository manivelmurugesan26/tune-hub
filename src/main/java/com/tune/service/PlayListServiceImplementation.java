package com.tune.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tune.entity.PlayList;
import com.tune.repository.PlayListRepository;

@Service
public class PlayListServiceImplementation implements PlayListService {

	@Autowired
	PlayListRepository repo;
	@Override
	public void addPlayList(PlayList playlist) {

		repo.save(playlist);
		
		
	}
	@Override
	public List<PlayList> fetchAllPlayLists() {

		return repo.findAll();
		
	}

}
