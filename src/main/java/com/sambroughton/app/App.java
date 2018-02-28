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
            ResultSet rs = stm.executeQuery("SELECT department.department_description, position.pay_type, employee.education_level "
                                          + "FROM department "
                                          + "INNER JOIN employee ON department.department_id=employee.department_id "
                                          + "INNER JOIN position ON employee.position_id=position.position_id "
                                          + "WHERE department_description='Store Management' "
                                          + "AND pay_type='Monthly' "
                                          + "AND education_level='Graduate Degree';");
            
            // Process rs
            while (rs.next()) {
                System.out.println(rs.getString("department_description") + ", "+ rs.getString("pay_type") + ", " + rs.getString("education_level"));
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
/*
SELECT foodmart.department.department_description, foodmart.employee.education_level
FROM foodmart.department
INNER JOIN foodmart.employee ON foodmart.department.department_id=foodmart.employee.department_id;
*/