package com.project.foodOrdering.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.foodOrdering.dao.branchDao;
import com.project.foodOrdering.dto.Branch;

@Service
public class BranchService {
	
	@Autowired
	branchDao branchdao;
	
	public Branch saveBranch(Branch branch,long id) {
		
		return branchdao.createBranch(branch, id);
	}
	
	public Branch getbranchbyid(long id) {
		  return branchdao.getbranchbyid(id);
	}

	public List<Branch> deletebranch(long branch_id, long user_id) {
		// TODO Auto-generated method stub
		
		return branchdao.deletebranch(branch_id,user_id);
	}

	public Branch updatebranch(Branch branch, long branch_id) {
		// TODO Auto-generated method stub
		return branchdao.updatebranch(branch,branch_id);
	
	}
}
