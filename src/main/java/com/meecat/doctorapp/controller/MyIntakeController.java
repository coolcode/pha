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
@RequestMapping("/my-intake")
public class MyIntakeController {
	
	private static final Logger logger = LoggerFactory.getLogger(MyIntakeController.class); 

	@Autowired
	private UserService userService; 

	@GetMapping("")
	public String index(Model model) { 
		return "user/intake";
	} 	
 
	
}
