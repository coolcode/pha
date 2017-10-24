package com.meecat.doctorapp.domain;

import java.time.LocalDateTime; 
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat; 

@Entity
@Table
public class Comment extends BaseEntity {  

	@Column
    private String content;

	@OneToOne(fetch=FetchType.EAGER)
    @JoinColumn(name = "postId") 
    private Post post;

	@OneToOne(fetch=FetchType.EAGER)
    @JoinColumn(name = "createUserId") 
    private User createUser;
	
    @Column
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss", timezone = "UTC")
    private LocalDateTime createDate;      

    public Comment(){
    	createDate = LocalDateTime.now();
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
	
	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}
	
	public LocalDateTime getCreateDate() {
		return createDate;
	}

	public void setCreateDate(LocalDateTime createDate) {
		this.createDate = createDate;
	}

}