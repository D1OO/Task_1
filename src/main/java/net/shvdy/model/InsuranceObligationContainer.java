package net.shvdy.model;

import net.shvdy.model.insurance_obligation.InsuranceObligation;
import net.shvdy.model.insurance_obligation.LifeInsuranceObligation;
import net.shvdy.model.insurance_obligation.PropertyInsuranceObligation;
import net.shvdy.model.insurance_obligation.VehicleOwnersLiabilityInsuranceObligation;

import java.time.LocalDate;

public enum InsuranceObligationContainer {
    IO1(new LifeInsuranceObligation("Mr. Bill Topson", "OOO AlfaInsurance", "Katie Topson",
            "General health insurance", LocalDate.parse("2021-07-30"), 60, 2, 3500,
            LifeInsuranceObligation.LIFE_INSURANCE_TYPE.TEMPORARY_DISABILITY,
            24, LifeInsuranceObligation.OBJECT_EMPLOYMENT_RISK.LOW)),
    IO2(new LifeInsuranceObligation("Sir Alex Ferguson", "AIG Insurance", "Sir Alex Ferguson",
            "Life insurance", LocalDate.parse("2025-07-30"), 180, 150, 1000000,
            LifeInsuranceObligation.LIFE_INSURANCE_TYPE.DEATH,
            70, LifeInsuranceObligation.OBJECT_EMPLOYMENT_RISK.VERY_LOW)),
    IO3(new LifeInsuranceObligation("Donald Trumk", "Colorado Insurance Group", "Eric Cartman",
            "Temporarily disability insurance", LocalDate.parse("2021-07-30"), 30, 1, 2000,
            LifeInsuranceObligation.LIFE_INSURANCE_TYPE.INAVAILABILITY,
            17, LifeInsuranceObligation.OBJECT_EMPLOYMENT_RISK.CRITICAL)),
    IO4(new PropertyInsuranceObligation("Donald Trumk", "StateFarmm Insurance", "Trumk Tower",
            "Property Insurance", LocalDate.parse("2030-02-22"), 365, 1000, 20000000,
            3, 0, 1, 2, 3, 1)),
    IO5(new PropertyInsuranceObligation("Corey Taylor", "StateFarmm Insurance", "Iowa, Des Moines, Elm Street, 68",
            "Property Insurance", LocalDate.parse("2024-04-30"), 365, 100, 500000,
            2, 1, 2, 1, 1, 1)),
    IO6(new PropertyInsuranceObligation("James Harden", "StateFarmm Insurance", "Texas, Houston, Groove Street, 22",
            "Property Insurance", LocalDate.parse("2024-04-30"), 365, 200, 700000,
            1, 3, 3, 1, 2, 1)),
    IO7(new VehicleOwnersLiabilityInsuranceObligation("Dwayne Wade", "StateFarmm Insurance", "53143151",
            "Drivers Liability Insurance", LocalDate.parse("2021-04-30"), 180, 200, 700000,
            VehicleOwnersLiabilityInsuranceObligation.DRIVERS_EXPERIENCE_COEF.AVERAGE,
            VehicleOwnersLiabilityInsuranceObligation.CAR_RELIABILITY_COEF.HIGH)),
    IO8(new VehicleOwnersLiabilityInsuranceObligation("Antony Davis", "StateFarmm Insurance", "12212121",
            "Drivers Liability Insurance", LocalDate.parse("2021-04-30"), 180, 300, 900000,
            VehicleOwnersLiabilityInsuranceObligation.DRIVERS_EXPERIENCE_COEF.BELOW_AVERAGE,
            VehicleOwnersLiabilityInsuranceObligation.CAR_RELIABILITY_COEF.HIGH)),
    IO9(new VehicleOwnersLiabilityInsuranceObligation("Eric Gordon", "StateFarmm Insurance", "32323232",
            "Drivers Liability Insurance", LocalDate.parse("2021-01-30"), 180, 50, 200000,
            VehicleOwnersLiabilityInsuranceObligation.DRIVERS_EXPERIENCE_COEF.VERY_HIGH,
            VehicleOwnersLiabilityInsuranceObligation.CAR_RELIABILITY_COEF.VERY_HIGH));

    public InsuranceObligation io;

    InsuranceObligationContainer(InsuranceObligation io) {
        this.io = io;
    }

    InsuranceObligation getObligation() {
        return io;
    }
}
