package com.project.foodOrdering.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.foodOrdering.dto.Foodproduct;
import com.project.foodOrdering.dto.Menu;
import com.project.foodOrdering.dto.User;
import com.project.foodOrdering.repo.foodProductRepo;
import com.project.foodOrdering.repo.menuRepo;

@Repository
public class foodProductDao {
	
	@Autowired
	foodProductRepo foodproductrepo;
	
	@Autowired
	UserDao userdao;
	@Autowired
	menuRepo menurepo;
	
	public Foodproduct saveFoodProduct(long user_id,int menu_id,Foodproduct foodproduct) {
		User user=userdao.getUserById(user_id);
		  
		  if(user==null) {
			  return null;
		  }
		  else {
			  
			  Menu menu=user.getMenu();
			  menu.addFoodproducts(foodproduct);
			  
			  foodproduct.setMenu(menu);
			  return foodproductrepo.save(foodproduct);
		  }
	}
	
	public List<Foodproduct> getAllFoodProduct(){
		return foodproductrepo.findAll();
	}
	
	
	public Foodproduct getProductById(int id) {
		Optional<Foodproduct> optional = foodproductrepo.findById(id);
		if(optional.isPresent()) {
			return optional.get();
		}
		else {
			return null;
		}
	}
	
	
	public List<Foodproduct> deleteFoodProductById(int id,int menu_id) {
		Optional<Menu> optional= menurepo.findById(menu_id);
	      
	    
	      if(optional.isPresent()) {
	    	  Optional<Foodproduct> fprod  = foodproductrepo.findById(id);
	    	  foodproductrepo.delete(fprod.get());
	    	  return optional.get().delete(id);
	    	  
	    	 
	      }
	    	 
	      
	          return null;
		
	}
	
	
 
	
	public Foodproduct UpdateFoodproductById(Foodproduct new_product,int fprodid) {
		
		Foodproduct existing_product = foodproductrepo.getById(fprodid);
		existing_product.setName(new_product.getName());
		existing_product.setAbout(new_product.getAbout());
		existing_product.setAvailability(new_product.getAvailability());
		existing_product.setPrice(new_product.getPrice());
		existing_product.setType(new_product.getType());
		return foodproductrepo.save(existing_product);
		 
			
			
	    }

	
	

}
