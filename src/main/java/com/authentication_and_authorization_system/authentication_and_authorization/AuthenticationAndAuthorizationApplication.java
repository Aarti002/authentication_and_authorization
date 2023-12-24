package com.authentication_and_authorization_system.authentication_and_authorization;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@EntityScan
public class AuthenticationAndAuthorizationApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuthenticationAndAuthorizationApplication.class, args);
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/getProfiles").allowedOrigins("http://localhost:8080")
				.allowedMethods("GET", "POST","PUT","OPTIONS");
			}
		};
	}
}
