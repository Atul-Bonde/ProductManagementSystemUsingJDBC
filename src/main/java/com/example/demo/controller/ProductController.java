package com.example.demo.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.example.demo.model.Product;
import com.example.demo.service.ProductServiceI;

@Controller
public class ProductController {

	@Autowired
	private ProductServiceI productServiceI;
	
	Product pro=new Product();
	
	Scanner sc=new Scanner(System.in);
	
	public void saveproduct() throws ClassNotFoundException, SQLException {
		
		System.out.println("Enter a Product id :");
		int id = sc.nextInt();
		pro.setId(id);
		
		System.out.println("Enter a Product Name");
		String name = sc.next();
		pro.setName(name);
		
		System.out.println("Enter a product Type");
		String type = sc.next();
		pro.setType(type);
		
		System.out.println("Enter a product place");
		String place = sc.next();
		pro.setPlace(place);
		
		System.out.println("Enter a product Warranty");
	       int war = sc.nextInt();
	     pro.setWarranty(war);
	       
		productServiceI.saveproduct(pro);
		
	}
	
	public ArrayList<Product> getall() throws ClassNotFoundException, SQLException{
		
		ArrayList<Product> getallproduct = productServiceI.getallproduct();
		
		return getallproduct;
	}
	
	
	public void findbyname() throws ClassNotFoundException, SQLException {
		
		System.out.println("Enter a product Name");
		String name = sc.next();
		
		ArrayList<Product> findbyname = productServiceI.findbyname(name);
		
		if(findbyname.isEmpty()) {
			
			System.out.println("No Product Found of Name "+name);
		}
		else {
			findbyname.forEach(e -> System.out.println(e));
		}
		
	}
	
	public void findbyid() throws ClassNotFoundException, SQLException {
		System.out.println("Enter a Product Id : ");
		int id = sc.nextInt();
		
		Product findbyid = productServiceI.findbyid(id);
		
		if(findbyid!=null) {
			System.out.println(findbyid);
			
		}
		else {
			
			System.out.println(" No Product Found of Id No "+id);
		}
	}
	
	
 public void update() throws ClassNotFoundException, SQLException {
	 
	 boolean flag=true;
	 
	 while(flag) {
	System.out.println("Press 1 for Update Name");
	System.out.println("Press 2 for Update Place");
	System.out.println("Press 3 for Update Type");
	System.out.println("Press 4 for Update Warranty");
	System.out.println("Press 5 for Exit to main Menu");
	
	int choice = sc.nextInt();
	
	switch(choice) {
	
	case 1:
		System.out.println("Enter a id");
		int id = sc.nextInt();
		
		System.out.println("Enter a product name");
		String name = sc.next();
		
		productServiceI.updatename(id, name);
		System.out.println("Name Updated Sucessfully to : "+name);
		break;
		
	case 2:
		System.out.println("Enter a Name");
		String name1 = sc.next();
		System.out.println("Enter a Place");
		String place = sc.next();
		
		productServiceI.updateplace(place, name1);
		System.out.println("Place Updated Sucessfully to : "+place);
		break;
	
	case 3:
		System.out.println("Enter a Name");
		String name2 = sc.next();
		System.out.println("Enter a Type");
		String type = sc.next();
		
		productServiceI.updatetype(type, name2);
		System.out.println("Type Updated Sucessfully to : "+type);
		break;
	
	case 4:
		System.out.println("Enter a Name");
		String name3 = sc.next();
		
		System.out.println("Enter a Warranty");
		int war = sc.nextInt();
		
		productServiceI.updatewarranty(war, name3);
		System.out.println("Warranty updated Successfully to : "+war);
		
		break;
		
	case 5:
		flag=false;
		break;
	
	}
	 
	 
	 }
      }	
}
