package com.meecat.doctorapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

import com.meecat.doctorapp.dao.*;
import com.meecat.doctorapp.domain.*;

@Service
public class UserService {

	@Autowired
	private UserDao userDao;

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
		return userDao.get(id);
	}
	public User getUserByEmail(String email) {
		return userDao.getUserByEmail(email);
	}
	
	public User getCurrentUser() {
		return userDao.get(1);
	}
	
	
	public boolean ifUserisDoctor(int id) {
		List<Role> roles = userDao.getRolesByUserId(id);
		boolean ifUerisDoctor = false;
		for(int a = 0; a < roles.size();a++) {
			String name = roles.get(a).getName();
			if (name == "doctor") {
				ifUerisDoctor = true;
			}			
		}
		return ifUerisDoctor;
	}

	
	public void createDemoDoctor() {

		User user = new User();
		user.setEmail("e@test1.com");
		user.setPassword("test");
		user.setVerification(0);
		Role role = new Role();
		role.setName("doctor");

		user.getRoles().add(role);

		userDao.save(user);
	}

	public void createDemoPatient() {

		User user = new User();
		user.setEmail("e@test1.com");
		user.setPassword("test");
		user.setDisplayName("xiaozhou");
		user.setVerification(1);
		Role role = new Role();
		role.setName("patient");

		user.getRoles().add(role);

		userDao.save(user);
	}



	public void fb(String name, String email, String pic) {
		User user= userDao.getUserByEmail(email);
		if(user==null){
			user = new User();
			user.setEmail(email);
			user.setDisplayName(name);
			user.setPassword("fb");
			user.setIcon(pic);
		}
		
		userDao.save(user);
	}

}