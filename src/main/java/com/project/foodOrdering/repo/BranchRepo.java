package com.project.foodOrdering.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.foodOrdering.dto.Branch;

public interface BranchRepo extends JpaRepository<Branch,Long>{

}
