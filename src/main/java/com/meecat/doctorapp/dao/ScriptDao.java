package com.meecat.doctorapp.dao;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
 
import org.springframework.stereotype.Repository;
 
import com.meecat.doctorapp.domain.*;

@Repository
public class ScriptDao {

	@PersistenceContext
	private EntityManager entityManger;

    public Script save(Script entity) {
    	return entityManger.merge(entity); 
    }
    
    public Script get(int id) {
    	return entityManger.find(Script.class, id); 
	}

    public void delete(int id) {
    	Script entity  =  get(id);
    	entityManger.remove(entity); 
    }
    
	public List<Script> list() {
		return entityManger
				.createQuery("from Script order by id", Script.class)
				.getResultList();    	
	}
 
}
