/**
 * SpecialTypeInsuranceLiabilityContract
 * <p>
 * version 1.0
 * <p>
 * 20.02.2020
 * <p>
 * Copyright(r) shvdy.net
 */

package net.shvdy.model.insurance_obligation;

import java.time.LocalDate;

public class VehicleOwnersLiabilityInsuranceObligation extends InsuranceObligation {

    DRIVERS_EXPERIENCE_COEF EXP_COEF;
    CAR_RELIABILITY_COEF CAR_COEF;

    public enum DRIVERS_EXPERIENCE_COEF {
        VERY_HIGH(80),
        HIGH(75),
        ABOVE_AVERAGE(60),
        AVERAGE(50),
        BELOW_AVERAGE(40),
        LOW(25),
        VERY_LOW(15),
        NOVICE(5);

        public int value;

        DRIVERS_EXPERIENCE_COEF(int coef) {
            value = coef;
        }
    }

    public enum CAR_RELIABILITY_COEF {
        VERY_HIGH(80),
        HIGH(75),
        ABOVE_AVERAGE(60),
        AVERAGE(50),
        BELOW_AVERAGE(40),
        LOW(25),
        VERY_LOW(15),
        CRITICAL(5);

        public int value;

        CAR_RELIABILITY_COEF(int risk) {
            value = risk;
        }
    }

    public VehicleOwnersLiabilityInsuranceObligation(String insurer, String policyHolder, String object, String policyEventInfo,
                                                     LocalDate term, int payoutTermLimit, int premiumMonthly, int payout,
                                                     DRIVERS_EXPERIENCE_COEF EC, CAR_RELIABILITY_COEF CC) {
        this.insurer = insurer;
        this.policyHolder = policyHolder;
        this.object = object;
        this.policyEventInfo = policyEventInfo;
        this.endTerm = term;
        this.payoutTermLimitDays = payoutTermLimit;
        this.premiumDaily = premiumMonthly;
        this.payout = payout;
        this.EXP_COEF = EC;
        this.CAR_COEF = CC;
        totalCost = getTotalCost();
        policyEventRisk = calculateRisk();
    }

    public int calculateRisk() {
        return (100 - EXP_COEF.value / 80) / 100 + (100 - CAR_COEF.value / 100) / 100;
    }
}
