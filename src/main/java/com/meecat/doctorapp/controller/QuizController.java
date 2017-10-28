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
@RequestMapping("/quiz")
public class QuizController {

	@GetMapping("/quiz_user")
	public String index(Model model) {
		return "quiz/quiz_user";
	
	}

	@GetMapping("/quiz_doctor")
	public String index2(Model model) {
		return "quiz/quiz_doctor";
	
	}
	@GetMapping("/quizContent")
	public String index3(Model model) {
		return "quiz/quizContent";
	
	}
	
}
