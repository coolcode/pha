package com.meecat.doctorapp.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletResponse;

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
	UserService userService;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class); 

	@GetMapping("/")
	public String home() {
		logger.info("Welcome home! ");
		return "home";
	}


	@GetMapping("/login")
	public String login(Model model, 
			@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout){
		if (error != null) {
			model.addAttribute("error", "Invalid username and password!");
		}
		if (logout != null) {
			model.addAttribute("msg", "You've been logged out successfully.");
		}
		return "login";		
	}
	

	@GetMapping("/facebook_callback")
	public String facebook_callback(HttpServletResponse response, Model model, 
			@RequestParam(name = "name") String name,
			@RequestParam(name = "email") String email, 
			@RequestParam(name = "id") String id) {
		logger.info("facebook: {}.", model);

		String pic = "http://graph.facebook.com/" + id + "/picture?type=square";
		userService.fb(name, email, pic);

		//saveLoginSession(response);

		return "redirect:/";
	}
}
