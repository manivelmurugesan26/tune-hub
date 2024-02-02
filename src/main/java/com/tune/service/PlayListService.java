package com.tune.service;

import java.util.List;

import com.tune.entity.PlayList;

public interface PlayListService {

	public void addPlayList(PlayList playlist);

	public List<PlayList> fetchAllPlayLists();

}
