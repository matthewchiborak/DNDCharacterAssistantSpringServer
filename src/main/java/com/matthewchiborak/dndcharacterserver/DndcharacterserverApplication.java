package com.matthewchiborak.dndcharacterserver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class DndcharacterserverApplication {

	public static void main(String[] args) {
		SpringApplication.run(DndcharacterserverApplication.class, args);
	}
	
	  @Bean
	  public CorsFilter corsFilter() {
	      final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();

	      final CorsConfiguration config = new CorsConfiguration();
	      config.setAllowCredentials(true);
	      List<String> allowedOriginStrings = new ArrayList();
	      allowedOriginStrings.add("http://localhost:4200");
	      allowedOriginStrings.add("http://localhost:3001");
	      config.setAllowedOrigins(allowedOriginStrings);
	      config.setAllowedHeaders(Arrays.asList("Origin", "Content-Type", "Accept", "Authorization"));
	      config.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));

	      source.registerCorsConfiguration("/**", config);
	      return new CorsFilter(source);
	  }
}
