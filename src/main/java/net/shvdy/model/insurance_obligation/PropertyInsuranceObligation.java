/**
 * InsuranceContractLiability
 * <p>
 * version 1.0
 * <p>
 * 20.02.2020
 * <p>
 * Copyright(r) shvdy.net
 */

package net.shvdy.model.insurance_obligation;

import java.time.Duration;
import java.time.LocalDate;

public class PropertyInsuranceObligation extends InsuranceObligation {

    int fireRisk;
    int stormOrFloodRisk;
    int lightningOrExplosionRisk;
    int earthquakeOrLandslipRisk;
    int fallingTreesRisk;
    int vehicleOrAircraftDamageRisk;

    public PropertyInsuranceObligation(String insurer, String policyHolder, String object, String policyEventInfo,
                                       LocalDate term, int payoutTermLimit, int premiumMonthly, int payout,
                                       int fireRisk, int stormOrFloodRisk, int lightningOrExplosionRisk, int earthquakeOrLandslipRisk,
                                       int fallingTreesRisk, int vehicleOrAircraftDamageRisk) {
        this.insurer = insurer;
        this.policyHolder = policyHolder;
        this.object = object;
        this.policyEventInfo = policyEventInfo;
        this.endTerm = term;
        this.payoutTermLimitDays = payoutTermLimit;
        this.premiumDaily = premiumMonthly;
        this.payout = payout;
        this.fireRisk = fireRisk;
        this.stormOrFloodRisk = stormOrFloodRisk;
        this.lightningOrExplosionRisk = lightningOrExplosionRisk;
        this.earthquakeOrLandslipRisk = earthquakeOrLandslipRisk;
        this.fallingTreesRisk = fallingTreesRisk;
        this.vehicleOrAircraftDamageRisk = vehicleOrAircraftDamageRisk;
        totalCost = getTotalCost();
        policyEventRisk = calculateRisk();
    }

    public int getTotalCost() {
        return (int) (premiumDaily * Duration.between(LocalDate.now().atStartOfDay(), endTerm.atStartOfDay()).toDays());
    }

    public int calculateRisk() {
        return fireRisk + stormOrFloodRisk + lightningOrExplosionRisk + earthquakeOrLandslipRisk +
                fallingTreesRisk + vehicleOrAircraftDamageRisk;
    }

}
