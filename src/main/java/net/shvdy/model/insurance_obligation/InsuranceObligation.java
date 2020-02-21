/**
 * InsuranceLiability
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

public abstract class InsuranceObligation {
    int policyEventRisk;
    int totalCost;
    String insurer;
    String policyHolder = null;
    String object;
    String policyEventInfo;
    LocalDate endTerm;
    int payoutTermLimitDays;
    int premiumDaily;
    int payout;

    public String getPolicyHolder() {
        return policyHolder;
    }

    public String getPolicyEventInfo() {
        return policyEventInfo;
    }

    public LocalDate getEndTerm() {
        return endTerm;
    }

    public int getPayout() {
        return payout;
    }

    public int getPolicyEventRisk() {
        return policyEventRisk;
    }

    public int getTotalCost() {
        return (int) (premiumDaily * Duration.between(LocalDate.now().atStartOfDay(), endTerm.atStartOfDay()).toDays());
    }

    abstract int calculateRisk();
}
