package com.meecat.doctorapp.service;

import java.util.ArrayList;
import java.util.List;

import org.aspectj.weaver.ast.Var;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitplan.mediawiki.japi.Mediawiki;
import com.bitplan.mediawiki.japi.api.Login; 
import com.meecat.doctorapp.dao.*;
import com.meecat.doctorapp.domain.DailyIntake;
import com.meecat.doctorapp.domain.User;
 


@Service 
public class DailyIntakeService { 

	@Autowired
	private DailyIntakeRepository dailyIntakeRepository; 

	@Autowired
	private UserRepository userRepository;

	private static final Logger logger = LoggerFactory.getLogger(DailyIntakeService.class); 

	public List<DailyIntake> listDailyIntakes() { 
		return dailyIntakeRepository.findAll();
	}
	
	public DailyIntake saveDailyIntake(DailyIntake hp) {
		dailyIntakeRepository.save(hp);
		return hp;
	}

	public DailyIntake getDailyIntake(int id) {
		return dailyIntakeRepository.findOne(id); 
	}
	
	public void deleteDailyIntake(int id) {
		dailyIntakeRepository.delete(id); 
	}  

	public List<DailyIntake> getMyDailyIntakes(String email) { 
		User user= userRepository.findByEmail(email);

		return dailyIntakeRepository.findByUserId(user.getId());
	}
	
	
	
}