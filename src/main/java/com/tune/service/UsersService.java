package com.tune.service;

import com.tune.entity.Users;

public interface UsersService {


	public String addUser(Users user);
	public boolean emailExists(String email);
	public boolean validationUser(String email, String password);
	public String getRole(String email);
	public Users getUser(String email);
	public void updateUser(Users user);
}
