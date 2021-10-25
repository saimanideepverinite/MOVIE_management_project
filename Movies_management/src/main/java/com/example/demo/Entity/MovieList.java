package com.example.demo.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity(name="Restapi")
@Getter
@Setter
public class MovieList {
	@Id
	private String mid;
	private String mname;
	private double rating;
	private String genere;
	

}
