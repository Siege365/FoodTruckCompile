package com.example.softwareproj;

import javax.swing.*;
import java.sql.*;


import static java.sql.DriverManager.getConnection;

public class DBconnectionFood {
    private static Connection con = null; // Changed to private static

    public static Connection ConnectionDB() {
        try {
            // Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Connect to the MySQL database
            con = getConnection("jdbc:mysql://localhost:3306/foodtruck", "Admin", "Putbol");
            System.out.println("Connection Succeeded");
            return con;
        } catch (Exception e) {
            // Show a GUI error message and print stack trace if connection fails
            JOptionPane.showMessageDialog(null, e);
            System.out.println("Connection Failed: " + e.getMessage());
            return null;
        }


    } public static void main(String []args){
        Connection con = ConnectionDB();
    }
}
