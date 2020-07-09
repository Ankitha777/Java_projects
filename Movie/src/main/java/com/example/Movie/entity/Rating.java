package com.example.Movie.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="rating")
public class Rating {
	@Id
	public String CID;
	@Column(nullable = false)
	public String name;
	@Column(nullable = true)
	public Float avgRating;
	@Column(nullable = false)
	public Float RatingCus;
	@ManyToOne
	@JoinColumn
	public Movie movieId;
	public String getCID() {
		return CID;
	}
	public void setCID(String cID) {
		CID = cID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Float getAvgRating() {
		return avgRating;
	}
	public void setAvgRating(Float avgRating) {
		this.avgRating = avgRating;
	}
	public Float getRating() {
		return RatingCus;
	}
	public void setRating(Float rating) {
		RatingCus = rating;
	}
	public Movie getMovieId() {
		return movieId;
	}
	public void setMovieId(Movie movieId) {
		this.movieId = movieId;
	}
}
