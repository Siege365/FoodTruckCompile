package com.example.softwareproj;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginFoodController {


    @FXML
    private PasswordField passwordtf;

    @FXML
    private CheckBox showpass;

    @FXML
    private TextField usertf;

    @FXML
    void close(ActionEvent event) {System.exit(0);}

    @FXML
    void toHomePage(ActionEvent event) {

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
    @FXML
    void gotoRegister(ActionEvent event) throws IOException {
        loadRegisterScene(event);
    }

    private void loadRegisterScene(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("RegisterPage.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Image icon = new Image(getClass().getResourceAsStream("images/El_pedidos1-removebg-preview.png"));
        stage.getIcons().add(icon);
        stage.setResizable(false);
        stage.setTitle("El Pedidos Mexicanos");
        stage.setScene(scene);
        stage.show();

        // Optionally close the current window if needed
        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        currentStage.close();
    }
    @FXML
    public void btnEnter(ActionEvent event) {
        String username = usertf.getText();
        String password = passwordtf.getText();
        Connection con = DBconnectionFood.ConnectionDB(); // Establish a database connection
        PreparedStatement pst = null;
        ResultSet rs = null;

        try {
            // Check if the database connection is successful
            if (con != null) {
                // SQL query to check if the username and password match any account
                String sql = "SELECT * FROM register WHERE Username = ? AND Password = ?";
                pst = con.prepareStatement(sql);
                pst.setString(1, username);
                pst.setString(2, password);
                rs = pst.executeQuery();

                if (username.equals("Admin") && password.equals("putbol")) {
                    // Admin credentials matched
                    showAlert("Login", "Login Successful", Alert.AlertType.INFORMATION);

                    // Load the AdminPage
                    loadNewScene(event, "AdminPage.fxml");
                } else if (rs.next()) {
                    // Valid user credentials (not Admin)
                    String userId = rs.getString("userID"); // Get the user ID
                    showAlert("Login", "Login Successful", Alert.AlertType.INFORMATION);

                    // Load the Homepage and pass the username and userID
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("AppFoodTruckH.fxml"));
                    Parent root = loader.load();

                    // Pass the user ID and username to the home page controller
                    AppController app = loader.getController();
                    app.getUserData(username);
                   //app.checkAndPopulateAccountDetails(username);
                    loadNewScene(event, root);
                } else {
                    // Handle case where no account exists
                    showAlert("Login Error", "No account exists with the provided credentials.", Alert.AlertType.ERROR);
                }
            } else {
                // Notify the user if the database connection failed
                showAlert("Error", "Failed to connect to the database.", Alert.AlertType.ERROR);
            }
        } catch (IOException e) {
            showAlert("Loading Error", "Could not load the page: " + e.getMessage(), Alert.AlertType.ERROR);
        } catch (SQLException e) {
            showAlert("Database Error", e.getMessage(), Alert.AlertType.ERROR);
        } finally {
            // Close resources in the finally block to ensure they are always closed
            try {
                if (rs != null) rs.close(); // Close ResultSet if it was initialized
                if (pst != null) pst.close(); // Close PreparedStatement if it was initialized
                if (con != null && !con.isClosed()) con.close(); // Close Connection if it is open
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    // Helper method to load a new scene
    private void loadNewScene(ActionEvent event, String fxmlFile) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFile));
        Parent root = loader.load();
        loadNewScene(event, root);
    }

    private void loadNewScene(ActionEvent event, Parent root) {
        Stage stage = new Stage();
        stage.setTitle("El Pedidos Mexicanos");
        Image icon = new Image(getClass().getResourceAsStream("images/El_pedidos1-removebg-preview.png"));
        stage.getIcons().add(icon);
        stage.setResizable(false);
        stage.setScene(new Scene(root));
        stage.show();

        // Close the current login window
        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        currentStage.close();
    }

    // Helper method to show alerts
    private void showAlert(String title, String content, Alert.AlertType alertType) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }
}
