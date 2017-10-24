package com.meecat.doctorapp.dao;
 
import org.springframework.stereotype.Repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
//import org.hibernate.Query;
import com.meecat.doctorapp.domain.*;

@Repository
public class AnnouncementDao {

	@PersistenceContext
	private EntityManager entityManager;

	public Announcement getAnnouncement(int id) {
		Announcement announcement = entityManager.find(Announcement.class, id);
		return announcement;
	}

	public void save(Announcement announcement) {
		entityManager.merge(announcement);

	}

	public void delete(int id) {
		Announcement announcement =  getAnnouncement(id);
		entityManager.remove(announcement);
	}

	public List<Announcement> getList() {
		return list(1024);
	}
    
    public List<Announcement> list(int n) {
		return entityManager
				.createQuery("from Announcement order by id desc", Announcement.class)
				.setMaxResults(n)
				.getResultList();   
	}
    
    public List<Announcement> getOwnList(int id) {
    		
		return entityManager
				.createQuery("from Announcement a where a.creator.id = :aId", Announcement.class)
				.setParameter("aId", id)
				.getResultList();   
	}
}
