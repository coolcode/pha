package com.meecat.doctorapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

import com.meecat.doctorapp.dao.*;
import com.meecat.doctorapp.domain.*;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public Boolean authenticate(String email, String password) {
		return true ;
//		User user = userDao.getUserByEmail(email);
//		if (user == null) {
//			return false;
//		}
//
//		return password.equals(user.getPassword());
	}
	

	public User getUserById(int id){
		return userRepository.findOne(id);
	}
	public User getUserByEmail(String email) {
		return userRepository.findByEmail(email);
	}
	
	public User getCurrentUser() {
		return userRepository.findOne(1);
	}	 

	public void fb(String name, String email, String pic) {
		User user= userRepository.findByEmail(email);
		if(user==null){
			user = new User();
			user.setEmail(email);
			user.setDisplayName(name);
			user.setPassword("fb");
			user.setIcon(pic);
		}
		
		userRepository.save(user);
	}

}