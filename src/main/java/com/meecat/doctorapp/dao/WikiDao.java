package com.meecat.doctorapp.dao;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
 
import com.meecat.doctorapp.domain.*;

@Repository
public class WikiDao {

	@PersistenceContext
	private EntityManager entityManger;

    public void save(Wiki entity) {
    	entityManger.merge(entity); 
    }
    
    public Wiki get(int id) {
    	return entityManger.find(Wiki.class, id); 
	}

    public void delete(int id) {
    	Wiki entity  = get(id);
    	entityManger.remove(entity); 
    }
    
	public List<Wiki> list() {
		return entityManger
				.createQuery("from Wiki order by id desc", Wiki.class)
				.getResultList();    	
	}  
	
	public List<Wiki> top(int n) {
		return entityManger
				.createQuery("from Wiki order by id desc", Wiki.class)
				.setMaxResults(n)
				.getResultList();    	
	} 
	
}
