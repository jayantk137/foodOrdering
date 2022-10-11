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

import com.project.foodOrdering.dao.UserDao;
import com.project.foodOrdering.dto.Foodproduct;
import com.project.foodOrdering.dto.Menu;
import com.project.foodOrdering.dto.ResponseStructure;
import com.project.foodOrdering.dto.User;
import com.project.foodOrdering.service.menuService;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class menuController {
	
	@Autowired
	menuService menuservice1;
	
	@Autowired
	UserDao userdao;
	
	@PostMapping("/menu/{id}")
	public Menu savemenu(@RequestBody Menu menu,@PathVariable long id) {
		User user=userdao.getUserById(id);
	
		 return menuservice1.saveMenu(menu, id);
		

	}
	
	
	@GetMapping("/menu/{id}")
	private Menu getmenu(@PathVariable long id) {
		return menuservice1.getmenu(id);
	}
	
	@DeleteMapping("/menu/{id}")
	private String delete(@PathVariable int id) {
		
		return menuservice1.delete(id);
	}
	
	@GetMapping("/getfoodproduct/{id}")
	private List<Foodproduct> getfoodproduct(@PathVariable int id){
		return menuservice1.getfoodproduct(id);
	}

}
