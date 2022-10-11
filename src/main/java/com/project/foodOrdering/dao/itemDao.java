package com.project.foodOrdering.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.foodOrdering.dto.foodOrder;
import com.project.foodOrdering.dto.item;
import com.project.foodOrdering.repo.foodOrderRepo;
import com.project.foodOrdering.repo.itemRepo;

@Repository
public class itemDao {
	@Autowired
	itemRepo itemrepo;
	
	@Autowired
	foodOrderDao foodorderdao;
	
	@Autowired
	foodOrderRepo frepo; 
	public item saveItem(item itm,long foodorder_id) {
		foodOrder foodorder = frepo.getById(foodorder_id);
		
		if(foodorder!=null) {
			foodorder.addFoodItems(itm);
			itm.setFoodOrder(foodorder);
			itemrepo.save(itm);
		}
		return itm;
	}
	
	public List<item> getAllItems(){
		return itemrepo.findAll();
	}
	
	
	public item getItemById(long id) {
		return itemrepo.getById(id);
		
	}
	
	public String deleteItem(long id) {
		Optional<item> itm = itemrepo.findById(id);
		if(itm.isPresent()) {
			itemrepo.delete(itm.get());
			return "Item "+id+" data is deleted";
		}
		
		return "Item with "+id +"not found";
	}
	
	public item updateItem(item itm) {
		Optional<item> optional = itemrepo.findById(itm.getId());
		if(optional.isPresent()) {
			return itemrepo.save(itm);
		}
		return null;
	}

}
