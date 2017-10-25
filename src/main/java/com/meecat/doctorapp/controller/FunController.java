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

@Controller
@Transactional
@RequestMapping("/fun")
public class FunController {

	@GetMapping("/index")
	public String index(Model model) {
		return "fun/index";
	
	}

	@GetMapping("/index2")
	public String index2(Model model) {
		return "fun/index2";
	
	}
	
}
