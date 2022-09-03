package com.guru.crud.repo;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.guru.crud.entity.Customer;

@Repository
@Transactional
public class CustomerRepository {
	
	@Autowired
	private EntityManager em;//Hibernate session

	public Customer create(Customer dto) {
		em.persist(dto);
		return dto;
	}

}
