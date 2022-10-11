package com.project.foodOrdering.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreType;

@Entity

public class foodOrder {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	private long id;
	private String Status;
	private long totalPrice;
	private Date orderCreatedTime;
	private Date orderDeliveryTime;
	private String customerName;
	private long contactNumber;

	@ManyToOne
	@JoinColumn
	@JsonIgnore
	User user;
	
	
	@OneToMany(mappedBy = "FoodOrder")
	@JsonIgnore
	List<item> FoodItems;
	
	
	public List<item> addFoodItems(item itm){
		this.FoodItems.add(itm);
		this.totalPrice += itm.getPrice() * itm.getQuantity();
		return this.FoodItems;
	}
	public List<item> deleteFoodItems(int item_id){
		int count=0;
		for(item itm:this.FoodItems) {
			if(itm.getId()==item_id) {
				this.totalPrice -= itm.getPrice()*itm.getQuantity();
				this.FoodItems.remove(count);
				return this.FoodItems;
			}
			++count;
		}
		
		return null;
	}
	
	public List<item> getFoodItems() {
		return FoodItems;
	}
     @JsonIgnore
	public void setFoodItems(List<item> foodItems) {
		FoodItems = foodItems;
	}

	foodOrder(){
		this.orderCreatedTime=new Date();
		this.totalPrice=0;
	}
     
	public long getId() {
		return id;
	}
     
	public void setId(long id) {
		this.id = id;
	}
     
	public String getStatus() {
		return Status;
	}
     
	public void setStatus(String status) {
		Status = status;
	}
      
	public long getTotalPrice() {
		return totalPrice;
	}
      
	public void setTotalPrice(long totalPrice) {
		this.totalPrice = totalPrice;
	}
      
	public Date getOrderCreatedTime() {
		return orderCreatedTime;
	}
     
	public void setOrderCreatedTime(Date orderCreatedTime) {
		this.orderCreatedTime = orderCreatedTime;
	}
    
	public Date getOrderDeliveryTime() {
		return orderDeliveryTime;
	}
      
	public void setOrderDeliveryTime(Date orderDeliveryTime) {
		this.orderDeliveryTime = orderDeliveryTime;
	}
   
	public String getCustomerName() {
		return customerName;
	}
  
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
   
	public long getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(long contactNumber) {
		this.contactNumber = contactNumber;
	}
   
	public User getUser() {
		return user;
	}
  
	public void setUser(User user) {
		this.user = user;
	}
}
