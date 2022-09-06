package com.guru.crud;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.guru.crud.entity.UserEntity;
import com.guru.crud.repo.UserEntityRepository;

@SpringBootApplication
public class SpringbootCrudJdbcApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(SpringbootCrudJdbcApplication.class, args);
	}
	
	@Autowired
	UserEntityRepository userEntityRepository;
	
	@Autowired
	@Lazy // To resolve circular dependency
	PasswordEncoder passwordEncode;

	@Override
	public void run(String... args) throws Exception {
		UserEntity user1 = new UserEntity();
		user1.setUsername("guru");
		user1.setPassword(passwordEncode.encode("guru123"));
		user1.setRoles(Arrays.asList("ROLE_ADMIN"));
		userEntityRepository.save(user1);
	}

}
