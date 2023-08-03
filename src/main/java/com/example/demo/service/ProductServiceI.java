package com.example.demo.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.example.demo.model.Product;

public interface ProductServiceI {

	
	public void saveproduct(Product p) throws ClassNotFoundException, SQLException;
	
	public ArrayList<Product> getallproduct() throws ClassNotFoundException, SQLException;
	
	public ArrayList<Product> findbyname(String name) throws ClassNotFoundException, SQLException;
	
	public Product findbyid(int id) throws ClassNotFoundException, SQLException;
	
	public void updatename(int id,String name) throws ClassNotFoundException, SQLException ;
	
	public void updateplace(String place,String name) throws ClassNotFoundException, SQLException ;
	
	public void updatetype(String type,String name) throws ClassNotFoundException, SQLException ;
	
	public void updatewarranty(int warranty,String name) throws ClassNotFoundException, SQLException ;
}
