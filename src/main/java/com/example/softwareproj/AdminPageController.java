package com.example.softwareproj;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;


public class AdminPageController implements Initializable{

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
    private TableView<?> inventory_tableView;

    @FXML
    private Button inventory_updateBtn;

    @FXML
    private Button logout_btn;

    @FXML
    private AnchorPane main_form;

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



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}

