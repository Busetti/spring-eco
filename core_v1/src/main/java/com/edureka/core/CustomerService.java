package com.edureka.core;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class CustomerService implements InitializingBean, DisposableBean {

	String message;
	
	public String getMessage() {
		return this.message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
	
	public void destroy() throws Exception {
		System.out.println("Called Destroy");

	}

	public void afterPropertiesSet() throws Exception {
		System.out.println("After properties set called");
	}

}
