package com.meecat.doctorapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.io.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.meecat.doctorapp.dao.*;
import com.meecat.doctorapp.domain.*;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;

	public User getUserById(int id) {
		return userRepository.findOne(id);
	}

	public User getUserByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	public User getCurrentUser() {
		String email = SecurityContextHolder.getContext().getAuthentication().getName();
		return getUserByEmail(email);
		// return userRepository.findOne(1);
	}

	public List<String> getRoles(String email) {
		//User user = getUserByEmail(email);
		// List<String> roles = new ArrayList<String>();
		// for (Role role : user.getRoles()) {
		// roles.add(role.getName());
		// }
		//
		// return roles;
		return userRepository.findRolesByEmail(email);
	}

	public boolean isDoctor(String email) {
		return getRoles(email).contains("ROLE_DOCTOR");
	}

	public boolean isAdmin(String email) {
		return getRoles(email).contains("ROLE_ADMIN");
	}

	public void assignUserToRole(int userid, String role) {
		Role newRole = roleRepository.findByName(role);
		System.out.println("role: "+ newRole.getName());
		User user = getUserById(userid);
		user.getRoles().clear();
		userRepository.save(user);
		user.setRoles(Arrays.asList(newRole));
		userRepository.save(user);
	}
	
	public void fb(String name, String email, String pic) {
		User user = userRepository.findByEmail(email);
		if (user == null) {
			user = new User();
			user.setEmail(email);
			user.setDisplayName(name);
			user.setPassword("fb");
			user.setIcon(pic);
		}

		userRepository.save(user);
	}

	public void saveUser(User user) { 
		userRepository.save(user);
	}

	public void deleteUser(int id) { 
		userRepository.delete(id);
	}
}