package com.chmyaf.gradle.plugin.libcenses.config;

import java.util.ArrayList;
import java.util.List;

/**
 * Configuration parameters.
 */
public class Config {
    /// List of a libraries.
    private List<ConfigLibrary> libraries = new ArrayList<>();

    /**
     * Library finder.
     *
     * Find library in the config by its name.
     *
     * @param name Name
     * @return Library
     */
    public ConfigLibrary findLibrary(String name) {
        ConfigLibrary result = null;

        for (ConfigLibrary lib : this.getLibraries()) {
            if (lib.getName().equals(name)) {
                result = lib;
                break;
            }
        }

        return result;
    }

    /**
     * Libraries list getter.
     *
     * @return Libraries.
     */
    public List<ConfigLibrary> getLibraries() {
        return this.libraries;
    }

    /**
     * Libraries list setter.
     *
     * @param libraries Libraries.
     */
    public void setLibraries(List<ConfigLibrary> libraries) {
        this.libraries = libraries;
    }
}
