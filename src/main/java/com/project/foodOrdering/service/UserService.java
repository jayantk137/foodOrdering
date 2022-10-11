package com.project.foodOrdering.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.project.foodOrdering.dao.UserDao;
import com.project.foodOrdering.dto.Branch;
import com.project.foodOrdering.dto.User;
import com.project.foodOrdering.dto.foodOrder;

@Service
public class UserService implements UserDetailsService {
	
	@Autowired
	UserDao userdao;
	
	@Autowired
	BCryptPasswordEncoder encoder;
	

	public User saveUser(User user) {
		user.setPassword(encoder.encode(user.getPassword()));
		return userdao.saveUser(user);
	}
	
	public User getUserById(long id) {
		return userdao.getUserById(id);
	}
	 
	
	public List<Branch> getallBranches(long user_id) {
	   	return userdao.getAllBranches(user_id);
	 }
	
	public List<foodOrder> getAllFoodProducts(long id){
		return userdao.getAllFoodProducts(id);
	}
	
	
	public void deleteUserById(long id) {
	    User user=userdao.getUserById(id);
		if(user==null) {
			System.out.println("User does not exist");
		}
		else {
			userdao.deleteUser(user.getId());
		}
	}
	public void UpdateUserById(User new_user,long id) {
		User user=userdao.getUserById(id);
		if(user==null) {
			System.out.println("User does not exist");
		}
		else {
			userdao.updateUser(new_user,id);
		}
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Optional<User> optional = userdao.findByUsername(username);
		if (optional.isEmpty()) {
			throw new UsernameNotFoundException("Username " + username + " is not found in Database");
		}
		//
		User user = optional.get();
		return new org.springframework.security.core.userdetails.User(username, user.getPassword(),new ArrayList<>());
	}

	public List<User> getUserList() {
		// TODO Auto-generated method stub
		return userdao.getAllUser();
	}

}
