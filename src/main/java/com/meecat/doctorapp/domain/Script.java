package com.meecat.doctorapp.domain;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table
public class Script  extends BaseEntity { 

	@OneToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="doctorId")
    private User doctor;

	@OneToOne(fetch=FetchType.EAGER)
    @JoinColumn(name = "patientId")
    private User patient; 
	
    @Column 
    private LocalDateTime createDate; 

    @ManyToMany(cascade = {CascadeType.ALL}, fetch=FetchType.EAGER)
    @JoinTable(
        name = "ScriptDetail",
        joinColumns = @JoinColumn(name = "scriptId"),
        inverseJoinColumns = @JoinColumn(name = "medicineId")
    ) 
    private List<Medicine> medicines = new ArrayList<Medicine>( );
    
    public Script(){
    	createDate = LocalDateTime.now();
    }

	public User getDoctor() {
		return doctor;
	}

	public void setDoctor(User doctor) {
		this.doctor = doctor;
	}

	public User getPatient() {
		return patient;
	}

	public void setPatient(User patient) {
		this.patient = patient;
	}

	public LocalDateTime getCreateDate() {
		return createDate;
	}

	public void setCreateDate(LocalDateTime createDate) {
		this.createDate = createDate;
	}

	public List<Medicine> getMedicines() {
		return medicines;
	}

	public void setMedicines(List<Medicine> medicines) {
		this.medicines = medicines;
	}    
    
     
}