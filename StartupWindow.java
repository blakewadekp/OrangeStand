package edu.tridenttech.cpt237.orangestand;

import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

class StartupWindow {
    private VBox mainPane;

    public StartupWindow(Stage primaryStage) {
    	startupWindow(primaryStage);
    }

    private void startupWindow(Stage primaryStage) {
        mainPane = new VBox(10);
        Button newOrderButton = new Button("New Order");
        Button quitButton = new Button("Quit");

        // Event handling to open the OrderUI or close the application
        newOrderButton.setOnAction(e -> {
            OrderWindow orderUI = new OrderWindow(primaryStage);
            Scene orderScene = new Scene(orderUI.getMainPane(), 400, 300);
            primaryStage.setScene(orderScene);
        });

        quitButton.setOnAction(e -> primaryStage.close());

        mainPane.getChildren().addAll(newOrderButton, quitButton);
        mainPane.setSpacing(10);
    }

    public VBox getMainPane() {
        return mainPane;
    }
}