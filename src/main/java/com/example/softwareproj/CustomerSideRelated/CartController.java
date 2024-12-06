package com.example.softwareproj.CustomerSideRelated;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.event.ActionEvent;


public class CartController {

    @FXML
    private CheckBox ItemCheckbox;

    @FXML
    private Button ItemDeletePane;

    @FXML
    private ImageView ItemImage;

    @FXML
    private Label ItemName;

    @FXML
    private AnchorPane ItemPane;

    @FXML
    private Label ItemPrice;

    @FXML
    private Spinner<?> ItemQuantity;
    @FXML
    private AppController appController; // AppController instance

    // Method to set the item details in the UI
    public void setItemDetails(String name, String price, int quantity) {
        ItemName.setText(name);
        ItemPrice.setText(price);
        //ItemQuantity.getValueFactory().setValue(quantity);
    }

    @FXML
    void toDeleteItem(ActionEvent event) {
//skibidid
    }


    // Method to add an item to the cart in AppController
    public void addItemToCart(FoodItem item) {
        if (appController != null) {
            appController.addItemToCart(item); // Pass the item to AppController for display
        }
    }
}
