package com.example.softwareproj;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

public class AppController {

    @FXML
    private Label Userlabel;

    @FXML
    private Pane footer;

    @FXML
    private AnchorPane fp;

    @FXML
    private AnchorPane hp;

    @FXML
    private AnchorPane mp;

    @FXML
    private AnchorPane op;


    @FXML
    public void getUserData(String username) {
        Userlabel.setText("Hello, " + username + "!");
        //usertf.setText(username);
    }
    @FXML
    void toFood(ActionEvent event) {
        fp.setVisible(true);
        mp.setVisible(false);
        op.setVisible(false);

    }

    @FXML
    void toHome(ActionEvent event) {
        fp.setVisible(false);
        mp.setVisible(false);
        op.setVisible(false);

    }

    @FXML
    void toMore(ActionEvent event) {
        fp.setVisible(false);
        mp.setVisible(true);
        op.setVisible(false);
    }

    @FXML
    void toOrder(ActionEvent event) {
        fp.setVisible(false);
        mp.setVisible(false);
        op.setVisible(true);
    }

}
