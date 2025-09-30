package org.example.simplecalculator.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.text.DecimalFormat;

public class HelloController {

    @FXML
    private TextField txtInput1;
    @FXML
    private TextField txtInput2;
    @FXML
    private Label lblOperator;
    @FXML
    private Label lblResult;

    // operators
    @FXML
    private void onBtnAdditionClick(ActionEvent actionEvent) {
        lblOperator.setText("+");
    }

    @FXML
    private void onBtnSubtractClick(ActionEvent actionEvent) {
        lblOperator.setText("-");
    }

    @FXML
    private void onBtnMultiplyClick(ActionEvent actionEvent) {
        lblOperator.setText("x");
    }

    @FXML
    private void onBtnDivisionClick(ActionEvent actionEvent) {
        lblOperator.setText("/");
    }

    // calculate
    @FXML
    private void onBtnCalculateClick(ActionEvent actionEvent) {
        try {
            double input1 = Double.parseDouble(txtInput1.getText());
            double input2 = Double.parseDouble(txtInput2.getText());
            String operator = lblOperator.getText();
            double result = 0;

            switch (operator) {
                case "+":
                    result = input1 + input2;
                    break;
                case "-":
                    result = input1 - input2;
                    break;
                case "x":
                    result = input1 * input2;
                    break;
                case "/":
                    if (input2 != 0) {
                        result = input1 / input2;
                    } else {
                        lblResult.setText("Error: Division by zero");
                        return;
                    }
                    break;
                default:
                    lblResult.setText("Error: No operator selected");
                    return;
            }

            DecimalFormat df = new DecimalFormat("0.##");
            lblResult.setText(df.format(result));
        } catch (NumberFormatException e) {
            lblResult.setText("Error: Invalid input");
        }
    }
}
