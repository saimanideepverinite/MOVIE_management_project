package com.example.demo.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;
@Entity(name="movie")
@Getter
@Setter
public class MovieEntity implements Serializable {
	
	
	@Id	
	private long eid;
	private String author;
	private String bookname;
	private double price;
		

}








