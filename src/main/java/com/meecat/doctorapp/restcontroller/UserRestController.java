package com.meecat.doctorapp.restcontroller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import com.meecat.doctorapp.dao.*;
import com.meecat.doctorapp.domain.*; 
import com.meecat.doctorapp.service.UserService;

@RestController()
@Transactional
@RequestMapping("/api/user")
public class UserRestController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("")
	public List<User> getUsers() {
		return userRepository.findAll();
	}

	@GetMapping("/current")
	public User getCurrentUser() {
		return userService.getCurrentUser();
	}
	
}
