package com.revature.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.UserClass;
import com.revature.services.UserService;


@RestController
//@RequestMapping(value = "/user")
public class UserController {
	
	private UserService userservice;
	
	@Autowired
	public UserController(UserService userservice) {
		
		super ();
		this.userservice = userservice;
		
	}
	
	
	@PostMapping("/signup")
	public UserClass saveUser(@Valid  @RequestBody UserClass uc) {
		
		return userservice.addOrUpdateUser(uc);
	}
	
	@GetMapping("/user")
	public List<UserClass> fetchUser(){
		return userservice.findAll();
		
	}
	@GetMapping("/user/{id}")
	public UserClass fetchById(@PathVariable ("id") int id) {
		return userservice.findById(id);
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
	public UserClass UpdateUser(@PathVariable ("id") int id, @RequestBody UserClass usr) {
		return userservice.updateUser(id,usr);
	}
	
	

}
