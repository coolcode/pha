package com.meecat.doctorapp.dao;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
 
import com.meecat.doctorapp.domain.*;

@Repository
public class HealthReportDao {

	@PersistenceContext
	private EntityManager entityManger;

    public void save(HealthReport entity) {
    	entityManger.merge(entity); 
    }
    
    public HealthReport get(int id) {
    	return entityManger.find(HealthReport.class, id); 
	}

    public void delete(int id) {
    	HealthReport entity  = get(id);
    	entityManger.remove(entity); 
    }
    
	public List<HealthReport> list() {
		return entityManger
				.createQuery("from HealthReport order by id desc", HealthReport.class)
				.getResultList();    	
	}  
	
	public List<HealthReport> top(int n) {
		return entityManger
				.createQuery("from HealthReport order by id desc", HealthReport.class)
				.setMaxResults(n)
				.getResultList();    	
	} 
	
}
