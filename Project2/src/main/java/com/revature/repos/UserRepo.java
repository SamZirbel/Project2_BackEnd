package com.revature.repos;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.models.UserClass;

@Repository
public interface UserRepo extends JpaRepository<UserClass, Integer> {  
	
	public Optional<List<UserClass>> findByUsername(String username);
	
}
