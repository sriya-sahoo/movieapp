package com.movieapp.authentication.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movieapp.authentication.exception.UserNotFoundException;
import com.movieapp.authentication.model.AuthenticationRequest;
import com.movieapp.authentication.repository.AuthenticationRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class AuthenticationServiceImpl implements AuthenticationService {

	@Autowired
	private AuthenticationRepository authrepository;

	@Override
	public AuthenticationRequest login(AuthenticationRequest authenticaterequest) throws UserNotFoundException {
		// TODO Auto-generated method stub4
		log.info("Finding user");

		Optional<AuthenticationRequest> authrequest = authrepository.findbyUserName(authenticaterequest.getUserName());
		log.info("Use found"+ authrequest.get().getUserName());
		if (authrequest.isPresent()) {
			return authrequest.get();
		} else
		{
			throw new UserNotFoundException("User not found");
		}

	}

	@Override
	public AuthenticationRequest AddData(AuthenticationRequest auth) {
		// TODO Auto-generated method stub
		log.info("Inside auth service");
		return authrepository.save(auth);
	}

	@Override
	public AuthenticationRequest getuser(String userName) {
		// TODO Auto-generated method stub
			
		return authrepository.findbyUserName(userName).get();
	}

}
