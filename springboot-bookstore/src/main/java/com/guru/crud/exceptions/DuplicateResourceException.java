package com.guru.crud.exceptions;

public class DuplicateResourceException extends RuntimeException {
	public DuplicateResourceException(String message) {
		super(message);
	}
}