package com.example.demo.model;

public class Product {

	private int Id;

	private String Name;

	private String Type;

	private String Place;

	private int Warranty;
	
	
	

	public Product(int id, String name, String type, String place, int warranty) {
		super();
		Id = id;
		Name = name;
		Type = type;
		Place = place;
		Warranty = warranty;
	}

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getType() {
		return Type;
	}

	public void setType(String type) {
		Type = type;
	}

	public String getPlace() {
		return Place;
	}

	public void setPlace(String place) {
		Place = place;
	}

	public int getWarranty() {
		return Warranty;
	}

	public void setWarranty(int warranty) {
		Warranty = warranty;
	}

	@Override
	public String toString() {
		return "Product [Id=" + Id + ", Name=" + Name + ", Type=" + Type + ", Place=" + Place + ", Warranty=" + Warranty
				+ "]";
	}

}
