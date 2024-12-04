package com.example.softwareproj;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.stage.StageStyle;

import java.io.IOException;

/**
 *
 * @author Aira
 */
public class TestingRun extends Application {

    @Override
    public void start(Stage primaryStage) throws IOException {


        //FXMLLoader fxmlLoader = new FXMLLoader(Login.class.getResource("LoginFood.fxml"));
        //FXMLLoader fxmlLoader = new FXMLLoader(Login.class.getResource("RegisterPage.fxml"));
       FXMLLoader fxmlLoader = new FXMLLoader(Login.class.getResource("AppFoodTruckCompile.fxml"));
        // FXMLLoader = new FXMLLoader(Login.class.getResource("AdminPage.fxml"));
       // FXMLLoader fxmlLoader = new FXMLLoader(Login.class.getResource("JustReceipt.fxml"));
        //FXMLLoader fxmlLoader = new FXMLLoader(Login.class.getResource("OnlinePaymentReceipt.fxml"));


        Scene scene = new Scene(fxmlLoader.load());
        primaryStage.setResizable(false);
        //primaryStage.initStyle(StageStyle.UNDECORATED); // Set the stage to be undecorated
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
