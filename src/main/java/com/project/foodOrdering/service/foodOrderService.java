package com.project.foodOrdering.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.project.foodOrdering.dao.foodOrderDao;
import com.project.foodOrdering.dto.ResponseStructure;
import com.project.foodOrdering.dto.foodOrder;
import com.project.foodOrdering.dto.item;

@Service
public class foodOrderService {

	@Autowired
	foodOrderDao foodorderdao;
	
	public foodOrder saveFoodOrder(foodOrder foodorder,long id) {
		return  foodorderdao.saveOrder(foodorder,id);
		
	}
	
	public  List<foodOrder> getAllOrder(){
		return foodorderdao.getAllOrder();
		
		
	}
	
	public List<foodOrder> getFoodOrderById(long id){
		return  foodorderdao.getFoodOrderById(id);
	}
	

	public void deleteFoodOrder(long id){
		foodorderdao.deleteFoodOrderById(id);
		
		}
	
	
//	public foodOrder updateFoodOrder(foodOrder foodorder){
//		return foodorderdao.getFoodOrderById(foodorder.getId());
//		
//	}
	public List<item> getlistOfItems(long id){
		return foodorderdao.getListOfItems(id);
	}
	
}
