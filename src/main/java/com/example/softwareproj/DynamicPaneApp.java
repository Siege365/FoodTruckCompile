package com.example.softwareproj;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class DynamicPaneApp extends Application {

    private int paneCount = 0; // Counter to keep track of the total panes
    private VBox paneContainer; // VBox to contain the panes

    @Override
    public void start(Stage primaryStage) {
        // Root container
        AnchorPane root = new AnchorPane();

        // Button to trigger the pane creation
        Button createPanesButton = new Button("Create Pane");
        createPanesButton.setLayoutX(10);
        createPanesButton.setLayoutY(10);

        // Add button to the root container
        root.getChildren().add(createPanesButton);

        // VBox to hold dynamically created panes
        paneContainer = new VBox(20); // 20 is the spacing between panes
        paneContainer.setLayoutX(50);
        paneContainer.setLayoutY(60);

        // ScrollPane to wrap the VBox container
        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setContent(paneContainer);
        scrollPane.setLayoutX(10);
        scrollPane.setLayoutY(50);
        scrollPane.setPrefSize(600, 700); // Set ScrollPane size (width x height)
        scrollPane.setFitToWidth(true); // Make content width fit ScrollPane width

        // Add the ScrollPane to the root container
        root.getChildren().add(scrollPane);

        // Event handler for button click to create panes
        createPanesButton.setOnAction(event -> {
            // Create a new Pane
            Pane newPane = createPane();

            // Add the Pane to the VBox
            paneContainer.getChildren().add(newPane);

            // Increment pane counter
            paneCount++;
            updatePaneNumbers();
        });

        // Set up the scene
        Scene scene = new Scene(root, 800, 800);
        primaryStage.setTitle("Scrollable Pane Example");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // Method to create a new pane with content
    private Pane createPane() {
        Pane newPane = new Pane();
        newPane.setPrefSize(500, 200); // Bigger size for the pane (500x200)
        newPane.setStyle("-fx-border-color: black; -fx-background-color: lightgray;"); // Optional styling

        // Content for the new Pane
        Label paneLabel = new Label("Pane " + (paneContainer.getChildren().size() + 1)); // Adjusted label to reflect pane number
        paneLabel.setLayoutX(20); // X position inside the pane
        paneLabel.setLayoutY(20); // Y position inside the pane

        Button deleteButton = new Button("Delete Pane");
        deleteButton.setLayoutX(20);
        deleteButton.setLayoutY(60);

        // Event handler for the delete button
        deleteButton.setOnAction(e -> {
            paneContainer.getChildren().remove(newPane);
            paneCount--;
            updatePaneNumbers();
        });

        // Add the Label and Delete Button to the new Pane
        newPane.getChildren().addAll(paneLabel, deleteButton);

        return newPane;
    }

    // Method to update pane numbers after any deletion
    private void updatePaneNumbers() {
        int index = 1;
        for (javafx.scene.Node node : paneContainer.getChildren()) {
            if (node instanceof Pane) {
                Pane pane = (Pane) node;
                // Find the Label inside the pane and update its text
                for (javafx.scene.Node child : pane.getChildren()) {
                    if (child instanceof Label) {
                       ((Label) child).setText("Pane " + index);
                       break;
                    }
                }
                index++;
            }
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
