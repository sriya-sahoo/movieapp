package com.movieapp.wishlist.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movieapp.wishlist.exception.MovieAlreadyWishlistedException;
import com.movieapp.wishlist.exception.MovieNotFoundInWishlistException;
import com.movieapp.wishlist.model.WishListedMovies;
import com.movieapp.wishlist.repository.WishlistRepository;

import lombok.extern.slf4j.Slf4j;

@Service
public class WishlistServiceImpl implements WishlistService {

	@Autowired
	private WishlistRepository wishlistRepo;
	
	@Override
	public WishListedMovies addMovieWishlist(WishListedMovies wishlistmovie) throws MovieAlreadyWishlistedException {
		// TODO Auto-generated method stub
		Optional<WishListedMovies> movie= wishlistRepo.findByTitle(wishlistmovie.getTitle(), wishlistmovie.getUserName());
		if(movie.isEmpty())
		{
			WishListedMovies wish= wishlistRepo.save(wishlistmovie);
		return wish;
		}
		else
			throw new MovieAlreadyWishlistedException("Movie Already wishlisted");
		
	}

	@Override
	public String removeFromWishlist(String title, String userName ) throws MovieNotFoundInWishlistException {
		// TODO Auto-generated method stub
		Optional<WishListedMovies> wish= wishlistRepo.findByTitle(title,userName);
		if(wish.isPresent()) {
		wishlistRepo.deleteById(wish.get().getWishListId());;
		return "Successfully removed from the wishlist";
		}
		else
		{
			throw new MovieNotFoundInWishlistException("Movie not found in wishlist");
		}
		
	}

	@Override
	public List<WishListedMovies> viewWishlist(String userName) {
		// TODO Auto-generated method stub
		List<WishListedMovies> movies=wishlistRepo.findByUserName(userName);
		return movies;
	}

	
}
