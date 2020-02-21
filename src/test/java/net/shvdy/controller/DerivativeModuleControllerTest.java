package net.shvdy.controller;

import net.shvdy.model.InsuranceObligationContainer;
import net.shvdy.model.insurance_obligation.InsuranceObligation;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DerivativeModuleControllerTest {

    @Test
    @Disabled
    void searchTest() {

        assertEquals(2, 3);

        //InsuranceDerivative id = new InsuranceDerivative();
        HashSet<InsuranceObligation> obligations = new HashSet<>();
        obligations.add(InsuranceObligationContainer.IO5.io);
        obligations.add(InsuranceObligationContainer.IO6.io);
        obligations.add(InsuranceObligationContainer.IO7.io);
        HashSet<InsuranceObligation> obligationsFull = new HashSet<>();
        InsuranceObligationContainer[] ca = InsuranceObligationContainer.values();
        for (InsuranceObligationContainer c : ca) {
            obligationsFull.add(c.io);
        }

        DerivativeModuleController dmc = new DerivativeModuleController(new Controller());

        //assertEquals(obligations, dmc.searchObligationsBy(obligationsFull, "minimal cost", 30000));
    }
}