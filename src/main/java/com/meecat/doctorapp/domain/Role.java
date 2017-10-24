package com.meecat.doctorapp.domain;
 
import java.util.ArrayList;
import java.util.List; 

import javax.persistence.*;

import com.fasterxml.jackson.annotation.*; 

@Entity
@Table(name = "Role")
public class Role extends BaseEntity {

    @Column
    private String name; 

    @JsonIgnore
    @ManyToMany(cascade = {CascadeType.ALL}, fetch=FetchType.EAGER)
    @JoinTable(
        name = "UserRole",
        joinColumns = @JoinColumn(name = "roleid"),
        inverseJoinColumns = @JoinColumn(name = "userid")
    ) 
    private List<User> users = new ArrayList<User>( );

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	} 
     
}