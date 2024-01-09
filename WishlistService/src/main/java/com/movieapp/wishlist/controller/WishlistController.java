package com.movieapp.wishlist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.movieapp.wishlist.exception.MovieAlreadyWishlistedException;
import com.movieapp.wishlist.exception.MovieNotFoundInWishlistException;
import com.movieapp.wishlist.model.WishListedMovies;
import com.movieapp.wishlist.service.WishlistService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@CrossOrigin
@RequestMapping("/wishlist")
public class WishlistController {
	
	@Autowired
	private WishlistService wishlistService;
	
	@Operation(summary = "add to wishlist", description = "takes movie and user id details and adds the movie to wishlist", method = "POST", responses = {
			@ApiResponse(responseCode = "201", description = "returns the wishlisted movie details", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ResponseEntity.class))) })

	@PostMapping("/addwishlist")
	public ResponseEntity<?> addMovieToWishlist(@RequestBody WishListedMovies wishlistmovie) throws MovieAlreadyWishlistedException
	{
		log.info("Adding to wishlist []:"+ wishlistmovie);
		return new ResponseEntity<>(wishlistService.addMovieWishlist(wishlistmovie), HttpStatus.CREATED);
		
	}
	@DeleteMapping("/remove/{title}/{userName}")
	public ResponseEntity<?> removeFromWishlist(@PathVariable String title, @PathVariable String userName) throws MovieNotFoundInWishlistException{
	//	log.info("removing from wishlist []:"+ wishlistmovie);
		return new ResponseEntity<>( wishlistService.removeFromWishlist(title,userName),HttpStatus.OK);
		
	} 
	
	@GetMapping("/view/{userName}")
	public ResponseEntity<?> viewAllWishlist(@PathVariable String userName){
		log.info("viewing all the wishlisted movie of the user"+ userName);

		return new ResponseEntity<>(wishlistService.viewWishlist(userName), HttpStatus.OK);
		
	}
}
