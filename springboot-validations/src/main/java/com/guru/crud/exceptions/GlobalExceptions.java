package com.guru.crud.exceptions;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptions {

	@ExceptionHandler(NoCustomerDetailsFound.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	public ErrorInfo handleNoCustomerFound(NoCustomerDetailsFound ex) {
		return new ErrorInfo(ex.getMessage(), LocalDateTime.now(),
				CustomCode.CUSTOMER_NOT_FOUND.getStatusCodeAndMessage());
	}

	// Handle Exceptions of JSR-303 Validations
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	public ErrorInfo handleNoCustomerFound(MethodArgumentNotValidException ex) {
		String cause = ex.getBindingResult().getAllErrors().stream().map(n -> n.getDefaultMessage())
				.collect(Collectors.joining(" ,"));
		return new ErrorInfo(cause, LocalDateTime.now(), CustomCode.VALIDATION_FAILED.getStatusCodeAndMessage());
	}

	@ExceptionHandler(Exception.class)
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	public ErrorInfo handleNoCustomerFound(Exception ex) {
		return new ErrorInfo(ex.getMessage(), LocalDateTime.now(), HttpStatus.INTERNAL_SERVER_ERROR.name());
	}

}
