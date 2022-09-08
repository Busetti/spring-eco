package com.guru.annotations;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.guru.annotations.service.CustomerBo;

public class MainApp {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		TextEditor te = (TextEditor) context.getBean("textEditor");
		te.spellCheck();
		
		Hostel student = (Hostel) context.getBean("hostel");
		student.printAge();
		student.printName();
		
		
		// AOP
		
		CustomerBo customer = (CustomerBo) context.getBean("customerBo");
		customer.addCustomer();
		try {
			customer.addCustomerThrowException();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		customer.addCustomerAround("Gurunath");
		
	}
}