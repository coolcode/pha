package com.meecat.doctorapp.domain;
 
import java.util.ArrayList;
import java.util.Collection;
import java.util.List; 

import javax.persistence.*;

import com.fasterxml.jackson.annotation.*; 

@Entity
@Table(name = "Role")
public class Role extends BaseEntity {

    @Column
    private String name; 

    @JsonIgnore
//    @ManyToMany(cascade = {CascadeType.ALL}, fetch=FetchType.EAGER)
//    @JoinTable(
//        name = "UserRole",
//        joinColumns = @JoinColumn(name = "roleid"),
//        inverseJoinColumns = @JoinColumn(name = "userid")
//    ) 

    @ManyToMany(mappedBy = "roles")
    private List<User> users = new ArrayList<User>( );

    @JsonIgnore
    @ManyToMany
    @JoinTable(
        name = "RolePrivilege", 
        joinColumns = @JoinColumn( name = "roleid", referencedColumnName = "id"), 
        inverseJoinColumns = @JoinColumn( name = "privilegeid", referencedColumnName = "id"))
    private Collection<Privilege> privileges;   
    
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

	public Collection<Privilege> getPrivileges() {
		return privileges;
	}

	public void setPrivileges(Collection<Privilege> privileges) {
		this.privileges = privileges;
	} 
     
	
}