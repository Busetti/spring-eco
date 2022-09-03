package com.guru.crud.exceptions;

import java.time.LocalDateTime;

public class ErrorInfo {

	private String cause;
	private LocalDateTime time;
	private String statusCode;

	public String getCause() {
		return cause;
	}

	public void setCause(String cause) {
		this.cause = cause;
	}

	public LocalDateTime getTime() {
		return time;
	}

	public void setTime(LocalDateTime time) {
		this.time = time;
	}

	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

	public ErrorInfo(String cause, LocalDateTime time, String statusCode) {
		super();
		this.cause = cause;
		this.time = time;
		this.statusCode = statusCode;
	}

	public ErrorInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

}
