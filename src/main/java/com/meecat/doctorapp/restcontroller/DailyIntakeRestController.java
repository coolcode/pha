package com.meecat.doctorapp.restcontroller;

import java.security.Principal;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import com.meecat.doctorapp.domain.*;
import com.meecat.doctorapp.service.*;

@RestController()
@Transactional
@RequestMapping("/api/intake")
public class DailyIntakeRestController {

	@Autowired
	private UserService userService;

	@Autowired
	private DailyIntakeService hpService;
	
	@GetMapping("/all")
	public List<DailyIntake> getDailyIntakes() {
		return hpService.listDailyIntakes();
	}

	@GetMapping("")
	public List<DailyIntake> getMyDailyIntakes(Principal principal) { 
	    String email = principal.getName(); 
		return hpService.getMyDailyIntakes(email);
	}

	@PostMapping("")
	public DailyIntake saveDailyIntake(@RequestBody DailyIntake hp) {
		hp.setUser(userService.getCurrentUser());
		hpService.saveDailyIntake(hp);
		return hp;
	}

	@DeleteMapping("/{id}")
	public void deleteDailyIntake(@PathVariable("id") int id) {
		hpService.deleteDailyIntake(id); 
	}	

	@GetMapping("/{id}")
	public DailyIntake getDailyIntake(@PathVariable("id") int id) {
		return hpService.getDailyIntake(id); 
	}	
 

}
