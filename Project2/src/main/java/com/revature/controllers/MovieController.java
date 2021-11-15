package com.revature.controllers;

import org.springframework.beans.factory.annotation.Autowired;
//<<<<<<< Updated upstream
//import org.springframework.web.bind.annotation.CrossOrigin;
//=======
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
//>>>>>>> Stashed changes
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.Movie;
import com.revature.services.MovieService;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/movie")
//@CrossOrigin(origins = "http://localhost:4200")
public class MovieController {

	private MovieService movieservice;
	
	@Autowired
	public MovieController(MovieService movieservice) {
		
		super ();
		this.movieservice = movieservice;
		
	}
	
	@PostMapping
	public ResponseEntity<String> addMovie(@RequestBody Movie movie) {
		
		System.err.println("Movie Post Request Captured");
		
		System.err.println(movie);
		
		movieservice.addOrUpdateMovie(movie);
		
		//trainerservice.addTrainer(trainer);
		 return ResponseEntity.status(200).body("Kalibunga Dudes!!");
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
