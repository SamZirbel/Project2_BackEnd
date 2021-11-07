package com.revature.services;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.revature.models.User;
import com.revature.repos.UserRepo;

class UserServiceTest {
	
	@Autowired
	public UserRepo userrepo;
	

	@Test
	void testFindByUsername() {

		Optional<List<User>> olist = userrepo.findByUsername("Sample");
		
		assertTrue(olist.isPresent());
		
	}

	@Test
	void testFindAll() {
		//fail("Not yet implemented");
	}

	@Test
	void testFindById() {
		//fail("Not yet implemented");
	}

	@Test
	void testAddOrUpdateUser() {

		
	
	}

	@Test
	void testDeleteUser() {
		//fail("Not yet implemented");
	}

}
