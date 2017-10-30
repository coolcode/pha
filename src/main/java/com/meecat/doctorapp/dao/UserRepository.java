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
	  

	  @Query(value="select * from User u where not exists(select * from UserRole ur inner join Role r on(ur.roleId = r.id and (r.name='ROLE_DOCTOR' OR r.name='ROLE_ADMIN')) where ur.userId = u.id)", nativeQuery = true)
	  List<User> findUsers();
}
