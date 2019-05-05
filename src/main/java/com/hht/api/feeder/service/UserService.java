/**
 * 
 */
package com.hht.api.feeder.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.hht.api.feeder.model.User;
import com.hht.api.feeder.repository.UserRepository;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

/**
 * Service layer to User model
 * 
 * @author Jorge De Los Santos
 * @Version 1.1
 * @Since May 5, 2019 
 */
@Service
public class UserService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);
	private UserRepository userRepository;
	
	@HystrixCommand(fallbackMethod = "getUserFalback", commandProperties = 
   {@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "10000")})
	public Optional<User> getUser(String userId) {
		
		return userRepository.findById(userId);
	}
	
  public Optional<User> getUserFalback(String userId, Throwable exception) {
	    LOGGER.error("UserService.getUserFalback excecuted. Exception found: {}", String.valueOf(exception));
		return Optional.empty();
	}

}
