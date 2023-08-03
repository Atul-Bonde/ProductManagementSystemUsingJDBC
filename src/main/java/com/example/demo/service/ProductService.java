package com.example.demo.service;

import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;

@Service
public class ProductService implements ProductServiceI {

	@Autowired
	private ProductRepository productRepository;

	@Override
	public void saveproduct(Product p) throws ClassNotFoundException, SQLException {

		productRepository.savepro(p);

	}

	@Override
	public ArrayList<Product> getallproduct() throws ClassNotFoundException, SQLException {

		ArrayList<Product> list = productRepository.getallproduct();

		return list;
	}

	@Override
	public ArrayList<Product> findbyname(String name) throws ClassNotFoundException, SQLException {

		ArrayList<Product> finbyname = productRepository.finbyname(name);

		return finbyname;
	}

	@Override
	public Product findbyid(int id) throws ClassNotFoundException, SQLException {

		Product getbyid = productRepository.getbyid(id);

		return getbyid;
	}

	@Override
	public void updatename(int id, String name) throws ClassNotFoundException, SQLException {

		Product getbyid = productRepository.getbyid(id);

		if (getbyid.getName() == null) {

			System.out.println("Invalid Id");
		} else {

			productRepository.updatename(id, name);
		}
	}

	@Override
	public void updateplace(String place, String name) throws ClassNotFoundException, SQLException {

		ArrayList<Product> finbyname = productRepository.finbyname(name);

		if (finbyname.isEmpty()) {

			System.out.println("Invalid Product Name");

		} else {

			productRepository.updateplace(place, name);
		}
	}

	@Override
	public void updatetype(String type, String name) throws ClassNotFoundException, SQLException {

		productRepository.updatetype(type, name);
	}

	@Override
	public void updatewarranty(int warranty, String name) throws ClassNotFoundException, SQLException {

		productRepository.updatewarranty(warranty, name);

	}

}
