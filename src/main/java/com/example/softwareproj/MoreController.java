package com.example.softwareproj;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Optional;

public class MoreController {
    @FXML
    private Button logoutbutton;
    @FXML
    private AnchorPane AboutUs;

    @FXML
    private TextArea AccAddress;

    @FXML
    private TextField AccEmail;

    @FXML
    private TextField AccFullName;

    @FXML
    private RadioButton AccGenderF;

    @FXML
    private RadioButton AccGenderM;

    @FXML
    private RadioButton AccGenderO;

    @FXML
    private TextField AccMobileNumber;

    @FXML
    private TextField AccPassword;

    @FXML
    private Button EditInfobtn;

    @FXML
    private Button Feedback;

    @FXML
    private Button MyAccount;

    @FXML
    private Button TransactionHistory;

    @FXML
    private ImageView back;

    @FXML
    private AnchorPane feedback;

    @FXML
    private Pane footer;

    @FXML
    private AnchorPane more;

    @FXML
    private AnchorPane myaccount;

    @FXML
    private AnchorPane transactionhistory;
    @FXML
    private ImageView avatar;

    @FXML
    void AccEditInfo(ActionEvent event) {

    }

    private void showAlert(String title, String message, Alert.AlertType alertType) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
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
    void toOrder(ActionEvent event) {
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
    @FXML
    void toAboutUs(ActionEvent event) {
        AboutUs.setVisible(true);
        myaccount.setVisible(false);
        feedback.setVisible(false);
        transactionhistory.setVisible(false);
        back.setVisible(true);

    }

    @FXML
    void toDeleteAccount(ActionEvent event) {
       /* Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Delete Account");
        alert.setHeaderText("Are you sure you want to delete your account?");
        alert.setContentText("This action cannot be undone.");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            // User chose to delete the account

            Connection con = DBconnectionFood.ConnectionDB(); // Establish the connection
            PreparedStatement pst = null;

            try {
                String username = AccFullName.getText(); // Retrieve fullname from user input (replace with actual reference)

                if (con != null) {
                    // SQL queries to delete the account based on the username from both tables
                    String sql1 = "DELETE FROM registerdb WHERE Username = ?";
                    String sql2 = "DELETE FROM accdetailsdb WHERE Username = ?";

                    // Delete from registerdb
                    pst = con.prepareStatement(sql1);
                    pst.setString(1, username); // Bind the username to the query
                    int rowsAffected1 = pst.executeUpdate(); // Execute the delete operation for registerdb

                    // Delete from accdetailsdb
                    pst = con.prepareStatement(sql2);
                    pst.setString(1, username); // Bind the username to the query
                    int rowsAffected2 = pst.executeUpdate(); // Execute the delete operation for accdetailsdb

                    // Check if both deletions were successful
                    if (rowsAffected1 > 0 && rowsAffected2 > 0) {
                        // Deletion was successful
                        showAlert("Success", "Your account has been successfully deleted.", Alert.AlertType.INFORMATION);

                        // Perform logout or any other necessary actions
                        toLogout();
                    } else {
                        // If no rows were affected, the account wasn't found in one of the tables
                        showAlert("Error", "Account not found or could not be deleted.", Alert.AlertType.ERROR);
                    }
                } else {
                    // Handle case where database connection failed
                    showAlert("Error", "Failed to connect to the database.", Alert.AlertType.ERROR);
                }
            } catch (SQLException e) {
                // Handle SQL exceptions
                showAlert("Database Error", e.getMessage(), Alert.AlertType.ERROR);
                e.printStackTrace(); // Print stack trace for debugging
            } finally {
                // Close resources
                try {
                    if (pst != null) pst.close(); // Close PreparedStatement
                    if (con != null && !con.isClosed()) con.close(); // Close Connection
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        } else {
            showAlert("Cancelled", "Account deletion cancelled.", Alert.AlertType.INFORMATION);
        }*/

    }
    @FXML
    void toLogout() {
        // Create and display the confirmation dialog
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Logout Confirmation");
        alert.setHeaderText("You are about to log out.");
        alert.setContentText("Are you sure you want to log out?");

        // Show the alert and wait for user response
        Optional<ButtonType> result = alert.showAndWait();

        // If the user confirms, proceed with logout
        if (result.isPresent() && result.get() == ButtonType.OK) {
            // Close the current stage using the event source
            Stage currentStage = (Stage) logoutbutton.getScene().getWindow();
            currentStage.close();

            try {
                // Load the login page
                Parent root = FXMLLoader.load(getClass().getResource("LoginFood.fxml"));
                Stage stage = new Stage();
                stage.setScene(new Scene(root));

                // Set the application icon
                Image icon = new Image(getClass().getResourceAsStream("images/El_pedidos1-removebg-preview.png"));
                stage.getIcons().add(icon);

                // Set the title and display the login page
                stage.setTitle("El Pedidos Mexicanos");
                stage.show();
            } catch (IOException e) {
                // Handle potential IOExceptions
                e.printStackTrace();
            }
        }
    }


    @FXML
    void MyAccount(ActionEvent  event) {
        myaccount.setVisible(true);
        feedback.setVisible(false);
        back.setVisible(true);
        AboutUs.setVisible(false);

    }
    @FXML
    void toBack(MouseEvent mouseEvent) {
        myaccount.setVisible(false);
        feedback.setVisible(false);
        transactionhistory.setVisible(false);
        back.setVisible(false);
        AboutUs.setVisible(false);
    }
    @FXML
    void Feedback(ActionEvent  event) {
        myaccount.setVisible(false);
        feedback.setVisible(true);
        transactionhistory.setVisible(false);
        back.setVisible(true);
        AboutUs.setVisible(false);

    }
    @FXML
    void TransactionHistory(ActionEvent  event) {
        myaccount.setVisible(false);
        feedback.setVisible(false);
        transactionhistory.setVisible(true);
        back.setVisible(true);
        AboutUs.setVisible(false);

    }
    @FXML
    void ImportAvatar(MouseEvent event) {
        // Open a file chooser to select an image
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Image Files", "*.jpg", "*.png", "*.jpeg"));
        File selectedImageFile = fileChooser.showOpenDialog(null);

        // If an image is selected, display it in the ImageView
        if (selectedImageFile != null) {
            Image image = new Image(selectedImageFile.toURI().toString());
            avatar.setImage(image);

            // Set the ImageView size to be a square for proper circular effect
            double size = 230;  // Use a square size for the avatar
            avatar.setFitWidth(size);
            avatar.setFitHeight(size);

            // Apply a circular clip with adjusted center and radius
            double centerX = size / 2;  // Center X (115 for 230 size)
            double centerY = size / 2;  // Center Y (115 for 230 size)
            double radius = size / 2;   // Radius (115 for 230 size)
            Circle clip = new Circle(centerX, centerY, radius);
            avatar.setClip(clip);

            // Optional: Add a border to the circular image
            avatar.setStyle(
                    "-fx-border-color: black;" +
                            "-fx-border-width: 2;" +
                    "-fx-padding: 0 0 0 5;"
            );
        } else {
            // Create and display an alert if no image is selected
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("No Image Selected");
            alert.setHeaderText(null);
            alert.setContentText("No image was selected. Please choose an image to upload.");
            alert.showAndWait();
        }
    }


}

