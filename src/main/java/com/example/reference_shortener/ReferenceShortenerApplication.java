package com.example.reference_shortener;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class ReferenceShortenerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReferenceShortenerApplication.class, args);
	}

}
