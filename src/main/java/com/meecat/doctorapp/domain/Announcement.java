package com.meecat.doctorapp.domain;
import java.time.LocalDateTime; 
import javax.persistence.*; 


@Entity 
@Table
public class Announcement extends BaseEntity {


	@OneToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="creator")
    private User creator;

	@Column
    private String title;
	
	@Column
    private String content;

    @Column 
    private LocalDateTime createDate; 
    
    @Column
    private Integer attachment;
    
    @Column
    private Boolean ifSendEmail = false;

    public Announcement(){
    	createDate = LocalDateTime.now();
    }
    
    public User getCreator() {
		return creator;
	}

	public void setCreator(User creator) {
		this.creator = creator;
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

	public boolean getIfSendEmail() {
		return ifSendEmail;
	}
     
	public void setIfSendEmail(Boolean ifSendEmail) {
		this.ifSendEmail = ifSendEmail;
	}
}