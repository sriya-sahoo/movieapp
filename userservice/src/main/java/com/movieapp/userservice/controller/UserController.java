package com.movieapp.userservice.controller;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.movieapp.userservice.exception.UserNotFoundException;
import com.movieapp.userservice.model.UserDetails;
import com.movieapp.userservice.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@CrossOrigin
@RequestMapping("/user")

public class UserController {
	
	private String validateEndpoint="http://localhost:8081/authentication/validate";
	HttpHeaders headers = new HttpHeaders();

	private RestTemplate restTemplate= new RestTemplate();
	@Autowired
	private UserService userService;
	
	@PostMapping("/register")
	public ResponseEntity<UserDetails> registerUser(@RequestBody UserDetails userDetails)
	{
		log.info("User Registration");
		log.info("Request resigterUser : {}", userDetails);
		UserDetails user=userService.registerUser(userDetails);
		log.info("Request resigterUser : {}", user);
		return new ResponseEntity<>(user, HttpStatus.CREATED);
		
	}
	
	@PutMapping("/update/{userName}")
	public ResponseEntity<?> updateUser(@PathVariable String userName, @RequestBody UserDetails userDetails) throws UserNotFoundException
	{
		
        
		log.info("User Update");
		log.info("Request update : {}", userName + " " + userDetails);
		UserDetails user=userService.updateUser(userName, userDetails);
		log.info("Response update : {}"+ userDetails);
		return new ResponseEntity<UserDetails>(user, HttpStatus.OK);
		
			
	}

}
