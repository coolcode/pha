package com.meecat.doctorapp.domain;

import javax.persistence.*;

@Entity
@Table
public class Quiz extends BaseEntity {
	
    @Column
    private int ID;

    @Column
    private String name;

    @Column
    private String description;

//    @Column
//    private double price;
//    
//    @Column
//    private int quantity;
//    
//    @Column
//    private String picture;
    
   
    public int getID(){
    	return ID;
    }
    
    public void setID(int ID){
    	this.ID = ID;
    }
    

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

//	public double getPrice() {
//		return price;
//	}
//
//	public void setPrice(double price) {
//		this.price = price;
//	}
//
//	public int getQuantity() {
//		return quantity;
//	}
//
//	public void setQuantity(int quantity) {
//		this.quantity = quantity;
//	} 
//	
//	public String getPicture() {
//		return picture;
//	}
//
//	public void setPicture(String picture) {
//		this.picture = picture;
//	}
    
	
    
     
}