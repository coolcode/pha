package com.meecat.doctorapp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@Transactional
@RequestMapping("/script")
public class ScriptController {
	
	private static final Logger logger = LoggerFactory.getLogger(ScriptController.class); 


	@GetMapping("")
	public String index(@RequestParam(name="patient") int patient, Model model) { 
		model.addAttribute("patient", patient);		 
		logger.info("script/index"); 
		
		return "script";
	} 	

	@GetMapping("/{id}")
	public String script_detail(@PathVariable(name="id") int id, Model model) { 
		model.addAttribute("scriptId", id);		 
		
		return "script-detail";
	} 	
}
