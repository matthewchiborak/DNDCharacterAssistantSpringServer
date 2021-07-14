package com.matthewchiborak.dndcharacterserver;

import java.util.Arrays;
import java.util.Collections;

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
	
//	  @Bean
//	  CorsConfigurationSource corsConfigurationSource() {
//	      CorsConfiguration configuration = new CorsConfiguration();
//	      configuration.setAllowedOrigins(Arrays.asList("https://example.com"));
//	      configuration.setAllowedMethods(Arrays.asList("GET","POST"));
//	      UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//	      source.registerCorsConfiguration("/**", configuration);
//	      return source;
//	  }
	  
	  @Bean
	  public CorsFilter corsFilter() {
	      final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();

	      final CorsConfiguration config = new CorsConfiguration();
	      config.setAllowCredentials(true);
	      config.setAllowedOrigins(Collections.singletonList("http://localhost:4200"));
	      config.setAllowedHeaders(Arrays.asList("Origin", "Content-Type", "Accept", "Authorization"));
	      config.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));

	      source.registerCorsConfiguration("/**", config);
	      return new CorsFilter(source);
	  }
}
