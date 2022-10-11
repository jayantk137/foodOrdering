package com.project.foodOrdering.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.foodOrdering.dto.Branch;
import com.project.foodOrdering.dto.User;
import com.project.foodOrdering.dto.foodOrder;
import com.project.foodOrdering.repo.UserRepo;

@Repository
public class UserDao {
	@Autowired
	 
	 UserRepo userRepo;

	public User saveUser(User user) {
		
	    return userRepo.save(user);
	}
	
	public List<User> getAllUser(){
		List<User> userlist=new ArrayList<>();
		List<User> userlist1=new ArrayList<>();

		userlist=userRepo.findAll();
		for(User user:userlist) {
			User user1=new User();
			user1.setId(user.getId());
			//user1.setName(user.getName());
			user1.setRole(user.getRole());
			userlist1.add(user1);
		}
		return userlist1;
	}
	
	public List<Branch> getAllBranches(long user_id){
		Optional<User> optional = userRepo.findById(user_id);
		if(optional.isPresent()) {
			return optional.get().getListOfBranches();
		}
		return null;
	}
	
	public List<foodOrder> getAllFoodProducts(long id){
		Optional<User> optional = userRepo.findById(id);
		if(optional.isPresent()) {
			return optional.get().getFoodOrderList();
		}
		return null;
	}
	public User getUserById(long id) {
		Optional<User> optional = userRepo.findById(id);
		if(optional.isPresent()) {
			return optional.get();
		}
		return null;
	}
	
	public String deleteUser(long id) {
		Optional<User> optional = userRepo.findById(id);
		if(optional.isPresent()) {
			userRepo.delete(optional.get());
			return "User "+id+" data is deleted";
		}
		
		return "User with "+id +"not found";
	}
	
	public User updateUser(User usr,long id) {
		Optional<User> optional = userRepo.findById(id);
		if(optional.isPresent()) {
			User user = optional.get();
			user.setName(usr.getName());
			user.setEmail(usr.getEmail());
			user.setPassword(usr.getPassword());
			user.setRole(usr.getRole());
			return userRepo.save(user);
		}
		return null;
	}
	public Optional<User> findByUsername(String username) {
		return userRepo.findByUsername(username);
	}
		
}
