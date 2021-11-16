package com.revature.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.services.MovieService;
import com.revature.services.ReviewService;
import com.revature.models.Movie;
import com.revature.models.Review;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/review")
public class ReviewController {
	

	private ReviewService reviewservice;
	private MovieService movieservice;
	
	@Autowired
	public ReviewController(ReviewService reviewservice, MovieService movieservice) {
		
		super ();
		this.reviewservice = reviewservice;
		this.movieservice = movieservice;
		
	}

	@GetMapping("/reviewsByMovie/{movieid}")
	public ResponseEntity<List<Review>> fetchReviewsByMovie(@PathVariable("movieid") String movieId){
		try {
			Movie movie = movieservice.findByimdbId(movieId).get();
			List<Review> list = reviewservice.findByMovie(movie);
		
			if(list.isEmpty()){
				return ResponseEntity.noContent().build();
			}
			return ResponseEntity.ok(list);
		} catch (NoSuchElementException e){
			e.printStackTrace();
		}
		return ResponseEntity.noContent().build();
	}

	@PostMapping("/addReview")
	public ResponseEntity<List<Review>> addReview(@RequestBody Review review){
		movieservice.addOrUpdateMovie(review.getMovie());
		reviewservice.addOrUpdateReview(review);
		return ResponseEntity.status(HttpStatus.OK).body(reviewservice.findAll());
	}

	@PostMapping("/addReview/{review}")
	public ResponseEntity<List<Review>> addReview(@RequestBody Review review){
		reviewservice.addOrUpdateReview(review);
		return ResponseEntity.status(HttpStatus.OK).body(reviewservice.findAll());
	}

	/* Note For Writing Paths:
	 * @GetMapping
	 * @PostMapping : Addition
	 * @PutMapping : Update
	 * @DeleteMapping
	 * 
	 * All Of These Annotations Can Take A Path As A Parameter Which Will
	 *  Be Useful So That We All Can Specify A Unique Path Based Upon The
	 *  Component We Will Be Using
	 *  
	 *  Example : @GetMapping("/login/{username}")
	 *  	public User getByUsername(@PathVariable("username") String username) {
	 *  
	 *  	return userservice.someDeclaredServiceFunction(username);
	 *  
	 *  }
	 * 
	 */

}
