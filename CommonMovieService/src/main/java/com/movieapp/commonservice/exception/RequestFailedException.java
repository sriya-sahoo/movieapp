package com.movieapp.commonservice.exception;

public class RequestFailedException extends RuntimeException {
	
	public RequestFailedException(String message)
	{
		super(message);
	}

}
