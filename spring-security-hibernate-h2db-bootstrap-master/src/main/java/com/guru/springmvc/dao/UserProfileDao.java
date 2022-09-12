package com.guru.springmvc.dao;

import java.util.List;

import com.guru.springmvc.model.UserProfile;


public interface UserProfileDao {

    List<UserProfile> findAll();

    UserProfile findByType(String type);

    UserProfile findById(int id);
}
