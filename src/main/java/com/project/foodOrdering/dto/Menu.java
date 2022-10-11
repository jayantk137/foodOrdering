package com.project.foodOrdering.dto;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Menu {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String menuname;
	@OneToMany(mappedBy="menu")
	@JsonIgnore
	List<Foodproduct> foodproducts;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn
	private User user;

	public String getMenuname() {
		return menuname;
	}

	public void setMenuname(String menuname) {
		this.menuname = menuname;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Foodproduct> getFoodproducts() {
		return foodproducts;
	}

	public void setFoodproducts(List<Foodproduct> foodproducts) {
		this.foodproducts = foodproducts;
	}
	
	public List<Foodproduct> addFoodproducts(Foodproduct foodproduct){
		this.foodproducts.add(foodproduct);
		return this.foodproducts;
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public List<Foodproduct> delete(int foodProductid){
		 int count=0;
	  	  for (Foodproduct foodproduct :this.foodproducts) {
				if(foodproduct.getId()==foodProductid) {
					this.foodproducts.remove(count);
					return this.foodproducts;
					
				}
				count++;
			}
	  	  return null;
	}


}
