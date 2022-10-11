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

import com.project.foodOrdering.dto.Foodproduct;
import com.project.foodOrdering.dto.ResponseStructure;
import com.project.foodOrdering.service.foodProductService;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class foodProductController {
	
	@Autowired
	foodProductService foodproductservice;
	
	
	@PostMapping("/foodProduct/{user_id}/{menu_id}")
	public Foodproduct saveFoodProduct(@RequestBody Foodproduct foodproduct,@PathVariable long user_id,@PathVariable int menu_id) {
		return foodproductservice.saveproduct(user_id,menu_id,foodproduct);
		
	}
	
	
	
	@GetMapping("/foodProduct/{id}")
	public Foodproduct getFoodProductById(@PathVariable int id){
		return foodproductservice.getProductById(id);
	}
	
	@DeleteMapping("/foodProduct/{id}/{menu_id}")
	public List<Foodproduct> deleteFoodProduct(@PathVariable int id, @PathVariable int menu_id){
		return foodproductservice.deleteproduct(id,menu_id);
	}
	
	@PutMapping("/foodProduct/{id}")
	public Foodproduct updateFoodProduct(@RequestBody Foodproduct foodproduct,@PathVariable int id){
		return foodproductservice.updateFoodproduct(foodproduct,id);
	}

}
