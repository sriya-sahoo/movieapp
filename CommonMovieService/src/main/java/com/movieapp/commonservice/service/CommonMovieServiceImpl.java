package com.movieapp.commonservice.service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.movieapp.commonservice.exception.RequestFailedException;
import com.movieapp.commonservice.model.MovieResponse;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class CommonMovieServiceImpl implements CommonMovieService {

	@Value("${external.service.url}")
	private String externalServiceUrl;

	private final RestTemplate restTemplate = new RestTemplate();

	// @Value("${param1}")
	private final String param1 = "19ae4c4b19msh5c7475b76ab0f50p1f0a90jsnd196d37a62b7";
	// @Value("${param2}")
	private final String param2 = "imdb-top-100-movies.p.rapidapi.com";

	List<MovieResponse> movieResponse = new ArrayList<MovieResponse>();

	HttpHeaders headers = new HttpHeaders();

	public MovieResponse[] getDataFromExternalService() throws IOException, InterruptedException {
		
		log.info("inside service");
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		headers.set("X-RapidAPI-Key", "19ae4c4b19msh5c7475b76ab0f50p1f0a90jsnd196d37a62b7");
		headers.set("X-RapidAPI-Host", "imdb-top-100-movies.p.rapidapi.com");
		HttpEntity request = new HttpEntity(headers);
		log.info("inside service before rest template");
		ResponseEntity<MovieResponse[]> response = restTemplate.exchange(externalServiceUrl, HttpMethod.GET, request,
				MovieResponse[].class);
		if (response.getStatusCode() == HttpStatus.OK) {
			log.info("Request Successful.");
			log.info("Movie Response Details []:"+ response.getBody());
			return response.getBody();
		} else {
			log.info("Request Failed");
			log.info("Response Code" + response.getStatusCode());
			throw new RequestFailedException("Request Failed");
		}

	}
}
