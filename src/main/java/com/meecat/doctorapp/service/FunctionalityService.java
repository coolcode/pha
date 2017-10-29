package com.meecat.doctorapp.service;
//import static org.junit.Assert.assertNotNull;
//import static org.mockito.Matchers.anyString;

import com.meecat.doctorapp.dao.AnnouncementDao;
import com.meecat.doctorapp.dao.FunctionalityDao;
import com.meecat.doctorapp.dao.UserRepository;
import com.meecat.doctorapp.domain.Announcement;
import com.meecat.doctorapp.domain.Functionality;
import com.meecat.doctorapp.domain.User;
import com.sendgrid.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service 
public class FunctionalityService {
	private static final Logger logger = LoggerFactory.getLogger(FunctionalityService.class);
	
	@Autowired
	private FunctionalityDao functionalityDao;

	@Autowired
	private UserRepository userRepository;
	
//	public List<Functionality> getList() {
//		return functionalityDao.getList();
//	}

	public List<Functionality> getEndUserFuncList(){
		return functionalityDao.getEndUserFuncList(1024);
	}

	public List<Functionality> getDoctorFuncList(){
		return functionalityDao.getDoctorFuncList(1024);
	}

	public List<Functionality> getTechnicalTeamFuncList(){
		return functionalityDao.getTechnicalTeamFuncList(1024);
	}

	public Functionality getFunc(int id) {
		Functionality functionality  = functionalityDao.getFunctionality(id);
		return functionality;
	}
	
	public void deleletFunc(int fId) {
		functionalityDao.delete(fId);
	}
	
	public void saveFunc(Functionality f) {
		functionalityDao.save(f);
	}
} 



