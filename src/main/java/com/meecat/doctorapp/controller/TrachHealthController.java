package com.meecat.doctorapp.controller;



import java.time.LocalDateTime;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;  


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.meecat.doctorapp.domain.*;
//import org.springframework.web.bind.annotation.RequestMethod;
import com.meecat.doctorapp.service.*;




//Main controller of the Announcement page and Announcement detail page.
@Controller
@Transactional
@RequestMapping("/TrackHealth")
public class TrachHealthController {

	private static final Logger logger = LoggerFactory.getLogger(TrachHealthController.class); 
	
	@Autowired
	TrackHealthService track;
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/")
	public String TrackHealth(Model model) {
		return "TrackHealth/TrackHealth";
	
	}

	@GetMapping("/input")
	public String InputIntake(Model model) {
		return "TrackHealth/InputIntake";
	
	}
	
	@PostMapping("/input")
	public String ProcessInput(Model model, @RequestParam String foodType, @RequestParam String quantity ) {
		TrackHealth trackhealth = new TrackHealth();
		trackhealth.setCreateDate(LocalDateTime.now());
		trackhealth.setFoodType(foodType);
		trackhealth.setContent(quantity);
		trackhealth.setCreateUser(userService.getCurrentUser());
		track.save(trackhealth);
		return ("redirect:/TrackHealth/");
	}
	
	@GetMapping("/result")
	public String ViewAnalyzeResult(Model model) {
		
		return "TrackHealth/ViewAnalyzeResult";
	
	}
	
	@GetMapping("/history")
	public String ViewHistroy(Map<String,Object> map) {
		List<TrackHealth> a = new ArrayList<TrackHealth>();
//		a = track.listTrackHealth();
		
		TrackHealth test = new TrackHealth();
		test.setFoodType("apple");
		test.setContent("100");
		
		a.add(test);
		
//		model.addAttribute("a",test);
		map.put("users", a); 
		return "TrackHealth/ViewHistory";
	
	}
}
