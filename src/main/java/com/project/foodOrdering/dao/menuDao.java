package com.project.foodOrdering.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.foodOrdering.dto.Foodproduct;
import com.project.foodOrdering.dto.Menu;
import com.project.foodOrdering.dto.User;
import com.project.foodOrdering.repo.UserRepo;
import com.project.foodOrdering.repo.menuRepo;

@Repository
public class menuDao {
	
	@Autowired
	menuRepo menurepo;
	
	@Autowired
	UserRepo userrepo;
	
	@Autowired
	UserDao userdao;
	
	public Menu savemenu(Menu menu,long id) {
		User usr = userdao.getUserById(id);
		if(usr!=null) {
			menu.setUser(usr);
			usr.setMenu(menu);
			return menurepo.save(menu);
		}
		
		return null;
		
	}
	
	public List<Menu> getAllData(){
		return menurepo.findAll();
	}
	
	public Menu getMenuById(long id) {
		User user=userdao.getUserById(id);
	     Menu menu=user.getMenu();
	     return menu;
	}

	
	public String deleteMenu(int id) {
		Optional<Menu> optional=	menurepo.findById( id);
		if(optional.isPresent()) {
			menurepo.delete(optional.get());
			return "menu data is deleted";
		}
			return "menu not found";
	
	}
	
	public List<Foodproduct> getfoodproduct(int menu_id){
		  Optional<Menu> menu = menurepo.findById(menu_id);
		  if(menu.isPresent()) {
			  return menu.get().getFoodproducts();
		  }
		  else {
			  return null;
		  }
	  }
	
		
//	public Menu UpdateMenuById(Menu new_menu) {
//	        
//		Optional<Menu> optional =menurepo.findById(new_menu.getId());
//		if(optional.isPresent()) {
//			return menurepo.save(new_menu);
//		}
//		return null;
//	    }
	

}
