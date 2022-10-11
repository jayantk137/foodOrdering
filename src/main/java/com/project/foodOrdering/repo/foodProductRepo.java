package com.project.foodOrdering.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.foodOrdering.dto.Foodproduct;

public interface foodProductRepo extends JpaRepository<Foodproduct,Integer>{

}
