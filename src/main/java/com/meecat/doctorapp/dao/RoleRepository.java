package com.meecat.doctorapp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.meecat.doctorapp.domain.Role;
import com.meecat.doctorapp.domain.User;

public interface RoleRepository extends JpaRepository<Role, Integer> { 
	  Role findByName(String name);
}
