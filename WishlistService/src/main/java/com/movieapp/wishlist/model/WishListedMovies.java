package com.movieapp.wishlist.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="WishListedMovies")
@Schema(description = "Creating model class for wishlist the movie")
public class WishListedMovies {
	@Schema(description = "stores the wishlist id for the wishlist movie")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int WishListId;
	@Schema(description = "stores the user id for the wishlist movie")
	private String userName;
	@Schema(description = "stores the title for the wishlist movie")
	private String title;
	@Schema(description = "stores the rating for the wishlist movie")
	private String rating;
	@Schema(description = "stores the id for the wishlist movie")
	private String id;
	@Schema(description = "stores the year for the wishlist movie")
	private int year;
	@Schema(description = "stores the description for the wishlist movie")
	private String description;
	@Schema(description = "stores the image link for the wishlist movie")
	private String image;
}
