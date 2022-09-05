package com.guru.crud.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.guru.crud.entity.UserEntity;
import com.guru.crud.service.UserEntityService;

@Service
public class CustomerUserDetailsService implements UserDetailsService{

	@Autowired
	UserEntityService userEntityService;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserEntity user = userEntityService.loadUserByName(username).orElseThrow(() -> new UsernameNotFoundException("Username not found"));
		System.out.println(user.toString());
		return new CustomUser(user);
	}

}
