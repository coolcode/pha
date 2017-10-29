package com.meecat.doctorapp.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.meecat.doctorapp.dao.*;
import com.meecat.doctorapp.domain.*;

@Service 
public class QuizService {
	
	@Autowired
	private QuizDao QuizDao;
	
	
	public List<Quiz> getList() { 
		return QuizDao.list();
	}
	
//	public List<Medicine> getListbyUser(int id) { 
//		return MedicineDao.getOwnList(id);
//	}
	
	public Quiz get(int id) {
		Quiz quiz = QuizDao.get(id);
		return quiz;
	}
	
	public void delelet(int aId) {
		QuizDao.delete(aId);
	}
	
	public void save(Quiz a) {
		QuizDao.save(a);
	}
	
	public Quiz getQuiz(int aID) {
		return QuizDao.get(aID); 
	}
	
	public void a(){
		Quiz a=new Quiz();
		a.setId(9);
		a.setName("111");
		a.setDescription("222");
		
		
		QuizDao.save(a);
	}
	
} 
