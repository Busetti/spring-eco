package com.guru.crud.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guru.crud.entity.UserEntity;
import com.guru.crud.repo.UserEntityRepository;

@Service
public class UserEntityService {

	@Autowired
	UserEntityRepository entityRepository;
	
	public Optional<UserEntity> loadUserByName(String username) {
		return entityRepository.findByUsername(username);
	}
}
