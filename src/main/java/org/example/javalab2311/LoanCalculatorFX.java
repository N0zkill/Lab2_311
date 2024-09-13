package org.example.javalab2311;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

import java.text.DecimalFormat;

public class LoanCalculatorFX extends Application {

    @Override
    public void start(Stage primaryStage) {

        // Create UI
        Label lblInterestRate = new Label("Annual Interest Rate:");
        TextField txtInterestRate = new TextField();

        Label lblNumberOfYears = new Label("Number of Years:");
        TextField txtNumberOfYears = new TextField();

        Label lblLoanAmount = new Label("Loan Amount:");
        TextField txtLoanAmount = new TextField();

        Label lblMonthlyPayment = new Label("Monthly Payment:");
        TextField txtMonthlyPayment = new TextField();
        txtMonthlyPayment.setEditable(false);

        Label lblTotalPayment = new Label("Total Payment:");
        TextField txtTotalPayment = new TextField();
        txtTotalPayment.setEditable(false);

        Button btnCompute = new Button("Compute Payment");

        //layout
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10));
        gridPane.setHgap(10);
        gridPane.setVgap(10);

        // Add components
        gridPane.add(lblInterestRate, 0, 0);
        gridPane.add(txtInterestRate, 1, 0);
        gridPane.add(lblNumberOfYears, 0, 1);
        gridPane.add(txtNumberOfYears, 1, 1);
        gridPane.add(lblLoanAmount, 0, 2);
        gridPane.add(txtLoanAmount, 1, 2);
        gridPane.add(lblMonthlyPayment, 0, 3);
        gridPane.add(txtMonthlyPayment, 1, 3);
        gridPane.add(lblTotalPayment, 0, 4);
        gridPane.add(txtTotalPayment, 1, 4);
        gridPane.add(btnCompute, 1, 5);

        //button action
        btnCompute.setOnAction(e -> {
            try {

                // Get values
                double interest = Double.parseDouble(txtInterestRate.getText());
                int years = Integer.parseInt(txtNumberOfYears.getText());
                double loanAmount = Double.parseDouble(txtLoanAmount.getText());


                //monthly interest rate
                double monthlyInterestRate = interest / 1200;
                int numberOfMonths = years * 12;


                //monthly payment
                double monthlyPayment = loanAmount * monthlyInterestRate /
                        (1 - 1 / Math.pow(1 + monthlyInterestRate, numberOfMonths));
                double totalPayment = monthlyPayment * numberOfMonths;

                // Display results
                DecimalFormat df = new DecimalFormat("#.##");
                txtMonthlyPayment.setText("$" + df.format(monthlyPayment));
                txtTotalPayment.setText("$" + df.format(totalPayment));

            } catch (NumberFormatException ex) {

                txtMonthlyPayment.setText("Invalid input");
                txtTotalPayment.setText("Invalid input");
            }
        });

        //scene and set stage
        Scene scene = new Scene(gridPane, 400, 250);
        primaryStage.setTitle("Loan Calculator");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
