package com.meecat.doctorapp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@Transactional
@RequestMapping("/map")
public class MapController {
	
	private static final Logger logger = LoggerFactory.getLogger(MapController.class);  
	
	@GetMapping("")
	public String index(Model model) {  
		logger.info("map");
		return "map";
	} 		
 
}
