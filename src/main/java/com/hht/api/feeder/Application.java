
package com.hht.api.feeder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;

@EnableCircuitBreaker
@SpringBootApplication
@SpringBootConfiguration
public class Application {

	/**
	 * The main method of the class which run the spring boot application
	 * @param args
	 * */
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}