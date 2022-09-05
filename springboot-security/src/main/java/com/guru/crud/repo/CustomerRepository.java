package com.guru.crud.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.guru.crud.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
