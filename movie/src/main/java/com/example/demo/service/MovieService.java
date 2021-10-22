package com.example.demo.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.entity.MovieEntity;

public interface MovieService {
	public MovieEntity insertMovie(MovieEntity m);
	public MovieEntity getMovieById(long Id);
	List<MovieEntity> getMovieEntity();
	public List<MovieEntity> getMovieByAuthor(String author);
	public ResponseEntity<MovieEntity> recordUpdate(long id,MovieEntity movie) throws ResourceNotFoundException;
	public void DeleteById(long Id);
	public void DeleteByBookName(String BookName);
	


}
