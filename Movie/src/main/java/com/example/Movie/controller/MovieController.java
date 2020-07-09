package com.example.Movie.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Movie.Dto.movieDto;
import com.example.Movie.Service.MovieService;
import com.example.Movie.entity.Movie;
import com.example.Movie.entity.Rating;
//import com.infosys.infytel.customer.dto.CustomerDTO;

@RestController
@RequestMapping("/api")
public class MovieController {
	//Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	MovieService movieService;
	@RequestMapping("/rest")
	public List<Movie> gethello() {
		return movieService.getallDetails();
       }
	@PostMapping(path= "/addMovie",consumes = MediaType.APPLICATION_JSON_VALUE)
	public void add_movieDetails(@RequestBody Movie movDto) {
		movieService.add_inDB(movDto);
		}
	@PostMapping(path= "/addCustomer",consumes = MediaType.APPLICATION_JSON_VALUE)
	public void add_customer(@RequestBody Rating rating) {
		movieService.add_customer(rating);
	}
	@GetMapping("/rest/{MID}")
	public Optional<Movie> getMoviename(@PathVariable ("MID")Integer mid) {
		return movieService.getMovieName(mid);
	}
	@PutMapping("rest/Customer/{CID}/rate/{Ratingcus}")
	public void addRating(@PathVariable ("CID")String cid,@PathVariable ("Ratingcus")Float rating) {
		movieService.updateRating(cid,rating);
		//return null;
		}
	@GetMapping("/rest/Customer/Highrated")
	public Rating highRating() {
		return movieService.highRating();
		
	}
	@GetMapping("/rest/Customer/CusMostRated")
	public Rating MostRated() {
		return movieService.MostRated();
	}
}