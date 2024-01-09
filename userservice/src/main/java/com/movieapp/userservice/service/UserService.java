package com.movieapp.userservice.service;

import java.util.List;

import com.movieapp.userservice.exception.UserNotFoundException;
import com.movieapp.userservice.model.UserDetails;

public interface UserService {
	public UserDetails registerUser(UserDetails userdetails);
//	public String loginUser(int userId, String password) throws UserNotFoundException;
	public UserDetails updateUser(String userName, UserDetails userdetails) throws UserNotFoundException;
	
}
