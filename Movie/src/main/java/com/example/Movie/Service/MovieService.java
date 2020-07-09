package com.example.Movie.Service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Movie.Dto.movieDto;
import com.example.Movie.Repository.MovieRepository;
import com.example.Movie.entity.Movie;

@Service("MovieService")
public class MovieService {
@Autowired
MovieRepository movieRepository;
Logger logger = LoggerFactory.getLogger(this.getClass());

public List<Movie> getallDetails(){
	List<Movie> movie=movieRepository.findAll();
	return movie;
	
}
public void add_inDB(Movie movie) {
	movieRepository.save(movie);
}
public String serv() {
	// TODO Auto-generated method stub
	return "uy";
}

}
