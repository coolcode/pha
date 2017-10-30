package com.meecat.doctorapp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
 
import com.meecat.doctorapp.domain.*;

public interface DailyIntakeRepository extends JpaRepository<DailyIntake, Integer> {

	  @Query(value = "select u.* from DailyIntake u where u.userId = ?1", nativeQuery = true)
	  List<DailyIntake> findByUserId(int userId); 
	  
 
}
