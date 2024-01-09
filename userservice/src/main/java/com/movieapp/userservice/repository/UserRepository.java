package com.movieapp.userservice.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.movieapp.userservice.model.UserDetails;

@Repository
public interface UserRepository extends JpaRepository<UserDetails, Integer> {
	
    //Optional<UserDetails> findByEmail(String email);
	@Query("select a from UserDetails a where a.userName= :userName")
	public Optional<UserDetails> findbyUserName(@Param("userName")String userName);

}
