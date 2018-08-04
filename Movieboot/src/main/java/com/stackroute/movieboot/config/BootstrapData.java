package com.stackroute.movieboot.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;

import com.stackroute.movieboot.domain.Movie;
import com.stackroute.movieboot.repository.MovieRepository;
@Configuration
public class BootstrapData implements ApplicationListener<ContextRefreshedEvent>{

private MovieRepository movierepository;
//private Movie movie;
@Autowired
public BootstrapData(MovieRepository movierepository) {
	super();
	this.movierepository = movierepository;
	
}
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		Movie movie=new Movie();
		// TODO Auto-generated method stub
		movie.setMovieTitle("maven");
		movierepository.save(movie);
		Movie testMovie =Movie.builder().movieTitle("foo").build();
		movierepository.save(testMovie);
		
	}

}
