package com.movieapp.authentication.service;

import org.springframework.stereotype.Service;

import com.movieapp.authentication.exception.UserNotFoundException;
import com.movieapp.authentication.model.AuthenticationRequest;

@Service
public interface AuthenticationService {
	
	public AuthenticationRequest login(AuthenticationRequest authenticaterequest) throws UserNotFoundException;
	public AuthenticationRequest AddData(AuthenticationRequest auth);
	public AuthenticationRequest getuser(String userName);
}
