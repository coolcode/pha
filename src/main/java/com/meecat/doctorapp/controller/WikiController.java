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
@RequestMapping("/wiki")
public class WikiController {
	
	private static final Logger logger = LoggerFactory.getLogger(WikiController.class); 

	@Autowired
	private UserService userService;

	@Autowired
	private WikiService wikiService;

	@GetMapping("")
	public String index(Model model) {
		logger.info("wiki"); 
		model.addAttribute("currentUser", userService.getCurrentUser() );		 
		
		return "wiki";
	} 	

	@GetMapping("/{id}")
	public String wiki(@PathVariable("id") int id, Model model) {
		Wiki wiki = wikiService.getWiki(id);
		model.addAttribute("wiki", wiki );
		model.addAttribute("currentUser", userService.getCurrentUser() );
		
		return "wiki-detail";
	} 
	
}
