package com.example.Movie.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Movie.entity.Movie;
//import com.infosys.infytel.calldetails.entity.CallDetails;

 @Repository 
 public interface MovieRepository extends  JpaRepository<Movie, Integer>
 { 
	 List<Movie> findAll();
	List<Movie> findByMID(int mid);
 }
 