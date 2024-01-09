package com.movieapp.wishlist.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.movieapp.wishlist.model.WishListedMovies;

@Repository
public interface WishlistRepository extends JpaRepository<WishListedMovies, Integer>
{
	@Query("select a from WishListedMovies a where a.userName= :userName")
	List<WishListedMovies> findByUserName(@Param("userName")String userName);
	@Query("select a from WishListedMovies a where a.title= :title AND a.userName = :userName")
	Optional<WishListedMovies> findByTitle(@Param("title")String title,@Param("userName") String userName);
	
	
}
