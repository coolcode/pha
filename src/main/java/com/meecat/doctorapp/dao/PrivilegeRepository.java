package com.meecat.doctorapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.meecat.doctorapp.domain.*;

public interface PrivilegeRepository extends JpaRepository<Privilege, Integer> { 

	Privilege findByName(String name);
}
