package com.example.demo.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.entity.MovieEntity;
import com.example.demo.repository.MovieRepository;
@Service
public class MovieImp implements MovieService{
	private final MovieRepository MovieRepo;
	MovieImp(MovieRepository MovieRepo)
	{
		this.MovieRepo=MovieRepo;
	}

	@Override
	public MovieEntity insertMovie(MovieEntity m) {
		// TODO Auto-generated method stub
		return MovieRepo.save(m);
	}

	@Override
	public MovieEntity getMovieById(long Id) {
		// TODO Auto-generated method stub
		return MovieRepo.findById(Id).get();
	}

	@Override
	public List<MovieEntity> getMovieEntity() {
		// TODO Auto-generated method stub
		return MovieRepo.findAll();
	}

	@Override
	public ResponseEntity<MovieEntity> recordUpdate(long id, MovieEntity movie) throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		MovieEntity n=(MovieEntity) MovieRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Employ not found "+id ));
		n.setAuthor(movie.getAuthor());
		n.setBookname(movie.getBookname());
		n.setPrice(movie.getPrice());
		
		final MovieEntity up= MovieRepo.save(n);
		return ResponseEntity.ok(up);
	}

	@Override
	public List<MovieEntity> getMovieByAuthor(String author) {
		return MovieRepo.findByAuthor(author);
	}

	@Override
	public void DeleteById(long Id) {
		// TODO Auto-generated method stub
		MovieRepo.deleteById(Id);
		
	}

	@Override
	public void DeleteByBookName(String BookName) {
		// TODO Auto-generated method stub
		MovieRepo.deleteByBookName(BookName);
		
	}

	

	

	

	

	

}
