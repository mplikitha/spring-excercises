package com.stackroute.movieboot.services;

import java.util.List;

import com.stackroute.movieboot.domain.Movie;

public class MovieServicedummyImpl implements MovieService{

	@Override
	public Movie saveMovie(Movie movie) {
		System.out.println("save movie");
		return null;
	}

	@Override
	public List<Movie> getallMovie() {
		System.out.println("get all movie");
		return null;
	}

	@Override
	public boolean deleteMovie(int movieId) {
		System.out.println("delete movie");
		return true;
	}

	@Override
	public Movie updateMovie(Movie movie) {
		System.out.println("update movie");
		return null;
	}

	@Override
	public List<Movie> getByMovieAlpha(String searchTerm) {
		System.out.println("get movie by name");
		return null;
	}

}
