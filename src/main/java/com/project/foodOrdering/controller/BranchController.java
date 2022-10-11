package com.project.foodOrdering.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.project.foodOrdering.service.BranchService;
import com.project.foodOrdering.service.UserService;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class BranchController {
	
	@Autowired
	private BranchService branchservice;
	
	@Autowired
	UserDao userdao;
	
	@Autowired
	UserService userservice;
	
	@PostMapping("/branch/{user_id}")
	public Branch saveBranch(@RequestBody Branch branch,@PathVariable long user_id) {
		
		return branchservice.saveBranch(branch, user_id);
	}
	
	@GetMapping("/getallbranch/{user_id}")
	private List<Branch> getallbranches(@PathVariable long user_id){
		User user = userdao.getUserById(user_id);
		
		return  userservice.getallBranches(user_id);
			
		
			
		
	}
	
	@GetMapping("/getbranch/{branch_id}")
	private Branch getBranch(@PathVariable long branch_id) {
		return branchservice.getbranchbyid(branch_id);
		
	}
	
	
	@DeleteMapping("/deletebranch/{branch_id}/{user_id}")
	private List<Branch> DeleteBranch(@PathVariable long branch_id,@PathVariable long user_id){
		return branchservice.deletebranch(branch_id,user_id);
	}
	
	@PutMapping("/updatebranch/{branch_id}")
	private Branch UpdateBranch(@RequestBody Branch branch,@PathVariable long branch_id) {
		return branchservice.updatebranch(branch,branch_id);
	}
	
	

}
