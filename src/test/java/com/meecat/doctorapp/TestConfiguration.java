package com.meecat.doctorapp;

import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

import com.meecat.doctorapp.dao.ScriptDao;
import com.meecat.doctorapp.domain.Script;

@Profile("test")
@Configuration
public class TestConfiguration {
	
    @Bean
    @Primary
    public ScriptDao scriptDao() {
    	ScriptDao dao =  Mockito.mock(ScriptDao.class);

        Mockito.when(dao.get(1)).thenReturn(new Script());
   
    	return dao;
    }
    
 
}
