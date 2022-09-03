package com.guru.crud.exceptions;

public class NoCustomerDetailsFound extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public NoCustomerDetailsFound(String cause) {
		super(cause);
	}
	
}
