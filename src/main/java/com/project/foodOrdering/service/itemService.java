package com.project.foodOrdering.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.project.foodOrdering.dao.itemDao;
import com.project.foodOrdering.dto.ResponseStructure;
import com.project.foodOrdering.dto.item;

@Service
public class itemService {
	
	
	@Autowired
	itemDao itemdao;
	
	public item saveItem(item itm,long id) {
		return itemdao.saveItem(itm,id);
		
	}
	
	public  List<item> getItems(){
		return itemdao.getAllItems();
		
		
	}
	
	public item getItemById(long id){
		return itemdao.getItemById(id);
	}
	

	public item deleteitem(long id){
		return  itemdao.getItemById(id);
		
		}
	
	
	public item updateItem(item itm){
		return  itemdao.getItemById(itm.getId());

	}
}
