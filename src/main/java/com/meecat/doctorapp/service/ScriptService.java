package com.meecat.doctorapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.meecat.doctorapp.dao.*;
import com.meecat.doctorapp.domain.*; 
 

@Service 
public class ScriptService {

    @Autowired
    private MedicineDao medicineDao; 

    @Autowired
    private ScriptDao scriptDao; 

    @Autowired
    private MessageDao messageDao; 
    
    public List<Medicine> getAllMedicines() { 
       return medicineDao.list();
    } 
    
    public void saveScript(Script script) {     	
      Script newScript =  scriptDao.save(script);
       
       //send a message to patient
       Message  message = new Message();
       message.setContent("Script");
       message.setAttachment(newScript.getId());
       message.setReceiver(newScript.getPatient());
       message.setSender(newScript.getDoctor());       
       messageDao.sendMessage(message);
    }

	public Script getScript(int id) { 
	   return scriptDao.get(id); 
	} 
	
	public List<Medicine> getMedicinesByScriptId(int id) { 
	   return scriptDao.get(id).getMedicines();
	} 
}