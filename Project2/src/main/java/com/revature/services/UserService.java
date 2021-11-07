package com.revature.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.User;
import com.revature.repos.UserRepo;

@Service
public class UserService {
	
	private UserRepo userrepo;
	
	
	@Autowired
	public UserService(UserRepo userrepo) {
		
		super();
		this.userrepo = userrepo;
		
	}
	
	

	
	public List<User> findByUsername(String username) { 
		
		Optional<List<User>> olist = userrepo.findByUsername(username);
		
		return (olist.isPresent()) ? olist.get() : new ArrayList<User>();
		
	}

	public List<User> findAll() { return userrepo.findAll(); }
	
	public User findById(int ID) { 
		
		Optional<User> userOpt = userrepo.findById(ID);
		
		User userID = userOpt.get();
		
		return userID;
		
	}

	// VV Use Save For Save And Update
	public void addOrUpdateUser(User user) { userrepo.save(user); }
	
	public void deleteUser(int ID) { User user = findById(ID); userrepo.delete(user); }
	

}
