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
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService userService;

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
 

	@RequestMapping("/list")
	public String list(Model model) {
		return "user/list";
	}
	

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView loginGET(@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout) {

		ModelAndView model = new ModelAndView();
		if (error != null) {
			model.addObject("error", "Invalid username and password!");
		}
		if (logout != null) {
			model.addObject("msg", "You've been logged out successfully.");
		}
		model.setViewName("login");
		return model;
	} 
	
	@GetMapping("/facebook_callback")
	public String facebook_callback(HttpServletResponse response, Model model, @RequestParam(name = "name") String name,
			@RequestParam(name = "email") String email, @RequestParam(name = "id") String id) {
		logger.info("facebook: {}.", model);

		String pic = "http://graph.facebook.com/" + id + "/picture?type=square";
		userService.fb(name, email, pic);

		saveLoginSession(response);

		return "redirect:/";
	}

	@GetMapping("/logout")
	public String logout(HttpServletResponse response) { 
		Cookie newCookie = new Cookie("login", "false");
		newCookie.setMaxAge(24 * 60 * 60);
		response.addCookie(newCookie);
		logger.info("logout");
		return "redirect:/user/login";
	}
	
	private void saveLoginSession(HttpServletResponse response) {
		Cookie newCookie = new Cookie("login", "true");
		newCookie.setMaxAge(24 * 60 * 60);
		response.addCookie(newCookie);
		logger.info("saveLoginSession");
	}

}