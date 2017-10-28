package com.meecat.doctorapp.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitplan.mediawiki.japi.Mediawiki;
import com.bitplan.mediawiki.japi.api.Login; 
import com.meecat.doctorapp.dao.*;
import com.meecat.doctorapp.domain.TrackHealth;
 


@Service 
public class TrackHealthService { 

	@Autowired
	private TrackHealthDao Track; 

	private static final Logger logger = LoggerFactory.getLogger(TrackHealthService.class); 

	public List<TrackHealth> listTrackHealth() { 
		return Track.List();
	}
	
	public TrackHealth save(TrackHealth wiki) {
		Track.save(wiki);
		return wiki;
	}

	public TrackHealth get(int wikiId) {
		return Track.get(wikiId); 
	}
	
	public void delete(int wikiId) {
		Track.delete(wikiId); 
	} 
	
	
	public List<TrackHealth> getEachItem(int count){
		return Track.getOwnList(count);
	}
}