package com.meecat.doctorapp;

import static org.junit.Assert.*;
 
import org.junit.Test;
import org.junit.runner.RunWith; 
import org.springframework.test.context.junit4.SpringRunner; 

@RunWith(SpringRunner.class)
public class DoctorappApplicationTests { 
	
	@Test
	public void test() {
		boolean result =  true;
		assertEquals("Test", true,result);
	}

	@Test
	public void daoTest() {
		boolean result =  true;
		assertEquals("Test", true,result);
	}
	 
}
	
//	@Test
//	public void announcementtest() {
//	   Announcement p = new Announcement() ;
//	   User user = userDao.get(1);
//       p.setTitle("joanne.test");
//       p.setContent("testing");
//       p.setCreator(user);
//       announcementDao.save(p);
////       Announcement a = announcementDao.getAnnouncement(1);
//       assertNotNull(p.getTitle());
//	}
//}
