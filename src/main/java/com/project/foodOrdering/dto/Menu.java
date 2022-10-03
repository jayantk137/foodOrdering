package com.project.foodOrdering.dto;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

//import org.apache.catalina.User;



@Entity
public class menu {
	private int id;
	
	@OneToMany(mappedBy="menu")
	List<Foodproduct>foodproducts;
	
	@OneToOne
	@JoinColumn
	private User user;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
