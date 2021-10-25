package com.example.demo.Service;

import java.util.List;

import javax.management.AttributeNotFoundException;

import org.springframework.http.ResponseEntity;

import com.example.demo.Entity.MovieList;

public interface Movie_Service {
	MovieList add(MovieList ml);
	List <MovieList> display();
	List <MovieList> DisplayByGenere(String g);
	ResponseEntity <MovieList> updateById(String Id,MovieList ml) throws AttributeNotFoundException;
	void DeleteByName(String name);
	List <MovieList> displayMoviesByRating();

}
