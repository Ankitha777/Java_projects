package com.example.Movie.Dto;

import javax.persistence.Column;

import com.example.Movie.entity.Movie;

public class movieDto {
	public  int MID;
	public String movieName;
	public movieDto(int MID, String movieName) {
		super();
		MID = MID;
		this.movieName = movieName;
	}
	public movieDto() {
		// TODO Auto-generated constructor stub
	}
	public int getMID() {
		return MID;
	}
	public void setMID(int MID) {
		MID=this.MID;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public  static void  valueOf(movieDto MovieDto) {
		
		MovieDto.setMID(MovieDto.getMID());
		MovieDto.setMovieName(MovieDto.getMovieName());
		
		}
	public  Movie createEntity() {
		Movie movie = new Movie();
		movie.setMID(this.getMID());
		movie.setMovieName(this.getMovieName());
		return movie;
	}
	

}
