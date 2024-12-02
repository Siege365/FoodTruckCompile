package com.example.softwareproj;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Optional;
import java.util.ResourceBundle;

public class AdminPageController implements Initializable {

    @FXML
    private AnchorPane customer_form;

    @FXML
    private TableView<?> customer_tableView;

    @FXML
    private Button customers_btn;

    @FXML
    private AnchorPane dashboard;

    @FXML
    private Button dashboard_btn;

    @FXML
    private AnchorPane dashboard_form;

    @FXML
    private Button feedback_btn;

    @FXML
    private AnchorPane feedback_form;

    @FXML
    private TableView<?> feedback_tableView;

    @FXML
    private Button inventory_addBtn;

    @FXML
    private Button inventory_btn;

    @FXML
    private TableColumn<?, ?> inventory_category;

    @FXML
    private Button inventory_deleteBtn;

    @FXML
    private AnchorPane inventory_form;

    @FXML
    private ImageView inventory_imageView;

    @FXML
    private Button inventory_importBtn;

    @FXML
    private TableColumn<?, ?> inventory_price;

    @FXML
    private TableColumn<?, ?> inventory_productName;

    @FXML
    private TableColumn<?, ?> inventory_status;

    @FXML
    private TableColumn<?, ?> inventory_stock;

    @FXML
    private TableView<Product> inventory_tableView;

    @FXML
    private Button inventory_updateBtn;

    @FXML
    private Button logout_btn;

    @FXML
    private AnchorPane main_form;

    @FXML
    private Label soldProductsLabel;

    @FXML
    private Label todaysIncomeLabel;

    @FXML
    private Label totalCustomersLabel;

    @FXML
    private Label totalIncomeLabel;

    @FXML
    private Label username;

    private void showAlert(String title, String message, Alert.AlertType alertType) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }

    @FXML
    void toCustomer(ActionEvent event) {
        inventory_form.setVisible(false);
        customer_form.setVisible(true);
        feedback_form.setVisible(false);
        dashboard_form.setVisible(false);
    }

    @FXML
    void toDashboard(ActionEvent event) {
        inventory_form.setVisible(false);
        customer_form.setVisible(false);
        feedback_form.setVisible(false);
        dashboard_form.setVisible(true);
    }

    @FXML
    void toFeedback(ActionEvent event) {
        inventory_form.setVisible(false);
        customer_form.setVisible(false);
        feedback_form.setVisible(true);
        dashboard_form.setVisible(false);
    }

    @FXML
    void toInventory(ActionEvent event) {
        inventory_form.setVisible(true);
        customer_form.setVisible(false);
        feedback_form.setVisible(false);
        dashboard_form.setVisible(false);
    }

    @FXML
    void toSignout(ActionEvent event) {
        // Create and display the confirmation dialog
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Logout Confirmation");
        alert.setHeaderText("You are about to log out.");
        alert.setContentText("Are you sure you want to log out?");

        // Show the alert and wait for user response
        Optional<ButtonType> result = alert.showAndWait();

        // If the user confirms, proceed with logout
        if (result.isPresent() && result.get() == ButtonType.OK) {
            // Close the current stage
            Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            currentStage.close();

            // Load and display the login page
            try {
                // Load the FXML file for the login page
                Parent root = FXMLLoader.load(getClass().getResource("LoginFood.fxml"));

                // Create a new stage for the login page
                Stage loginStage = new Stage();
                loginStage.setScene(new Scene(root));
                loginStage.setResizable(false);

                // Set the application icon
                Image icon = new Image(getClass().getResourceAsStream("images/El_pedidos1-removebg-preview.png"));
                loginStage.getIcons().add(icon);

                // Set the title and show the login stage
                loginStage.setTitle("El Pedidos Mexicanos");
                loginStage.show();
            } catch (IOException e) {
                // Handle potential IOExceptions
                e.printStackTrace();
            }
        }
    }

    public void loadDashboardData() {
        // Fetch values from the database using DBconnectionFood methods
        int totalCustomers = DBconnectionFood.getTotalCustomers();
        double todaysIncome = DBconnectionFood.getTodaysIncome();
        double totalIncome = DBconnectionFood.getTotalIncome();
        int soldProducts = DBconnectionFood.getSoldProducts();

        // Set the values to the corresponding labels
        totalCustomersLabel.setText(String.valueOf(totalCustomers));
        todaysIncomeLabel.setText("₱" + String.format("%.2f", todaysIncome)); // Format for currency
        totalIncomeLabel.setText("₱" + String.format("%.2f", totalIncome));   // Format for currency
        soldProductsLabel.setText(String.valueOf(soldProducts));
    }

    public void loadInventoryData() {
        ObservableList<Product> productList = FXCollections.observableArrayList();

        // Get database connection
        Connection con = DBconnectionFood.ConnectionDB();

        // Query to fetch product details
        String query = "SELECT ProductName, Price, Stock, Category, 'Active' AS Status FROM products";
        try (Statement stmt = con.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
            // Loop through the result set and add products to the list
            while (rs.next()) {
                String productName = rs.getString("ProductName");
                double price = rs.getDouble("Price");
                int stock = rs.getInt("Stock");
                String category = rs.getString("Category");
                String status = "Active"; // You can modify this if you want dynamic status

                productList.add(new Product(productName, price, stock, category, status));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Set data to the TableView
        inventory_productName.setCellValueFactory(new PropertyValueFactory<>("productName"));
        inventory_price.setCellValueFactory(new PropertyValueFactory<>("price"));
        inventory_stock.setCellValueFactory(new PropertyValueFactory<>("stock"));
        inventory_category.setCellValueFactory(new PropertyValueFactory<>("category"));
        inventory_status.setCellValueFactory(new PropertyValueFactory<>("status"));

        // Add the list to the TableView
        inventory_tableView.setItems(productList);
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        DBconnectionFood.ConnectionDB(); // Ensure DB connection is established
        loadDashboardData(); // Load initial data into the dashboard
        loadInventoryData();
    }
}
