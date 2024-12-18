package com.example.softwareproj;   

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import java.io.IOException;


/**
 *
 * @author Aira
 */
public class Login extends Application {

    @Override
    public void start(Stage primaryStage) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(Login.class.getResource("LoginFood.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        primaryStage.setResizable(false);
        Image icon = new Image(getClass().getResourceAsStream("images/El_pedidos1-removebg-preview.png"));
        primaryStage.getIcons().add(icon);
        // Set stage properties
        primaryStage.setTitle("El Pedidos Mexicanos");
        primaryStage.setScene(scene);
        primaryStage.centerOnScreen();
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
