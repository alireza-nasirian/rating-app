package com.sample.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {"com.sample"})
@EntityScan(basePackages = {"com.sample"})
@EnableJpaRepositories(basePackages = {"com.sample"})
public class RatingAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(RatingAppApplication.class, args);
	}

}
