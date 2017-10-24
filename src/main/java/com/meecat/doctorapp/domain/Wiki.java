package com.meecat.doctorapp.domain;

import java.time.LocalDateTime; 
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat; 

@Entity
@Table
public class Wiki extends BaseEntity { 
	@Column
    private String title;

	@Column
    private String content;

	@OneToOne(fetch=FetchType.EAGER)
    @JoinColumn(name = "createUserId") 
    private User createUser;
	
    @Column
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss", timezone = "UTC")
    private LocalDateTime createDate;      

    public Wiki(){
    	createDate = LocalDateTime.now();
    }
    
    
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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

	public LocalDateTime getCreateDate() {
		return createDate;
	}

	public void setCreateDate(LocalDateTime createDate) {
		this.createDate = createDate;
	}

}