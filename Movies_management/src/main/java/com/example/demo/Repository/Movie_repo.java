package com.example.demo.Repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.MovieList;

@Repository
public interface Movie_repo extends JpaRepository<MovieList, String> {

	@Query(value="select * from Restapi where genere=?1",nativeQuery=true)
	List<MovieList> getByGenere(String g);
	@Transactional
	@Modifying
	@Query(value="delete from Restapi where mname like %?1",nativeQuery=true)
	void Delete(String name);

}
