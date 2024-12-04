package com.example.softwareproj;

import javafx.animation.TranslateTransition;
import javafx.animation.ParallelTransition;
import javafx.scene.Node;
import javafx.util.Duration;
import javafx.animation.Interpolator;

public class AnimationHelper {

    // Method to animate multiple nodes from right to left (off-screen to on-screen)
    public static void animateNodesFromRightToLeft(Node... nodes) {
        // Create individual TranslateTransitions for each node
        ParallelTransition parallelTransition = new ParallelTransition();

        for (Node node : nodes) {
            TranslateTransition transition = new TranslateTransition(Duration.seconds(0.3), node);
            transition.setFromX(768); // Start from the right (off-screen)
            transition.setToX(0);     // Move to its final position (visible on-screen)
            transition.setInterpolator(Interpolator.EASE_OUT);

            // Add each transition to the parallel transition
            parallelTransition.getChildren().add(transition);

            // Optionally set the node visible before starting the transition
            node.setVisible(true);

            // Hide the node after the animation finishes
            transition.setOnFinished(e -> node.setVisible(true));  // Ensure node stays visible after moving in
        }

        // Play all transitions simultaneously
        parallelTransition.play();
    }

    // Method to animate nodes from left to right (reverse transition, off-screen to on-screen)
    public static void animateNodesFromLeftToRight(Node... nodes) {
        // Create individual TranslateTransitions for each node
        ParallelTransition parallelTransition = new ParallelTransition();

        for (Node node : nodes) {
            TranslateTransition transition = new TranslateTransition(Duration.seconds(0.3), node);
            transition.setFromX(0);    // Start from the visible position
            transition.setToX(768);    // Move off-screen to the right
            transition.setInterpolator(Interpolator.EASE_OUT);

            // Add each transition to the parallel transition
            parallelTransition.getChildren().add(transition);

            // Optionally set the node visible before starting the transition
            node.setVisible(true);

            // Hide the node after the animation finishes
            transition.setOnFinished(e -> node.setVisible(true));  // Hide node after moving out
        }

        // Play all transitions simultaneously
        parallelTransition.play();

    }

    // Method to animate multiple nodes from left to right (off-screen to on-screen)
    public static void animateStartFromLeft(Node... nodes) {
        // Create individual TranslateTransitions for each node
        ParallelTransition parallelTransition = new ParallelTransition();

        for (Node node : nodes) {
            // Create a TranslateTransition for each node
            TranslateTransition transition = new TranslateTransition(Duration.seconds(.3), node);

            // Start from off-screen to the left (-768 width sa Frame)  and move to the on-screen position (0)
            transition.setFromX(-768); // Start from off-screen left
            transition.setToX(0);      // End at the on-screen position

            transition.setInterpolator(Interpolator.EASE_OUT); // Apply easing to make the animation smoother

            // Add each transition to the parallel transition
            parallelTransition.getChildren().add(transition);

            // Ensure the node is visible before starting the transition
            node.setVisible(true);

            // Optionally set the node to be visible after the transition
            transition.setOnFinished(e -> node.setVisible(true));  // Ensure the node stays visible after the animation
        }

        // Play all transitions simultaneously
        parallelTransition.play();
    }
    // Method to animate multiple nodes from left to right (off-screen to on-screen)
    public static void animateStartFromRight(Node... nodes) {
        // Create individual TranslateTransitions for each node
        ParallelTransition parallelTransition = new ParallelTransition();

        for (Node node : nodes) {
            // Create a TranslateTransition for each node
            TranslateTransition transition = new TranslateTransition(Duration.seconds(.3), node);

            transition.setFromX(0); // Start from off-screen right
            transition.setToX(-768);      // End at the on-screen position

            transition.setInterpolator(Interpolator.EASE_OUT); // Apply easing to make the animation smoother

            // Add each transition to the parallel transition
            parallelTransition.getChildren().add(transition);

            // Ensure the node is visible before starting the transition
            node.setVisible(true);

            // Optionally set the node to be visible after the transition
            transition.setOnFinished(e -> node.setVisible(true));  // Ensure the node stays visible after the animation
        }

        // Play all transitions simultaneously
        parallelTransition.play();
    }
    public static void animateNodesFromLeftToRightThatWontPermanentlyHideTheNode(Node... nodes) {
        // Create individual TranslateTransitions for each node
        ParallelTransition parallelTransition = new ParallelTransition();

        for (Node node : nodes) {
            TranslateTransition transition = new TranslateTransition(Duration.seconds(0.3), node);
            transition.setFromX(0);    // Start from the visible position
            transition.setToX(768);   // Move off-screen to the right
            transition.setInterpolator(Interpolator.EASE_OUT);

            // Add each transition to the parallel transition
            parallelTransition.getChildren().add(transition);

            // Optionally set the node visible before starting the transition
            node.setVisible(true);

            // Reset the position and keep visibility true
            transition.setOnFinished(e -> node.setTranslateX(0));
        }

        // Play all transitions simultaneously
        parallelTransition.play();
    }


}

