package com.example.demo.query;

import org.springframework.stereotype.Component;

@Component
public class Query {
	
	public static String insert ="Insert into product values (?,?,?,?,?)";
	
	public static String read="select * from product";
	
	public static String findbyname="select * from product where Name=?";
	
	public static String findbyid="select * from product where Id=?";
	
	public static String updatename="update product set Name=? where id=?";
	
	public static String updateplace="update product set Place=? where Name=?";
	
	public static String updatetype="update product set Type=? where Name=?";
	
	public static String updatewarranty="update product set Warranty=? where Name=?";

}
