/**
 * CompulsoryInsuranceLiability
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

public class LifeInsuranceObligation extends InsuranceObligation {

    public enum LIFE_INSURANCE_TYPE {
        DEATH("Уход из жизни заемщика по любой причине"),
        INAVAILABILITY("Присвоение инвалидности I и II группы в результате несчастного случая и/или болезни"),
        TEMPORARY_DISABILITY("нахождение на длительном больничном");

        public String type_desc;

        LIFE_INSURANCE_TYPE(String desc) {
            type_desc = desc;
        }
    }

    public enum OBJECT_EMPLOYMENT_RISK {
        CRITICAL(16),
        SEVERE(12),
        SUBSTANTIONAL(8),
        MODERATE(6),
        LOW(2),
        VERY_LOW(1);

        public int risk;

        OBJECT_EMPLOYMENT_RISK(int risk) {
            this.risk = risk;
        }
    }

    LIFE_INSURANCE_TYPE TYPE;
    OBJECT_EMPLOYMENT_RISK EMPLOYMENT_RISK;
    public int objectAge;

    public LifeInsuranceObligation(String insurer, String policyHolder, String object, String policyEventInfo,
                                   LocalDate term, int payoutTermLimit, int premiumDaily, int payout,
                                   LIFE_INSURANCE_TYPE T, int objectAge, OBJECT_EMPLOYMENT_RISK ER) {
        this.insurer = insurer;
        this.policyHolder = policyHolder;
        this.object = object;
        this.policyEventInfo = policyEventInfo;
        this.endTerm = term;
        this.payoutTermLimitDays = payoutTermLimit;
        this.premiumDaily = premiumDaily;
        this.payout = payout;
        this.objectAge = objectAge;
        TYPE = T;
        EMPLOYMENT_RISK = ER;

        totalCost = getTotalCost();
        policyEventRisk = calculateRisk();
    }

    public int getTotalCost() {
        return (int) (premiumDaily * Duration.between(LocalDate.now().atStartOfDay(), endTerm.atStartOfDay()).toDays());
    }

    public int calculateRisk() {
        return objectAge / 100 + EMPLOYMENT_RISK.risk / 2;
    }
}
