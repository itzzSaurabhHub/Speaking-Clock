package com.example.timeconversion;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class TimeConversionServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(TimeConversionServiceApplication.class, args);
	}

}
