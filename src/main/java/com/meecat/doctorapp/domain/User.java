package com.meecat.doctorapp.domain;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore; 

@Entity
@Table
public class User extends BaseEntity {

    @Column(name="email", unique=true)
    private String email;

    @Column
    private String password;

    @Column
    private String displayName;

    @Column
    private String icon;

	@Column 
    private LocalDateTime createDate;

    @Column 
    private LocalDateTime birthday;
    
    @Column
    @Enumerated(EnumType.ORDINAL)
    private Gender gender;
    
    @Column
    private String introduction;
    
    @Column
    private int verification;

    @JsonIgnore
    @ManyToMany(cascade = {CascadeType.ALL}, fetch=FetchType.LAZY)
    @JoinTable(
        name = "UserRole",
        joinColumns = @JoinColumn(name = "userid"),
        inverseJoinColumns = @JoinColumn(name = "roleid")
    )
    private List<Role> roles = new ArrayList<Role>( );
    

    public User(){
    	createDate = LocalDateTime.now();
    }
    
	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

    public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}
	
	public LocalDateTime getCreateDate() {
		return createDate;
	}

	public void setCreateDate(LocalDateTime createDate) {
		this.createDate = createDate;
	}

	public LocalDateTime getBirthday() {
		return birthday;
	}

	public void setBirthday(LocalDateTime birthday) {
		this.birthday = birthday;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public String getIntroduction() {
		return introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	public int getVerification() {
		return verification;
	}

	public void setVerification(int verification) {
		this.verification = verification;
	}


	
     
}