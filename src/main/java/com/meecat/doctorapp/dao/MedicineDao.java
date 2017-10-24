package com.meecat.doctorapp.dao;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
 
import org.springframework.stereotype.Repository;
 
import com.meecat.doctorapp.domain.*;

@Repository
public class MedicineDao {

	@PersistenceContext
	private EntityManager entityManger;

    public void save(Medicine entity) {
    	entityManger.merge(entity); 
    }
    
    public Medicine get(int id) {
    	return entityManger.find(Medicine.class, id); 
	}

    public void delete(int id) {
    	Medicine entity  = get(id);
    	entityManger.remove(entity); 
    }
    
	public List<Medicine> list() {
		return entityManger
				.createQuery("from Medicine order by id", Medicine.class)
				.getResultList();    	
	} 
}

