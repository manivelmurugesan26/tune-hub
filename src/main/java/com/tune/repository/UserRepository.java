package com.tune.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tune.entity.Users;

public interface UserRepository  extends JpaRepository<Users, Integer>{

	
	public Users findByEmail(String email);
	
}
