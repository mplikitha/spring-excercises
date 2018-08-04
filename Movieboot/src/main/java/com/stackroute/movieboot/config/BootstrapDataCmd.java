package com.stackroute.movieboot.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import com.stackroute.movieboot.domain.Movie;
import com.stackroute.movieboot.repository.MovieRepository;
@Component
public class BootstrapDataCmd implements CommandLineRunner  {
	
	private MovieRepository movierepository;
	@Autowired
	public BootstrapDataCmd(MovieRepository movierepository) {
		super();
		this.movierepository = movierepository;
	}
	
	@Override
	public void run(String... args) throws Exception {
		Movie movie=new Movie();
		// TODO Auto-generated method stub
		movie.setMovieTitle("appu");
		movierepository.save(movie);
		Movie testMovie =Movie.builder().movieTitle("foo").build();
		movierepository.save(testMovie);
		
	}

}
