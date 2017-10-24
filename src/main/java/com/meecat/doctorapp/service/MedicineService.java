package com.meecat.doctorapp.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.meecat.doctorapp.dao.*;
import com.meecat.doctorapp.domain.*;

@Service 
public class MedicineService {
	
	@Autowired
	private MedicineDao MedicineDao;
	
	
	public List<Medicine> getList() { 
		return MedicineDao.list();
	}
	
//	public List<Medicine> getListbyUser(int id) { 
//		return MedicineDao.getOwnList(id);
//	}
	
	public Medicine get(int id) {
		Medicine medicine = MedicineDao.get(id);
		return medicine;
	}
	
	public void delelet(int aId) {
		MedicineDao.delete(aId);
	}
	
	public void save(Medicine a) {
		MedicineDao.save(a);
	}
	
	public Medicine getMedicine(int aID) {
		return MedicineDao.get(aID); 
	}
	
	public void a(){
		Medicine a=new Medicine();
		a.setId(9);
		a.setName("111");
		a.setDescription("222");
		a.setPrice(333);
		a.setQuantity(444);
		
		MedicineDao.save(a);
	}
	
} 
