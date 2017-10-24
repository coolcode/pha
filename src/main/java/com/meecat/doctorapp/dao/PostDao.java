package com.meecat.doctorapp.dao;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
 
import org.springframework.stereotype.Repository;
 
import com.meecat.doctorapp.domain.*;

@Repository
public class PostDao {

	@PersistenceContext
	private EntityManager entityManger;

    public void save(Post entity) {
    	entityManger.merge(entity); 
    }
    
    public Post get(int id) {
    	return entityManger.find(Post.class, id);    	 
	}

    public void delete(int id) {
    	Post entity  = get(id);
    	entityManger.remove(entity); 
    }

	public List<Post> list() {
		return list(1024);
	}
	
	public List<Post> list(int n) {
		return entityManger
				.createQuery("from Post order by id desc", Post.class)
				.setMaxResults(n)
				.getResultList();    	
	} 
}
