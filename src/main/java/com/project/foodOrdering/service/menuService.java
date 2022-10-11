package com.project.foodOrdering.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.project.foodOrdering.dao.menuDao;
import com.project.foodOrdering.dto.Foodproduct;
import com.project.foodOrdering.dto.Menu;
import com.project.foodOrdering.dto.ResponseStructure;

@Service
public class menuService {
	
	@Autowired
	menuDao menudao;
	
	
	public Menu saveMenu(Menu menu ,long id) {
		return menudao.savemenu(menu, id);
	}
	
		
	
	
	public String delete(int id) {
		return menudao.deleteMenu(id);
	}
	
//	public ResponseStructure<Menu> updateproduct(Menu menu){
//		ResponseStructure<Menu> responseStructure=new ResponseStructure<Menu>();
//				
//				Menu menu1=menudao.getMenuById(menu.getId());
//				if(menu1 !=null) {
//					responseStructure.setStatusCode(HttpStatus.FOUND.value());
//					responseStructure.setMessage(" data is updated");
//					responseStructure.setData(menu1);
//					
//				}
//				
//				return responseStructure;
//				
//				
//			}
	
	public List<Foodproduct> getfoodproduct(int id){
		return menudao.getfoodproduct(id);
	}
	
	public Menu getmenu(long id){
		return menudao.getMenuById(id);
	}
}
