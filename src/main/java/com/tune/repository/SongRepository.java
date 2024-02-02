package com.tune.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tune.entity.Song;

public interface SongRepository extends JpaRepository<Song, Integer> {
	public Song findByName(String name);

}
