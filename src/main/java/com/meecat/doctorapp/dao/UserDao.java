package com.meecat.doctorapp.dao;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
 
import com.meecat.doctorapp.domain.*;

@Repository("userDao") 
public class UserDao {
	
    @PersistenceContext
    @Qualifier("entityManger")
    private EntityManager entityManger;

    public EntityManager getEntityManger() {
		return entityManger;
	}


	public void setEntityManger(EntityManager entityManger) {
		this.entityManger = entityManger;
	}


	public User save(User user) {
    	return entityManger.merge(user);
    }

    
    public User get(int id) {
    	User entity = entityManger.find(User.class, id);
    	
    	return entity;
	}
    
    public void delete(int id) {
    	User entity  =  get(id);
    	entityManger.remove(entity); 
    }
    
	public List<User> list() {
		return entityManger.createQuery("from User", User.class).getResultList();    	
	}

	public List<Role> getRolesByUserId(int id) {
    	User u = entityManger.find(User.class, id);
    	
    	return u.getRoles();
	}

	public User getUserByEmail(String email) {
    	TypedQuery<User> query = entityManger.createQuery("from User where email=:email", User.class);
    	query.setParameter("email", email);
    	try{
    		return query.getSingleResult(); 
    	}catch(Exception e){
    		return null;
    	}
	}
}
