package com.project.foodOrdering.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.foodOrdering.dto.User;
import com.project.foodOrdering.dto.foodOrder;
import com.project.foodOrdering.dto.item;
import com.project.foodOrdering.repo.UserRepo;
import com.project.foodOrdering.repo.foodOrderRepo;

@Repository
public class foodOrderDao {
	@Autowired
	foodOrderRepo  foodorderrepo;
	
	@Autowired
	UserRepo userrepo;
	
	@Autowired
	UserDao userdao;
	
	public foodOrder saveOrder(foodOrder foodorder,long user_id) {
		User user=userdao.getUserById(user_id);
		if(user!=null) {
         user.getFoodOrderList().add(foodorder);
        user.setFoodOrderList(user.getFoodOrderList());
			foodorder.setUser(user);
			return foodorderrepo.save(foodorder);
		}
		else {
			return null;
		}
		
		
	}
	
	public List<foodOrder> getAllOrder(){
		return foodorderrepo.findAll();
	}
	
	
	public List<foodOrder> getFoodOrderById(long id) {
		User user=userdao.getUserById(id);
		Optional<foodOrder> optional = foodorderrepo.findById(id);
		if(user!=null) {
			return user.getFoodOrderList();
		}
		return null;
	}
	
	public void deleteFoodOrderById(long id) {
		Optional<foodOrder> foodorder = foodorderrepo.findById(id);
		if(foodorder.isPresent()) {
		    foodorderrepo.delete(foodorder.get());
			
		}
		
		return ;
	}
	
	public foodOrder updateFoodOrder(foodOrder foodorder) {
		Optional<foodOrder> optional = foodorderrepo.findById(foodorder.getId());
		if(optional.isPresent()) {
			return foodorderrepo.save(foodorder);
		}
		return null;
	}
	public List<item> getListOfItems(long id){
		Optional<foodOrder> optional = foodorderrepo.findById(id);
		if(optional.isPresent()) {
			return optional.get().getFoodItems();
		}
		return null;
	}
}
