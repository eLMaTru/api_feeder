package com.hht.api.feeder.controller;

import java.util.Collections;
import java.util.Optional;

import javax.validation.constraints.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;

import com.hht.api.feeder.constants.Endpoint;
import com.hht.api.feeder.constants.ValidationMessage;
import com.hht.api.feeder.constants.ValidationPattern;
import com.hht.api.feeder.dto.ApiResponseDto;
import com.hht.api.feeder.dto.ErrorDto;
import com.hht.api.feeder.dto.UserDto;
import com.hht.api.feeder.model.User;
import com.hht.api.feeder.service.UserService;
import com.hht.api.feeder.utils.ResponseWrapper;

/**
 * <h1>UserController</h1> The class is annotated with {@code @RestContoller},
 * which add the {@code @Controller} and {@code @ResponseBody} annotations. With
 * this annotation you no longer need to add {@code @ResponseBody} to all the
 * request mapping methods, it is active by default.
 * <p>
 * This class handles the application flow. It takes the HTTP requests and
 * resolve them using the corresponding service.
 * <p>
 * Copyright 2019 Horizon High Tech, Inc. All Rights Reserved.
 *
 * @author Jorge De Los Santos
 * @version 1.0
 * @see org.springframework.boot.SpringApplication
 * @see <a href=
 *      "https://docs.spring.io/spring/docs/current/javadoc-api/org/springframework/web/bind/annotation/RestController.html">RestController</a>
 * @Since May 5, 2019
 */
@RequestScope
@RestController
@RequestMapping("v1")
public class UserController {
	/**
	 * This is the constant logger.
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserService userService;

	/**
	 * Gets the user by id.
	 *
	 * @param userId the user id
	 * @return the user by id
	 */
	@GetMapping(value = Endpoint.ENDPOINT_USER, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ApiResponseDto> getUserById(
			@Pattern(regexp = ValidationPattern.UUID_PATTERN, message = " Invalid user ID format") @PathVariable("userId") String userId) {

		final String ENDPOINT = Endpoint.ENDPOINT_USER.replace("{userId}", userId);
		LOGGER.info("Excecuting endpoint: ".concat(ENDPOINT));

		HttpStatus status = HttpStatus.OK;
		ApiResponseDto response = new ApiResponseDto();
		Optional<User> optional = userService.getUserById(userId);

		if (!optional.isPresent()) {
			status = HttpStatus.BAD_GATEWAY;
			ErrorDto<String> error = new ErrorDto<>(status.name(), status.toString(),
					ValidationMessage.EXCEPTION_FALLBACK, ValidationMessage.EXCEPTION_FALLBACK_DETAILS, ENDPOINT);

			response.addError(error);
		} else {
			User user = optional.get();
			if (null != user && null != user.getUserId()) {
				response.setData(Collections.singletonList(ResponseWrapper.of(user)));
			} else {

				status = HttpStatus.NOT_FOUND;
				ErrorDto<String> error = new ErrorDto<>(status.name(), status.toString(),
						ValidationMessage.USER_NOT_FOUND,
						ValidationMessage.USER_NOT_FOUND_DETAILS.replace("{userId}", userId), ENDPOINT);
				response.addError(error);
			}
		}

		return ResponseEntity.status(status).body(response);
	}

	/**
	 * Save user.
	 *
	 * @param request the request
	 * @return the response entity
	 */
	@PostMapping(value = Endpoint.ENDPOINT_USER_POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ApiResponseDto> saveUser(@Validated @RequestBody UserDto request) {

		final String ENDPOINT = Endpoint.ENDPOINT_USER;
		LOGGER.info("Excecuting endpoint: ".concat(ENDPOINT).concat(" with request: ").concat(request.toString()));

		HttpStatus status = HttpStatus.CREATED;

		User requestUser = request.convertToUser();
		ApiResponseDto response = new ApiResponseDto();
		Optional<User> optional = userService.saveUser(requestUser);

		if (!optional.isPresent()) {
			status = HttpStatus.BAD_GATEWAY;
			ErrorDto<String> error = new ErrorDto<>(status.name(), status.toString(),
					ValidationMessage.EXCEPTION_FALLBACK, ValidationMessage.EXCEPTION_FALLBACK_DETAILS, ENDPOINT);

			response.addError(error);
		} else {
			User user = optional.get();
			response.setData(Collections.singletonList(ResponseWrapper.of(user)));
		}

		return ResponseEntity.status(status).body(response);
	}
}
