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

import com.project.foodOrdering.dto.ResponseStructure;
import com.project.foodOrdering.dto.foodOrder;
import com.project.foodOrdering.dto.item;
import com.project.foodOrdering.service.itemService;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class itemController {

	@Autowired
	itemService itemservice;
	
	@PostMapping("/item/{foodorder_id}")
	public item saveItem(@RequestBody item itm,@PathVariable long foodorder_id) {
		return itemservice.saveItem(itm,foodorder_id);
	}
	
	@GetMapping("/item")
	public List<item> getItem(){
		return itemservice.getItems();
	}
	
	@GetMapping("/item/{id}")
	public item getItemById(@PathVariable long id){
		return itemservice.getItemById(id);
	}
	
	@DeleteMapping("/item/{id}")
	public item deleteItem(@PathVariable long id){
		return itemservice.deleteitem(id);
	}
	
	@PutMapping("/item")
	public item updateItem(@RequestBody item itm){
		return itemservice.updateItem(itm);
	}
}
