package com.meecat.doctorapp.domain;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore; 

@Entity
public class Privilege extends BaseEntity { 
    private String name;
 
    @ManyToMany(mappedBy = "privileges")
    private Collection<Role> roles; 

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Collection<Role> getRoles() {
		return roles;
	}

	public void setRoles(Collection<Role> roles) {
		this.roles = roles;
	}
    
    
}
