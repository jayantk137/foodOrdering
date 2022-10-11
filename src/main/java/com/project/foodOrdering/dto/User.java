package com.project.foodOrdering.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String name;
	private String email;
	private String password;
	private String username;
	private String role;
	
	@OneToOne
	@JsonIgnore
	Menu menu;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
	private List<Branch> listOfBranches;
    
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
	List<foodOrder> FoodOrderList;
	


	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}



	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

	public List<foodOrder> getFoodOrderList() {
		return FoodOrderList;
	}

	public void setFoodOrderList(List<foodOrder> foodOrderList) {
		FoodOrderList = foodOrderList;
	}
	
	public List<foodOrder> addFoodOrder(foodOrder foodorder){
		this.FoodOrderList.add(foodorder);
		return this.FoodOrderList;
	}

	public User() {

	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public List<Branch> getListOfBranches() {
		return listOfBranches;
	}

	public void setListOfBranches(List<Branch> listOfBranches) {
		this.listOfBranches = listOfBranches;
	}
	
	public List<Branch> addBranches(Branch branch){
		this.listOfBranches.add(branch);
		return this.listOfBranches;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public List<Branch> deletebranch(long branch_id) {
		// TODO Auto-generated method stub
		int count=0;
		for(Branch branch:this.listOfBranches) {
			if(branch.getId()==branch_id) {
				this.listOfBranches.remove(count);
				return this.listOfBranches;
			}
			++count;
		}
		return null;
	}

}
