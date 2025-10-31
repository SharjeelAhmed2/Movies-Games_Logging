package com.entertainment.log.movieGame;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})

public class MovieGameApplication {

	public static void main(String[] args) {
		SpringApplication.run(MovieGameApplication.class, args);
	}

}
