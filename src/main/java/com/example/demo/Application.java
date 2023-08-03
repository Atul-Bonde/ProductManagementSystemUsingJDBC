package com.example.demo;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.example.demo.controller.ProductController;
import com.example.demo.model.Product;

@SpringBootApplication
public class Application {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
		
		ProductController controller = context.getBean(ProductController.class);
		
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Welcome To Product Management Application");
		
		while(true) {
			
			System.out.println("Press 1 For Add a Product");
			System.out.println("Press 2 For Get All Product Details");
			System.out.println("Press 3 For Get a Product By Name");
			System.out.println("Press 4 For Get a product By Id");
			System.out.println("Press 5 For update a Product Details");
			System.out.println("Press 6 For Exit");
			int choice = sc.nextInt();
			
			
			switch(choice) {
			
			case  1:
				controller.saveproduct();
				break;
				
			case 2:
				ArrayList<Product> list = controller.getall();
				list.forEach(e -> System.out.println(e));
				break;
				
			case 3:
				controller.findbyname();
				break;
				
			case 4:
				controller.findbyid();
				break;
			case 5:
				controller.update();
				break;
			case 6:
				System.exit(0);
			 default:
				 System.out.println("invalid input");
				
			
			}
			
		}
		

		
		
	}

}
