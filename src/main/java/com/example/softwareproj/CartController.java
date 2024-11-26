package com.example.softwareproj;

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
    void toDeleteItem(ActionEvent event) {
//skibidid
    }


}
