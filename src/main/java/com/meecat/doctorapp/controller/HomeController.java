package com.meecat.doctorapp.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.meecat.doctorapp.service.UserService;  


@Controller
@Transactional
public class HomeController {
	
	@Autowired
	UserService u;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class); 

	@GetMapping("/")
	public String home(Locale locale, Model model, @CookieValue(value = "login",
            defaultValue = "false")
				 String login) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("message", formattedDate );
		

//		u.createDemoPatient();
		
		if(!"true".equalsIgnoreCase(login)){
			//return "redirect:/user/login";
		}
		
		System.out.println("123456");
		return "home";
	}


	@GetMapping("/login")
	public String login(){
		return "login";		
	}
}
