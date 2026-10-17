
package main.java;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class TipCalculatorController {

    @FXML
    private TextField billAmountField;

    @FXML
    private TextField tipPercentageField;

    @FXML
    private Label tipAmountLabel;

    @FXML
    private Label errorLabel;

    @FXML
    private void calculateTip() {
        try {
            double billAmount =
                Double.parseDouble(billAmountField.getText().trim());

            double tipPercentage =
                Double.parseDouble(tipPercentageField.getText().trim());

            if (!Double.isFinite(billAmount)
                    || !Double.isFinite(tipPercentage)
                    || billAmount < 0
                    || tipPercentage < 0) {
                errorLabel.setText(
                    "Error: Enter valid non-negative numbers."
                );
                tipAmountLabel.setText("");
                return;
            }

            double tipAmount = billAmount * tipPercentage / 100.0;

            tipAmountLabel.setText(
                String.format("Tip Amount: $%.2f", tipAmount)
            );

            errorLabel.setText("");

        } catch (NumberFormatException e) {
            tipAmountLabel.setText("");
            errorLabel.setText(
                "Error: Invalid input. Please enter numbers."
            );
        }
    }

    @FXML
    private void reset() {
        billAmountField.clear();
        tipPercentageField.clear();
        tipAmountLabel.setText("");
        errorLabel.setText("");
    }
}
