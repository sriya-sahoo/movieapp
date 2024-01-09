package com.movieapp.commonservice.service;

import java.io.IOException;
import java.util.List;
import org.springframework.stereotype.Service;
import com.movieapp.commonservice.model.MovieResponse;

@Service
public interface CommonMovieService {

	public MovieResponse[] getDataFromExternalService() throws IOException, InterruptedException;
}