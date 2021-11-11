package com.revature.controllers;

import java.security.Principal;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.UserClass;
import com.revature.services.UserService;
import com.revature.services.util.JwtUtil;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
//@RequestMapping(value = "/public")
public class UserController {

	// creating objects
	private UserService userservice;
	@Autowired
	private JwtUtil jwtUtil;
	@Autowired

	private AuthenticationProvider pm;

	// Constructor
	@Autowired
	public UserController(UserService userservice) {
		super();
		this.userservice = userservice;
	}

	// Rest Controller methods.......................

	@PostMapping("/register")
	public UserClass saveUser(@Valid @RequestBody UserClass uc) {
		return userservice.addUser(uc);
	}

	@GetMapping("/user/{username}")
	public UserClass fetchByUsername(@PathVariable("username") String username) {
		return userservice.findByUsername(username);
	}

	@RequestMapping("/userlogin")
	public Principal user(Principal user) {
		System.out.println(user.getName());
		System.out.println("......................................");
		return user;
	}

	@PutMapping("/passupdate")
	public UserClass updatePass(@RequestBody UserClass usr) {
		return userservice.updatePass(usr);
	}

	@PostMapping("/loginauth")
	public String generateToken(@RequestBody UserClass authRequest) throws Exception {
		try {
			UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(
					authRequest.getUsername(), authRequest.getPassword());

			pm.authenticate(token);

		} catch (Exception ex) {
			throw new Exception("inavalid username/password");
		}
		return jwtUtil.generateToken(authRequest.getUsername());
	}

}
