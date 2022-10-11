package com.project.foodOrdering.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.foodOrdering.dto.Branch;
import com.project.foodOrdering.dto.User;
import com.project.foodOrdering.repo.BranchRepo;
import com.project.foodOrdering.repo.UserRepo;

@Repository
public class branchDao {
	
	@Autowired
	private UserRepo userrepo;

	@Autowired
	private BranchRepo branchrepo;
	
	public Branch createBranch(Branch branch,long user_id) {
	     Optional<User> optional=userrepo.findById(user_id);
	     
	     if(!optional.isPresent()) {
	    	 //System.out.println("User does not exist");
	    	 return null;
	     }
	     else {
	    	 User user=optional.get();
   	         user.addBranches(branch);
	    	 //System.out.println(branch.getBranchAddress());
	    	 branch.setUser(user);
	    	 
              return branchrepo.save(branch);	    	 
	     }    
	}
	
	public Branch getbranchbyid(long id) {
		Optional<Branch> optional = branchrepo.findById(id);
		if(optional.isPresent()) {
			return optional.get();
		}
		else {
			return null;
		}
	}

	public List<Branch> deletebranch(long branch_id, long user_id) {
		// TODO Auto-generated method stub
		Optional<User> optional=userrepo.findById(user_id);
		if(optional.isPresent()) {
			User user = optional.get();
			user.deletebranch(branch_id);
			branchrepo.delete(branchrepo.getById(branch_id));
			return user.getListOfBranches();
		}
		return null;
	}

	public Branch updatebranch(Branch branch, long branch_id) {
		// TODO Auto-generated method stub
		Branch branch1 = branchrepo.findById(branch_id).get();
		if(branch1!=null) {
			branch1.setBranchAddress(branch.getBranchAddress());
			branch1.setBranchEmail(branch.getBranchEmail());
			branch1.setBranchName(branch.getBranchName());
			branch1.setBranchPhone(branch.getBranchPhone());
			return branchrepo.save(branch1);
		}
		return null;
	}
	
}
