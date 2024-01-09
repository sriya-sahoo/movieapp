package com.movieapp.wishlist;

import javax.crypto.SecretKey;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
/*import org.springframework.cloud.client.discovery.EnableDiscoveryClient;*/
import org.springframework.context.annotation.Bean;

import com.movieapp.wishlist.filter.MovieFilter;

import io.jsonwebtoken.SignatureAlgorithm;


/*@EnableDiscoveryClient*/
@SpringBootApplication
public class WishlistServiceApplication {

 
	public static void main(String[] args) {
		SpringApplication.run(WishlistServiceApplication.class, args);
	}
	
	@Bean
	public FilterRegistrationBean getFilter()
	{
		FilterRegistrationBean fbean = new FilterRegistrationBean();
		fbean.setFilter(new MovieFilter());
		fbean.addUrlPatterns("/wishlist/*");
		return fbean;
	}

}
