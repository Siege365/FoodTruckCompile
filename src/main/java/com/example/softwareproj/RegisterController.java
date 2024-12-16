package com.example.softwareproj;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;


import javax.swing.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RegisterController {

    @FXML
    private Button Createbtn;

    @FXML
    private Button backbtn;

    @FXML
    private TextField emailtf;

    @FXML
    private TextField fntf;

    @FXML
    private PasswordField passwordtf;


    @FXML
    private CheckBox showpass;

    @FXML
    private TextField usertf;


    @FXML
    void toLogin(ActionEvent event) {
        Connection con = DBconnectionFood.ConnectionDB();
        String sql = "INSERT INTO register (UserID, Email, FullName, Username, Password) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement pst = null;

        try {
            if (con != null) {
                // Step 1: Check if Username, Email, or FullName already exists
                String checkSql = "SELECT COUNT(*) AS recordCount FROM register WHERE Username = ? OR Email = ? OR FullName = ?";
                pst = con.prepareStatement(checkSql);
                pst.setString(1, usertf.getText());   // Username field
                pst.setString(2, emailtf.getText());  // Email field
                pst.setString(3, fntf.getText());     // FullName field
                ResultSet rs = pst.executeQuery();

                if (rs.next() && rs.getInt("recordCount") > 0) {
                    JOptionPane.showMessageDialog(null,
                            "Username, Email, or Full Name already exists. Please use different credentials.",
                            "Error",
                            JOptionPane.ERROR_MESSAGE);
                    usertf.clear();
                    passwordtf.clear();
                    emailtf.clear();
                    fntf.clear();
                    return; // Exit method
                }

                // Step 2: Get the next available userID
                String idSql = "SELECT MAX(UserID) AS maxID FROM register";
                pst = con.prepareStatement(idSql);
                ResultSet idResult = pst.executeQuery();
                int newUserID = 5000; // Default starting UserID

                if (idResult.next()) {
                    int maxID = idResult.getInt("maxID");
                    if (maxID > 0) {
                        newUserID = maxID + 1; // Increment UserID
                    }
                }

                // Step 3: Insert the new record
                pst = con.prepareStatement(sql);
                pst.setInt(1, newUserID);
                pst.setString(2, emailtf.getText());
                pst.setString(3, fntf.getText());
                pst.setString(4, usertf.getText());
                pst.setString(5, passwordtf.getText());
                pst.executeUpdate();

                JOptionPane.showMessageDialog(null, "Record Added Successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);

                // Step 4: Load the login page
                Parent root = FXMLLoader.load(getClass().getResource("LoginFood.fxml"));
                Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                Image icon = new Image(getClass().getResourceAsStream("images/El_pedidos1-removebg-preview.png"));
                Stage stage = new Stage();
                stage.setResizable(false);
                Scene scene = new Scene(root);
                stage.setTitle("El Pedidos Mexicanos");
                stage.setScene(scene);
                stage.show();
                currentStage.close();
            } else {
                JOptionPane.showMessageDialog(null, "Failed to connect to the database.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "SQL Error", JOptionPane.ERROR_MESSAGE);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error loading the login page: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            try {
                if (pst != null) pst.close();
                if (con != null && !con.isClosed()) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    @FXML
    void backtologin(ActionEvent event) {
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("LoginFood.fxml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Stage stage = new Stage();
        Image icon = new Image(getClass().getResourceAsStream("images/El_pedidos1-removebg-preview.png"));
        stage.getIcons().add(icon);
        stage.centerOnScreen();
        stage.setResizable(false);
        Scene scene = new Scene(root);
        stage.setTitle("El Pedidos Mexicanos");
        stage.setScene(scene);
        stage.show();
        currentStage.close();
    }
    @FXML
    void showPassword(ActionEvent event) {
        if (showpass.isSelected()) {
            passwordtf.setPromptText(passwordtf.getText());
            passwordtf.setText("");
            passwordtf.setDisable(true);
        } else {
            passwordtf.setText(passwordtf.getPromptText());
            passwordtf.setPromptText("");
            passwordtf.setDisable(false);
        }
    }
}

