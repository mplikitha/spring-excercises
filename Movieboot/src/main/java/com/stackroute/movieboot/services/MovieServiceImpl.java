package com.stackroute.movieboot.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.stackroute.movieboot.domain.Movie;
import com.stackroute.movieboot.repository.MovieRepository;
@Service
public class MovieServiceImpl implements MovieService{

	private MovieRepository movieRepository;
	
	@Autowired
	public MovieServiceImpl(MovieRepository movieRepository) {
		//super();
		this.movieRepository = movieRepository;
	}

	@Override
	public Movie saveMovie(Movie movie) {
		Movie savedMovie=movieRepository.save(movie);
		return savedMovie;
	}

	@Override
	public List<Movie> getallMovie() {
	List<Movie>	list=(List<Movie>) movieRepository.findAll();
	return list;
	}
	@Override
	public boolean deleteMovie(int movieId) {
		movieRepository.deleteById(movieId);
		return true;
		
	}
//	@Override
//	public Movie getMovieByName(String movieTitle) {
//		Movie movietitle=movieRepository.getByMovieTitle(movieTitle);
//		return movietitle;
//	}
	@Override
		public Movie updateMovie(Movie movie) {
			
			Movie updatedmovie= movieRepository.save(movie);
			
		return updatedmovie;
	}
	//@Query("SELECT movie FROM Movie movie WHERE movie.movieTitle LIKE CONCAT(:searchTerm,'%')")
	public List<Movie> getByMovieAlpha(String searchTerm){
		
		List<Movie>movie=movieRepository.getByMovieAlpha(searchTerm);
		return movie;
		
	}
	
	}
		



