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
            FXMLLoader fxmlLoader1 = new FXMLLoader(getClass().getResource("AppFoodTruckH.fxml"));
            // Set up the scene using the loaded FXML
            Scene scene = new Scene(fxmlLoader1.load());

            // Add an application icon (ensure correct image path)
            Image icon = new Image(getClass().getResourceAsStream("images/El_pedidos1-removebg-preview.png"));
           stage.getIcons().add(icon);

            // Add CSS stylesheet (ensure correct path)
            //scene.getStylesheets().add(getClass().getResource("RegisterPageCss.css").toExternalForm());
               scene.getStylesheets().add(getClass().getResource("AppFoodTruck.css").toExternalForm());

            // Configure stage properties
            stage.setResizable(false);
            stage.setTitle("El Pedidos Mexicanos");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error loading FXML: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        launch();
    }
}

