package com.stackroute.movieboot.services;

import java.util.List;
import java.util.Optional;

import com.stackroute.movieboot.domain.Movie;


public interface MovieService {
public Movie saveMovie(Movie movie);
public List<Movie> getallMovie() ;
public boolean deleteMovie(int movieId);
public Movie updateMovie(Movie movie);
//public Movie getMovieByName(String movieTitle);
public List<Movie> getByMovieAlpha(String searchTerm);

}
