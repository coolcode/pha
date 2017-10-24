package com.meecat.doctorapp.restcontroller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import com.meecat.doctorapp.dao.*;
import com.meecat.doctorapp.domain.*;
import com.meecat.doctorapp.service.UserService; 

@RestController()
@Transactional
@RequestMapping("/api/message")
public class MessageRestController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private MessageDao msgDao;

	@GetMapping("/chat_users")
	public List<User> getChatUsers() {
		return msgDao.getChatUsers(userService.getCurrentUser());
	}
	
	@GetMapping()
	public List<Message> getMessages(@RequestParam(name="chat_user_id") int chat_user_id) {
		return msgDao.getMessages(chat_user_id, userService.getCurrentUser());
	}

	@PostMapping()
	public Message sendMessage(@RequestBody Message msg) {
    	msg.setSender(userService.getCurrentUser());
    	
		return msgDao.sendMessage(msg);
	}
}
