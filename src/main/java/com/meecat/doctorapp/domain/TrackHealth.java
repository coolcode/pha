package com.meecat.doctorapp.domain;

import java.time.LocalDateTime;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="TrackHealth")
public class TrackHealth extends BaseEntity{
	
	@OneToOne(fetch=FetchType.EAGER)
    @JoinColumn(name = "createUserId") 
    private User createUser;
	
    @Column
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss", timezone = "UTC")
    private LocalDateTime createDate; 
    
	@Column
    public String foodType;

	@Column
    public String content;
	
	public String getFoodType() {
		return foodType;
	}

	public void setFoodType(String title) {
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
	
	public LocalDateTime getCreateDate() {
		return createDate;
	}

	public void setCreateDate(LocalDateTime createDate) {
		this.createDate = createDate;
	}

}
