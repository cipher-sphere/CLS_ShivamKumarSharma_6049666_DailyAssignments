package com.cg.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.demo.entities.Movies;

public interface IMovie extends JpaRepository<Movies, Integer> {

	

	List<Movies> findByGenre(String genre);

	Movies findByName(String name);

}
