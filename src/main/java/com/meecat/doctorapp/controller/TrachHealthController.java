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




//Main controller of the Announcement page and Announcement detail page.
@Controller
@Transactional
@RequestMapping("/TrackHealth")
public class TrachHealthController {

	@GetMapping("/")
	public String TrackHealth(Model model) {
		return "TrackHealth/TrackHealth";
	
	}

	@GetMapping("/input")
	public String InputIntake(Model model) {
		return "TrackHealth/InputIntake";
	
	}
	
	@GetMapping("/result")
	public String ViewAnalyzeResult(Model model) {
		return "TrackHealth/ViewAnalyzeResult";
	
	}
	
	@GetMapping("/history")
	public String ViewHistroy(Model model) {
		return "TrackHealth/ViewHistory";
	
	}
}
