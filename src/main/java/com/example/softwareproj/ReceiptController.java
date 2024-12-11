package com.example.softwareproj;


import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Image;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
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
        saveAsPDF();
    }
    private void saveAsPDF() {
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

                System.out.println("PDF saved successfully.");
            } catch (IOException e) {
                System.err.println("Failed to save PDF: " + e.getMessage());
            }
        }
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
