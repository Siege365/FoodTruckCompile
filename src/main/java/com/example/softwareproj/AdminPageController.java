package com.example.softwareproj;

import com.example.softwareproj.GettersAndSetters.CustomerOrder;
import com.example.softwareproj.GettersAndSetters.FeedBack;
import com.example.softwareproj.GettersAndSetters.Product;
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
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.Optional;
import java.util.ResourceBundle;

public class AdminPageController implements Initializable {

    @FXML
    private ComboBox<String> ProductCategoryCB;

    @FXML
    private TextField ProductNametf;

    @FXML
    private TextField ProductPricetf;

    @FXML
    private Spinner<Integer> ProductStockSpnr;


    @FXML
    private AnchorPane customer_form;

    @FXML
    private TableView<CustomerOrder> customer_tableView;

    @FXML
    private TableColumn<CustomerOrder, String> customerAddress;

    @FXML
    private TableColumn<CustomerOrder, String> customerContactNumber;

    @FXML
    private TableColumn<CustomerOrder, String> customerDate;

    @FXML
    private TextArea customerDisplayCustomerOrder;

    @FXML
    private TableColumn<CustomerOrder, String> customerName;

    @FXML
    private TableColumn<CustomerOrder, Integer> customerOrderID;

    @FXML
    private TableColumn<CustomerOrder, String> customerOrderType;

    @FXML
    private TableColumn<CustomerOrder, String> customerPaymentType;

    @FXML
    private TableColumn<CustomerOrder, String> customerStatus;

    @FXML
    private TableColumn<CustomerOrder, Integer> customerTotalAmount;

    @FXML
    private TableColumn<CustomerOrder, Integer> customerTotalProducts;

    @FXML
    private TableColumn<CustomerOrder, String> customerOrderItems;

    @FXML
    private ComboBox<String> customerUpdateStatus;

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
    private TableView<FeedBack> feedback_tableView;

    @FXML
    private TableColumn<FeedBack, String> feedback_Description;

    @FXML
    private TableColumn<FeedBack, Integer> feedback_cusID;

    @FXML
    private TableColumn<FeedBack, String> feedback_cusName;

    @FXML
    private TableColumn<FeedBack, String> feedback_titleofConcern;

    @FXML
    private TableColumn<FeedBack, String> feedback_typeOFfeedback;

    @FXML
    private TextArea feedbackContent;

    @FXML
    private Button inventory_addBtn;

    @FXML
    private Button inventory_btn;

    @FXML
    private TableColumn<Product, String> inventory_category;

    @FXML
    private Button inventory_deleteBtn;

    @FXML
    private AnchorPane inventory_form;

    @FXML
    private ImageView inventory_imageView;

    @FXML
    private Button inventory_importBtn;

    @FXML
    private TableColumn<Product, Integer> inventory_productID;

    @FXML
    private TableColumn<Product, Double> inventory_price;

    @FXML
    private TableColumn<Product, String> inventory_productName;

    @FXML
    private TableColumn<Product, String> inventory_status,inventory_ImageUrl;

    @FXML
    private TableColumn<Product, Integer> inventory_stock;

    @FXML
    private TableView<Product> inventory_tableView;

    @FXML
    private Button inventory_updateBtn;

    @FXML
    private Button logout_btn, inventory_clear;

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
    private File selectedImageFile; // Store the selected image file path

    private  void showAlert(String title, String message, Alert.AlertType alertType) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        DBconnectionFood.ConnectionDB(); // Ensure DB connection is established
        loadDashboardData();
        loadInventoryData();
        loadFeedbackData();
        loadCustomerOrders();
        ProductStockSpnr.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 100, 0));
        ProductCategoryCB.setItems(FXCollections.observableArrayList("Main Dish", "Side Dish", "Drinks", "Desserts"));
        customerUpdateStatus.setItems(FXCollections.observableArrayList("Preparing","Cooking","Ready for Pickup", "Ready for Delivery", "On Delivery","Out for Delivery","Completed"));

        // TableView setup dapat kada "" same og variable name sa getters and setters nimo
        inventory_productName.setCellValueFactory(new PropertyValueFactory<>("productName"));
        inventory_price.setCellValueFactory(new PropertyValueFactory<>("price"));
        inventory_stock.setCellValueFactory(new PropertyValueFactory<>("stock"));
        inventory_category.setCellValueFactory(new PropertyValueFactory<>("category"));
        inventory_status.setCellValueFactory(new PropertyValueFactory<>("status"));
        inventory_productID.setCellValueFactory(new PropertyValueFactory<>("productId"));

        feedback_cusID.setCellValueFactory(new PropertyValueFactory<>("customerID"));
        feedback_cusName.setCellValueFactory(new PropertyValueFactory<>("customerName"));
        feedback_typeOFfeedback.setCellValueFactory(new PropertyValueFactory<>("typeOfFeedback"));
        feedback_titleofConcern.setCellValueFactory(new PropertyValueFactory<>("titleOfConcern"));
        feedback_Description.setCellValueFactory(new PropertyValueFactory<>("description"));

        customerOrderID.setCellValueFactory(new PropertyValueFactory<>("orderID"));
        customerName.setCellValueFactory(new PropertyValueFactory<>("customerName"));
        customerContactNumber.setCellValueFactory(new PropertyValueFactory<>("customerNumber"));
        customerOrderType.setCellValueFactory(new PropertyValueFactory<>("customerOrderType"));
        customerPaymentType.setCellValueFactory(new PropertyValueFactory<>("customerPaymentType"));
        customerDate.setCellValueFactory(new PropertyValueFactory<>("customerOrderDate"));
        customerTotalProducts.setCellValueFactory(new PropertyValueFactory<>("amountOfProducts"));
        customerTotalAmount.setCellValueFactory(new PropertyValueFactory<>("totalAmount"));
        customerStatus.setCellValueFactory(new PropertyValueFactory<>("orderStatus"));
        customerAddress.setCellValueFactory(new PropertyValueFactory<>("customerAddress"));
        customerOrderItems.setCellValueFactory(new PropertyValueFactory<>("foodItems"));
    }

    // Side navigator
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

    // Dashboard data load
    public void loadDashboardData() {
        totalCustomersLabel.setText(String.valueOf(DBconnectionFood.getTotalOrders()));
        todaysIncomeLabel.setText("₱" + String.format("%.2f", DBconnectionFood.getTodaysIncome()));
        totalIncomeLabel.setText("₱" + String.format("%.2f", DBconnectionFood.getTotalIncome()));
        soldProductsLabel.setText(String.valueOf(DBconnectionFood.getSoldProducts()));
    }

    public void loadInventoryData() {
        ObservableList<Product> productList = FXCollections.observableArrayList();
        String query = "SELECT * FROM products";

        try (Connection connection = DBconnectionFood.ConnectionDB();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                int productId = resultSet.getInt("ProductID");
                String productName = resultSet.getString("ProductName");
                double price = resultSet.getDouble("Price");
                int stock = resultSet.getInt("Stock");
                String category = resultSet.getString("Category");

                // Check stock level and set the status accordingly
                String status;
                if (stock == 0) {
                    status = "Unavailable";
                } else if (stock <= 10) {
                    status = "Available (Low Stock)";
                } else {
                    status = "Available";
                }
                String imageUrl = resultSet.getString("ProductImg");
                productList.add(new Product(productId,productName, price, stock, category, status, imageUrl));
            }
            inventory_tableView.setItems(productList); // Update TableView with the new data
        } catch (SQLException e) {
            e.printStackTrace();
            showAlert("Database Error", "An error occurred while fetching product data.", Alert.AlertType.ERROR);
        }
    }

    // Inventory page actions

    @FXML
    void populateProductInfo(MouseEvent event) {
        if (event.getClickCount() == 2) { // Check for double-click
            Product selectedProduct = inventory_tableView.getSelectionModel().getSelectedItem();

            if (selectedProduct != null) {
                // Populate other fields
                ProductNametf.setText(selectedProduct.getProductName());
                ProductCategoryCB.setItems(FXCollections.observableArrayList("Main Dish", "Side Dish", "Drinks", "Desserts"));
                ProductCategoryCB.setValue(selectedProduct.getCategory()); // Set the selected category
                ProductStockSpnr.getValueFactory().setValue(selectedProduct.getStock());
                ProductPricetf.setText(String.valueOf(selectedProduct.getPrice())); // Convert price to string

                String imagePath = selectedProduct.getImageUrl(); // Get the image path from the product
                if (imagePath != null && !imagePath.isEmpty()) {
                    try {
                        // Debugging: Print the image path to the console
                        System.out.println("Image path: " + imagePath);

                        // Use getClass().getResource() to load the image from the classpath
                        URL imageUrl = getClass().getResource("/" + imagePath); // Ensure the path starts with a slash

                        // Check if the image is found
                        if (imageUrl != null) {
                            Image image = new Image(imageUrl.toString());
                            inventory_imageView.setImage(image);
                        } else {
                            showAlert("Image Error", "Image not found: " + imagePath, Alert.AlertType.WARNING);
                            inventory_imageView.setImage(null); // Clear the image if not found
                        }
                    } catch (Exception e) {
                        showAlert("Unexpected Error", "An unexpected error occurred while loading the image.", Alert.AlertType.ERROR);
                        inventory_imageView.setImage(null); // Clear the image in case of error
                        e.printStackTrace(); // Optional: Print stack trace for debugging
                    }
                } else {
                    showAlert("Image Error", "No image path provided for the product.", Alert.AlertType.WARNING);
                    inventory_imageView.setImage(null); // Clear the image if no path is provided
                }
            }
        }
    }


    @FXML
    void deleteProduct(ActionEvent event) {
        // Step 1: Get the selected product
        Product selectedProduct = inventory_tableView.getSelectionModel().getSelectedItem();

        if (selectedProduct == null) {
            // No product selected, show an alert
            showAlert("Selection Error", "Please select a product to delete.", Alert.AlertType.WARNING);
            return;
        }

        // Step 2: Confirm deletion (Optional)
        Alert confirmationAlert = new Alert(Alert.AlertType.CONFIRMATION);
        confirmationAlert.setTitle("Delete Product");
        confirmationAlert.setHeaderText("Are you sure you want to delete this product?");
        confirmationAlert.setContentText("Product: " + selectedProduct.getProductName());
        if (confirmationAlert.showAndWait().orElse(ButtonType.CANCEL) != ButtonType.OK) {
            return; // User canceled the deletion
        }

        // Step 3: Call the method in DBconnectionFood to delete the product
        boolean isDeleted = DBconnectionFood.deleteProduct(selectedProduct.getProductName());

        if (isDeleted) {
            showAlert("Success", "Product deleted successfully.", Alert.AlertType.INFORMATION);
        } else {
            showAlert("Error", "Product could not be deleted. Please try again.", Alert.AlertType.ERROR);
        }

        // Step 4: Refresh the TableView
        loadInventoryData();
    }


    @FXML
    public void saveProduct(ActionEvent event) {
        Product selectedProduct = inventory_tableView.getSelectionModel().getSelectedItem();
        int prodId = (selectedProduct != null) ? selectedProduct.getProductId() : generateProductId(); // Generate new ID if no product selected

        String prodName = ProductNametf.getText();
        String prodCategory = ProductCategoryCB.getSelectionModel().getSelectedItem();
        int prodStock = ProductStockSpnr.getValue();
        String prodPrice = ProductPricetf.getText();

        // If no image selected, use the default "No Image" value
        String imageFilePath = (selectedImageFile != null)
                ? getRelativePath(selectedImageFile) // Convert to relative path
                : "No Image";

        DBconnectionFood.saveOrUpdateProduct(prodId, prodName, prodCategory, prodStock, prodPrice, imageFilePath);
        resetProductFields();
        loadInventoryData();
    }
    private static int currentProductId = 25; // Start from 25
    private static int generateProductId() {
        return currentProductId++;
    }

    @FXML
    private void resetProductFields() {
        // Unselect the current selected item in the TableView
        inventory_tableView.getSelectionModel().clearSelection();

        // Clear all the input fields
        ProductNametf.clear();
        ProductCategoryCB.setValue(null);
        ProductStockSpnr.getValueFactory().setValue(1);
        ProductPricetf.clear();
        inventory_imageView.setImage(null);
    }

    @FXML
    void importProductImg(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Image Files", "*.jpg", "*.png", "*.jpeg"));
        selectedImageFile = fileChooser.showOpenDialog(null);

        // If an image is selected, display it in the ImageView
        if (selectedImageFile != null) {
            String imagePath = getRelativePath(selectedImageFile);

            // Use getClass().getResource() to load the image from the resources folder
            URL imageUrl = getClass().getResource("/" + imagePath); // Ensure the path starts with a slash

            // Check if the image is found
            if (imageUrl != null) {
                Image image = new Image(imageUrl.toString());
                inventory_imageView.setImage(image);

                double size = 120;  // Use a square size for the avatar
                inventory_imageView.setFitWidth(size);
                inventory_imageView.setFitHeight(size);

                // Optional: Add a border to the circular image
                inventory_imageView.setStyle(
                        "-fx-border-color: black;" +
                                "-fx-border-width: 2;" +
                                "-fx-padding: 0 0 0 5;"
                );
            } else {
                showAlert("Error", "Image not found in resources.", Alert.AlertType.ERROR);
            }
        } else {
            // Create and display an alert if no image is selected
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("No Image Selected");
            alert.setHeaderText(null);
            alert.setContentText("No image was selected. Please choose an image to upload.");
            alert.showAndWait();
        }
    }

    private String getRelativePath(File file) {
        // Assuming the images are stored in "src/main/resources/images/"
        // This method returns the path relative to the resources folder
        String baseDir = new File("src/main/resources").getAbsolutePath();
        String filePath = file.getAbsolutePath();

        if (filePath.startsWith(baseDir)) {
            String relativePath = filePath.substring(baseDir.length() + 1); // +1 to remove the slash after "resources"
            relativePath = relativePath.replace("\\", "/"); // Ensure forward slashes
            return relativePath;
        } else {
            return "No Image";
        }
    }
//end of inventory

//starts sa customer page
    @FXML
    void UpdateStatus(ActionEvent event) {
        CustomerOrder selectedOrder = customer_tableView.getSelectionModel().getSelectedItem();
        if (selectedOrder != null) {

            String statusUpdate = customerUpdateStatus.getSelectionModel().getSelectedItem(); // Combobox
            if (statusUpdate == null) {
                showAlert("No Status Selected", "Please state a status to update the order.", Alert.AlertType.WARNING);
                return;
            }

            // Update the status in the database
            DBconnectionFood.updateCustomerOrderStatus(selectedOrder, statusUpdate);

            // Update the value in the TableView
            selectedOrder.setOrderStatus(statusUpdate);
            showAlert("Update Successful", "Order Status Updated", Alert.AlertType.INFORMATION);
            customer_tableView.refresh(); // Refresh the TableView to show updated values

            // Load and update dashboard data
            loadDashboardData(); // Refresh the dashboard data to show the most recent information
        }
    }

    @FXML
    void populateCustomerOrders(MouseEvent event) {
        if (event.getClickCount() == 2) { // Check for double-click
            CustomerOrder selectedOrder = customer_tableView.getSelectionModel().getSelectedItem();

            if (selectedOrder != null) {
                // Create a border around the receipt
                String border = "************************************\n";
                StringBuilder receiptText = new StringBuilder();

                // Add the border and customer details section
                receiptText.append(border)
                        .append("       TRANSACTION RECEIPT\n")
                        .append(border)
                        .append("Customer Name: ").append(selectedOrder.getCustomerName()).append("\n")
                        .append("Contact Number: ").append(selectedOrder.getCustomerNumber()).append("\n")
                        .append("Address: ").append(selectedOrder.getCustomerAddress()).append("\n")
                        .append("Order Type: ").append(selectedOrder.getCustomerOrderType()).append("\n")
                        .append("Payment Type: ").append(selectedOrder.getCustomerPaymentType()).append("\n")
                        .append("Order Date: ").append(selectedOrder.getCustomerOrderDate()).append("\n")
                        .append(border);

                // Items section
                receiptText.append("Items (").append(selectedOrder.getAmountOfProducts()).append("):\n");
                receiptText.append(selectedOrder.getFoodItems()).append("\n");
                receiptText.append(border);

                // Total section
                receiptText.append(String.format("TOTAL AMOUNT: ₱%.2f (Including Shipping Cost & Handling Fee)\n",
                                (double) selectedOrder.getTotalAmount()))
                        .append(border);

                // Display receipt in transactionContent
                customerDisplayCustomerOrder.setText(receiptText.toString());
            }
        }
    }
    void loadCustomerOrders() {
        // Fetch the feedback data from DBconnectionFood
        ObservableList<CustomerOrder> selectedOrder = DBconnectionFood.loadCustomerOrderData();
        if (selectedOrder.isEmpty()) {
            showAlert("Database Error", "An error occurred while fetching feedback data.", Alert.AlertType.ERROR);
        }
        // Set the feedback data to the TableView
        customer_tableView.setItems(selectedOrder);
    }

    //end sa customer page
    //start sa feedback page
    @FXML
    void populateFeedback(MouseEvent event) {
        if (event.getClickCount() == 2) { // Check for double-click
            FeedBack selectedFeedback = feedback_tableView.getSelectionModel().getSelectedItem();

            if (selectedFeedback != null) {
                feedbackContent.setText(selectedFeedback.getFeedbackDescription());


            }
        }
    }

    public void loadFeedbackData() {
        // Fetch the feedback data from DBconnectionFood
        ObservableList<FeedBack> feedBacks = DBconnectionFood.loadFeedbackData();
        if (feedBacks.isEmpty()) {
            showAlert("Database Error", "An error occurred while fetching feedback data.", Alert.AlertType.ERROR);
        }
        // Set the feedback data to the TableView
        feedback_tableView.setItems(feedBacks);
    }

    //end of feedback page

}
