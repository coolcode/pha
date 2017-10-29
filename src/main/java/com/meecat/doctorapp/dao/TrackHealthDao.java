package com.meecat.doctorapp.dao;
 
import org.springframework.stereotype.Repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
//import org.hibernate.Query;
import com.meecat.doctorapp.domain.*;

@Repository
public class TrackHealthDao {

	@PersistenceContext
	private EntityManager entityManager;

	public TrackHealth get(int id) {
		return entityManager.find(TrackHealth.class, id);
	}

	public void save(TrackHealth announcement) {
		entityManager.merge(announcement);

	}

	public void delete(int id) {
		TrackHealth announcement =  get(id);
		entityManager.remove(announcement);
	}
	

	public List<TrackHealth> List() {
		return list(1024);
	}
    
    public List<TrackHealth> list(int n) {
		return entityManager
				.createQuery("from HealthTrack order by id desc", TrackHealth.class)
				.setMaxResults(n)
				.getResultList();   
	}
    
    public List<TrackHealth> getOwnList(int id) {
    		
		return entityManager
				.createQuery("from TrackHealth a where a.eachId = :aId", TrackHealth.class)
				.setParameter("aId", id)
				.getResultList();   
	}
}
