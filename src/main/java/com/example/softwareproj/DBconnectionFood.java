package com.example.softwareproj;


import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.scene.layout.*;
import javafx.scene.text.TextAlignment;

import javax.swing.*;
import java.io.File;
import java.net.URL;
import java.sql.*;
import java.util.Map;

public class DBconnectionFood {
    private static Connection con = null; // Static connection for reuse
    public static Connection ConnectionDB() {
        try {
            // Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Connect to the MySQL database
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/foodtruck1", "Admin", "Putbol");
            System.out.println("Connection Succeeded");
            return con; // Return the connection object
        } catch (Exception e) {
            // Show a GUI error message and print stack trace if connection fails
            JOptionPane.showMessageDialog(null, e);
            System.out.println("Connection Failed: " + e.getMessage());
            return null;
        }
    }
    public static void showAlert(String title, String message, Alert.AlertType alertType) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }
    // Getter methods for fetching data from the database
//DIRI A IPANG TAPOK ANG MGA ADMIN RELATED
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

    //Get today's income
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




//WITH IN DIRIA IPANG TAPOK ANG ADMIN RELATED

    //Diria itapok ang mga customer related
    public static void submitFeedback(String UserID, String Username, String FeedbackType, String TitleOfConcern, String FeedbackDescription) {
        // Use a simple INSERT statement to always insert a new row
        String query = "INSERT INTO feedback (Account_ID, Username, TypeOfFeedback, TitleOfConcern, FeedbackContent) VALUES (?, ?, ?, ?, ?)";

        try (Connection connection = DBconnectionFood.ConnectionDB();
             PreparedStatement statement = connection.prepareStatement(query)) {

            // Set the parameters for the query
            statement.setString(1, UserID);
            statement.setString(2, Username);
            statement.setString(3, FeedbackType);
            statement.setString(4, TitleOfConcern);
            statement.setString(5, FeedbackDescription);

            // Execute the query
            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                showAlert("Success", "Feedback submitted successfully.", Alert.AlertType.INFORMATION);
            } else {
                showAlert("Error", "Failed to submit feedback.", Alert.AlertType.ERROR);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            showAlert("Error", "An error occurred while submitting feedback.", Alert.AlertType.ERROR);
        }
    }




    //within diri ipang butang ang customer related

    public static void main(String[] args) {
        // Test the connection and getters
        Connection con = ConnectionDB();
    }



}
