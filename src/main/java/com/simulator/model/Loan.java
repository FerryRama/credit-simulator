package com.simulator.model;

public class Loan {
    private double totalLoan;
    private double downPayment;
    private int loanTenor; // in years
    private String vehicleType; // Motor atau Mobil
    private String vehicleCondition; // Bekas atau Baru
    private static final double BASE_INTEREST_RATE_MOBIL = 0.08; // 8%
    private static final double BASE_INTEREST_RATE_MOTOR = 0.09; // 9%
    public Loan(double totalLoan, double downPayment, int loanTenor, String vehicleType, String vehicleCondition) {
        this.totalLoan = totalLoan;
        this.downPayment = downPayment;
        this.loanTenor = loanTenor;
        this.vehicleType = vehicleType.toLowerCase();
        this.vehicleCondition = vehicleCondition.toLowerCase();
    }

    public double calculateMonthlyPayment(int year) {
        double loanAmount = totalLoan - downPayment;
        double interestRate = calculateInterestRate(year);
        return (loanAmount * (1 + interestRate)) / (year * 12);
    }

    public double calculateInterestRate(int year) {
        double baseRate = vehicleType.equals("mobil") ? BASE_INTEREST_RATE_MOBIL : BASE_INTEREST_RATE_MOTOR;
        // Interest increases 0.1% per year for each year after the first year
        if (year > 1) {
            baseRate += 0.001 * (year - 1); // 0.1% increase for each year
        }
        // Additionally, increase by 0.5% for each full two years
        if (year > 2) {
            baseRate += 0.005 * ((year - 1) / 2); // 0.5% for each full two years
        }
        return baseRate;
    }

    public int getLoanTenor() {
        return loanTenor;
    }

    public double getTotalLoan() {
        return totalLoan;
    }

    public double getDownPayment() {
        return downPayment;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public String getVehicleCondition() {
        return vehicleCondition;
    }
}
