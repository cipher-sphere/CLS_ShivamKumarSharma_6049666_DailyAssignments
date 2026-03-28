package com.cg.demo.service;


import java.util.List;

import com.cg.demo.entities.Movies;

public interface MovieInterface {
public void addMovie(Movies movie) throws Exception;
public void deleteMovie(String name) throws Exception;
public List<Movies> searchAllMovies() throws Exception;
public List<Movies> searchByGenre(String genre) throws Exception;
public void updateMovie(String name, double rating,String genre) throws Exception;


}
