package com.meecat.doctorapp.dao;

import com.meecat.doctorapp.domain.Functionality;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

//import org.hibernate.Query;

@Repository
public class FunctionalityDao {

	@PersistenceContext
	private EntityManager entityManager;

	public Functionality getFunctionality(int id) {
		Functionality functionality = entityManager.find(Functionality.class, id);
		return functionality;
	}

	public void save(Functionality Functionality) {
		entityManager.merge(Functionality);

	}

	public void delete(int id) {
		Functionality Functionality =  getFunctionality(id);
		entityManager.remove(Functionality);
	}

	public List<Functionality> getList() {
		return list(1024);
	}
    
    public List<Functionality> list(int n) {
		return entityManager
				.createQuery("from Functionality order by id desc", Functionality.class)
				.setMaxResults(n)
				.getResultList();   
	}
    
    public List<Functionality> getEndUserFuncList(int n) {
    		
		return entityManager
				.createQuery("from Functionality a where a.accessToEndUser = true", Functionality.class)
				.setMaxResults(n)
				.getResultList();   
	}

	public List<Functionality> getDoctorFuncList(int n) {

		return entityManager
				.createQuery("from Functionality a where a.accessToDoctor = true", Functionality.class)
				.setMaxResults(n)
				.getResultList();
	}

	public List<Functionality> getTechnicalTeamFuncList(int n) {

		return entityManager
				.createQuery("from Functionality a where a.accessToTechnicalTeam = true", Functionality.class)
				.setMaxResults(n)
				.getResultList();
	}
}
