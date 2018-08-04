package com.stackroute.movieboot.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.movieboot.domain.Movie;
import com.stackroute.movieboot.services.MovieService;


@RestController
@RequestMapping("/api/v1/movieboot")
@ControllerAdvice
public class MovieController {
private MovieService movieservice;
	
	@Autowired
	public MovieController(MovieService movieservice) {
		super();
		this.movieservice = movieservice;
	}
	@RequestMapping(value = "/movie", method = RequestMethod.POST, produces = { "application/json" })
	public ResponseEntity<?> saveMovie(@RequestBody Movie movie) {
		Movie savedmovie=movieservice.saveMovie(movie);
		return new ResponseEntity<Movie>(savedmovie, HttpStatus.CREATED);
		
		
	}
	@RequestMapping(value = "/movies", method = RequestMethod.GET,produces = { "application/json" })
public ResponseEntity<?>  getallMovie() {
		List<Movie> movies=movieservice.getallMovie();
		return new ResponseEntity<List<Movie>>(movies, HttpStatus.OK);
	
	}
	@RequestMapping(value = "/movie/{movieId}", method = RequestMethod.DELETE, produces = { "application/json" })
	public ResponseEntity<?> deleteMovie(@PathVariable int movieId) {
		if(movieservice.deleteMovie(movieId)) {
				return new ResponseEntity<String>("{ \"message\": \"" + "Success" + "\"}", HttpStatus.OK);
			} else {
				return new ResponseEntity<String>("{ \"message\": \"" + "failure" + "\"}", HttpStatus.CONFLICT);
			}
	}

	
	@RequestMapping(value = "/movie", method = RequestMethod.PUT, produces = { "application/json" })
	public ResponseEntity<?> updateMovie(@PathVariable Movie movie) {
		Movie updatedmovie=movieservice.updateMovie(movie);
		return new ResponseEntity<Movie>(updatedmovie, HttpStatus.CREATED);	
			}
	
	@RequestMapping(value = "/movie/{searchTerm}", method = RequestMethod.GET,produces = { "application/json" })
	public ResponseEntity<?>  getByMovieAlpha(@PathVariable String movieTitle) {
			List<Movie> movies=movieservice.getByMovieAlpha(movieTitle);
			return new ResponseEntity<List<Movie>>(movies, HttpStatus.OK);
		
		}
//	@RequestMapping(value="/movie", method = RequestMethod.GET,produces = { "application/json" })
//	public String getmovieById(@RequestBody Movie movie,@PathVariable int movieId){
//		String msg=null;
//		try {
//			movieservice.getMovieById(movieId);
//				//return new ResponseEntity<Movie>(HttpStatus.OK);
//			}
//			
//		catch(Exception e) {
//			  msg=  e.getMessage();
//		}
//		return msg;
//		}
//	
	
	
}
	
	
	

