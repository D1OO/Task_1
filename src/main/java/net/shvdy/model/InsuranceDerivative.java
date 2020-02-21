/**
 * Derivative
 * <p>
 * version 1.0
 * <p>
 * 20.02.2020
 * <p>
 * Copyright(r) shvdy.net
 */

package net.shvdy.model;

import net.shvdy.model.insurance_obligation.InsuranceObligation;

import java.util.HashSet;

public class InsuranceDerivative {
    private HashSet<InsuranceObligation> constituentInsuranceObligations;

    InsuranceDerivative(HashSet<InsuranceObligation> obligations) {
        constituentInsuranceObligations = obligations;
    }

    public HashSet<InsuranceObligation> getConstituentObligations() {
        return constituentInsuranceObligations;
    }
}
