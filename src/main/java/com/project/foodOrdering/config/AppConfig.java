package com.project.foodOrdering.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration


public class AppConfig {
     @Autowired
     
     private Environment env;
     
     SecurityFilter secure=new SecurityFilter();
   
	@Bean
	public BCryptPasswordEncoder getBCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			 @Override
			public void addCorsMappings(CorsRegistry registry) {
			   registry.addMapping("/**")
			   .allowedOrigins("http://localhost:4200")
               .allowedMethods("GET", "POST", "PUT", "DELETE", "HEAD","OPTIONS")
               .allowedHeaders("Content-Type", "Date", "Total-Count", secure.jwt_token)
               .exposedHeaders("Content-Type", "Date", "Total-Count", secure.jwt_token)
               .maxAge(3600);
			}
			
		};
	   
	}

}
