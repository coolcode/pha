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
@RequestMapping("/func")
public class FuncController {

	@GetMapping("/endUserFunc")
	public String endUserFunc(Model model) {
		return "functionality/endUserFunc";
	}

	@GetMapping("/doctorFunc")
	public String doctorFunc(Model model) {
		return "functionality/doctorFunc";
	}

	@GetMapping("/technicalTeamFunc")
	public String technicalTeamFunc(Model model) {
		return "functionality/technicalTeamFunc";
	}

	@GetMapping("/addFunc")
	public String addFunc(Model model) {
		return "functionality/addFunc";
	}
}
