package com.project.foodOrdering.controller;

import java.util.List;
import java.util.Optional;

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
import com.project.foodOrdering.dto.User;
import com.project.foodOrdering.dto.foodOrder;
import com.project.foodOrdering.dto.item;
import com.project.foodOrdering.service.foodOrderService;


@RestController
@CrossOrigin(origins="http://localhost:4200")
public class foodOrderController {
	@Autowired
	foodOrderService foodorderservice;
	@Autowired
	UserDao userdao;
	
	@PostMapping("/foodOrder/{id}")
	public foodOrder savefoodorder(@RequestBody foodOrder foodorder,@PathVariable long id) {
	    try {
		    System.out.println(foodorder.getId());	
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		 return foodorderservice.saveFoodOrder(foodorder,id);
		
		
	}
	
	@GetMapping("/foodOrder")
	public List<foodOrder> getAllOrder(){
		return foodorderservice.getAllOrder();
	}
	
	@GetMapping("/foodOrder/{id}")
	public List<foodOrder> getFoodOrderById(@PathVariable long id){
		return foodorderservice.getFoodOrderById(id);
	}
	
	@DeleteMapping("/foodOrder/{id}")
	public void deleteFoodOrder(@PathVariable long id){
		 foodorderservice.deleteFoodOrder(id);
	}
	
//	@PutMapping("/foodOrder")
//	public foodOrder updateFoodOrder(@RequestBody foodOrder foodorder){
//		return foodorderservice.updateFoodOrder(foodorder);
//	}
	@GetMapping("/getItems/{id}")
	public List<item> getListOfItems(@PathVariable long id){
		return foodorderservice.getlistOfItems(id);
	}
	
}
