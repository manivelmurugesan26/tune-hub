package com.tune.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tune.entity.PlayList;

public interface PlayListRepository  extends JpaRepository<PlayList,Integer>{

	
}
