package com.demo.models;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.demo.entities.Item;
import com.demo.entities.Product;

public class ProductModel {

	public ProductModel() {
		// TODO Auto-generated constructor stub
	}

	
	public Product find (String id)
	{
		System.out.println("____________**************");
		 Product product  = null;
		
		try
		{
			 // Initialize the database 
	        Connection con = DatabaseConnection.getConnection(); 
	        Statement st = con.createStatement();
	        ResultSet rs = st.executeQuery("select * from shoppingcart.product where id="+id);
	
	        if (rs.next()) {            
	          
	            product  = new Product(rs.getString("id"),rs.getString("name"), rs.getString("photo"), Double.parseDouble(rs.getString("price")),rs.getString("total_quantity"));
	           
	        }
		
		}
		catch(Exception e)
		{
			
		}
		return  product;
	}
	
	public List findAll ()
	{
		List li = new ArrayList();
		try
		{
		 // Initialize the database 
        Connection con = DatabaseConnection.getConnection(); 
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("select * from shoppingcart.product");

        while (rs.next()) {
            
            System.out.println(rs.getString(1));
            Product product  = new Product(rs.getString("id"),rs.getString("name"), rs.getString("photo"), Double.parseDouble(rs.getString("price")),rs.getString("total_quantity"));
            li.add(product);
        }
      
		
		}
		catch(Exception e)
		{
			
		}
		
		System.out.println("========Total size :"+li.size());
		return  li;
	}
}
