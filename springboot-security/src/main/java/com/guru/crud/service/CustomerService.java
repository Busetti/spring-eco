package com.guru.crud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guru.crud.entity.Customer;
import com.guru.crud.exceptions.NoCustomerDetailsFound;
import com.guru.crud.repo.CustomerRepository;

@Service
public class CustomerService implements CustomerServiceImpl{

	@Autowired
	CustomerRepository customerRepository;
	
	@Override
	public Customer create(Customer dto) {
		return customerRepository.save(dto);
	}

	public Customer findCustomer(Long id) {
		return customerRepository.findById(id).orElseThrow(() -> new NoCustomerDetailsFound("No customer found with id " + id));
	}

}
