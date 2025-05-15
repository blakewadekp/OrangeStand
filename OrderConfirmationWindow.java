package edu.tridenttech.cpt237.orangestand;

import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
//import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
//import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.Window;

/*public class OrderConfirmationWindow {
    private double[] fruitPrices;
    //private int[] amounts;
    private VBox root;
    private String[] fruitNames = {"Navel", "Cara Cara", "Valencia"};
    private TextField amountInputs;
    
    public OrderConfirmationWindow() {
        // Initialize amountInputs to zero
        amountInputs = new TextField();
        amountInputs.setText("0");
    }

    public VBox createConfirmationLayout(TextField[] amountInputs) {
        VBox confirmationLayout = new VBox();
        double totalCost = 0.0;

        Text header = new Text("Receipt");
        confirmationLayout.getChildren().add(header);
        for (int i = 0; i < fruitPrices.length; i++) {
            String text = amountInputs[i].getText();
            int amount = text.isEmpty() ? 0 : Integer.parseInt(text);
            double total = fruitPrices[i] * amount;
            Text itemText2 = new Text(String.format("%s\t%.2f\t%d\t%.2f", fruitNames[i], fruitPrices[i], amount, total));
            confirmationLayout.getChildren().add(itemText2);
            totalCost += total;
        }
        Text itemText3 = new Text(String.format("Total Cost: $%.2f", totalCost));
        confirmationLayout.getChildren().add(itemText3);

        Button dismissButton = new Button("Dismiss");
        dismissButton.setOnAction(e -> {
            Window owner = dismissButton.getScene().getWindow();
            if (owner instanceof Stage) {
                ((Stage) owner).close();
            }
        });
        confirmationLayout.getChildren().add(dismissButton);

        return confirmationLayout;
    }
    public VBox getRoot() {
        return root;
    }
}*/




class OrderConfirmationWindow {
    private VBox confirmationPane;
    private TextArea receiptTextArea;

    public OrderConfirmationWindow(Stage stage) {
    	startupWindow(stage);
    }

    private void startupWindow(Stage stage) {
        confirmationPane = new VBox(10);
        receiptTextArea = new TextArea();
        stage.setTitle("Purchase Receipt");
        receiptTextArea.setEditable(false);
        confirmationPane.getChildren().add(receiptTextArea);
    }

    public void displayReceipt(
        String product1, String amount1, String total1, String price1,
        String product2, String amount2, String total2, String price2,
        String product3, String amount3, String total3, String price3,
        String total) {

        // Construct and display the formatted purchase receipt
        receiptTextArea.setText(
            String.format("%-15s %-15s %-15s %-15s\n", "Product", "Amount", "Total", "Price") +
            String.format("%-24s %-16s %-10s %-10s\n", product1, amount1, total1, price1) +
            String.format("%-19s %-16s %-10s %-10s\n", product2, amount2, total2, price2) +
            String.format("%-21s %-16s %-10s %-10s\n", product3, amount3, total3, price3) +
            String.format("%-10s\n", total)
        );
        
        Button dismissButton = new Button("Dismiss");
        dismissButton.setOnAction(e -> {
            Window owner = dismissButton.getScene().getWindow();
            if (owner instanceof Stage) {
                ((Stage) owner).close();
            }
        });
        confirmationPane.getChildren().add(dismissButton);
    }

    public VBox getMainPane() {
        return confirmationPane;
    }
}