package com.meecat.doctorapp.service;
//import static org.junit.Assert.assertNotNull;
//import static org.mockito.Matchers.anyString;

import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.meecat.doctorapp.dao.*;
import com.meecat.doctorapp.domain.*;
import com.sendgrid.Content;
import com.sendgrid.Email;
import com.sendgrid.Mail;
import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;

@Service 
public class AnnouncementService {
	private static final Logger logger = LoggerFactory.getLogger(AnnouncementService.class); 
	
	@Autowired
	private AnnouncementDao announcementDao;	

	@Autowired
	private UserRepository userRepository;
	
	public List<Announcement> getList() { 
		return announcementDao.getList();
	}
	
	public List<Announcement> getListbyUser(int id) { 
		return announcementDao.getOwnList(id);
	}
	
	public Announcement getAMNT(int id) {
		Announcement announcement = announcementDao.getAnnouncement(id);
		return announcement;
	}

	public void deleletANMT(int aId) {
		announcementDao.delete(aId);
	}
	
	public void saveANMT(Announcement a) {		
		announcementDao.save(a);
		//Send email which the Checkbox is selected.
		if(a.getIfSendEmail() == true) {
			sendEmailToAllUsers(a);
		}
	}
	
	public Announcement getANMT(int aID) {
		return announcementDao.getAnnouncement(aID); 
	}
	
	public void sendEmailToAllUsers(Announcement a) {
		List<User> users = userRepository.findAll();
		for (User user : users) {
			sendEmail(user.getEmail(), a.getTitle(), a.getContent() );
		}
	}
	
	private void sendEmail(String emailAddress, String title, String emailContent){
		String apikey = "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";
		Email from = new Email("bruce.meerkat@gmail.com");
	    String subject = title + " [Doctor Online]";
	    Email to = new Email(emailAddress);
	    Content content = new Content("text/html", emailContent);
	    Mail mail = new Mail(from, subject, to, content);

	    SendGrid sg = new SendGrid(apikey);
	    Request request = new Request();
	    try {
	      request.setMethod(Method.POST);
	      request.setEndpoint("mail/send");
	      request.setBody(mail.build());
	      Response response = sg.api(request);
	      logger.info("SendEamil (Status Code):"+response.getStatusCode() );
	      logger.info(response.getBody());
	      logger.info(response.getHeaders().toString()); 
	    } catch (IOException ex) {
	       logger.error("Error:", ex);
	    }
	}
	
} 



