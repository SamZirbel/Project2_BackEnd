package com.revature.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.models.Review;

@Repository
public interface ReviewRepo extends JpaRepository<Review, Integer>{

}
