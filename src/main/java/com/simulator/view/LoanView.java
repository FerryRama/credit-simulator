package com.simulator.view;

import java.util.Scanner;

public class LoanView {
    private Scanner scanner;

    public LoanView() {
        this.scanner = new Scanner(System.in);
    }

    public String getVehicleType() {
        System.out.print("Input Jenis Kendaraan (Motor/Mobil): ");
        return scanner.nextLine();
    }

    public String getVehicleCondition() {
        System.out.print("Input Kendaraan (Bekas/Baru): ");
        return scanner.nextLine();
    }

    public int getVehicleYear() {
        System.out.print("Input Tahun Kendaraan (4 Digit): ");
        return Integer.parseInt(scanner.nextLine());
    }

    public double getTotalLoan() {
        System.out.print("Input Jumlah Pinjaman Total (<= 1 Miliar): ");
        return Double.parseDouble(scanner.nextLine());
    }

    public int getLoanTenor() {
        System.out.print("Input Tenor Pinjaman (1-5 thn): ");
        return Integer.parseInt(scanner.nextLine());
    }

    public double getDownPayment() {
        System.out.print("Input Jumlah DP: ");
        return Double.parseDouble(scanner.nextLine());
    }
    public String getUserResponse() {
        return scanner.nextLine();
    }
    public void displayMonthlyPayment(int year, double monthlyPayment, double interestRate, String vehicleType) {
        System.out.printf("Tahun %d: Rp. %.2f/bln, Suku Bunga: %.1f%%%n", year, monthlyPayment, interestRate * 100);
    }

    public void displayError(String message) {
        System.out.println("Error: " + message);
    }

    public void close() {
        scanner.close();
    }
}
