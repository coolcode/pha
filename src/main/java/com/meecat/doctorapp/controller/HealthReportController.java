package com.meecat.doctorapp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import com.meecat.doctorapp.service.*;
import com.meecat.doctorapp.domain.*;


@Controller
@Transactional
@RequestMapping("/health-report")
public class HealthReportController {
	
	private static final Logger logger = LoggerFactory.getLogger(HealthReportController.class); 

	@Autowired
	private UserService userService;

	@Autowired
	private HealthReportService hpService;

	@GetMapping("")
	public String index(Model model) {
		logger.info("health-report"); 
		model.addAttribute("currentUser", userService.getCurrentUser() );		 
		
		return "health-report/health-report";
	} 	

	@GetMapping("/{id}")
	public String detail(@PathVariable("id") int id, Model model) {
		HealthReport report = hpService.getHealthReport(id);
		model.addAttribute("report", report );
		model.addAttribute("currentUser", userService.getCurrentUser() );
		
		return "health-report/health-report-detail";
	} 
	
}
