package edu.tridenttech.cpt237.orangestand;

import javafx.stage.Stage;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;


class OrderWindow {
    private GridPane orderPane;
    private Label totalPriceLabel = new Label("Total: $0.00");
    private Stage stage;

    public OrderWindow(Stage stage) {
        this.setPrimaryStage(stage);
        startupWindow(stage);
    }

    private void startupWindow(Stage stage) {
        orderPane = new GridPane();
        orderPane.setHgap(10);
        orderPane.setVgap(10);
        orderPane.setPadding(new Insets(10));
        Label nameLabel = new Label("Product");
        Label priceLabel = new Label("Price");
        Label amountLabel = new Label("Amount");

        // TextFields for entering the quantity of each orange type
        TextField navelAmount = new TextField();
        TextField caraCaraAmount = new TextField();
        TextField valenciaAmount = new TextField();

        // Labels for displaying the prices of each orange type
        Label navelPrice = new Label("$1.29");
        Label caraCaraPrice = new Label("$1.49");
        Label valenciaPrice = new Label("$1.99");

        // Labels to display the calculated total prices
        Label navelTotalPrice = new Label();
        Label caraCaraTotalPrice = new Label();
        Label valenciaTotalPrice = new Label();

        // Buttons for recalculating, submitting the order, or canceling
        Button recalculateButton = new Button("Recalculate");
        Button submitButton = new Button("Submit");
        Button cancelButton = new Button("Cancel");

        // Event handling to recalculate and update the total price
        recalculateButton.setOnAction(e -> {
            // Calculate total prices for each type of orange
            try {
                double navelAmountValue = Double.parseDouble(navelAmount.getText());
                navelTotalPrice.setText(String.format("$%.2f", navelAmountValue * 1.29));
            } catch (NumberFormatException ex) {
                navelTotalPrice.setText("Invalid");
            }
            try {
                double caraCaraAmountValue = Double.parseDouble(caraCaraAmount.getText());
                caraCaraTotalPrice.setText(String.format("$%.2f", caraCaraAmountValue * 1.49));
            } catch (NumberFormatException ex) {
                caraCaraTotalPrice.setText("Invalid");
            }
            try {
                double valenciaAmountValue = Double.parseDouble(valenciaAmount.getText());
                valenciaTotalPrice.setText(String.format("$%.2f", valenciaAmountValue * 1.99));
            } catch (NumberFormatException ex) {
                valenciaTotalPrice.setText("Invalid");
            }

            double total = 0.0;
            try {
                double navelTotal = Double.parseDouble(navelTotalPrice.getText().substring(1));
                double caraCaraTotal = Double.parseDouble(caraCaraTotalPrice.getText().substring(1));
                double valenciaTotal = Double.parseDouble(valenciaTotalPrice.getText().substring(1));

                total = navelTotal + caraCaraTotal + valenciaTotal;
            } catch (NumberFormatException ex) {
                total = 0.0;
            }

            totalPriceLabel.setText(String.format("Total: $%.2f", total));
        });

        // Event handling to transition to the confirmation window
        submitButton.setOnAction(e -> {
        	OrderConfirmationWindow confirmationUI = new OrderConfirmationWindow(stage);
            confirmationUI.displayReceipt(
                "Navel", navelAmount.getText(), navelTotalPrice.getText(), navelPrice.getText(),
                "Cara Cara", caraCaraAmount.getText(), caraCaraTotalPrice.getText(), caraCaraPrice.getText(),
                "Valencia", valenciaAmount.getText(), valenciaTotalPrice.getText(), valenciaPrice.getText(),
                totalPriceLabel.getText()
            );

            Scene confirmationScene = new Scene(confirmationUI.getMainPane(), 400, 300);
            stage.setScene(confirmationScene);
        });

        // Event handling to close the application
        cancelButton.setOnAction(e -> {
        	stage.close();
        });

        // Construct the order user interface layout
        orderPane.addRow(0, nameLabel, priceLabel, amountLabel, totalPriceLabel);
        orderPane.addRow(1, new Label("Navel"), navelPrice, navelAmount, navelTotalPrice);
        orderPane.addRow(2, new Label("Cara Cara"), caraCaraPrice, caraCaraAmount, caraCaraTotalPrice);
        orderPane.addRow(3, new Label("Valencia"), valenciaPrice, valenciaAmount, valenciaTotalPrice);
        orderPane.addRow(4, recalculateButton, submitButton, cancelButton);

        totalPriceLabel.setText("Total: $0.00");
    }

    public GridPane getMainPane() {
        return orderPane;
    }

	public Stage getPrimaryStage() {
		return stage;
	}

	public void setPrimaryStage(Stage primaryStage) {
		this.stage = primaryStage;
	}
}