package com.revature.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

import com.revature.models.UserClass;
import com.revature.repos.UserRepo;

@Service
public class UserService {
	private AES256 ae;
	private UserRepo userrepo;

	@Autowired
	public UserService(UserRepo userrepo, AES256 ae) {

		super();
		this.userrepo = userrepo;
		this.ae = ae;

	}
//need to test this login method
	public UserClass login(String username, String password) {
		return userrepo.verifyLoginInfo(username, ae.encrypt(password));	 
	}

	@Modifying
	@Transactional
	public boolean forgetPasword(String username, String displayname) {
		
		
		// need implementation
		return false;
	}

	public List<UserClass> findByUsername(String username) {

		Optional<List<UserClass>> olist = userrepo.findByUsername(username);

		return (olist.isPresent()) ? olist.get() : new ArrayList<UserClass>();

	}

	public List<UserClass> findAll() {
		return userrepo.findAll();
	}

	public UserClass findById(int ID) {
		Optional<UserClass> userOpt = userrepo.findById(ID);
		UserClass userID = userOpt.get();
		return userID;

	}

	@Modifying
	@Transactional
	// VV Use Save For Save And Update
	public void addOrUpdateUser(UserClass user) {
		user.setPassword(ae.encrypt(user.getPassword()));
		userrepo.save(user);
	}

	@Transactional
	public void deleteUser(int ID) {
		UserClass user = findById(ID);
		userrepo.delete(user);
	}

}
