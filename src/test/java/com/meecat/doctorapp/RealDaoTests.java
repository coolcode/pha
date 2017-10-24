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
@AutoConfigureTestDatabase(replace = Replace.NONE)  
public class RealDaoTests {

    @Autowired
    private TestEntityManager entityManger;
    
	@Autowired
	private UserDao userDao;

	@Test
	public void userDaoTest() {
		String email = "coolcode@live.com";
		User user = new User();
		user.setEmail(email);
		user.setPassword("password");
		entityManger.persist(user);

        userDao.save(user);
        System.out.println(user.getEmail());
		
		List<User> users = userDao.list(); 		
		assertThat(users.size()).isGreaterThan(0);
		
        User newUser = userDao.getUserByEmail(email);
        assertThat(newUser).isNotNull();
        assertThat(newUser.getEmail()).isEqualTo(email);

		entityManger.flush();
        System.out.println("end");
	}

}

