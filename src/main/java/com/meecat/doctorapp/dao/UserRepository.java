package com.meecat.doctorapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.meecat.doctorapp.domain.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	  @Query("select u from User u where u.email = ?1")
	  User findByEmail(String email);
	  
}
