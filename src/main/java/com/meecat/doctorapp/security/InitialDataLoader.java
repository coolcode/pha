package com.meecat.doctorapp.security;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.meecat.doctorapp.dao.*;
import com.meecat.doctorapp.domain.*;

@Component
public class InitialDataLoader implements ApplicationListener<ContextRefreshedEvent> {

	boolean alreadySetup = false;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private PrivilegeRepository privilegeRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	@Transactional
	public void onApplicationEvent(ContextRefreshedEvent event) {

		if (alreadySetup)
			return;

		Privilege readPrivilege = createPrivilegeIfNotFound("READ_PRIVILEGE");
		Privilege writePrivilege = createPrivilegeIfNotFound("WRITE_PRIVILEGE");
		Privilege doctorPrivilege = createPrivilegeIfNotFound("DOCTOR_PRIVILEGE");
 
		createRoleIfNotFound("ROLE_ADMIN", Arrays.asList(readPrivilege, writePrivilege));
		createRoleIfNotFound("ROLE_USER", Arrays.asList(readPrivilege));
		createRoleIfNotFound("ROLE_DOCTOR", Arrays.asList(doctorPrivilege));

		Role adminRole = roleRepository.findByName("ROLE_ADMIN");
		List<User> users = userRepository.findAll();
		for (User user : users) {
			if (user.getId() < 16) {
				// user.setDisplayName("Bruce Lee");
				user.setPassword(passwordEncoder.encode("test"));
				// user.setEmail("test@test.com");
				//user.setRoles(Arrays.asList(adminRole));
				userRepository.save(user);
			}
		}

		Role doctorRole = roleRepository.findByName("ROLE_DOCTOR");
		User user = userRepository.findByEmail("doctor@test.com");
		if (user == null) {
			user = new User();
			user.setEmail("doctor@test.com");
			user.setDisplayName("Dr. Meerkat");
			user.setPassword(passwordEncoder.encode("test"));
			user.setIcon("http://res.cloudinary.com/yopo/image/upload/t_icon/v1506154115/doctoronline/pitt.jpg");
			user.setRoles(Arrays.asList(doctorRole));
			userRepository.save(user);
		}
		
		alreadySetup = true;
	}

	@Transactional
	private Privilege createPrivilegeIfNotFound(String name) {

		Privilege privilege = privilegeRepository.findByName(name);
		if (privilege == null) {
			privilege = new Privilege();
			privilege.setName(name);
			privilegeRepository.save(privilege);
		}

		return privilege;
	}

	@Transactional
	private Role createRoleIfNotFound(String name, List<Privilege> privileges) {

		Role role = roleRepository.findByName(name);
		if (role == null) {
			role = new Role();
			role.setName(name);
			role.setPrivileges(privileges);
			roleRepository.save(role);
		}
		return role;
	}
}