package com.meecat.doctorapp.dao; 
import java.util.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
 
import com.meecat.doctorapp.domain.*;

@Repository
public class MessageDao {

	@PersistenceContext
	private EntityManager entityManger;

    @Autowired
    private UserDao userDao; 
    
    public List<User> getChatUsers(User currentUser) {
    	String sql = "(select m.sender from Message m where m.receiver=:current_user_id) UNION (select m.receiver from Message m where m.sender=:current_user_id)";
    	@SuppressWarnings("unchecked")
		List<Integer> userIds =  entityManger
    			.createNativeQuery(sql)
    		    .setParameter("current_user_id", currentUser.getId())
    			.getResultList();  

    	@SuppressWarnings("unchecked")
		List<User> list = entityManger
    			.createNativeQuery("select * from User u where u.id in :user_list ", User.class)
    		    .setParameter("user_list", userIds)
    			.getResultList(); 
    	
    	return list;
    }
    
    public List<Message> getMessages(int senderId, User currentUser) {
    	List<Message> list = entityManger
    			.createQuery("from Message where (sender=:chat_user and receiver=:current_user) or (sender=:current_user and receiver=:chat_user ) order by id ", Message.class)
    		    .setParameter("chat_user", userDao.get(senderId))
    		    .setParameter("current_user", currentUser)
    			.getResultList();  
    	
    	return list;
    }
    
    public Message sendMessage(Message entity) {
    	entityManger.persist(entity);
    	
    	return entity;
	}
 
}
