package com.example.softwareproj;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

public class AppController {

    @FXML
    private Label Userlabel;

    @FXML
    private Pane footer;


    @FXML
    public void getUserData(String username) {
        Userlabel.setText("Hello, " + username + "!");
        //usertf.setText(username);
    }
}
