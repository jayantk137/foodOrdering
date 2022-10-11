package com.project.foodOrdering.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.project.foodOrdering.dao.foodProductDao;
import com.project.foodOrdering.dto.Foodproduct;
import com.project.foodOrdering.dto.ResponseStructure;

@Service
public class foodProductService {
	
	@Autowired
	foodProductDao foodproductdao;
	
	public Foodproduct saveproduct(long user_id,int menu_id,Foodproduct foodproduct) {
		return foodproductdao.saveFoodProduct(user_id, menu_id, foodproduct);
	}
	

	
	public Foodproduct getProductById(int id) {
		return foodproductdao.getProductById(id);
		
		}


	public List<Foodproduct> deleteproduct(int id,int menu_id){
		return foodproductdao.deleteFoodProductById(id, menu_id);	
	}
	
	
	
	public Foodproduct updateFoodproduct(Foodproduct foodproduct,int id){
	return foodproductdao.UpdateFoodproductById(foodproduct, id);
	}
}

