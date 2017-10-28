package com.meecat.doctorapp.domain;

import java.time.LocalDateTime;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;

public class TrackHealth extends BaseEntity{
	
	@OneToOne(fetch=FetchType.EAGER)
    @JoinColumn(name = "createUserId") 
    private User createUser;
	
    @Column
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss", timezone = "UTC")
    private LocalDateTime createDate; 
    
	@Column
    private String foodType;

	@Column
    private String content;
	
	@Column
	private int eachId;
	
	public String getTitle() {
		return foodType;
	}

	public void setTitle(String title) {
		this.foodType = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public User getCreateUser() {
		return createUser;
	}

	public void setCreateUser(User createUser) {
		this.createUser = createUser;
	}
	
	public int getEachId() {
		return eachId;
	}

	public void setEachId(int n) {
		this.eachId = n;
	}
	
	public LocalDateTime getCreateDate() {
		return createDate;
	}

	public void setCreateDate(LocalDateTime createDate) {
		this.createDate = createDate;
	}

}
