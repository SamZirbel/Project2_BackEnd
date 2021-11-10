package com.revature.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
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
@CrossOrigin(origins = "http://localhost:4200")
//@RequestMapping(value = "/public")
public class UserController {

	private UserService userservice;
	
	//Constructor 
	@Autowired
	
	public UserController(UserService userservice) {
		super();
		this.userservice = userservice;
	}

	@PostMapping("/register")
	public UserClass saveUser(@Valid @RequestBody UserClass uc) {
		return userservice.addUser(uc);
	}


	@GetMapping("/user/{username}")
	public UserClass fetchByUsername(@PathVariable("username") String username) {
		return userservice.findByUsername(username);
	}

	@GetMapping("/login")
	public UserClass loginDetail(@RequestBody UserClass logininfo) {
		String username = "umer";
		return userservice.findByUsername(username);
	}

}
