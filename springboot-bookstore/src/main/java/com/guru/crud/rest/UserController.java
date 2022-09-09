package com.guru.crud.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.guru.crud.entity.UserEntity;
import com.guru.crud.repo.UserEntityRepository;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserEntityRepository entityRepository;
	
	@Autowired
	@Lazy
	PasswordEncoder encoder;
	
	@PostMapping("/signup")
	public UserEntity createUser(@RequestBody UserEntity user) {
		user.setPassword(encoder.encode(user.getPassword()));
		return entityRepository.save(user);
	}
}
