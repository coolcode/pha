package com.meecat.doctorapp;
 
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*; 
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


import org.aspectj.lang.annotation.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.meecat.doctorapp.controller.ScriptController;
import com.meecat.doctorapp.domain.Post;
import com.meecat.doctorapp.domain.Script;
import com.meecat.doctorapp.restcontroller.ScriptRestController;
import com.meecat.doctorapp.security.SecurityConfig;
import com.meecat.doctorapp.service.ScriptService;
import com.meecat.doctorapp.service.UserService;

import static org.mockito.BDDMockito.*;
 

@RunWith(SpringRunner.class) 
@ContextConfiguration(classes={DoctorappApplication.class, SecurityConfig.class})
//@WebMvcTest(ScriptRestController.class) 
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
public class RestControllerTests { 
     
    @Autowired
	private TestRestTemplate restTemplate;
    
    @Test
	public void testScriptRestController() throws Exception{      
    	Script body =  restTemplate.getForObject("/api/script/1", Script.class);
		assertNotNull(body);
		assertThat(body.getId()).isEqualTo(1);
	}

	@Test
	public void testForumRestController() {
		ResponseEntity<Post[]> resp = restTemplate.getForEntity("/api/forum/posts",  Post[].class);
		Post[] body  = resp.getBody();
		assertThat(body.length).isGreaterThan(0);
	}

}



//@MockBean
//private ScriptService scriptService; 
//
//@MockBean
//private UserService userService;

//Script s = new Script();
//s.setId(1);
//
//given(scriptService.getScript(1)).willReturn(s);

