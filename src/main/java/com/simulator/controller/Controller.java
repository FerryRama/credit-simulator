package com.simulator.controller;

import com.simulator.model.Loan;
import com.simulator.model.LoanFactory;
import com.simulator.view.LoanView;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Controller {
    private LoanView view;

    public Controller(LoanView view) {
        this.view = view;
    }

    public void processFileInput(String filename) {
        try {
            Scanner fileScanner = new Scanner(new File(filename));
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                // Assume the line format is:
                // vehicleType,vehicleCondition,vehicleYear,totalLoan,loanTenor,downPayment
                String[] inputs = line.split(",");

                if (inputs.length != 6) {
                    System.out.println("Invalid input line: " + line);
                    continue; // Skip invalid lines
                }

                String vehicleType = inputs[0].trim();
                String vehicleCondition = inputs[1].trim();
                int vehicleYear = Integer.parseInt(inputs[2].trim());
                double totalLoan = Double.parseDouble(inputs[3].trim());
                int loanTenor = Integer.parseInt(inputs[4].trim());
                double downPayment = Double.parseDouble(inputs[5].trim());

                // Create Loan using factory
                Loan loan = LoanFactory.createLoan(totalLoan, downPayment, loanTenor, vehicleType, vehicleCondition, vehicleYear);
                System.out.println("====== Vehicle Details =========");
                System.out.println("Type : "+vehicleType);
                System.out.println("Vehicle Years : "+vehicleYear);
                System.out.println("=================================");
                System.out.println("======= Monthly Payments ========");
                // Display Monthly Payments
                for (int year = 1; year <= loan.getLoanTenor(); year++) {
                    double monthlyPayment = loan.calculateMonthlyPayment(year);
                    double interestRate = loan.calculateInterestRate(year);
                    view.displayMonthlyPayment(year, monthlyPayment, interestRate, vehicleType);
                }
                System.out.println("=================================");
            }
            fileScanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filename);
        } catch (NumberFormatException e) {
            System.out.println("Invalid number format in file.");
        } catch (IllegalArgumentException e) {
            System.out.println("Error in input data: " + e.getMessage());
        }
    }

    public void processLoan() {
        boolean continueCalculating = true;
        while (continueCalculating) {
            try {
               String vehicleType = view.getVehicleType();
               String vehicleCondition = view.getVehicleCondition();
               int vehicleYear = view.getVehicleYear();
               double totalLoan = view.getTotalLoan();
               int loanTenor = view.getLoanTenor();
               double downPayment = view.getDownPayment();

                // Create Loan using factory
                Loan loan = LoanFactory.createLoan(totalLoan, downPayment, loanTenor, vehicleType, vehicleCondition, vehicleYear);

                // Display Monthly Payments
                for (int year = 1; year <= loan.getLoanTenor(); year++) {
                   double monthlyPayment = loan.calculateMonthlyPayment(year);
                   double interestRate = loan.calculateInterestRate(year);
                    view.displayMonthlyPayment(year, monthlyPayment, interestRate, vehicleType);
                }
            } catch (NumberFormatException e) {
                view.displayError("Input tidak valid. Mohon masukkan angka yang benar.");
            } catch (IllegalArgumentException e) {
                view.displayError(e.getMessage());
        }
            // Ask user if they want to calculate again
        System.out.print("Ingin menghitung lagi? (y/n): ");
        String response = view.getUserResponse();
        if (!response.equalsIgnoreCase("y")) {
            continueCalculating = false; // Exit the loop if the user does not want to continue
        }
    }
        view.close(); // Always close the scanner to prevent resource leaks
    }
}
