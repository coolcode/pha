package com.meecat.doctorapp.restcontroller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import com.meecat.doctorapp.domain.*;
import com.meecat.doctorapp.service.*;


@RestController()
@Transactional
@RequestMapping("/api/medicine")
public class MedicineRestController {

	@Autowired
	private UserService userService;

	@Autowired
	private MedicineService medicineService;
	
	@GetMapping("")
	public List<Medicine> getList() {
		return medicineService.getList();
	}

	
	@PostMapping("")
	public Medicine save(@RequestBody Medicine medicine) {
		medicineService.save(medicine);
		return medicine;
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") int id) {
		medicineService.delelet(id); 
	}	
	
}
