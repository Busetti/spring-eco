package com.edureka.core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");

		CustomerService cust = (CustomerService) ac.getBean("customerService");

		System.out.println(cust.getMessage());

	}

}
