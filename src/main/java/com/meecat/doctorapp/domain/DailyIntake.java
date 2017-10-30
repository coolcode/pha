package com.meecat.doctorapp.domain;

import java.time.LocalDateTime; 
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat; 

@Entity
@Table
public class DailyIntake extends BaseEntity { 

	@Column
    private String intakeType;	
	@Column
    private int intakeQty;
	@Column
    private String intakeUnit;
	@Column
    private int karlories;
	@Column
    private String remarks; 


	@OneToOne(fetch=FetchType.EAGER)
    @JoinColumn(name = "userId")
    private User user; 
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
 
	
    @Column
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss", timezone = "UTC")
    private LocalDateTime createDate;      

    public DailyIntake(){
    	createDate = LocalDateTime.now();
    }

	public String getIntakeType() {
		return intakeType;
	}

	public void setIntakeType(String intakeType) {
		this.intakeType = intakeType;
	}

	public int getIntakeQty() {
		return intakeQty;
	}

	public void setIntakeQty(int intakeQty) {
		this.intakeQty = intakeQty;
	}

	public String getIntakeUnit() {
		return intakeUnit;
	}

	public void setIntakeUnit(String intakeUnit) {
		this.intakeUnit = intakeUnit;
	}

	public int getKarlories() {
		return karlories;
	}

	public void setKarlories(int karlories) {
		this.karlories = karlories;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public LocalDateTime getCreateDate() {
		return createDate;
	}

	public void setCreateDate(LocalDateTime createDate) {
		this.createDate = createDate;
	}
     

}