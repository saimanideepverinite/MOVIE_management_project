package com.example.demo.Service;

import java.util.List;

import javax.management.AttributeNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.MovieList;
import com.example.demo.Repository.Movie_repo;

@Service
public class Movie_Service_impl implements Movie_Service{
	@Autowired
	Movie_repo repo;

	@Override
	public MovieList add(MovieList ml) {
		return repo.save(ml);
	}

	@Override
	public List<MovieList> display() {
		
		return repo.findAll();
	}

	@Override
	public List<MovieList> DisplayByGenere(String g) {
		
		return repo.getByGenere(g);
	}


	@Override
	public void DeleteByName(String name) {
		repo.Delete(name);
		
	}

	@Override
	public List<MovieList> displayMoviesByRating() {
		return repo.findAll(Sort.by("rating").ascending());
	}

	@Override
	public ResponseEntity<MovieList> updateById(String Id, MovieList ml) throws AttributeNotFoundException {
		MovieList m=(MovieList) repo.findById(Id).orElseThrow();
		m.setGenere(ml.getGenere());
		m.setMname(ml.getMname());
		m.setRating(ml.getRating());
		final MovieList k=repo.save(m);
		return ResponseEntity.ok(k);
		}

}
