package com.example.Movie.Service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Movie.Dto.movieDto;
import com.example.Movie.Repository.MovieRepository;
import com.example.Movie.Repository.RatingRepository;
import com.example.Movie.entity.Movie;
import com.example.Movie.entity.Rating;
import java.lang.*;

@Service("MovieService")
public class MovieService {
@Autowired
MovieRepository movieRepository;
@Autowired
RatingRepository ratingRepository;
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
public void add_customer(Rating rating) {
	ratingRepository.save(rating);
}
public Optional<Movie> getMovieName(int mid) {
	return movieRepository.findById(mid);
	
}
public void updateRating(String cid,Float rating) {
	
	ratingRepository.updateById(cid, rating);
	}
	
	
	//return ratting;

public Optional<Rating> updateRating1(String cid) {
	return ratingRepository.findById(cid);
}
public Rating highRating() {
	List<Rating> highRate=ratingRepository.findAll();
	Rating highrate=new Rating();
	Float max=(float) 0.0;
	for(Rating rate:highRate) {
		if(max<rate.Ratingcus) {
			max=rate.Ratingcus;
			highrate=rate;
			
		}
	}
	return highrate;
}
public Rating MostRated() {
	List<Rating> mostRate=ratingRepository.findAll();
	//List<Movie> movie=movieRepository.findAll();
	Rating mostrating=new Rating();
	Rating mostRated=new Rating();
	int max=0;
	int flag=0;
	for(Rating rating1:mostRate) {
		for(Rating rating2:mostRate) {
			if(rating1.CID==rating2.CID) {
				flag++;
				mostRated=rating1;
		}
		}
	
		if(max<flag) {
			max=flag;
			mostrating=mostRated;
			}
		flag=0;
		}
	return mostrating;
}


}
