package com.guru.crud.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.guru.crud.entity.Customer;
import com.guru.crud.exceptions.NoCustomerDetailsFound;
import com.guru.crud.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	CustomerService customerService;
	
	@PostMapping("/create")
	public Customer createCustomer(@RequestBody Customer customer) {
		return customerService.create(customer);
	}
	
	@GetMapping("/findone")
	public Customer findCustomer(@RequestParam("id") Long id) {
		throw new NoCustomerDetailsFound("No Customer Found for " + id);
	}
}
