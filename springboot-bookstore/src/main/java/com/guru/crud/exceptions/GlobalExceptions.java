package com.guru.crud.exceptions;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptions {
	
	@ExceptionHandler(NoCustomerDetailsFound.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	public ErrorInfo handleNoCustomerFound(NoCustomerDetailsFound ex) {
		System.out.println("controll here");
		return new ErrorInfo(ex.getMessage(),LocalDateTime.now(), CustomCode.CUSTOMER_NOT_FOUND.getStatusCodeAndMessage());
	}

}
