/**
 * ResourceBrowser
 * <p>
 * version 2
 * <p>
 * 13.02.2020
 * <p>
 * Copyright(r) shvdy
 */
package net.shvdy.controller;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.security.CodeSource;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/**
 * Scans jar /resources folder on available ".properties" files,
 * saves all localisations to {@link List}<{@link Locale}>
 *
 * @see ResourceBundle
 */
class ResourceBundleLoader {
    private List<Locale> availableLocales = new ArrayList<>();

    public List<Locale> getAvailableLocales() {
        return availableLocales;
    }

    /**
     * Scans jar /resources folder on available ".properties" files,
     * saves all localisations to {@link List}<{@link Locale}>
     *
     * @see ResourceBundle
     */
    void loadFromJarResources() throws IOException, URISyntaxException {
        CodeSource src = ResourceBundleLoader.class.getProtectionDomain().getCodeSource();
        ZipInputStream jar = null;
        ZipEntry ze;

        if (src != null) {
            URI jarUri = new URI(src.getLocation().toString());
            URL jarUrl = jarUri.toURL();
            jar = new ZipInputStream(jarUrl.openStream());
        }

        while ((ze = jar.getNextEntry()) != null) {
            String entryName = ze.getName();
            if (entryName.startsWith("controller/locale_") && entryName.endsWith(".properties")) {
                availableLocales.add(new Locale(entryName
                        .replaceFirst("controller/locale_", "")
                        .replaceFirst(".properties", "")));
            }
        }
    }
}
