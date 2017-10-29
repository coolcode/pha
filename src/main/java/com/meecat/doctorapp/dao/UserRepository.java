package com.meecat.doctorapp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.meecat.doctorapp.domain.Role;
import com.meecat.doctorapp.domain.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	  @Query("select u from User u where u.email = ?1")
	  User findByEmail(String email);

	  @Query(value="select r.name from UserRole ur inner join (Role r, User u) on(ur.roleId = r.id  and ur.userId = u.id) where u.email = ?1", nativeQuery = true)
	  List<String> findRolesByEmail(String email);
}
