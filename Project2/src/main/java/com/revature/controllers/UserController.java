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
//@RequestMapping(value = "/public")
public class UserController {
	
	private UserService userservice;
	
	@Autowired
	public UserController(UserService userservice) {
		
		super ();
		this.userservice = userservice;
		
	}
	
	
	@PostMapping("/register")
	public UserClass saveUser(@Valid  @RequestBody UserClass uc) {
		
		return userservice.addOrUpdateUser(uc);
	}
	
	
	@GetMapping("/user/{id}")
	public UserClass fetchById(@PathVariable ("id") int id) {
		return userservice.findById(id);
	}
	
	@GetMapping("/user/{username}")
	public UserClass fetchByUsername(@PathVariable ("username") String username) {
		return userservice.findByUsername(username);
	}
	@GetMapping("/login")
	public UserClass LoginDetail(@RequestBody UserClass logininfo) {
		String username= "umer";
		return userservice.findByUsername(username);
	}
	
	
	
	

}
