package com.revature.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

import com.revature.models.Movie;
import com.revature.models.Review;
import com.revature.repos.ReviewRepo;

@Service
public class ReviewService {
	
	private ReviewRepo reviewrepo;

	@Autowired
	public ReviewService(ReviewRepo reviewrepo) {

		super();
		this.reviewrepo = reviewrepo;

	}

	public List<Review> findAll() { return reviewrepo.findAll(); }

	public Review findById(int ID) {
		Optional<Review> reviewOpt = reviewrepo.findById(ID);
		Review reviewID = reviewOpt.get();
		return reviewID;

	}

	@Modifying
	@Transactional
	// VV Use Save For Save And Update
	public void addOrUpdateReview(Review review) { reviewrepo.save(review); }

	@Transactional
	public void deleteReview(int ID) {
		Review review = findById(ID);
		reviewrepo.delete(review);
	}

	public List<Review> findByMovie(Movie movie){
		return reviewrepo.findByMovie(movie);
	}

}
