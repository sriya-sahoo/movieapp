package com.movieapp.userservice.service;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.movieapp.userservice.exception.UserNotFoundException;
import com.movieapp.userservice.model.AuthenticationRequest;
import com.movieapp.userservice.model.UserDetails;
import com.movieapp.userservice.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;

	private static final String TOPIC ="usertopic";
	
	@Autowired
	private Gson gson;
	@Override
	public UserDetails registerUser(UserDetails userdetails) {
		
		AuthenticationRequest authuser= new AuthenticationRequest(userdetails.getUserName(), userdetails.getPassword());
		// TODO Auto-generated method stub
		kafkaTemplate.send(TOPIC, gson.toJson((authuser)));
		return userRepository.save(userdetails);
	}

	@Override
	public UserDetails updateUser(String userName, UserDetails userdetails) throws UserNotFoundException {
		// TODO Auto-generated method stub
		Optional<UserDetails> user = userRepository.findbyUserName(userName);
		if (user.isPresent()) {
			user.get().setEmail(userdetails.getEmail());
			user.get().setFirstName(userdetails.getFirstName());
			user.get().setLastName(userdetails.getLastName());
			user.get().setPassword(userdetails.getPassword());
			user.get().setPhoneNumber(userdetails.getPhoneNumber());
			userRepository.save(user.get());
			return user.get();
		} else {
			throw new UserNotFoundException("User not found");
		}
	}

}
