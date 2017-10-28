package com.meecat.doctorapp.restcontroller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import com.meecat.doctorapp.domain.*;
import com.meecat.doctorapp.service.*;

@RestController()
@Transactional
@RequestMapping("/api/wiki")
public class WikiRestController {

	@Autowired
	private UserService userService;

	@Autowired
	private WikiService wikiService;
	
	@GetMapping("")
	public List<Wiki> getWikis() {
		return wikiService.listWikis();
	}

	@PostMapping("")
	public Wiki saveWiki(@RequestBody Wiki wiki) {
		wiki.setCreateUser(userService.getCurrentUser());
		wikiService.saveWiki(wiki);
		return wiki;
	}

	@DeleteMapping("/{id}")
	public void deleteWiki(@PathVariable("id") int id) {
		wikiService.deleteWiki(id); 
	}	

	@GetMapping("/{id}")
	public Wiki getWiki(@PathVariable("id") int id) {
		return wikiService.getWiki(id); 
	}	

	@PostMapping("/search")
	public Wiki searchWiki(@RequestBody Wiki wiki) { 
		return wikiService.searchWiki(wiki.getTitle()); 
	}

	@GetMapping("/top/{n}")
	public List<Wiki> getWikis(@PathVariable("n") int n) {
		return wikiService.getNewestWikis(5);
	}
}
