package com.samcancode;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@EnableAsync
@SpringBootApplication
public class TsbSccBreweryApplication {

	public static void main(String[] args) {
		SpringApplication.run(TsbSccBreweryApplication.class, args);
	}

}
