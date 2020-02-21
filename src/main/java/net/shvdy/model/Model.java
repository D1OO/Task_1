/**
 * Model
 * <p>
 * version 1.0
 * <p>
 * 20.02.2020
 * <p>
 * Copyright(r) shvdy.net
 */

package net.shvdy.model;

import net.shvdy.model.insurance_obligation.InsuranceObligation;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

public class Model {

    public static InsuranceDerivative createRandomDerivative() {

        Random r = new Random();
        HashSet<InsuranceObligation> obligations = new HashSet<>();
        int derivativeSize = (r.nextInt(9 - 5) + 5);
        ArrayList<Integer> randomIndexes = new ArrayList<>();

        while (randomIndexes.size() < derivativeSize) {
            int randInt = r.nextInt(9);
            if (!randomIndexes.contains(randInt)) {
                randomIndexes.add(randInt);
            }
        }

        InsuranceObligationContainer[] ss = InsuranceObligationContainer.values();
        for (int k : randomIndexes) {
            obligations.add(ss[k].getObligation());
        }

        return new InsuranceDerivative(obligations);
    }
}
