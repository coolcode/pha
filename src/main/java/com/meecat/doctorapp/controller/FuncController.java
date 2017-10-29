package com.meecat.doctorapp.controller;


import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

//import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@Transactional
@RequestMapping("/func")
public class FuncController {

	@GetMapping("/endUserFunc")
	public String index(Model model) {
		return "func/endUserFunc";
	}

	@GetMapping("/doctorFunc")
	public String index2(Model model) {
		return "func/doctorFunc";
	}

	@GetMapping("/techniclaTeamFunc")
	public String index3(Model model) {
		return "func/technicalTeamFunc";

	}
}
