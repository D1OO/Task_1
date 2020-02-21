/**
 * ResourceBundleContainer
 * <p>
 * version 1.0
 * <p>
 * 20.02.2020
 * <p>
 * Copyright(r) shvdy.net
 */

package net.shvdy.controller;

import net.shvdy.view.View;

import java.util.ResourceBundle;

public class ViewController {
    public static final String WELCOME_MSG = "message.welcome";
    public static final String WRONG_INPUT_MSG = "message.input.wrong.data";
    public static final String GOODBYE_MSG = "message.goodbye";
    public static final String CREATE_DERIVATIVE_MSG = "message.create_derivative";
    public static final String COUNT_TOTAL_COST = "message.count_total_cost";
    public static final String SORT_BY_RISK_DECR = "message.sort_by_risk_decrease";
    public static final String FIND_OBL_BY = "message.find+obligations_by";
    public static final String MIN_COST = "message.minimal_cost";
    public static final String CURRENT_DERIVATIVE = "message.current_derivative";
    public static final String MAX_RISK = "message.max_risk";
    public static final String EXIT = "message.exit";
    public static final String DERIVATIVE_TOTAL_COST_IS = "message.derivative_total_cost";
    public static final String SEARCH_RESULTS = "message.search_results";
    public static final String INPUT_DESIRED = "message.input_desired";
    public static final String VALUE = "message.value";
    public static final String RISK = "message.risk";
    public static final String PAYOUT = "message.payout";
    public static final String COST = "message.cost";
    public static final String SIZE = "message.size";
    public static final String AVG_RISK = "message.avg_risk";
    public static final String AVG_COST = "message.avg_cost";

    public ResourceBundle currentLocale;
    private View view;

    ViewController(View view) {
        this.view = view;
    }

    void setLocale(ResourceBundle rb) {
        currentLocale = rb;
    }

    public void printMessage(String message) {
        view.printMessage(message);
    }

    public void printMessage(String... message) {
        view.printMessage(concatenateString(message));
    }

    public void printLocalisedMessage(String message) {
        view.printMessage(currentLocale.getString(message));
    }

    public String getLocalisedMsg(String key) {
        return currentLocale.getString(key);
    }

    public String concatenateString(String... message) {
        StringBuilder concatString = new StringBuilder();
        for (String v : message) {
            concatString.append(v);
        }
        return new String(concatString);
    }
}
