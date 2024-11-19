package com.example.softwareproj;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class AppController {

    @FXML
    private Label Userlabel;

    @FXML
    public void getUserData(String username) {
        Userlabel.setText("Hello, " + username + "!");
        //usertf.setText(username);
    }
}
