package com.movieapp.authentication.util;


import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;


import org.springframework.stereotype.Service;

import com.movieapp.authentication.model.AuthenticationRequest;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;


@Service
@Slf4j
/* This class generates the Unique Jwt token */
public class JwtUtil {

	
		public Map<String, String> generateToken(AuthenticationRequest
				authRequest){
			//This user details will the there in the jwt token body
			Map<String,Object> userdata=new HashMap<>();
			userdata.put("userName", authRequest.getUserName());
			userdata.put("password", authRequest.getPassword());
			String jwtToken="";
			 jwtToken = Jwts.builder().setClaims(userdata)
					 .setIssuedAt(new Date())
					 .signWith(SignatureAlgorithm.HS256, "secret2").compact();
			 Map<String, String> jwtTokenMap=new HashMap<>();
			 jwtTokenMap.put("token", jwtToken);
					 return jwtTokenMap;

	 
					

		}

	}

	 