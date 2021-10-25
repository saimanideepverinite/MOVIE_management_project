package com.example.demo.controller;

import java.util.List;

import javax.management.AttributeNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.MovieList;
import com.example.demo.Service.Movie_Service;

@RestController
public class Movie_controller {
	@Autowired
	Movie_Service ser;
	Movie_controller(Movie_Service ser)
	{
		this.ser=ser;
	}
	@PostMapping("moviesList")
	MovieList insert(@RequestBody MovieList ml)
	{
		return  ser.add(ml);
	}
	@GetMapping("moviesList")
	List<MovieList> Display()
	{
		return ser.display();
		
	}
	@GetMapping("moviesList/genere/{genere}")
	List<MovieList> displayByGenere(@PathVariable String genere)
	{
		return ser.DisplayByGenere(genere);
	}
	@PutMapping("moviesList/{mid}")
	ResponseEntity <MovieList> updateById(@PathVariable String mid,@RequestBody MovieList ml) throws AttributeNotFoundException
	{
		return ser.updateById(mid,ml);
	}
	@DeleteMapping("moviesList/{mname}")
	void delete(@PathVariable String mname)
	{
		ser.DeleteByName(mname);
	}
	@GetMapping("moviesList/rating")
	 List<MovieList> displayMoviesByRating()
	 {
		return ser.displayMoviesByRating();
	 }
}
