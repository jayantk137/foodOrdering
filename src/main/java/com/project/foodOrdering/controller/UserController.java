package com.project.foodOrdering.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.foodOrdering.dao.UserDao;
import com.project.foodOrdering.dto.Branch;
import com.project.foodOrdering.dto.User;
import com.project.foodOrdering.dto.UserRequest;
import com.project.foodOrdering.dto.UserResponse;
import com.project.foodOrdering.service.UserService;
import com.project.foodOrdering.util.JwtUtil;


@RestController
@CrossOrigin(origins="http://localhost:4200")
public class UserController {
	
	@Autowired
	UserDao userdao;
	
	@Autowired
	UserService userservice;
	

	@Autowired
	JwtUtil jwtUtil;

	@Autowired
	AuthenticationManager manager;
	
	
	@PostMapping("/user")
	 public User saveUser(@RequestBody User user) {
		
		return  userservice.saveUser(user);
	 }
	@PostMapping("/login")
	public UserResponse loginUser(@RequestBody UserRequest request) throws Exception {
     //System.out.println("Login working");
	       //System.out.println(request.getUsername());  
		try {
		manager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
		}
		catch(Exception ex){
			throw new Exception("invalid username/password");
			
		}
		String token = jwtUtil.generateToken(request.getUsername());
		User user=userdao.findByUsername(request.getUsername()).get();
		return new UserResponse(token, "Sucessfully generated token",user.getRole(),user.getId());
	}
	
	 
	 @GetMapping("/user/{user_id}")
	 public User getUserById(@PathVariable long user_id) {
		  return userservice.getUserById(user_id);
	 }
     
	 @GetMapping("/getBranch/{user_id}")
	 public List<Branch> getAllBranches(@PathVariable long user_id) {
		  return userservice.getallBranches(user_id);
	 }
	 
	 @DeleteMapping("/user/{id}")
     public void deleteUerById(@PathVariable long id) {
		 userservice.deleteUserById(id);
	 }
	 
	 
	 @PutMapping("/user/{id}")
	 public void UpdatUserById(@RequestBody User new_user,@PathVariable long id) {
		 userservice.UpdateUserById(new_user, id);
	 }
	 @GetMapping("/getAllUsers")
	 public List<User> getUserList(){
		return userservice.getUserList();
		 
	 }
	 @PostMapping("/welcome")
		public String welcome() {
			return "Welcome";
		}
}
