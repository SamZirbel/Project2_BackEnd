package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.UserClass;
import com.revature.services.UserService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/updateuser")

public class UserUpdateController {
	
	private UserService userservice;
	
	@Autowired
	public UserUpdateController(UserService userservice) {
		super ();
		this.userservice = userservice;
	}
	
	@DeleteMapping("/user/{id}")
	public String deleteById(@PathVariable ("id") int id) {
		try {
			userservice.deleteUser(id);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		 return "deleted";
	}
	
	@PutMapping("/user/{id}")
	public UserClass updateUser(@PathVariable ("id") int id, @RequestBody UserClass usr) {
		return userservice.updateUser(id,usr);
	}
	
	@GetMapping("/user")
	public List<UserClass> fetchUser(){
		return userservice.findAll();
		
	}
}
