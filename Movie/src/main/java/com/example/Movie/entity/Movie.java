package com.example.Movie.entity;


import javax.persistence.*;

import org.springframework.boot.autoconfigure.domain.EntityScan;

@Entity
@Table(name="Movie")
public class Movie{
	public Movie(int MID, String movieName) {
		super();
		this.MID = MID;
		this.movieName = movieName;
	}
	public Movie() {
		// TODO Auto-generated constructor stub
	}
	@Id
	@JoinColumn (name = "movieId")
	public  int MID;
	@Column
	public String movieName;
	
	public int getMID() {
		return MID;
	}
	public void setMID(int MID) {
		this.MID = MID;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
}