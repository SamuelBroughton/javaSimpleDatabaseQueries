package com.sambroughton.app;

import java.sql.*;

public class App {
    
    public static void main( String[] args ) throws SQLException {        
        
        String URL = "jdbc:mysql://localhost:3306/foodmart";
        String USER = "root";
        String PASSWORD = "84Rts5-G.";
                
        
        try {
            // Connecting to database
            System.out.println("Connecting to database. . .");
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Connected!");
            
            // Creating statement
            Statement stm = conn.createStatement();
            
            // SQL query
            ResultSet rs = stm.executeQuery("select * from department");
            
            // Process rs
            while (rs.next()) {
                System.out.println(rs.getString("department_id") + ", " + rs.getString("department_description"));
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
