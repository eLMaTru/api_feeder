
package com.hht.api.feeder.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
	@Autowired
	private UserRepository userRepository;
	
	@HystrixCommand(fallbackMethod = "getUserByIdFalback", commandProperties = 
   {@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "10000")})
	public Optional<User> getUserById(String userId) {
		User user = userRepository.findByUserId(userId);
		if(null == user) {
			user = new User();
		};
		return Optional.of(user);
	}
	
  public Optional<User> getUserByIdFalback(String userId, Throwable exception) {
	    LOGGER.error("UserService.getUserFalback excecuted. Exception found: {}", String.valueOf(exception));
		return Optional.empty();
	}
  
	@HystrixCommand(fallbackMethod = "saveUserFalback", commandProperties = 
		   {@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "10000")})
			public Optional<User> saveUser(User user) {
				User savedUser = userRepository.save(user);
				return Optional.of(savedUser);
			}
			
		  public Optional<User> saveUserFalback(User user, Throwable exception) {
			    LOGGER.error("UserService.saveUserFalback excecuted. Exception found: {}", String.valueOf(exception));
				return Optional.empty();
			}

}