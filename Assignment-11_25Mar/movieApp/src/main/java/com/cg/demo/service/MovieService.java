package com.cg.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.demo.entities.Movies;
import com.cg.demo.repo.IMovie;

@Service
public class MovieService implements MovieInterface {

	@Autowired
	IMovie movieRepo;

	@Override
	public void addMovie(Movies movie) throws Exception {
		movieRepo.save(movie);
		System.out.println("Movie added successfully");

	}

	@Override
	public void deleteMovie(String name) throws Exception {
		Movies movie = movieRepo.findByName(name);

		if (movie == null) {
			throw new Exception("Movie not found");
		}

		movieRepo.delete(movie);
		System.out.println("Movie deleted successfully");

	}

	@Override
	public List<Movies> searchAllMovies() throws Exception {
		List<Movies> list = movieRepo.findAll();
		return list;
	}

	@Override
	public List<Movies> searchByGenre(String genre) throws Exception {
		return movieRepo.findByGenre(genre);
	}

	@Override
	public void updateMovie(String name, double rating, String genre) throws Exception {

		Movies movie = movieRepo.findByName(name);

		if (movie == null) {
			throw new Exception("Movie not found");
		}

		movie.setRating(rating);
		movie.setGenre(genre);

		movieRepo.save(movie);

		System.out.println("Movie updated successfully");
	}

}
