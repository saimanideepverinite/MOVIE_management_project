package com.example.demo.repository;

import java.util.List;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.MovieEntity;
@Repository
public interface MovieRepository extends JpaRepositoryImplementation<MovieEntity,Number>{

	@Query(value="select * from movie where author=?1",nativeQuery=true)
	List<MovieEntity> findByAuthor(String author);
	@Transactional
	@Modifying
	@Query(value="DELETE FROM public.movie m WHERE  m.bookname LIKE %?1",nativeQuery=true)
	void deleteByBookName(@Param("name")String bookname);

}
