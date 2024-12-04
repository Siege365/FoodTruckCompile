package com.example.softwareproj;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import java.util.List;
import java.util.stream.Collectors;

import static javafx.scene.paint.Color.*;

public class ReceiptController {

    @FXML
    private ProgressBar Bar;

    @FXML
    private Label PaymentMethodtxt;

    @FXML
    private AnchorPane PaymentPage;

    @FXML
    private Button Print1,Back;

    @FXML
    private Circle ProgressPoint;

    @FXML
    private Circle ProgressPoint1;

    @FXML
    private Button closebtn;

    @FXML
    private Label Receipt;

    @FXML
    public  TextArea ReceiptContent;

    @FXML
    private AnchorPane ReceiptIfnotOnline;

    @FXML
    private AnchorPane ReceiptIfOnline;

    @FXML
    private AnchorPane ReceiptMainBody;

    @FXML
    private AnchorPane ReceiptPage;

    @FXML
    private TextField UserCVC;

    @FXML
    private DatePicker UserCardExpiryDate;

    @FXML
    private TextField UserCardNumber;

    @FXML
    private TextField UserNameCard;

    double progress =0.5;
    private void showAlert(String title, String message, Alert.AlertType alertType) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }
    @FXML
    void toBack(ActionEvent event){
        PaymentPage.setVisible(true);
        ReceiptPage.setVisible(false);
        Receipt.setVisible(false);
        PaymentMethodtxt.setVisible(true);
        Print1.setVisible(false);
        Back.setVisible(false);
        if(progress > 0.99){
            progress -= 0.5;
            Bar.setProgress(progress);
        }
        ProgressPoint1.setFill(LIGHTGRAY);

    }

    @FXML
    void PrintReceipt(ActionEvent event) {

    }

    @FXML
    void toReceiptPage(ActionEvent event) {
        PaymentPage.setVisible(false);
        ReceiptPage.setVisible(true);
        Receipt.setVisible(true);
        PaymentMethodtxt.setVisible(false);
        Print1.setVisible(true);
        Back.setVisible(true);
        if(progress < 0.99){
            progress += 0.5;
            Bar.setProgress(progress);
        }
        ProgressPoint1.setFill(DODGERBLUE);
        showAlert("Success", "Your order has been placed successfully! Please print your receipt as proof for order validation and claiming.", Alert.AlertType.INFORMATION);
    }
    @FXML
    void close(ActionEvent event) {
        Stage stage = (Stage) closebtn.getScene().getWindow(); // Get the current stage
        stage.close(); // Close the stage
    }
    public void setReceiptDetails(
            String fullName, String contactNumber, String deliveryType, String paymentType,
            List<FoodItem> items, double subtotal, double shippingCost, double handlingFee, double totalPrice) {
        // Update receipt fields
        ReceiptContent.setText(
                "Customer Name: " + fullName + "\n" +
                        "Contact Number: " + contactNumber + "\n" +
                        "Delivery Type: " + deliveryType + "\n" +
                        "Payment Type: " + paymentType + "\n\n" +
                        "Items:\n" +
                        items.stream()
                                .map(item -> item.getName() + " x" + item.getQuantity() + " - ₱" + String.format("%.2f", item.getTotal()))
                                .collect(Collectors.joining("\n")) +
                        "\n\n" +
                        "Subtotal: ₱" + String.format("%.2f", subtotal) + "\n" +
                        "Shipping Cost: ₱" + String.format("%.2f", shippingCost) + "\n" +
                        "Handling Fee: ₱" + String.format("%.2f", handlingFee) + "\n" +
                        "Total: ₱" + String.format("%.2f", totalPrice)
        );
    }


}
