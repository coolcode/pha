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
@RequestMapping("/api/health-report")
public class HealthReportRestController {

	@Autowired
	private UserService userService;

	@Autowired
	private HealthReportService hpService;
	
	@GetMapping("")
	public List<HealthReport> getHealthReports() {
		return hpService.listHealthReports();
	}

	@GetMapping("/current")
	public List<HealthReport> getMyHealthReports(Principal principal) { 
	    String email = principal.getName(); 
		return hpService.getMyHealthReports(email);
	}

	@PostMapping("")
	public HealthReport saveHealthReport(@RequestBody HealthReport hp) {
		hp.setCreateUser(userService.getCurrentUser());
		hpService.saveHealthReport(hp);
		return hp;
	}

	@DeleteMapping("/{id}")
	public void deleteHealthReport(@PathVariable("id") int id) {
		hpService.deleteHealthReport(id); 
	}	

	@GetMapping("/{id}")
	public HealthReport getHealthReport(@PathVariable("id") int id) {
		return hpService.getHealthReport(id); 
	}	

	@PostMapping("/search")
	public HealthReport searchHealthReport(@RequestBody HealthReport hp) { 
		return hpService.searchHealthReport(hp.getTitle()); 
	}

	@GetMapping("/top/{n}")
	public List<HealthReport> getHealthReports(@PathVariable("n") int n) {
		return hpService.getNewestHealthReports(5);
	}
}
