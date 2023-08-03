package com.example.demo.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.configuration.Configuration;
import com.example.demo.model.Product;
import com.example.demo.query.Query;

@Repository
public class ProductRepository {

	@Autowired
	private Configuration configuration;

	@Autowired
	private Query query;

	public void savepro(Product product) throws ClassNotFoundException, SQLException {

		Connection con = configuration.getconfi();

		String query = Query.insert;

		PreparedStatement ps = con.prepareStatement(query);

		ps.setInt(1, product.getId());
		ps.setString(2, product.getName());
		ps.setString(3, product.getType());
		ps.setString(4, product.getPlace());
		ps.setInt(5, product.getWarranty());

		boolean execute = ps.execute();

		System.out.println("Data Inserted Successfully of id : " + product.getId());

		con.close();

	}

	public ArrayList<Product> getallproduct() throws ClassNotFoundException, SQLException {

		ArrayList<Product> pro_list = new ArrayList<>();

		Connection con = configuration.getconfi();

		String query = Query.read;

		Statement st = con.createStatement();

		ResultSet rs = st.executeQuery(query);

		while (rs.next()) {

			Product p = new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5));

			pro_list.add(p);

		}

		con.close();

		return pro_list;

	}

	public ArrayList<Product> finbyname(String name) throws ClassNotFoundException, SQLException {

		Connection con = configuration.getconfi();

		ArrayList<Product> al = new ArrayList<>();

		String query = Query.findbyname;

		PreparedStatement ps = con.prepareStatement(query);

		ps.setString(1, name);

		ResultSet rs = ps.executeQuery();

		while (rs.next()) {

			Product p = new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5));

			al.add(p);
		}

		con.close();

		return al;

	}

	public Product getbyid(int id) throws ClassNotFoundException, SQLException {

		Connection con = configuration.getconfi();
		String query = Query.findbyid;

		PreparedStatement ps = con.prepareStatement(query);

		ps.setInt(1, id);

		ResultSet rs = ps.executeQuery();

		Product p = new Product();

		while (rs.next()) {

			p = new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5));

		}
		con.close();

		return p;
	}

	public void updatename(int id, String name) throws ClassNotFoundException, SQLException {

		Connection con = configuration.getconfi();

		String query = Query.updatename;

		PreparedStatement ps = con.prepareStatement(query);
		ps.setInt(2, id);
		ps.setString(1, name);

		ps.executeUpdate();

		con.close();

	}

	public void updateplace(String place, String name) throws ClassNotFoundException, SQLException {

		Connection con = configuration.getconfi();

		String query = Query.updateplace;

		PreparedStatement ps = con.prepareStatement(query);

		ps.setString(1, place);
		ps.setString(2, name);

		ps.executeUpdate();

		con.close();
	}

	public void updatetype(String type, String name) throws ClassNotFoundException, SQLException {

		Connection con = configuration.getconfi();

		String query = Query.updatetype;

		PreparedStatement ps = con.prepareStatement(query);

		ps.setString(1, type);
		ps.setString(2, name);

		ps.executeUpdate();

		con.close();

	}

	public void updatewarranty(int warranty, String name) throws ClassNotFoundException, SQLException {

		Connection con = configuration.getconfi();

		String query = Query.updatewarranty;

		PreparedStatement ps = con.prepareStatement(query);

		ps.setInt(1, warranty);
		ps.setString(2, name);

		ps.executeUpdate();

		con.close();
	}

}
