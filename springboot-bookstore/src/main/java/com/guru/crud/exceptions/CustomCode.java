package com.guru.crud.exceptions;

public enum CustomCode {

	CUSTOMER_NOT_FOUND("5001", "Customer Not Found");

	private String errorCode;
	private String errorMessage;


	private CustomCode(String errorCode, String errorMessage) {
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}
	
	public String getStatusCodeAndMessage() {
		return errorCode + " - " + errorMessage;
	}

}
