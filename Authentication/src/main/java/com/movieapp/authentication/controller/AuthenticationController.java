package com.movieapp.authentication.controller;


import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.movieapp.authentication.exception.LoginException;
import com.movieapp.authentication.exception.UserNotFoundException;
import com.movieapp.authentication.model.AuthenticationRequest;
import com.movieapp.authentication.model.AuthenticationResponse;
import com.movieapp.authentication.model.VaildatingDTO;
import com.movieapp.authentication.service.AuthenticationService;
import com.movieapp.authentication.util.JwtUtil;

import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@CrossOrigin
@RequestMapping("/authentication")
public class AuthenticationController {
	@Autowired
	private AuthenticationService authService;

	@Autowired
	private JwtUtil jwtUtilToken;
	
	private VaildatingDTO vaildatingDTO= new VaildatingDTO();
	
	@Autowired
	private Gson gson;
	
	@Operation(summary = "User Login", description = "takes customer credentials and generates the unique JWT for each customer", method = "POST", responses = {
			@ApiResponse(responseCode = "200", description = "generates the unique JWT for each customer", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ResponseEntity.class))) })
	@PostMapping("/login")
	public ResponseEntity<?> createAuthorizationToken(@RequestBody AuthenticationRequest authenticationRequest)
			throws LoginException, UserNotFoundException {
		log.info("Login request Recieved[]:"+ authenticationRequest);
		AuthenticationRequest auth = authService.login(authenticationRequest);
		if (auth.getPassword().equals(authenticationRequest.getPassword())) {
			Map<String,String> myToken= jwtUtilToken.generateToken(authenticationRequest);
			return new ResponseEntity<>(myToken,HttpStatus.OK);
		} else {
			throw new LoginException("Invalid Username or Password");

		}
	}
	
	@KafkaListener(topics="usertopic",groupId = "group_id")
    public ResponseEntity<?> addData(String authRes){
		log.info("Register request Recieved[]:"+ authRes);
		AuthenticationRequest auth= gson.fromJson(authRes, AuthenticationRequest.class);
		return new ResponseEntity<>( authService.AddData(auth),HttpStatus.CREATED);
    }
	
	

	@Operation(summary = "health-check", description = "Health Check", method = "GET", responses = {
			@ApiResponse(responseCode = "200", description = "Health Check", content = @Content(mediaType = "application/json", schema = @Schema(implementation = String.class))) })
	@GetMapping(path = "/health-check")
	public ResponseEntity<String> healthCheck() {
		log.info("Authentication Microservice is Up and Running....");
		return new ResponseEntity<>("OK", HttpStatus.OK);
	}
}
