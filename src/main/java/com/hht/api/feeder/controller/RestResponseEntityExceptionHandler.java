package com.hht.api.feeder.controller;

import javax.validation.ConstraintViolationException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.hht.api.feeder.dto.ApiResponseDto;
import com.hht.api.feeder.dto.ErrorDto;
import com.hht.api.feeder.utils.Utils;

/**
 * <h1>RestResponseEntityExceptionHandler</h1>
 * <p>
 * This class handles the application exceptions.
 * <p>
 * 
 * Copyright 2019 Horizon High Tech, Inc. All Rights Reserved.
 *
 * @author Jorge De Los Santos
 * @version 1.0
 * @Since May 5, 2019
 */
@ControllerAdvice
public class RestResponseEntityExceptionHandler {

	/** The Constant LOGGER. */
	private static final Logger LOGGER = LoggerFactory.getLogger(RestResponseEntityExceptionHandler.class);

	/**
	 * Allows us to handle thrown exceptions in all controller.
	 * <p>
	 * Receives an exception and WebRequest objects which provide specific
	 * information that is handle and formating for the service clients.
	 *
	 * Manage the exception ConstraintViolationException in a Controller
	 *
	 * @param exception
	 * @param request
	 * @return an instance of ResponseEntity<ApiResponseDto>
	 */
	@ExceptionHandler(value = { ConstraintViolationException.class })
	protected ResponseEntity<ApiResponseDto> handleConstraintViolationException(ConstraintViolationException exception,
			WebRequest request) {
		LOGGER.error("Constraint violation: ", exception.getCause());

		ApiResponseDto response = new ApiResponseDto();
		response.setErrors(Utils.getErrorsFromConstraintViolations(exception.getConstraintViolations(),
				request.getDescription(false)));

		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);

	}

	/**
	 * Allows us to handle thrown exceptions in all controller.
	 * <p>
	 * Receives an exception and WebRequest objects which provide specific
	 * information that is handle and formating for the service clients.
	 *
	 * Manage the exception MethodArgumentNotValidException in a Controller
	 *
	 * @param exception
	 * @param webRequest
	 * @return an instance of ResponseEntity<ApiResponseDto>
	 */
	@ExceptionHandler(value = { MethodArgumentNotValidException.class })
	protected ResponseEntity<ApiResponseDto> handleMethodArgumentNotValidException(
			MethodArgumentNotValidException exception, WebRequest webRequest) {
		LOGGER.error(exception.getMessage(), exception);
		ApiResponseDto response = new ApiResponseDto();

		for (FieldError fieldError : (exception).getBindingResult().getFieldErrors()) {

			ErrorDto<String> error = new ErrorDto<String>(HttpStatus.BAD_REQUEST.name(),
					String.valueOf(HttpStatus.BAD_REQUEST.value()), "Invalid method argument",
					"Invalid method argument (" + fieldError.getField() + ") with value ("
							+ fieldError.getRejectedValue() + "), " + fieldError.getDefaultMessage(),
					webRequest.getDescription(false));
			response.addError(error);
		}

		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
	}

	/**
	 * Allows us to handle thrown exceptions in all controller.
	 * <p>
	 * Receives an exception and WebRequest objects which provide specific
	 * information that is handle and formating for the service clients.
	 * 
	 * @param exception
	 * @param request
	 * @return an instance of ResponseEntity<ApiResponseDto>
	 */
	@ExceptionHandler(value = { HttpMessageNotReadableException.class })
	protected ResponseEntity<ApiResponseDto> handleHttpMessageNotReadable(HttpMessageNotReadableException exception,
			WebRequest request) {

		ApiResponseDto response = new ApiResponseDto();
		HttpStatus responseStatus = HttpStatus.BAD_REQUEST;

		ErrorDto<String> error = new ErrorDto<String>(HttpStatus.BAD_REQUEST.name(),
				String.valueOf(HttpStatus.BAD_REQUEST.value()), "Message not readable",
				exception.getClass().getName() + " " + exception.getMessage(), request.getDescription(false));

		response.addError(error);

		return ResponseEntity.status(responseStatus).body(response);

	}

	/**
	 * Allows us to handle thrown HttpRequestMethodNotSupportedException in all
	 * controller.
	 * <p>
	 * Receives an exception and WebRequest objects which provide specific
	 * information that is handle and formating for the service clients.
	 * 
	 * @param exception
	 * @param request
	 * @return an instance of ResponseEntity<InternalProblem>
	 */
	@ExceptionHandler(value = { HttpRequestMethodNotSupportedException.class })
	protected ResponseEntity<ApiResponseDto> handleHttpRequestMethodNotSupportedException(
			HttpRequestMethodNotSupportedException exception, WebRequest request) {

		ApiResponseDto response = new ApiResponseDto();
		HttpStatus responseStatus = HttpStatus.METHOD_NOT_ALLOWED;

		ErrorDto<String> error = new ErrorDto<String>(responseStatus.name(), responseStatus.toString(), "Method not allowed",
				exception.getMessage(), request.getDescription(false));
		response.addError(error);

		return ResponseEntity.status(responseStatus).body(response);

	}
}
