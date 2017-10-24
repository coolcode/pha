package com.meecat.doctorapp.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitplan.mediawiki.japi.Mediawiki;
import com.bitplan.mediawiki.japi.api.Login; 
import com.meecat.doctorapp.dao.*;
import com.meecat.doctorapp.domain.Wiki;
 


@Service 
public class WikiService { 

	@Autowired
	private WikiDao wikiDao; 

	private static final Logger logger = LoggerFactory.getLogger(WikiService.class); 

	public List<Wiki> listWikis() { 
		return wikiDao.list();
	}
	
	public Wiki saveWiki(Wiki wiki) {
		wikiDao.save(wiki);
		return wiki;
	}

	public Wiki getWiki(int wikiId) {
		return wikiDao.get(wikiId); 
	}
	
	public void deleteWiki(int wikiId) {
		wikiDao.delete(wikiId); 
	} 
	
	public Wiki searchWiki(String title) { 
		String content = "";
		try {
			Mediawiki wiki = new Mediawiki("https://en.wikipedia.org");
			Login login = wiki.login("doctor_online", "elec5619");//WikiUser wuser= WikiUser.getUser("mediawiki_org");
			logger.info("wiki login: "+ login.getResult());  
			content = wiki.getPageHtml(title); 
			 
		} catch (Exception e) { 
			//e.printStackTrace();
			logger.error("wiki error: "+ e.getMessage());  
			content = "Error: " +  e.getMessage();
		}
		
        Wiki r = new Wiki();
        r.setContent(content);
		return r;
	}
	
	public List<Wiki> getNewestWikis(int count){
		return wikiDao.top(count);
	}
}