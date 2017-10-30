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
import com.meecat.doctorapp.domain.HealthReport;
 


@Service 
public class HealthReportService { 

	@Autowired
	private HealthReportDao hpDao; 

	@Autowired
	private UserRepository userRepository;

	private static final Logger logger = LoggerFactory.getLogger(HealthReportService.class); 

	public List<HealthReport> listHealthReports() { 
		return hpDao.list();
	}
	
	public HealthReport saveHealthReport(HealthReport hp) {
		hpDao.save(hp);
		return hp;
	}

	public HealthReport getHealthReport(int id) {
		return hpDao.get(id); 
	}
	
	public void deleteHealthReport(int id) {
		hpDao.delete(id); 
	} 
	
	public HealthReport searchHealthReport(String title) { 
		String content = "";
		try {
			Mediawiki hp = new Mediawiki("https://en.wikipedia.org");
			Login login = hp.login("doctor_online", "elec5619");
			logger.info("hp login: "+ login.getResult());  
			content = hp.getPageHtml(title); 
			 
		} catch (Exception e) { 
			//e.printStackTrace();
			logger.error("hp error: "+ e.getMessage());  
			content = "Error: " +  e.getMessage();
		}
		
        HealthReport r = new HealthReport();
        r.setContent(content);
		return r;
	}
	
	public List<HealthReport> getNewestHealthReports(int count){
		return hpDao.top(count);
	}
	

	public List<HealthReport> getMyHealthReports(String email) { 
		List<HealthReport> filterhps = new ArrayList<HealthReport>();
		List<HealthReport> hps = listHealthReports();
		for(HealthReport hp :hps){
			if(email.equalsIgnoreCase(hp.getUser().getEmail())){
				filterhps.add(hp);
			}
		}
		return filterhps;
	}
	
	
	
}