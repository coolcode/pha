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

import com.meecat.doctorapp.domain.User;
//import org.springframework.web.bind.annotation.RequestMethod;
import com.meecat.doctorapp.service.*;




@Controller
@Transactional
@RequestMapping("/medicine")
public class MedicineController {
	
	private static final Logger logger = LoggerFactory.getLogger(MedicineController.class); 

	@Autowired
	private UserService userService;

	@Autowired
	private MedicineService medicineService;

	@GetMapping("")
	public String index(Model model) {
		logger.info("medicine"); 
		User currentUser = userService.getCurrentUser();
		model.addAttribute("currentUser", currentUser);	

		return "medicine";
	
	}
	
	@GetMapping("/{id}")
	public String medicine(@PathVariable("id") int id, Model model) {		
		model.addAttribute("medicine", medicineService.getMedicine(id));
		model.addAttribute("currentUser", userService.getCurrentUser() );
		
		return "medicinedetail";
	} 
	
	
}
