package com.hht.api.feeder.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;

import com.hht.api.feeder.dto.ApiResponseDto;
import com.hht.api.feeder.dto.ErrorDto;
import com.hht.api.feeder.utils.Endpoint;

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
@Validated
public class UserController {
	/**
     * This is the constant logger.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
    
    @GetMapping(value = Endpoint.ENDPOINT_USER, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiResponseDto> getUser(@PathVariable("userId") String userId) {

    	LOGGER.info("Excecuting ".concat(Endpoint.ENDPOINT_USER.replace("{userId}", userId)));
    	
    	HttpStatus status = HttpStatus.OK;
    	ApiResponseDto response = new ApiResponseDto();
        
		/*
		 * if (true) { status = HttpStatus.BAD_GATEWAY; ErrorDto<String> error = new
		 * ErrorDto<>( status.name(), status.toString(),
		 * Constants.EXCEPTION_INVALID_REQUEST,
		 * Constants.EXCEPTION_INVALID_REQUEST_PARAMETERS, Constants.URL_GET_HISTORY);
		 * response.addError(error); return new ResponseEntity<>(response, status); }
		 */
        
    	
    	return ResponseEntity.status(status).body(response);
    }
}

	



