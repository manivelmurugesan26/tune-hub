package com.tune.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.tune.entity.Users;
import com.tune.service.UsersService;

import jakarta.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class UserController {
	
	@Autowired
	UsersService service;
	
	@PostMapping("/register")
	public String addusers(@ModelAttribute Users user){
		
		boolean userStatus = service.emailExists(user.getEmail());
		if(userStatus == false) {
		service.addUser(user);
		System.out.println("user added ");
		}
		else {
			System.out.println("user already exists..");
		}
		return "home";
	}
	
	@PostMapping("/validation")
	public String validation(@RequestParam("email") String email,@RequestParam("password") String password,HttpSession session) {
		
		if(service.validationUser(email,password)==true) {
			String role = service.getRole(email);
			session.setAttribute(email, email);
			if(role.equals("admin")) {
				return "admin";
			}
			else {
				return "customer";
			}
		}
		else {
			return "login";
		}
	}
	
}
