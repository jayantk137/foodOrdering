package com.project.foodOrdering.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.foodOrdering.dto.Menu;

public interface menuRepo extends JpaRepository<Menu,Integer> {
	

}