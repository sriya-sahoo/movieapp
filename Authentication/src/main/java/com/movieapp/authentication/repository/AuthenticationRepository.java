package com.movieapp.authentication.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.movieapp.authentication.model.AuthenticationRequest;

@Repository
public interface AuthenticationRepository extends JpaRepository<AuthenticationRequest, String>{

	@Query("select a from AuthenticationRequest a where a.userName= :userName")
	public Optional<AuthenticationRequest> findbyUserName(@Param("userName")String userName);
}
