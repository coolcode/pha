package com.meecat.doctorapp;

import static org.junit.Assert.*;

import java.util.List;

import org.aspectj.lang.annotation.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest; 
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.meecat.doctorapp.domain.*;
import com.meecat.doctorapp.service.ScriptService;
import com.meecat.doctorapp.dao.*;
 

@RunWith(SpringRunner.class)
@SpringBootTest() 
public class ServiceTests { 
 
	@Test
	public void scriptServiceTest() { 
		assertNotNull("scriptServiceTest", "");
	}

}

