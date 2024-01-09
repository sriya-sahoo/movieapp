package com.movieapp.userservice.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.web.client.RestTemplate;

@Configuration
public class UserServiceConfig{
	
	 @Bean
	    public NewTopic topic(){
	    	return TopicBuilder
	    			.name("usertopic")
	    			.build();
	    }

	 @Bean
		public RestTemplate restTemplate() {
			return new RestTemplate();
		}
}