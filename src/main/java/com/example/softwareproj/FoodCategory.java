package com.example.softwareproj;

import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

public class FoodCategory {

    @FXML
    private Pane footer;

    @FXML
    void click(MouseEvent event) {
    System.out.println("CLICKED");
    }

}