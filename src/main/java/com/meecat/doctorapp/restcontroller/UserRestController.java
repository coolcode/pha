package com.meecat.doctorapp.restcontroller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.security.Principal;
import java.util.*;
 
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriUtils;

import com.meecat.doctorapp.dao.*;
import com.meecat.doctorapp.domain.*; 
import com.meecat.doctorapp.service.UserService;

@RestController()
@Transactional
@RequestMapping("/api/user")
public class UserRestController {

	@Autowired
	private UserService userService;
	
	@GetMapping("")
	public List<User> getUsers() {
		return userService.getAllUsers();
	}

	@GetMapping("/simpleUsers")
	public List<User> simpleUsers() {
		return userService.findUsers();
	}
	
	@PostMapping
	public User saveUser(@RequestBody User user) {
		userService.saveUser(user);
		return user;
	}

	@DeleteMapping("/{id}")
	public void deleteUser(@PathVariable("id") int id) {
		userService.deleteUser(id); 
	}	

	@GetMapping("/{id}")
	public User getWiki(@PathVariable("id") int id) {
		return userService.getUserById(id); 
	}	

	@GetMapping("/current")
	public User getCurrentUser(Principal principal) {
	      String email = principal.getName(); 
	      return userService.getUserByEmail(email);
	}
	 
	@GetMapping( value = "/current/icon",
			  produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
	public @ResponseBody byte[]  getCurrentUserIcon(Principal principal) throws IOException {
	      String email = principal.getName(); 
	      String url= userService.getUserByEmail(email).getIcon();
	      URL u = new URL(url);
	      ByteArrayOutputStream baos = new ByteArrayOutputStream();
	      InputStream isx = null;
	      try {
	        isx = u.openStream ();
	        byte[] byteChunk = new byte[4096]; // Or whatever size you want to read in at a time.
	        int n;

	        while ( (n = isx.read(byteChunk)) > 0 ) {
	          baos.write(byteChunk, 0, n);
	        }
	      }
	      catch (IOException e) {
	        System.err.printf ("Failed while reading bytes from %s: %s", u.toExternalForm(), e.getMessage());
	        e.printStackTrace ();
	        // Perform any other exception handling that's appropriate.
	      }
	      finally {
	        if (isx != null) { isx.close(); }
	      }
	      
	      return baos.toByteArray();
	}
	
	@GetMapping("/myroles")
	public List<String> roles(Principal principal) { 
	      String email = principal.getName(); 
	      return userService.getRoles(email);
	}

	@GetMapping("/roles")
	public List<String> roles(@RequestParam(name="email") String email) {  
	      return userService.getRoles(email);
	}
	
	@PostMapping("/roles/{id}")
	public List<String> assignUserToRole(@PathVariable("id") int id, @RequestBody Role role) {  
	       userService.assignUserToRole(id, role.getName());
	       String email = userService.getUserById(id).getEmail();
		   return userService.getRoles(email);
	}
}
