package com.meecat.doctorapp.dao;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
 
import com.meecat.doctorapp.domain.*;

@Repository
public class CommentDao {

	@PersistenceContext
	private EntityManager entityManger;

    public void save(Comment entity) {
    	entityManger.merge(entity); 
    }
    
    public Comment get(int id) {
    	return entityManger.find(Comment.class, id); 
	}

    public void delete(int id) {
    	Comment entity  = get(id);
    	entityManger.remove(entity); 
    }
    
	public List<Comment> list(int postId) {
		return entityManger
				.createQuery("from Comment where postId=:postId order by id desc", Comment.class)
				.setParameter("postId", postId)
				.getResultList();    	
	} 
}
