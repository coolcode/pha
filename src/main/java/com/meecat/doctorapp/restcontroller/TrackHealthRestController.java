package com.meecat.doctorapp.restcontroller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import com.meecat.doctorapp.domain.*;
import com.meecat.doctorapp.service.*;

@RestController()
@Transactional
@RequestMapping("/api/TrackHealth")
public class TrackHealthRestController {

	@Autowired
	private UserService userService;

	@Autowired
	private TrackHealthService TrackhealthService;
	
	@GetMapping("")
	public List<TrackHealth> getTrackHealth() {
		return TrackhealthService.listTrackHealth();
	}

}
