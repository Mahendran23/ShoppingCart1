package com.demo.models;

import java.sql.Connection; 
import java.sql.DriverManager; 
import java.sql.ResultSet;
import java.sql.SQLException; 
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
  
// This class can be used to initialize the database connection 
public class DatabaseConnection { 
	
	private static  Connection con = null;
	private static DatabaseConnection dc = null;
	
	private DatabaseConnection() 
        throws SQLException, ClassNotFoundException 
    { 
        // Initialize all the information regarding 
        // Database Connection 
        String dbDriver = "com.mysql.jdbc.Driver"; 
        String dbURL = "jdbc:mysql:// localhost:3306/"; 
        // Database name to access 
        String dbName = "shoppingcart"; 
        String dbUsername = "root"; 
        String dbPassword = "root"; 
  
        Class.forName(dbDriver); 
         con = DriverManager.getConnection(dbURL + dbName, 
                                                     dbUsername,  
                                                     dbPassword); 
        
    } 
	
	public static Connection getConnection()
	{
		if(dc == null)
			try {
				dc = new DatabaseConnection();
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		return con;
	}
    
    public static void main(String arg[])
    {
    	String url = "jdbc:mysql://localhost:3306/shoppingcart?useSSL=false";
        String user = "root";
        String password = "root";
        
        String query = "select * from shoppingcart.product";

        try (Connection con = DriverManager.getConnection(url, user, password);
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query)) {

            while (rs.next()) {
                
                System.out.println(rs.getString(1));
            }

        } catch (SQLException ex) {
            
            Logger lgr = Logger.getLogger(DatabaseConnection.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        } 
    }
} 