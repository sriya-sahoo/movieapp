
package com.movieapp.servicegateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
@Configuration
public class GatewayConfig {

	@Bean
	public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {

		return builder.routes().route("Redirect to wishlist service", r -> r.path("/wishlist/**").uri("http://localhost:8084/"))
				.route("Redirect to Commonmovie service", r -> r.path("/movie/**").uri("http://localhost:8083/"))
				.route("Redirect to authentication service", r -> r.path("/authentication/**").uri("http://localhost:8081"))
				.route("Redirect to user service", r -> r.path("/user/**").uri("http://localhost:8082/"))
				.build();
	}

}
