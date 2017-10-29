package com.meecat.doctorapp.dao;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
 
import org.springframework.stereotype.Repository;
 
import com.meecat.doctorapp.domain.*;

@Repository
public class QuizDao {

	@PersistenceContext
	private EntityManager entityManger;

    public void save(Quiz entity) {
    	entityManger.merge(entity); 
    }
    
    public Quiz get(int id) {
    	return entityManger.find(Quiz.class, id); 
	}

    public void delete(int id) {
    	Quiz entity  = get(id);
    	entityManger.remove(entity); 
    }
    
	public List<Quiz> list() {
		return entityManger
				.createQuery("from Quiz order by id", Quiz.class)
				.getResultList();    	
	}

}

