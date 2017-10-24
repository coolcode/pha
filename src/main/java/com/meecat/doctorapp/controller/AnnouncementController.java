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
@RequestMapping("/announcement")
public class AnnouncementController {
	
	private static final Logger logger = LoggerFactory.getLogger(AnnouncementController.class); 

	@Autowired
	private UserService userService;


	@Autowired
	private AnnouncementService announcementService;

	@GetMapping("")
	public String index(Model model) {
		logger.info("announcement"); 
		User currentUser = userService.getCurrentUser();
		model.addAttribute("currentUser", currentUser);	
		model.addAttribute("ifUserisDoctor", userService.ifUserisDoctor(currentUser.getId()));
//		Announcement p = new Announcement();
//		announcementDao.save(p);
		return "announcement";
	
	}
	
	@GetMapping("/{id}")
	public String announcement(@PathVariable("id") int id, Model model) {		
		model.addAttribute("announcement", announcementService.getANMT(id));
		model.addAttribute("currentUser", userService.getCurrentUser() );
		
		return "announcementdetail";
	} 
	
//    @RequestMapping(value = "", method = RequestMethod.POST)
//    public String hibernateAdd(Locale locale, Model model) {
//    	public String hibernateAdd(HttpServletRequest httpServletRequest)  {  
//        Announcement p = new Announcement();
//        p.setTitle("joanne.test");
//        p.setContent("testing");
//        p.setCreator(userService.getCurrentUser());

//        announcementService.saveANMT(p);
//        return "redirect:/announcement";
////    }
}
