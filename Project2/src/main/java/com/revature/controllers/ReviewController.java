package com.revature.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.services.ReviewService;
import com.revature.models.Movie;
import com.revature.models.Review;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/review")
public class ReviewController {
	

	private ReviewService reviewservice;
	
	@Autowired
	public ReviewController(ReviewService reviewservice) {
		
		super ();
		this.reviewservice = reviewservice;
		
	}

	@GetMapping("/reviewsByMovie/{movie}")
	public ResponseEntity<List<Review>> fetchReviewsByMovie(@PathVariable("movie") Movie movie){
		List<Review> list = reviewservice.findByMovie(movie);
		
		if(list.isEmpty()){
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(list);
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
