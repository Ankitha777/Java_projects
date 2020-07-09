package com.example.Movie.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Movie.Dto.movieDto;
import com.example.Movie.Service.MovieService;
import com.example.Movie.entity.Movie;
//import com.infosys.infytel.customer.dto.CustomerDTO;

@RestController
@RequestMapping("/api")
public class MovieController {
	//Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	MovieService movieService;
	@RequestMapping("/rest")
	public List<Movie> gethello() {
		//List<Movie> movie=(List<Movie>) new Movie();
		return movieService.getallDetails();
       }
	@RequestMapping("/api/rest/api")
	public String gethello1() {
		/*
		 * List<Movie> movie=(List<Movie>) new Movie();
		 * movie=movieService.getallDetails();
		 */
		return movieService.serv();
       }
	@PostMapping(path= "/add",consumes = MediaType.APPLICATION_JSON_VALUE)
	public void add(@RequestBody Movie movDto) {
		
		movieService.add_inDB(movDto);
		
	}
	
	
}