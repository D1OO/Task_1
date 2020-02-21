/**
 * NoteCreatorController
 * <p>
 * version 2
 * <p>
 * 13.02.2020
 * <p>
 * Copyright(r) shvdy
 */
package net.shvdy.controller;

import net.shvdy.model.InsuranceDerivative;
import net.shvdy.model.Model;
import net.shvdy.model.insurance_obligation.InsuranceObligation;

import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Scanner;

import static java.lang.String.format;

class DerivativeModuleController {
    private ViewController viewController;
    private Scanner sc;

    DerivativeModuleController(Controller controller) {
        viewController = controller.viewController;
        sc = controller.sc;
    }

    void session() {
        InsuranceDerivative derivative = Model.createRandomDerivative();
        boolean keepWorking = true;

        while (keepWorking) {
            viewController.printMessage("\n", viewController.getLocalisedMsg(ViewController.CURRENT_DERIVATIVE),
                    ":\n\t[", currentDerivativeShortInfo(derivative) + "]\n",
                    "\t1) ", viewController.getLocalisedMsg(ViewController.CREATE_DERIVATIVE_MSG), ";\n",
                    "\t2) ", viewController.getLocalisedMsg(ViewController.COUNT_TOTAL_COST), ";\n",
                    "\t3) ", viewController.getLocalisedMsg(ViewController.SORT_BY_RISK_DECR), ";\n",
                    "\t   ", viewController.getLocalisedMsg(ViewController.FIND_OBL_BY), ":\n",
                    "\t4) ", viewController.getLocalisedMsg(ViewController.MIN_COST), ";\n",
                    "\t5) ", viewController.getLocalisedMsg(ViewController.MAX_RISK), ";\n",
                    "\t6) ", viewController.getLocalisedMsg(ViewController.EXIT), "");

            int chosenActionCode = sc.nextInt();
            sc.nextLine();

            switch (chosenActionCode) {
                case 1: {
                    derivative = Model.createRandomDerivative();
                    break;
                }
                case 2: {
                    viewController.printMessage("[",
                            viewController.getLocalisedMsg(ViewController.DERIVATIVE_TOTAL_COST_IS), ": ",
                            String.valueOf(countDerivativeCost(derivative)), "$]");
                    break;
                }
                case 3: {
                    sortDerivativeObligations(derivative);
                    break;
                }
                case 4: {
                    searchObligationsBy(derivative, "minimal cost");
                    break;
                }
                case 5: {
                    searchObligationsBy(derivative, "max risk");
                    break;
                }
                case 6: {
                    keepWorking = false;
                    break;
                }
                default:
                    viewController.printLocalisedMessage(
                            viewController.getLocalisedMsg(ViewController.WRONG_INPUT_MSG));
            }
        }
    }

    private int countDerivativeCost(InsuranceDerivative derivative) {
        int cost = 0;
        for (InsuranceObligation io : derivative.getConstituentObligations()) {
            cost += io.getTotalCost();
        }
        return cost;
    }

    private void searchObligationsBy(InsuranceDerivative derivative, String param) {
        int paramSearchValue = getUserIntInput(param);
        HashSet<InsuranceObligation> obligations = derivative.getConstituentObligations();

        if (param.equals("max risk"))
            obligations.removeIf(o -> o.getPolicyEventRisk() > paramSearchValue);
        else if (param.equals("minimal cost"))
            obligations.removeIf(o -> o.getTotalCost() < paramSearchValue);

        viewController.printMessage("\n", viewController.getLocalisedMsg(ViewController.SEARCH_RESULTS), ":");
        printObligationsList(obligations.toArray(new InsuranceObligation[0]));
    }

    private int getUserIntInput(String param) {
        int result;
        while (true) {
            viewController.printMessage(viewController.getLocalisedMsg(ViewController.INPUT_DESIRED),
                    " ", param, " ", viewController.getLocalisedMsg(ViewController.VALUE), ": ");
            try {
                result = sc.nextInt();
            } catch (InputMismatchException e) {
                viewController.printMessage(viewController.getLocalisedMsg(ViewController.WRONG_INPUT_MSG));
                continue;
            }
            sc.nextLine();
            return result;
        }
    }

    private void sortDerivativeObligations(InsuranceDerivative derivative) {
        InsuranceObligation[] obligations = derivative.getConstituentObligations().toArray(new InsuranceObligation[0]);
        for (int i = 0; i < obligations.length; i++) {
            for (int j = 0; j < obligations.length; j++) {
                if (obligations[i].getPolicyEventRisk() > obligations[j].getPolicyEventRisk()) {
                    InsuranceObligation temp = obligations[j];
                    obligations[j] = obligations[i];
                    obligations[i] = temp;
                }
            }
        }
        printObligationsList(obligations);
    }

    private void printObligationsList(InsuranceObligation[] obligations) {
        for (InsuranceObligation io : obligations) {
            viewController.printMessage("\t", viewController.getLocalisedMsg(ViewController.RISK), " - ",
                    String.valueOf(io.getPolicyEventRisk()),
                    "%  [", viewController.getLocalisedMsg(ViewController.PAYOUT),
                    ": ", String.valueOf(io.getPayout()), "$ ", viewController.getLocalisedMsg(ViewController.COST),
                    ": ", String.valueOf(io.getTotalCost()),
                    " ", io.getPolicyEventInfo(), " ", io.getPolicyHolder(), " ", io.getEndTerm().toString(), "]");
        }
    }

    private String currentDerivativeShortInfo(InsuranceDerivative derivative) {
        HashSet<InsuranceObligation> obligations = derivative.getConstituentObligations();
        double avgRisk = 0, avgCost = 0, totalCost;

        for (InsuranceObligation o : obligations) {
            avgRisk += o.getPolicyEventRisk();
            avgCost += o.getTotalCost();
        }

        totalCost = avgCost;
        avgRisk = avgRisk / obligations.size();
        avgCost = avgCost / obligations.size();

        return concatenateString(viewController.getLocalisedMsg(ViewController.SIZE),
                ": ", String.valueOf(obligations.size()), " | ",
                viewController.getLocalisedMsg(ViewController.AVG_RISK), ": ", format("%.2f", avgRisk),
                " | ", viewController.getLocalisedMsg(ViewController.AVG_COST), ": " + format("%.2f", avgCost),
                " | ", viewController.getLocalisedMsg(ViewController.COST), ": " + format("%.2f", totalCost));
    }

    private String concatenateString(String... pieces) {
        StringBuilder sb = new StringBuilder();
        for (String p : pieces) {
            sb.append(p);
        }
        return sb.toString();
    }
}
