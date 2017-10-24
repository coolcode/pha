package com.meecat.doctorapp.restcontroller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
 
import com.meecat.doctorapp.domain.*; 
import com.meecat.doctorapp.service.*;

@RestController()
@Transactional
@RequestMapping("/api/script")
public class ScriptRestController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private ScriptService scriptService; 
	
	@GetMapping("/medicines")
	public List<Medicine> getAllMedicines() {
		return scriptService.getAllMedicines();
	} 
	
	@PostMapping("")
	public Script saveScript(@RequestBody Script script) {
		 script.setDoctor(userService.getCurrentUser());
		 User patient = new User();
		 patient = userService.getUserById(3);
		 script.setPatient(patient);
		 scriptService.saveScript(script);
		 return script;
	}	

	@GetMapping("/{id}")
	public Script getScript(@PathVariable("id") int id) {
		return scriptService.getScript(id);
	} 
	
	@GetMapping("/{id}/medicines")
	public List<Medicine> getMedicines(@PathVariable("id") int id) {
		return scriptService.getMedicinesByScriptId(id);
	} 
}
