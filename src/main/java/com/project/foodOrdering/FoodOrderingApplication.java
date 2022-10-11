package com.project.foodOrdering;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
//import java.util.ArrayList;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

import com.project.foodOrdering.dto.User;
import com.project.foodOrdering.repo.UserRepo;

//
//import springfox.documentation.builders.RequestHandlerSelectors;
//import springfox.documentation.service.ApiInfo;
//import springfox.documentation.service.Contact;
//import springfox.documentation.service.VendorExtension;
//import springfox.documentation.spi.DocumentationType;
//import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
@EnableSwagger2
public class FoodOrderingApplication implements CommandLineRunner {
	
	@Autowired
	private UserRepo userrepo;

	public static void main(String[] args) {
		SpringApplication.run(FoodOrderingApplication.class, args);
	}
	
//	List<VendorExtension> vendorext = new ArrayList<VendorExtension>();
//	Contact contact = new Contact("Jayant","http://food-app.com","jayant@mail.com");
//	ApiInfo apiinfo = new ApiInfo("Food App","Online Food Ordering System Project", 
//			"snapshot-0.01",
//			"https://food-app.com", contact,
//			"www.foodie.com", "terms and condition", vendorext);
//	
//	@Bean
//	public Docket myDocket() {
//		return new Docket(DocumentationType.SWAGGER_2)
//				.select().apis(RequestHandlerSelectors.basePackage("com.project.foodOrdering"))
//				.build()
//				.apiInfo(apiinfo);
//	}
	
@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Code Working");
//		User user =new User();
//	    user.setName("Umaang Kumar");
//	    user.setPassword("1234");
//	    user.setEmail("kumaang19@gmail.com");
//        user.setRole("admin");
//        user.setUsername("kumaang");
//////	    
//        userrepo.save(user);
//	   
	}

}
