package com.guru.crud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guru.crud.entity.Customer;
import com.guru.crud.repo.CustomerRepository;

@Service
public class CustomerService implements CustomerServiceImpl{

	@Autowired
	CustomerRepository customerRepository;
	
	@Override
	public Customer create(Customer dto) {
		return customerRepository.create(dto);
	}

}
