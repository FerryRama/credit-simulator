package com.simulator.model;

import java.time.Year;

public class LoanFactory {
    public static Loan createLoan(double totalLoan, double downPayment, int loanTenor,
                                  String vehicleType, String vehicleCondition, int vehicleYears) {
        int currentYear = Year.now().getValue();
        int currentYearsMins1 = currentYear - 1;
        // Validate Year for New Vehicles
        if (vehicleCondition.equalsIgnoreCase("Baru") && (vehicleYears < currentYearsMins1 )) {
            throw new IllegalArgumentException("Kendaraan baru tidak boleh memiliki tahun kurang dari tahun "+currentYearsMins1);
        }
        if(loanTenor >= 6){
            throw new IllegalArgumentException("Tenor tidak boleh lebih dari 5 Tahun");
        }
        // Validate Down Payment
        if (vehicleCondition.equalsIgnoreCase("Baru") && downPayment < 0.35 * totalLoan) {
            throw new IllegalArgumentException("Jumlah DP untuk kendaraan baru harus >= 35% dari jumlah pinjaman.");
        } else if (vehicleCondition.equalsIgnoreCase("Bekas") && downPayment < 0.25 * totalLoan) {
            throw new IllegalArgumentException("Jumlah DP untuk kendaraan bekas harus >= 25% dari jumlah pinjaman.");
        }

        return new Loan(totalLoan, downPayment, loanTenor, vehicleType, vehicleCondition);
    }
}
