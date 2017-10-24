package com.meecat.doctorapp;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import javax.persistence.EntityManager;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.meecat.doctorapp.domain.*;
import com.meecat.doctorapp.security.SecurityConfig;
import com.meecat.doctorapp.dao.*;
 

@RunWith(SpringRunner.class) 
@DataJpaTest
//@AutoConfigureTestDatabase(replace = Replace.NONE) 
//@Transactional(propagation = Propagation.NOT_SUPPORTED)
public class DaoTests {

    @Autowired
    private TestEntityManager entityManger;
 
    @MockBean
	private ScriptDao  scriptDao;

	@Test
	public void scriptDaoTest() { 
		Script script =  scriptDao.get(1);
		assertThat(script).isNull();  
	}

}

