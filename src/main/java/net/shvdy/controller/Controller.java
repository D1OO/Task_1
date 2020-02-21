/**
 * Controller
 * <p>
 * version 3
 * <p>
 * 13.02.2020
 * <p>
 * Copyright(r) shvdy
 */
package net.shvdy.controller;

import net.shvdy.view.View;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

public class Controller {
    View view;
    Scanner sc = new Scanner(System.in);
    ResourceBundleLoader resourcesBrowser = new ResourceBundleLoader();
    ViewController viewController;

    public void processSession(View viewLink) {
        try {
            resourcesBrowser.loadFromJarResources();
        } catch (IOException | URISyntaxException e) {
            view.printMessage("Internal error \n");
        }

        view = viewLink;
        viewController = new ViewController(view);
        DerivativeModuleController derivativeModuleController = new DerivativeModuleController(this);

        viewController.setLocale(inquireAndGetLanguageBundle());
        viewController.printLocalisedMessage(ViewController.WELCOME_MSG);

        derivativeModuleController.session();

        viewController.printLocalisedMessage(ViewController.GOODBYE_MSG);
    }

    /**
     * Receives locales, loaded from jar file with {@link ResourceBundleLoader},
     * returns one chosen by user
     *
     * @return ResourceBundle of locale chosen by user
     * @see ResourceBundle
     */
    private ResourceBundle inquireAndGetLanguageBundle() {
        List<Locale> availableLocales;
        StringBuilder chooseLangMsg = new StringBuilder();

        availableLocales = resourcesBrowser.getAvailableLocales();

        chooseLangMsg.append("Choose your language/Виберіть мову:");
        for (int i = 0; i < availableLocales.size(); i++) {
            chooseLangMsg.append("\n\t").append(i + 1).append(". ").append(availableLocales.get(i).toString().toUpperCase());
        }

        int chosenLangCode;
        while (true) {
            viewController.printMessage(chooseLangMsg.toString());
            try {
                chosenLangCode = sc.nextInt();
                sc.nextLine();
                if (chosenLangCode > availableLocales.size() || chosenLangCode < 1) throw new Exception();
                break;
            } catch (Exception e) {
                viewController.printLocalisedMessage(ViewController.WRONG_INPUT_MSG);
            }
        }

        return ResourceBundle.getBundle("controller/locale", availableLocales.get(chosenLangCode - 1));
    }
}
