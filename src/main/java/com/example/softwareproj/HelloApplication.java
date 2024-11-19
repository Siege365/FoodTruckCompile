package com.example.softwareproj;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) {
        try {
            // Load the FXML file for the AppFoodTruck page
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AppFoodTruckH.fxml"));

            // Set up the scene using the loaded FXML
            Scene scene = new Scene(fxmlLoader.load());

            // Add an application icon (ensure the image path is correct)
            Image icon = new Image(getClass().getResourceAsStream("images/El_pedidos1-removebg-preview.png"));
            stage.getIcons().add(icon);

            // Add CSS stylesheet for styling (ensure the CSS path is correct)
            scene.getStylesheets().add(getClass().getResource("AppFoodTruck.css").toExternalForm());

            // Configure stage properties
            stage.setResizable(false);
            stage.setTitle("El Pedidos Mexicanos");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            // Handle loading errors and print a meaningful message
            e.printStackTrace();
            System.out.println("Error loading FXML or resources: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        launch();
    }
}
