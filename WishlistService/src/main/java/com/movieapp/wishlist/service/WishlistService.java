package com.movieapp.wishlist.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.movieapp.wishlist.exception.MovieAlreadyWishlistedException;
import com.movieapp.wishlist.exception.MovieNotFoundInWishlistException;
import com.movieapp.wishlist.model.WishListedMovies;

@Service
public interface WishlistService {

	
	public WishListedMovies addMovieWishlist(WishListedMovies wishlistmovie) throws MovieAlreadyWishlistedException;
	public String removeFromWishlist(String title,String userName) throws MovieNotFoundInWishlistException;
	public List<WishListedMovies> viewWishlist(String userName);
	
}
