package com.example.softwareproj;


import com.example.softwareproj.GettersAndSetters.FoodItem;
import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Image;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;
import java.io.*;

import static javafx.scene.paint.Color.*;

public class ReceiptController {

    @FXML
    private ProgressBar Bar;

    @FXML
    private Label PaymentMethodtxt;

    @FXML
    private AnchorPane PaymentPage;

    @FXML
    private Button Print1;

    @FXML
    private Circle ProgressPoint;

    @FXML
    private Circle ProgressPoint1;

    @FXML
    private Button closebtn;

    @FXML
    public Button PayAmountbtn;

    @FXML
    private Label Receipt;

    @FXML
    public  TextArea ReceiptContent;


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

    @FXML
    private AnchorPane frame;

    double progress =0.5;

    private double xOffset = 0;
    private double yOffset = 0;


    @FXML
    public void getUserCardData(String Username) {
        Connection con = DBconnectionFood.ConnectionDB();
        String sql = "SELECT Account_Cardname, Account_Cardnumber, Account_CardExpiryDate, Account_CardCVC FROM accountdetails WHERE Username = ?";
        try (PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setString(1, Username);
            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    UserNameCard.setText(rs.getString("Account_Cardname"));
                    UserCardNumber.setText(rs.getString("Account_Cardnumber"));
                    UserCardExpiryDate.setValue(rs.getDate("Account_CardExpiryDate").toLocalDate());
                    UserCVC.setText(rs.getString("Account_CardCVC"));
                } else {
                    showAlert("No Data", "No record found for the given username.", Alert.AlertType.INFORMATION);
                }
            }
        } catch (SQLException e) {
            showAlert("Database Error", e.getMessage(), Alert.AlertType.ERROR);
            e.printStackTrace();
        } finally {
            try {
                if (con != null) con.close();  // Close connection
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private void showAlert(String title, String message, Alert.AlertType alertType) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }

    @FXML
    void framePress(MouseEvent event) {
        // Record the initial click position relative to the window
        xOffset = event.getSceneX();
        yOffset = event.getSceneY();
    }

    @FXML
    void frameDrag(MouseEvent event) {
        Stage stage = (Stage) frame.getScene().getWindow();
        stage.setX(event.getScreenX() - xOffset);
        stage.setY(event.getScreenY() - yOffset);
    }

    @FXML
    void PrintReceipt(ActionEvent event) {
        saveAsPDF(event);
    }
    private void saveAsPDF(ActionEvent event) {
        // Show file chooser for saving the PDF
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save PDF");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("PDF Files", "*.pdf"));
        File file = fileChooser.showSaveDialog(ReceiptPage.getScene().getWindow());

        if (file != null) {
            try {
                // Capture the node (ReceiptContent) as an image
                BufferedImage image = SwingFXUtils.fromFXImage(ReceiptPage.snapshot(null, null), null);

                // Write the image to a temporary PNG file
                File tempImageFile = new File("tempImage.png");
                ImageIO.write(image, "png", tempImageFile);

                // Load the image into iText
                ImageData imageData = ImageDataFactory.create(tempImageFile.getAbsolutePath());

                // Create PDF writer and document
                PdfWriter writer = new PdfWriter(new FileOutputStream(file));
                PdfDocument pdfDocument = new PdfDocument(writer);
                Document document = new Document(pdfDocument);

                // Add the image to the PDF document
                Image pdfImage = new Image(imageData);
                pdfImage.setAutoScale(true); // Adjust the image to fit the page
                document.add(pdfImage);

                // Close the PDF document
                document.close();

                // Delete the temporary image file
                tempImageFile.delete();

                showAlert("Success","PDF saved successfully.",Alert.AlertType.INFORMATION);


            } catch (IOException e) {
                System.err.println("Failed to save PDF: " + e.getMessage());
            }

        }
        Node source = (Node) event.getSource(); // Get the source of the event
        Stage stage = (Stage) source.getScene().getWindow(); // Get the current stage
        stage.close(); // Close the stage

    }

    @FXML
    void toReceiptPage(ActionEvent event) {
        PaymentPage.setVisible(false);
        ReceiptPage.setVisible(true);
        Receipt.setVisible(true);
        PaymentMethodtxt.setVisible(false);
        Print1.setVisible(true);
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
            String fullName, String contactNumber, String address, int totalProducts, String deliveryType,
            String paymentType, List<FoodItem> items, double subtotal, double shippingCost, double handlingFee, double totalPrice) {

        // Create formatted receipt text
        StringBuilder receiptText = new StringBuilder();

        // Customer details section
        receiptText.append("Customer Name: ").append(fullName).append("\n")
                .append("Contact Number: ").append(contactNumber).append("\n")
                .append("Address: ").append(address).append("\n")
                .append("Order Type: ").append(deliveryType).append("\n")
                .append("Payment Type: ").append(paymentType).append("\n\n");

        // Items section
        receiptText.append("Items (").append(totalProducts).append("):\n");
        for (FoodItem item : items) {
            receiptText.append(String.format("%-20s x%-2d - ₱%.2f\n",
                    item.getName(), item.getQuantity(), item.getTotal()));
        }

        // Summary section
        receiptText.append("\n")
                .append(String.format("Subtotal:      ₱%.2f\n", subtotal))
                .append(String.format("Shipping Cost: ₱%.2f\n", shippingCost))
                .append(String.format("Handling Fee:  ₱%.2f\n", handlingFee))
                .append(String.format("Total:         ₱%.2f", totalPrice));

        // Set text to ReceiptContent (your TextArea or Label)
        ReceiptContent.setText(receiptText.toString());
    }



}
