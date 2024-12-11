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
    private File selectedFoodImageFile; // Store the selected image file path
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
    public static void updateFoodPage(GridPane maindishGridpane, GridPane sidedishGridpane, GridPane drinksGridpane, GridPane dessertsGridpane) {
        // Clear previous items
        maindishGridpane.getChildren().clear();
        sidedishGridpane.getChildren().clear();
        drinksGridpane.getChildren().clear();
        dessertsGridpane.getChildren().clear();

        // Styling and spacing for GridPane
        setupGridPane(maindishGridpane);
        setupGridPane(sidedishGridpane);
        setupGridPane(drinksGridpane);
        setupGridPane(dessertsGridpane);

        String query = "SELECT ProductName, Category, Price, ProductImg FROM products"; // Adjust to match your database
        int spinnerIdCounter = 25; // Starting ID for spinners
        final int COLUMNS = 2; // Number of columns in the grid


        try (Statement stmt = con.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
            int mainIndex = 0, sideIndex = 0, drinkIndex = 0, dessertIndex = 0; // Track positions in each category

            while (rs.next()) {
                String foodName = rs.getString("ProductName");
                String category = rs.getString("Category");
                int price = rs.getInt("Price");
                String imagePath = rs.getString("ProductImg");

                Pane foodPane = createFoodPane(foodName, price, spinnerIdCounter, imagePath);

                // Add to the appropriate GridPane
                switch (category) {
                    case "Main Dish" -> addToGridPane(maindishGridpane, foodPane, mainIndex++, COLUMNS);
                    case "Side Dish" -> addToGridPane(sidedishGridpane, foodPane, sideIndex++, COLUMNS);
                    case "Drinks" -> addToGridPane(drinksGridpane, foodPane, drinkIndex++, COLUMNS);
                    case "Desserts" -> addToGridPane(dessertsGridpane, foodPane, dessertIndex++, COLUMNS);
                    default -> System.out.println("Unknown category: " + category);
                }

                spinnerIdCounter++; // Increment spinner ID counter
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Adds a Pane to a GridPane at the appropriate position based on the index.
     *
     * @param gridPane The GridPane to add the pane to.
     * @param pane     The Pane to be added.
     * @param index    The index position in the list.
     * @param columns  The number of columns in the GridPane.
     */
    private static void addToGridPane(GridPane gridPane, Pane pane, int index, int columns) {
        int row = index / columns; // Calculate row based on index
        int col = index % columns; // Calculate column based on index
        gridPane.add(pane, col, row); // Add the pane at the specified position
    }

    /**
     * Configures a GridPane with consistent spacing, padding, and alignment.
     *
     * @param gridPane The GridPane to configure.
     */
    private static void setupGridPane(GridPane gridPane) {
        gridPane.setHgap(10); // Horizontal gap between columns
        gridPane.setVgap(10); // Vertical gap between rows
        gridPane.setPadding(new Insets(10)); // Padding around the grid
        gridPane.setAlignment(Pos.TOP_CENTER); // Align content to the top center
    }


    private static Pane createFoodPane(String foodName, int price, int spinnerIdCounter, String imagePath) {
        Pane foodPane = new Pane();
        foodPane.setPrefSize(355, 385);
        foodPane.setStyle("-fx-background-color: white; -fx-background-radius: 30;");

        // Declare image variable for food image
        Image foodImageObject = null;

        try {
            if (imagePath != null && !imagePath.isEmpty()) {
                // Assuming imagePath is a relative path, constructing URL from resources
                URL imageUrl = DBconnectionFood.class.getResource("/" + imagePath);
                if (imageUrl != null) {
                    foodImageObject = new Image(imageUrl.toExternalForm()); // Assign the image to the variable
                } else {
                    System.err.println("Image not found: " + imagePath); // Log missing image
                }
            } else {
                System.err.println("Invalid image path: " + imagePath); // Log invalid path
            }
        } catch (Exception e) {
            System.err.println("Error loading image: " + e.getMessage()); // Handle errors
        }

        // Set the image to ImageView if it's not null
        if (foodImageObject != null) {
            ImageView foodImage = new ImageView(foodImageObject);
            foodImage.setFitHeight(226);
            foodImage.setFitWidth(346);
            foodImage.setLayoutX(8);
            foodImage.setLayoutY(11);
            foodImage.setPreserveRatio(true);
            foodPane.getChildren().add(foodImage); // Add food image to the pane
        }

        Label nameLabel = new Label(foodName);
        nameLabel.setLayoutX(68);
        nameLabel.setLayoutY(227);
        nameLabel.setPrefSize(300, 53);
        nameLabel.setStyle("-fx-text-fill: black;");
        nameLabel.setFont(new javafx.scene.text.Font(36));
        nameLabel.setAlignment(Pos.CENTER_LEFT);
        nameLabel.setTextAlignment(TextAlignment.RIGHT);

        Label priceLabel = new Label("₱" + price);
        priceLabel.setLayoutX(26);
        priceLabel.setLayoutY(319);
        priceLabel.setPrefSize(140, 58);
        priceLabel.setStyle("-fx-text-fill: #EF3A31;");
        priceLabel.setFont(new javafx.scene.text.Font(36));

        Spinner<Integer> quantitySpinner = new Spinner<>();
        quantitySpinner.setId("food_spinner" + spinnerIdCounter);
        quantitySpinner.setLayoutX(125);
        quantitySpinner.setLayoutY(334);
        quantitySpinner.setPrefSize(115, 43);
        quantitySpinner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 100, 1));

        Button addToCartButton = new Button();
        addToCartButton.setLayoutX(239);
        addToCartButton.setLayoutY(326);
        addToCartButton.setPrefSize(81, 48);
        addToCartButton.setStyle("-fx-background-color: transparent;");

        // Declare image variable for the button image
        ImageView buttonImageView = null;
        try {
            URL buttonImageUrl = DBconnectionFood.class.getResource("/com/example/softwareproj/images/AddToCartbtnImg.png");
            if (buttonImageUrl != null) {
                buttonImageView = new ImageView(new Image(buttonImageUrl.toExternalForm())); // Assign the button image to the variable
                buttonImageView.setFitHeight(54);
                buttonImageView.setFitWidth(87);
                addToCartButton.setGraphic(buttonImageView); // Set the button image
            } else {
                System.err.println("Button image not found at: /com/example/softwareproj/images/AddToCartbtnImg.png");
            }
        } catch (Exception e) {
            System.err.println("Error loading button image: " + e.getMessage());
        }

        addToCartButton.setOnAction(e -> System.out.println("Add to Cart: " + foodName));

        foodPane.getChildren().addAll(nameLabel, priceLabel, quantitySpinner, addToCartButton);
        return foodPane;
    }







    //within diri ipang butang ang customer related

    public static void main(String[] args) {
        // Test the connection and getters
        Connection con = ConnectionDB();
    }



}
