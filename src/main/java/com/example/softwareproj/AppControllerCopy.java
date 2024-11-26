package com.example.softwareproj;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
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

public class AppControllerCopy {

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
    private Label AccUsername;

    @FXML
    private Pane Dessertspane;

    @FXML
    private Pane Drinkspane;

    @FXML
    private Button EditInfobtn;

    @FXML
    private Button Feedback;

    @FXML
    private Button MyAccount;

    @FXML
    private Button TransactionHistory;

    @FXML
    private Button cart;

    @FXML
    private Label itemCounter;

    @FXML
    private Label Userlabel;

    @FXML
    private ImageView avatar;

    @FXML
    private ImageView back;

    @FXML
    private Button backButton;

    @FXML
    private AnchorPane desserts;

    @FXML
    private AnchorPane drinks;

    @FXML
    private AnchorPane feedback;

    @FXML
    private TextArea feedbacktxtArea;

    @FXML
    private ImageView foodCategoryLogo;

    @FXML
    private Label foodCategorytxt;

    @FXML
    private AnchorPane foodPage;

    @FXML
    private Pane footer;

    @FXML
    private Pane fpHeader;

    @FXML
    private Button logoutbutton;

    @FXML
    private Pane mainAds;

    @FXML
    private Pane mainBestSeller;

    @FXML
    private Pane mainDishpane;

    @FXML
    private Pane mainHeader;

    @FXML
    private TableView<?> mainOrderStatus;

    @FXML
    private AnchorPane mainPage;

    @FXML
    private Pane mainfirstPane;

    @FXML
    private AnchorPane md;

    @FXML
    private AnchorPane morePage;

    @FXML
    private AnchorPane myaccount;

    @FXML
    private AnchorPane orderPage;

    @FXML
    private RadioButton questionradionBtn;

    @FXML
    private AnchorPane sd;

    @FXML
    private Pane sideDishpane;

    @FXML
    private Button submitFBbtn;

    @FXML
    private RadioButton suggestionradioBtn;

    @FXML
    private AnchorPane transactionhistory;


    private void showAlert(String title, String message, Alert.AlertType alertType) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }

    @FXML
    public void getUserData(String username) {
        Userlabel.setText("Hello, " + username + "!");

    }

    @FXML
    void toFood(ActionEvent event) {
        mainPage.setVisible(false);
        orderPage.setVisible(false);
        foodPage.setVisible(true);
        morePage.setVisible(false);
        itemCounter.setVisible(true);
        cart.setVisible(true);
    }


    @FXML
    void toHome(ActionEvent event) {
        mainPage.setVisible(true);
        orderPage.setVisible(false);
        foodPage.setVisible(false);
        morePage.setVisible(false);
        itemCounter.setVisible(true);
        cart.setVisible(true);

    }

    @FXML
    void toMore(ActionEvent event) {
        mainPage.setVisible(false);
        orderPage.setVisible(false);
        foodPage.setVisible(false);
        morePage.setVisible(true);
        itemCounter.setVisible(false);
        cart.setVisible(false);
    }

    @FXML
    void toOrder(ActionEvent event) {
        mainPage.setVisible(false);
        orderPage.setVisible(true);
        foodPage.setVisible(false);
        morePage.setVisible(false);
        itemCounter.setVisible(true);
        cart.setVisible(true);

    }

    @FXML
    void toCart(ActionEvent event) {

    }
    //end of navigation

    //start sa food category
    @FXML
    void toBack(ActionEvent event) {
        desserts.setVisible(false);
        md.setVisible(false);
        sd.setVisible(false);
        drinks.setVisible(false);
        backButton.setVisible(false);
        foodCategoryLogo.setVisible(true);
        foodCategorytxt.setVisible(true);
        mainDishpane.setVisible(true);
        sideDishpane.setVisible(true);
        Dessertspane.setVisible(true);
        Drinkspane.setVisible(true);
    }

    @FXML
    void toDesserts(MouseEvent event) {
        desserts.setVisible(true);
        mainDishpane.setVisible(false);
        sideDishpane.setVisible(false);
        Drinkspane.setVisible(false);
        backButton.setVisible(true);
        foodCategoryLogo.setVisible(false);
        foodCategorytxt.setVisible(false);
    }

    @FXML
    void toDrinks(MouseEvent event) {
        drinks.setVisible(true);
        mainDishpane.setVisible(false);
        sideDishpane.setVisible(false);
        Dessertspane.setVisible(false);
        backButton.setVisible(true);
        foodCategoryLogo.setVisible(false);
        foodCategorytxt.setVisible(false);

    }

    @FXML
    void toMD(MouseEvent event) {
        md.setVisible(true);
        sideDishpane.setVisible(false);
        Drinkspane.setVisible(false);
        Dessertspane.setVisible(false);
        backButton.setVisible(true);
        foodCategoryLogo.setVisible(false);
        foodCategorytxt.setVisible(false);
    }

    @FXML
    void toSD(MouseEvent event) {
        sd.setVisible(true);
        mainDishpane.setVisible(false);
        Drinkspane.setVisible(false);
        Dessertspane.setVisible(false);
        backButton.setVisible(true);
        foodCategoryLogo.setVisible(false);
        foodCategorytxt.setVisible(false);
    }
//end sa food category

//start sa more page

    @FXML
    private void handleSubmitFeedback() {
        // Retrieve the selected feedback type
        String feedbackType = "";
        if (questionradionBtn.isSelected()) {
            feedbackType = "Question";
        } else if (suggestionradioBtn.isSelected()) {
            feedbackType = "Suggestion";
        }

        // Retrieve the feedback description from the TextArea
        String feedbackDescription = feedbacktxtArea.getText();

        // Validate that feedback description is not empty
        if (feedbackDescription.isEmpty() || feedbackType.isEmpty()) {
            showAlert("Validation Error", "Please select a feedback type and provide a description.", Alert.AlertType.WARNING);
            return;
        }

        // SQL query to insert feedback into the database
        String query = "INSERT INTO feedback (feedback_type, feedback_description) VALUES (?, ?)";

        try (Connection connection = DBconnectionFood.ConnectionDB();
             PreparedStatement statement = connection.prepareStatement(query)) {

            // Set the parameters for the query
            statement.setString(1, feedbackType);
            statement.setString(2, feedbackDescription);

            // Execute the query
            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                showAlert("Success", "Feedback submitted successfully.", Alert.AlertType.INFORMATION);
            } else {
                showAlert("Error", "Failed to submit feedback.", Alert.AlertType.ERROR);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            showAlert("Error", "An error occurred while submitting feedback.", Alert.AlertType.ERROR);
        }
    }

    @FXML
    private void handleEditInformationButton() {
        String username = AccUsername.getText();  // Get the current username
        String fullName = AccFullName.getText();
        String email = AccEmail.getText();
        String password = AccPassword.getText();
        String mobileNumber = AccMobileNumber.getText();
        String gender = getSelectedGender();  // Get the selected gender
        String address = AccAddress.getText();

        saveOrUpdateUserInfo(username, fullName, email, password, mobileNumber, gender, address);
    }

    // Get the selected gender from the RadioButtons
    private String getSelectedGender() {
        if (AccGenderM.isSelected()) {
            return "Male";
        } else if (AccGenderF.isSelected()) {
            return "Female";
        } else if (AccGenderO.isSelected()) {
            return "Other";
        }
        return null;
    }

    private void saveOrUpdateUserInfo(String username, String fullName, String email, String password, String mobileNumber, String gender, String address) {
        // Validate that required fields are not empty
        if (fullName.isEmpty() || email.isEmpty() || password.isEmpty() || mobileNumber.isEmpty() || gender.isEmpty() || address.isEmpty()) {
            showAlert("Validation Error", "Please fill in all the required fields.", Alert.AlertType.WARNING);
            return; // Stop execution if fields are empty
        }

        String query = "INSERT INTO foodtruck (Username, FullName, Email, Password, MobileNumber, Gender, Address) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?) " +
                "ON DUPLICATE KEY UPDATE " +
                "FullName = VALUES(FullName), " +
                "Email = VALUES(Email), " +
                "Password = VALUES(Password), " +
                "MobileNumber = VALUES(MobileNumber), " +
                "Gender = VALUES(Gender), " +
                "Address = VALUES(Address);";

        try (Connection connection = DBconnectionFood.ConnectionDB();
             PreparedStatement statement = connection.prepareStatement(query)) {

            // Set parameters for the query
            statement.setString(1, username);
            statement.setString(2, fullName);
            statement.setString(3, email);
            statement.setString(4, password);
            statement.setString(5, mobileNumber);
            statement.setString(6, gender);
            statement.setString(7, address);

            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                // Show success alert if the information is saved/updated successfully
                showAlert("Success", "Information saved/updated successfully.", Alert.AlertType.INFORMATION);
            } else {
                // Show error alert if the information wasn't saved
                showAlert("Error", "Error: Information not saved.", Alert.AlertType.ERROR);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Show error alert if there's an exception
            showAlert("Error", "An error occurred while saving/updating information.", Alert.AlertType.ERROR);
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
                stage.setResizable(false);

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
    void toBack1(ActionEvent event) {
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
    @FXML
    void RadioButtons(ActionEvent event) {
        // Create a ToggleGroup
        ToggleGroup genderGroup = new ToggleGroup();

        // Assign the ToggleGroup to all RadioButtons
        AccGenderM.setToggleGroup(genderGroup);
        AccGenderF.setToggleGroup(genderGroup);
        AccGenderO.setToggleGroup(genderGroup);

        // Add listeners to detect when a RadioButton is selected or deselected
        genderGroup.selectedToggleProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                // When a RadioButton is selected, disable the others
                disableAccGenderOButtons(newValue);
            } else {
                // If no selection, enable all RadioButtons
                enableAllRadioButtons();
            }
        });
    }

    // Disable RadioButtons based on the selected one
    private void disableAccGenderOButtons(Toggle selectedToggle) {
        if (selectedToggle == AccGenderM) {
            AccGenderF.setDisable(true);
            AccGenderO.setDisable(true);
        } else if (selectedToggle == AccGenderF) {
            AccGenderM.setDisable(true);
            AccGenderO.setDisable(true);
        } else if (selectedToggle == AccGenderO) {
            AccGenderM.setDisable(true);
            AccGenderF.setDisable(true);
        }
    }

    // Enable all RadioButtons
    private void enableAllRadioButtons() {
        AccGenderM.setDisable(false);
        AccGenderF.setDisable(false);
        AccGenderO.setDisable(false);
    }
    //end sa more page
}
