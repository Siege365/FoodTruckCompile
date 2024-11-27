package com.example.softwareproj;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
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


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
