package com.sambroughton.app;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.util.Scanner;

public class App {
    
    /**
     * Main method
     * 
     * @param args
     * @throws SQLException
     */
    public static void main( String[] args ) throws SQLException {        
        
        // Scanner used for Command line input
        Scanner scanner = new Scanner(System.in);
        
        // Database connection variables
        String URL = "jdbc:mysql://localhost:3306/foodmart";
        String USER = "root";
        String PASSWORD = "84Rts5-G.";
                
        
        try {
            // Connecting to database
            System.out.println("Connecting to database. . .");
            Connection conn = (Connection)DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Connected!");
            
            // User input
            System.out.print("Department name: ");
            String deptName = scanner.nextLine();
            System.out.print("Pay type: ");
            String payType = scanner.nextLine();
            System.out.print("Education: ");
            String educationLevel = scanner.nextLine();
            
            // Creating statement
            Statement stm = (Statement)conn.createStatement();
            
            // SQL query
            ResultSet rs = stm.executeQuery("SELECT department.department_description, position.pay_type, employee.education_level "
                                          + "FROM department "
                                          + "INNER JOIN employee ON department.department_id=employee.department_id "
                                          + "INNER JOIN position ON employee.position_id=position.position_id "
                                          + "WHERE department_description='" + deptName + "' "
                                          + "AND pay_type='" + payType + "' "
                                          + "AND education_level='" + educationLevel + "';");
            
            // Process rs
            System.out.println();
            System.out.println("Results of query:");
            System.out.println();
            while (rs.next()) {
                System.out.println(rs.getString("department_description") + " | "
                                 + rs.getString("pay_type") + " | " 
                                 + rs.getString("education_level"));
            }
            
        } catch (Exception e) {
            System.out.println("FAILED:");
            e.printStackTrace();
        }
    }
}