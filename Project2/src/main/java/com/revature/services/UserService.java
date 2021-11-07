package com.revature.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.UserClass;
import com.revature.repos.UserRepo;

@Service
public class UserService {
	
	private UserRepo userrepo;
	
	
	@Autowired
	public UserService(UserRepo userrepo) {
		
		super();
		this.userrepo = userrepo;
		
	}
	
	

	
	public List<UserClass> findByUsername(String username) { 
		
		Optional<List<UserClass>> olist = userrepo.findByUsername(username);
		
		return (olist.isPresent()) ? olist.get() : new ArrayList<UserClass>();
		
	}

	public List<UserClass> findAll() { return userrepo.findAll(); }
	
	public UserClass findById(int ID) { 
		
		Optional<UserClass> userOpt = userrepo.findById(ID);
		
		UserClass userID = userOpt.get();
		
		return userID;
		
	}

	// VV Use Save For Save And Update
	public void addOrUpdateUser(UserClass user) { userrepo.save(user); }
	
	public void deleteUser(int ID) { UserClass user = findById(ID); userrepo.delete(user); }
	

}
