package com.project.foodOrdering.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.foodOrdering.dto.foodOrder;

public interface foodOrderRepo extends JpaRepository<foodOrder, Long> {
	

}
