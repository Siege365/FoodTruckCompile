package com.example.softwareproj;


import com.example.softwareproj.GettersAndSetters.CustomerOrder;
import com.example.softwareproj.GettersAndSetters.FeedBack;
import com.example.softwareproj.GettersAndSetters.FoodItem;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.*;

import javax.swing.*;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import java.sql.*;


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
    public static int getTotalOrders() {
        String query = "SELECT COUNT(*) FROM customerorder WHERE Status != 'Completed'";
        try (Connection con = ConnectionDB();  // Connection opened here
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            if (rs.next()) {
                return rs.getInt(1); // Return the count of orders
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0; // Return 0 if an error occurs
    }

    //Get today's income
    public static double getTodaysIncome() {
        String query = "SELECT SUM(TotalAmount) FROM customerorder WHERE DATE(OrderDate) = CURDATE() AND Status = 'Completed'";
        try (Connection con = ConnectionDB();  // Connection opened here
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            if (rs.next()) {
                return rs.getDouble(1); // Return today's total income
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0.0; // Return 0.0 if an error occurs
    }


    // Get the total income
    public static double getTotalIncome() {
        String query = "SELECT SUM(TotalAmount) FROM customerorder WHERE Status = 'Completed'";
        try (Connection con = ConnectionDB();  // Connection opened here
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
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
        String query = "SELECT SUM(AmountofProducts) FROM customerorder WHERE Status = 'Completed'";
        try (Connection con = ConnectionDB();  // Connection opened here
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            if (rs.next()) {
                return rs.getInt(1); // Return the sum of sold products
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0; // Return 0 if no data or an error occurs
    }

    //Inventory page
    // Save or Update Product
    public static void saveOrUpdateProduct(int prodId, String prodName, String prodCategory, int prodStock, String prodPrice, String imageFilePath) {
        if (prodName.isEmpty() || prodCategory == null || prodPrice.isEmpty()) {
            showAlert("Validation Error", "Please fill in all the required fields.", Alert.AlertType.WARNING);
            return;
        }

        double parsedPrice;
        try {
            parsedPrice = Double.parseDouble(prodPrice);
        } catch (NumberFormatException e) {
            showAlert("Input Error", "Please enter a valid numeric value for price.", Alert.AlertType.WARNING);
            return;
        }

        String status = (prodStock == 0) ? "Unavailable" : (prodStock <= 10) ? "Available (Low Stock)" : "Available";

        try (Connection connection = ConnectionDB()) {
            if (isNewProduct(prodId, connection)) { // Check if the product is new
                String insertQuery = "INSERT INTO products (ProductID, ProductName, Category, Price, Stock, Productimg, Status) " +
                        "VALUES (?, ?, ?, ?, ?, ?, ?)";
                try (PreparedStatement statement = connection.prepareStatement(insertQuery)) {
                    statement.setInt(1, prodId);
                    statement.setString(2, prodName);
                    statement.setString(3, prodCategory);
                    statement.setDouble(4, parsedPrice);
                    statement.setInt(5, prodStock);
                    statement.setString(6, imageFilePath); // Set the file path (or "No Image")
                    statement.setString(7, status);
                    statement.executeUpdate();
                    showAlert("Success", "Product added successfully.", Alert.AlertType.INFORMATION);
                }
            } else {
                String updateQuery = "UPDATE products SET ProductName = ?, Category = ?, Price = ?, Stock = ?, Productimg = ?, Status = ? " +
                        "WHERE ProductID = ?";
                try (PreparedStatement statement = connection.prepareStatement(updateQuery)) {
                    statement.setString(1, prodName);
                    statement.setString(2, prodCategory);
                    statement.setDouble(3, parsedPrice);
                    statement.setInt(4, prodStock);
                    statement.setString(5, imageFilePath); // Use the file path for update
                    statement.setString(6, status);
                    statement.setInt(7, prodId);
                    statement.executeUpdate();
                    showAlert("Success", "Product updated successfully.", Alert.AlertType.INFORMATION);
                }
            }
        } catch (SQLException e) {
            showAlert("Database Error", "An error occurred while saving/updating the product. Please check your connection.", Alert.AlertType.ERROR);
            e.printStackTrace();
        }
    }

    // Check if a product is new
    private static boolean isNewProduct(int prodId, Connection connection) throws SQLException {
        String checkQuery = "SELECT COUNT(*) FROM products WHERE ProductID = ?";
        try (PreparedStatement statement = connection.prepareStatement(checkQuery)) {
            statement.setInt(1, prodId);
            try (ResultSet resultSet = statement.executeQuery()) {
                return resultSet.next() && resultSet.getInt(1) == 0;
            }
        }
    }

    public static boolean deleteProduct(String productName) {
        String query = "DELETE FROM products WHERE ProductName = ?";
        try (Connection connection = ConnectionDB(); // Assuming you have a method to establish the connection
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, productName);
            int rowsAffected = statement.executeUpdate();
            return rowsAffected > 0; // Return true if the deletion was successful
        } catch (SQLException e) {
            e.printStackTrace();
            return false; // Return false if an error occurred
        }
    }


    // New method to load feedback data
    public static ObservableList<FeedBack> loadFeedbackData() {
        ObservableList<FeedBack> feedBacks = FXCollections.observableArrayList();
        String query = "SELECT * FROM feedback";

        try (Connection connection = ConnectionDB();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                int cusID = resultSet.getInt("Account_ID");
                String username = resultSet.getString("Username");
                String typeOfFeedback = resultSet.getString("TypeOfFeedback");
                String typeOfConcern = resultSet.getString("TitleOfConcern");
                String feedbackContent = resultSet.getString("FeedbackContent");

                // Create new FeedBack object and add it to the list
                feedBacks.add(new FeedBack(cusID, username, typeOfFeedback, typeOfConcern, feedbackContent));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            showAlert("Database Error", "An error occurred while fetching feedback data.", Alert.AlertType.ERROR);
        }
        System.out.println("Feedback Loaded");
        return feedBacks; // Return the list of feedbacks
    }
    public static ObservableList<CustomerOrder> loadCustomerOrderData() {
        ObservableList<CustomerOrder> selectedOrder = FXCollections.observableArrayList();
        String query = "SELECT * FROM customerorder";

        try (Connection connection = ConnectionDB();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                // Retrieving customer and order details from ResultSet
                int orderID = resultSet.getInt("OrderID"); //column label == column name sa database
                String customerName = resultSet.getString("CustomerName");
                String contactNumber = resultSet.getString("CustomerNumber");
                String address = resultSet.getString("CustomerAddress");
                String orderType = resultSet.getString("OrderType");
                String paymentType = resultSet.getString("PaymentType");
                String date = resultSet.getString("OrderDate");
                int totalProducts = resultSet.getInt("AmountofProducts");
                String items = resultSet.getString("FoodItems");
                int totalAmount = resultSet.getInt("TotalAmount");
                String status = resultSet.getString("Status");


                // Create new FeedBack object and add it to the list
                selectedOrder.add(new CustomerOrder(orderID, customerName, contactNumber, address, orderType,paymentType,date,totalProducts,items,totalAmount,status));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            showAlert("Database Error", "An error occurred while fetching feedback data.", Alert.AlertType.ERROR);
        }
        System.out.println("Orders Loaded");
        return selectedOrder; // Return the list of feedbacks
    }

    public static void updateCustomerOrderStatus(CustomerOrder orderID,String orderStatus){
        Connection con = ConnectionDB();
        String sql = "UPDATE customerorder SET Status = ? WHERE OrderID  = ?";

        try (PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setString(1, orderStatus);          // Set the status
            pst.setInt(2, orderID.getOrderID());
            pst.executeUpdate();
        } catch (SQLException e) {
            showAlert("Database Error", e.getMessage(), Alert.AlertType.ERROR);
            e.printStackTrace();
        } finally {
            try {
                if (con != null && !con.isClosed()) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

//WITH IN DIRIA IPANG TAPOK ANG ADMIN RELATED




    //Diria itapok ang mga customer related
    public static boolean deleteAccountFromDatabase(String username) {
        try (Connection con = ConnectionDB()) {
            if (con != null) {
                // Check if username exists in register table
                String checkSql = "SELECT COUNT(*) FROM register WHERE Username = ?";
                try (PreparedStatement checkPst = con.prepareStatement(checkSql)) {
                    checkPst.setString(1, username);
                    try (ResultSet rs = checkPst.executeQuery()) {
                        if (rs.next() && rs.getInt(1) == 0) {
                            showAlert("Error", "Account not found in the register table.", Alert.AlertType.ERROR);
                            return false;
                        }
                    }
                }

                // Delete from accountdetails
                String sql1 = "DELETE FROM accountdetails WHERE Username = ?";
                try (PreparedStatement pst1 = con.prepareStatement(sql1)) {
                    pst1.setString(1, username);
                    pst1.executeUpdate();
                }

                // Delete from register
                String sql2 = "DELETE FROM register WHERE Username = ?";
                try (PreparedStatement pst2 = con.prepareStatement(sql2)) {
                    pst2.setString(1, username);
                    pst2.executeUpdate();
                }

                return true;  // Successfully deleted the account
            } else {
                showAlert("Error", "Failed to connect to the database.", Alert.AlertType.ERROR);
                return false;
            }
        } catch (SQLException e) {
            showAlert("Database Error", e.getMessage(), Alert.AlertType.ERROR);
            e.printStackTrace();
            return false;
        }
    }

    public static void submitFeedback(String UserID, String Username, String FeedbackType, String TitleOfConcern, String FeedbackDescription) {
        // Use a simple INSERT statement to always insert a new row
        String query = "INSERT INTO feedback (Account_ID, Username, TypeOfFeedback, TitleOfConcern, FeedbackContent) VALUES (?, ?, ?, ?, ?)";

        try (Connection connection = ConnectionDB();
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

    //credit card
    public static void saveOrUpdateCardInfo(int accountId, String cardName, String cardNumber, LocalDate cardDate, String cardCVC) {
        String query = "INSERT INTO accountdetails (Account_ID, Account_Cardname, Account_Cardnumber, Account_CardExpiryDate, Account_CardCVC) " +
                "VALUES (?, ?, ?, ?, ?) " +
                "ON DUPLICATE KEY UPDATE " +
                "Account_Cardname = VALUES(Account_Cardname), " +
                "Account_Cardnumber = VALUES(Account_Cardnumber), " +
                "Account_CardExpiryDate = VALUES(Account_CardExpiryDate), " +
                "Account_CardCVC = VALUES(Account_CardCVC);";

        try (Connection connection = ConnectionDB();
             PreparedStatement statement = connection.prepareStatement(query)) {

            // Set parameters for the query
            statement.setInt(1, accountId);               // Account_ID (primary key)
            statement.setString(2, cardName);              // Account_Cardname
            statement.setString(3, cardNumber);            // Account_Cardnumber
            statement.setString(4, cardDate.toString());   // Account_CardExpiryDate (converted to String)
            statement.setString(5, cardCVC);               // Account_CardCVC

            // Execute the query
            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                showAlert("Success", "Card details updated successfully.", Alert.AlertType.INFORMATION);
            } else {
                showAlert("Error", "Failed to update card details.", Alert.AlertType.ERROR);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            showAlert("Error", "An error occurred while updating the card details: " + e.getMessage(), Alert.AlertType.ERROR);
        } catch (NumberFormatException e) {
            showAlert("Validation Error", "Invalid Account ID.", Alert.AlertType.WARNING);
        }
    }

    //my account
    public static void saveOrUpdateUserInfo(
            int accountID, String username, String fullName, String email, String password,
            String mobileNumber, String gender, String address, String imageFilePath) {

        // Validate inputs
        if (fullName.isEmpty() || email.isEmpty() || mobileNumber.isEmpty() || address.isEmpty() || gender == null) {
            showAlert("Validation Error", "Please fill in all the required fields.", Alert.AlertType.WARNING);
            return; // Stop execution if fields are empty
        }

        // SQL queries for `accountdetails` and `register` tables
        String accountDetailsQuery = "INSERT INTO accountdetails (Account_ID, Username, Full_Name, Email, Password, Mobile_Number, Gender, Account_Address, Account_Avatar) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?) " +
                "ON DUPLICATE KEY UPDATE " +
                "Full_Name = VALUES(Full_Name), " +
                "Email = VALUES(Email), " +
                "Password = VALUES(Password), " +
                "Mobile_Number = VALUES(Mobile_Number), " +
                "Gender = VALUES(Gender), " +
                "Account_Address = VALUES(Account_Address), " +
                "Account_Avatar = VALUES(Account_Avatar);";

        String registerTableQuery = "UPDATE register SET " +
                "Email = ?, FullName = ?, Password = ? " +
                "WHERE Username = ?;";

        try (Connection connection = ConnectionDB();
             PreparedStatement accountDetailsStmt = connection.prepareStatement(accountDetailsQuery);
             PreparedStatement registerTableStmt = connection.prepareStatement(registerTableQuery)) {

            // Set parameters for `accountdetails` query
            accountDetailsStmt.setInt(1, accountID);          // Account_ID (primary key)
            accountDetailsStmt.setString(2, username);
            accountDetailsStmt.setString(3, fullName);
            accountDetailsStmt.setString(4, email);
            accountDetailsStmt.setString(5, password);
            accountDetailsStmt.setString(6, mobileNumber);
            accountDetailsStmt.setString(7, gender);
            accountDetailsStmt.setString(8, address);
            accountDetailsStmt.setString(9, imageFilePath);

            // Execute `accountdetails` query
            int accountRowsAffected = accountDetailsStmt.executeUpdate();

            // Set parameters for `register` query
            registerTableStmt.setString(1, email);
            registerTableStmt.setString(2, fullName);
            registerTableStmt.setString(3, password);
            registerTableStmt.setString(4, username);

            // Execute `register` query
            int registerRowsAffected = registerTableStmt.executeUpdate();

            // Provide feedback based on the results
            if (accountRowsAffected > 0 && registerRowsAffected > 0) {
                showAlert("Success", "User profile updated successfully in both tables.", Alert.AlertType.INFORMATION);
            } else if (accountRowsAffected > 0) {
                showAlert("Partial Success", "User profile updated in `accountdetails` table, but not in `register` table.", Alert.AlertType.WARNING);
            } else if (registerRowsAffected > 0) {
                showAlert("Partial Success", "User profile updated in `register` table, but not in `accountdetails` table.", Alert.AlertType.WARNING);
            } else {
                showAlert("Error", "Failed to update user profile in both tables.", Alert.AlertType.ERROR);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            showAlert("Error", "An error occurred while updating the user profile: " + e.getMessage(), Alert.AlertType.ERROR);
        } catch (NumberFormatException e) {
            showAlert("Validation Error", "Invalid Account ID.", Alert.AlertType.WARNING);
        }
    }


    //MO ORDER ANG CUSTOMER
    public static void insertOrderIntoDatabase(String customerName, String contactNumber, String address,
                                               String orderType, String paymentType, int totalProducts,
                                               double totalAmount, String Items) {
        String query = "INSERT INTO customerorder (CustomerName, CustomerNumber, CustomerAddress, OrderType, " +
                "PaymentType, OrderDate, AmountofProducts, FoodItems, TotalAmount, Status) " +
                "VALUES (?, ?, ?, ?, ?, CURDATE(), ?, ?, ?, ?)";

        try (Connection conn = ConnectionDB();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            // Setting basic customer and order details
            pstmt.setString(1, customerName);
            pstmt.setString(2, contactNumber);
            pstmt.setString(3, address);
            pstmt.setString(4, orderType);
            pstmt.setString(5, paymentType);

            // Total products count
            pstmt.setInt(6, totalProducts);

            pstmt.setString(7, Items);

            // Total amount
            pstmt.setDouble(8, totalAmount);

            // Default status
            pstmt.setString(9, "Pending");

            // Execute the query
            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Order inserted successfully.");
            } else {
                System.out.println("Failed to insert the order.");
            }

        } catch (SQLException e) {
            showAlert("Database Error", "Failed to insert the order into the database: " + e.getMessage(), Alert.AlertType.ERROR);
            e.printStackTrace();
        }
    }

    public static ObservableList<CustomerOrder> getCustomerOrders(String customerName) throws SQLException {
        ObservableList<CustomerOrder> cusOrders = FXCollections.observableArrayList();
        String sql = "SELECT * FROM customerorder WHERE CustomerName = ?";
        try (Connection con = ConnectionDB();
             PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setString(1, customerName); // Pass CustomerName to the query
            ResultSet rs = pst.executeQuery();

            // Loop through the result set and create CustomerOrder objects
            while (rs.next()) {
                CustomerOrder customerOrder = new CustomerOrder(
                        rs.getInt("OrderID"),
                        rs.getString("CustomerName"),
                        rs.getString("CustomerNumber"),
                        rs.getString("CustomerAddress"),
                        rs.getString("OrderType"),
                        rs.getString("PaymentType"),
                        rs.getString("OrderDate"),
                        rs.getInt("AmountofProducts"),
                        rs.getString("FoodItems"),
                        rs.getInt("TotalAmount"),
                        rs.getString("Status")
                );
                // Add the object to the list
                cusOrders.add(customerOrder);
            }
        }
        return cusOrders;
    }

    public static void cancelCustomerOrder(CustomerOrder order) {
        String query = "DELETE customerorder WHERE OrderID = ?";

        try (Connection con = ConnectionDB();
             PreparedStatement pst = con.prepareStatement(query)) {

            pst.setInt(1, order.getOrderID());
            int rowsAffected = pst.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Order ID " + order.getOrderID() + " has been cancelled.");
            } else {
                System.out.println("Failed to cancel order. No matching order found.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            showAlert("Database Error", "Unable to cancel the order: " + e.getMessage(), Alert.AlertType.ERROR);
        }
    }

    //within diri ipang butang ang customer related

    public static void main(String[] args) {
        // Test the connection and getters
        Connection con = ConnectionDB();
    }



}
