package com.chmyaf.gradle.plugin.libcenses.config;

import java.util.ArrayList;
import java.util.List;

/**
 * One of a libraries in configuration.
 */
public class ConfigLibrary {
    /// Accepted notes.
    private List<String> accepted = new ArrayList<>();
    /// Library license.
    private String license = "unknown";
    /// Library name.
    private String name = "";
    /// Waiting notes.
    private List<String> waiting = new ArrayList<>();

    /**
     * Accepted notes getter.
     *
     * @return Notes.
     */
    public List<String> getAccepted() {
        return accepted;
    }

    /**
     * License name getter.
     *
     * @return Name.
     */
    public String getLicense() {
        return this.license;
    }

    /**
     * Library name getter.
     *
     * @return Library name.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Waiting notes getter.
     *
     * @return Notes.
     */
    public List<String> getWaiting() {
        return this.waiting;
    }

    /**
     * Accepted notes setter.
     *
     * @param accepted Notes.
     */
    public void setAccepted(List<String> accepted) {
        this.accepted = accepted;
    }

    /**
     * License name setter.
     *
     * @param license Name.
     */
    public void setLicense(String license) {
        this.license = license;
    }

    /**
     * Library name setter.
     *
     * @param name Library name.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Waiting notes setter.
     *
     * @param waiting Notes.
     */
    public void setWaiting(List<String> waiting) {
        this.waiting = waiting;
    }
}
