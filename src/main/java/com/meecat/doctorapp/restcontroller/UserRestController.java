package com.meecat.doctorapp.restcontroller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import com.meecat.doctorapp.dao.UserDao;
import com.meecat.doctorapp.domain.Role;
import com.meecat.doctorapp.domain.User;
import com.meecat.doctorapp.service.UserService;

@RestController()
@Transactional
@RequestMapping("/api/user")
public class UserRestController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private UserDao userDao;
	
	@GetMapping("")
	public List<User> getUsers() {
		return userDao.list();
	}

	@GetMapping("/roles")
	public List<Role> getRoles() {
		return userDao.getRolesByUserId(3);
	}	

	@GetMapping("/current")
	public User getCurrentUser() {
		return userService.getCurrentUser();
	}
	
	@PostMapping("/login")
	public User save(@RequestBody User user) {
		//userService.saveUser(user);
		return user;
	}
}
