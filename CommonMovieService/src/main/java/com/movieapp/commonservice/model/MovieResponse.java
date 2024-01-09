package com.movieapp.commonservice.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class MovieResponse {
	
	private String title;
	private String rating;
	private String id;
	private int year;
	private String description;
	private String image;
}
