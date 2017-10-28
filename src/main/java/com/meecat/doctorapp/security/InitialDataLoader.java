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

		List<Privilege> adminPrivileges = Arrays.asList(readPrivilege, writePrivilege);
		createRoleIfNotFound("ROLE_ADMIN", adminPrivileges);
		createRoleIfNotFound("ROLE_USER", Arrays.asList(readPrivilege));

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