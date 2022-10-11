package com.project.foodOrdering.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.foodOrdering.dto.item;

public interface itemRepo extends JpaRepository<item,Long>{

}
