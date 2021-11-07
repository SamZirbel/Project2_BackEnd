package com.revature.services;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.revature.models.User;
import com.revature.repos.UserRepo;
@SpringBootTest
class UserServiceTest {
	

	@Autowired
	private UserRepo userRepo;

	@Test
	void testFindByUsername() {

		Optional<List<User>> olist = userRepo.findByUsername("Sample");
		assertTrue(!(olist.isEmpty()));
		
	}

	@Test
	void testFindAll() {
	List<User> olist = userRepo.findAll();
		System.out.println(olist);
		
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
