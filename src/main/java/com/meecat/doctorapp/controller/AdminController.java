package com.meecat.doctorapp.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.meecat.doctorapp.domain.Announcement;
import com.meecat.doctorapp.domain.User;
import com.meecat.doctorapp.param.UserLoginParam;
import com.meecat.doctorapp.service.UserService;

@Controller
@Transactional
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	UserService userService;

	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);
 

	@RequestMapping("/user/list")
	public String list(Model model) {
		return "/admin/user/list";
	}	 
	

//	@GetMapping("/logout")
//	public String logout(HttpServletResponse response) { 
//		Cookie newCookie = new Cookie("login", "false");
//		newCookie.setMaxAge(24 * 60 * 60);
//		response.addCookie(newCookie);
//		logger.info("logout");
//		return "redirect:/user/login";
//	}	 

}