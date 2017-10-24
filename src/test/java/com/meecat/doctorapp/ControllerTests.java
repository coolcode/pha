package com.meecat.doctorapp;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.meecat.doctorapp.controller.ScriptController;
import com.meecat.doctorapp.security.SecurityConfig;
import com.fasterxml.jackson.databind.ObjectMapper;
 

@RunWith(SpringRunner.class)  
@ContextConfiguration(classes={DoctorappApplication.class, SecurityConfig.class})
@WebMvcTest(ScriptController.class)
public class ControllerTests { 

    @Autowired
    private MockMvc mockMvc;
 

    @Test
    public void testScriptController() throws Exception {  
    	mockMvc.perform(
    		get("/script?patient=1"))                
    		   .andExpect(status().isOk()) ; 
    }

}

