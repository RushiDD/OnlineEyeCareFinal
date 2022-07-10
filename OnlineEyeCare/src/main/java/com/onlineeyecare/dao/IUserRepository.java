package com.onlineeyecare.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.onlineeyecare.dto.User;

public interface IUserRepository extends JpaRepository<User,Integer>{
	
		Optional<User> findByuserName(String name);
}