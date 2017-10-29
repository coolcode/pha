package com.meecat.doctorapp.restcontroller;

import java.security.Principal;
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
	
	@GetMapping("")
	public List<User> getUsers() {
		return userService.getAllUsers();
	}

	@PostMapping
	public User saveUser(@RequestBody User user) {
		userService.saveUser(user);
		return user;
	}

	@DeleteMapping("/{id}")
	public void deleteUser(@PathVariable("id") int id) {
		userService.deleteUser(id); 
	}	

	@GetMapping("/{id}")
	public User getWiki(@PathVariable("id") int id) {
		return userService.getUserById(id); 
	}	

	@GetMapping("/current")
	public User getCurrentUser(Principal principal) {
	      String email = principal.getName(); 
	      return userService.getUserByEmail(email);
	}

	@GetMapping("/myroles")
	public List<String> roles(Principal principal) { 
	      String email = principal.getName(); 
	      return userService.getRoles(email);
	}

	@GetMapping("/roles")
	public List<String> roles(@RequestParam(name="email") String email) {  
	      return userService.getRoles(email);
	}
	
	@PostMapping("/roles/{id}")
	public List<String> assignUserToRole(@PathVariable("id") int id, @RequestBody Role role) {  
	       userService.assignUserToRole(id, role.getName());
	       String email = userService.getUserById(id).getEmail();
		   return userService.getRoles(email);
	}
}
