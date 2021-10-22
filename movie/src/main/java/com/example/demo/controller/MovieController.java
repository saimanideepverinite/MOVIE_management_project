package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.MovieEntity;
import com.example.demo.service.MovieService;
import com.example.demo.service.ResourceNotFoundException;

@RestController
public class MovieController  {
	MovieService MS;
	@Autowired
	public MovieController(MovieService MS)
	{
		this.MS=MS;
	}
	@PostMapping("/movie")
	MovieEntity insertMovie(@RequestBody MovieEntity m)
	{
		return MS.insertMovie(m);
	}
	
	@GetMapping("/movie")
	List<MovieEntity> getMovieEntity()
	{
		return MS.getMovieEntity();
	}
	@GetMapping("/movie/{Id}")
	MovieEntity getMovieById(@PathVariable long Id) {
		return MS.getMovieById(Id);
		}
	@PutMapping("movie/{id}")
	public ResponseEntity<MovieEntity> recordUpdate(@PathVariable long id,@RequestBody MovieEntity e) throws ResourceNotFoundException 
	{
		return MS.recordUpdate(id, e);
	}
	@GetMapping("/movie/author/{author}")
	List <MovieEntity> getMovieByAuthor(@PathVariable String author) {
		return MS.getMovieByAuthor(author);
		}
	@DeleteMapping("/movie/{id}")
	void DeleteById(@PathVariable long id) {
		MS.DeleteById(id);
		
	}
	@DeleteMapping("/movie/bookname/{bookname}")
	void DeleteByBookName(@PathVariable  String bookname) {
		MS.DeleteByBookName(bookname);
		
	}
	
	

}