package com.movieapp.commonservice.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.movieapp.commonservice.exception.RequestFailedException;
import com.movieapp.commonservice.service.CommonMovieService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/movie")
@CrossOrigin
public class CommonServiceController {

	@Autowired
	private CommonMovieService commonMovieService;

	@GetMapping("/getmovie")
	public ResponseEntity<?> getMovieInfo() throws IOException, InterruptedException, RequestFailedException {
		log.info("Inside Controller");
		return new ResponseEntity<>(commonMovieService.getDataFromExternalService(), HttpStatus.OK);

	}

}
