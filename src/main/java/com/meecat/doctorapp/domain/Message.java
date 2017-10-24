package com.meecat.doctorapp.domain;

import java.time.LocalDateTime; 
import javax.persistence.*; 

@Entity
@Table
public class Message extends BaseEntity { 

	@OneToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="sender")
    private User sender;

	@OneToOne(fetch=FetchType.EAGER)
    @JoinColumn(name = "receiver")
    private User receiver;

	@Column
    private String content;

    @Column 
    private LocalDateTime createDate; 
    
    @Column
    private Integer attachment;

    public Message(){
    	createDate = LocalDateTime.now();
    }
    
    public User getSender() {
		return sender;
	}

	public void setSender(User sender) {
		this.sender = sender;
	}

	public User getReceiver() {
		return receiver;
	}

	public void setReceiver(User receiver) {
		this.receiver = receiver;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public LocalDateTime getCreateDate() {
		return createDate;
	}

	public void setCreateDate(LocalDateTime createDate) {
		this.createDate = createDate;
	}

	public Integer getAttachment() {
		return attachment;
	}

	public void setAttachment(Integer attachment) {
		this.attachment = attachment;
	}

     
}