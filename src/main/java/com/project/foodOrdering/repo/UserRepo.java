package com.project.foodOrdering.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.foodOrdering.dto.User;

public interface UserRepo extends JpaRepository<User, Long>{

	public Optional<User> findByUsername(String username);

 
}
