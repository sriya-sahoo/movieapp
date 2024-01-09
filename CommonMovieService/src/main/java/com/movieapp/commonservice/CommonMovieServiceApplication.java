package com.movieapp.commonservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/*import org.springframework.cloud.client.discovery.EnableDiscoveryClient;*/
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

/*@EnableDiscoveryClient*/
@ComponentScan(basePackages = {"com.movieapp.commonservice"})
@SpringBootApplication
public class CommonMovieServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CommonMovieServiceApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
