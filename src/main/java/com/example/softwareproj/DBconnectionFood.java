package com.example.softwareproj;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBconnectionFood {
    private static Connection con = null; // Static connection for reuse

    public static Connection ConnectionDB() {
        try {
            // Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Connect to the MySQL database
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/foodtruck", "Admin", "Putbol");
            System.out.println("Connection Succeeded");
            return con; // Return the connection object
        } catch (Exception e) {
            // Show a GUI error message and print stack trace if connection fails
            JOptionPane.showMessageDialog(null, e);
            System.out.println("Connection Failed: " + e.getMessage());
            return null;
        }
    }

    // Getter methods for fetching data from the database

    // Get the total number of customers
    public static int getTotalCustomers() {
        String query = "SELECT COUNT(*) FROM accountdetails";
        try (Statement stmt = con.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
            if (rs.next()) {
                return rs.getInt(1); // Return the count
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0; // Return 0 if no data or an error occurs
    }

    // Get today's income
    public static double getTodaysIncome() {
        String query = "SELECT SUM(TotalAmount) FROM orders WHERE DATE(OrderDate) = CURDATE()";
        try (Statement stmt = con.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
            if (rs.next()) {
                return rs.getDouble(1); // Return the sum of today's income
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0.0; // Return 0.0 if no data or an error occurs
    }

    // Get the total income
    public static double getTotalIncome() {
        String query = "SELECT SUM(TotalAmount) FROM orders";
        try (Statement stmt = con.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
            if (rs.next()) {
                return rs.getDouble(1); // Return the sum of total income
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0.0; // Return 0.0 if no data or an error occurs
    }

    // Get the total number of sold products
    public static int getSoldProducts() {
        String query = "SELECT SUM(Quantity) FROM order_details";
        try (Statement stmt = con.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
            if (rs.next()) {
                return rs.getInt(1); // Return the sum of sold products
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0; // Return 0 if no data or an error occurs
    }

    public static void main(String[] args) {
        // Test the connection and getters
        Connection con = ConnectionDB();
    }
}
