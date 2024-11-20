package com.example.softwareproj;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class FoodCategory {
    @FXML
    private AnchorPane desserts;

    @FXML
    private AnchorPane drinks;

    @FXML
    private Pane footer;

    @FXML
    private AnchorPane md;

    @FXML
    private AnchorPane sd;


    private void showAlert(String title, String message, Alert.AlertType alertType) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }

    @FXML
    void toDesserts(MouseEvent event) {
        desserts.setVisible(true);
        md.setVisible(false);
        sd.setVisible(false);
        drinks.setVisible(false);
    }

    @FXML
    void toDrinks(MouseEvent event) {
        drinks.setVisible(true);
        md.setVisible(false);
        sd.setVisible(false);
        desserts.setVisible(false);

    }

    @FXML
    void toMD(MouseEvent event) {
        md.setVisible(true);
        sd.setVisible(false);
        desserts.setVisible(false);
        drinks.setVisible(false);
    }

    @FXML
    void toSD(MouseEvent event) {
        sd.setVisible(true);
        md.setVisible(false);
        desserts.setVisible(false);
        drinks.setVisible(false);
    }
    @FXML
    void toFood(ActionEvent event) {
        try {
            // Load the new FXML file
            FXMLLoader fxmlLoader = new FXMLLoader(Login.class.getResource("FoodCategory.fxml"));

            // Create the new scene
            Scene scene = new Scene(fxmlLoader.load());

            // Get the current stage (primaryStage)
            Stage primaryStage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();

            // Set stage properties
            primaryStage.setResizable(false);
            Image icon = new Image(getClass().getResourceAsStream("images/El_pedidos1-removebg-preview.png"));
            primaryStage.getIcons().add(icon);
            primaryStage.setTitle("El Pedidos Mexicanos");
            primaryStage.setScene(scene);
            primaryStage.centerOnScreen();

            // Close the previous window and show the new one
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
            showAlert("Error", "Could not load the FoodCategory screen: " + e.getMessage(), Alert.AlertType.ERROR);
        }
    }




    @FXML
    void toHome(ActionEvent event) {
        try {
            // Load the new FXML file
            FXMLLoader fxmlLoader = new FXMLLoader(Login.class.getResource("AppFoodTruckH.fxml"));

            // Create the new scene
            Scene scene = new Scene(fxmlLoader.load());

            // Get the current stage (primaryStage)
            Stage primaryStage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();

            // Set stage properties
            primaryStage.setResizable(false);
            Image icon = new Image(getClass().getResourceAsStream("images/El_pedidos1-removebg-preview.png"));
            primaryStage.getIcons().add(icon);
            primaryStage.setTitle("El Pedidos Mexicanos");
            primaryStage.setScene(scene);
            primaryStage.centerOnScreen();

            // Close the previous window and show the new one
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
            showAlert("Error", "Could not load the FoodCategory screen: " + e.getMessage(), Alert.AlertType.ERROR);
        }

    }
    @FXML
    void toMore(ActionEvent event) {
        try {
            // Load the new FXML file
            FXMLLoader fxmlLoader = new FXMLLoader(Login.class.getResource("MorePage.fxml"));

            // Create the new scene
            Scene scene = new Scene(fxmlLoader.load());

            // Get the current stage (primaryStage)
            Stage primaryStage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();

            // Set stage properties
            primaryStage.setResizable(false);
            Image icon = new Image(getClass().getResourceAsStream("images/El_pedidos1-removebg-preview.png"));
            primaryStage.getIcons().add(icon);
            primaryStage.setTitle("El Pedidos Mexicanos");
            primaryStage.setScene(scene);
            primaryStage.centerOnScreen();

            // Close the previous window and show the new one
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
            showAlert("Error", "Could not load the FoodCategory screen: " + e.getMessage(), Alert.AlertType.ERROR);
        }
    }

    @FXML
    void toOrders (ActionEvent event) {
        try {
            // Load the new FXML file
            FXMLLoader fxmlLoader = new FXMLLoader(Login.class.getResource("OrderPage.fxml"));

            // Create the new scene
            Scene scene = new Scene(fxmlLoader.load());

            // Get the current stage (primaryStage)
            Stage primaryStage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();

            // Set stage properties
            primaryStage.setResizable(false);
            Image icon = new Image(getClass().getResourceAsStream("images/El_pedidos1-removebg-preview.png"));
            primaryStage.getIcons().add(icon);
            primaryStage.setTitle("El Pedidos Mexicanos");
            primaryStage.setScene(scene);
            primaryStage.centerOnScreen();

            // Close the previous window and show the new one
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
            showAlert("Error", "Could not load the FoodCategory screen: " + e.getMessage(), Alert.AlertType.ERROR);
        }
    }
}