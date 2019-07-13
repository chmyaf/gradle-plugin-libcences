/*
 * Copyright 2019 Andrey S Teplitskiy
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.chmyaf.gradle.plugin.libcenses;

import com.chmyaf.gradle.plugin.libcenses.config.Config;
import com.chmyaf.gradle.plugin.libcenses.config.ConfigLibrary;
import org.gradle.api.DefaultTask;
import org.gradle.api.GradleScriptException;
import org.gradle.api.Project;
import org.gradle.api.artifacts.Configuration;
import org.gradle.api.artifacts.ConfigurationContainer;
import org.gradle.api.tasks.TaskAction;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Set;

/**
 * Task libcensesCheck implementation.
 *
 * The "libcensesCheck" task for the plugin.
 */
public class LibcensesCheckTask extends DefaultTask {
    /// Plugin extension.
    private LibcensesPluginExtension LCPE;
    /// Configuration.
    private Config config;
    /// Dependencies.
    private Set<String> deps = new HashSet<>();

    public LibcensesCheckTask() {
        this.LCPE = this.getProject().getExtensions().
                findByType(LibcensesPluginExtension.class);
    }

    /**
     * Main task method.
     */
    @TaskAction
    public void apply() {
        this.loadConfig();
        this.initDependencies();
        this.deps.forEach(this::checkDependency);
    }

    /**
     * Dependency checker.
     *
     * Check dependency library in the config.
     *
     * @param depName Library name
     */
    private void checkDependency(String depName) {
        ConfigLibrary lib = this.getConfig().findLibrary(depName);
        String logPrefix = "The library '" + depName + "' ";
        if (lib == null) {
            this.getLogger().warn(logPrefix + "was not found in '" +
                    this.getConfigFile().getAbsolutePath() + "'."
            );
        } else if (lib.getLicense().equals("unknown")) {
            this.getLogger().warn(logPrefix + "has an unknown license.");
        } else if (lib.getWaiting().size() != 0) {
            this.getLogger().warn(logPrefix +
                    "is waiting for the terms of the agreement:"
            );
            lib.getWaiting().forEach(System.out::println);
        }
    }

    /**
     * Configuration getter.
     *
     * @return Configuration.
     */
    private Config getConfig() {
        return this.config;
    }

    /**
     * Path to configuration file getter.
     *
     * @return Path.
     */
    private File getConfigFile() {
        return new File(this.getProject().getProjectDir().getAbsolutePath(),
                this.getLCPE().config
        );
    }

    /**
     * Plugin extension getter.
     *
     * @return Plugin extension.
     */
    private LibcensesPluginExtension getLCPE() {
        return this.LCPE;
    }

    /**
     * Libraries list initializer.
     */
    private void initDependencies() {
        Project project = this.getProject();
        ConfigurationContainer configurations = project.getConfigurations();
        Configuration compile = configurations.getByName("compile");
        compile.forEach(dep -> this.deps.add(dep.getName()));
    }

    /**
     * Configuration loader.
     */
    private void loadConfig() {
        InputStream is = this.loadFileToInputStream(this.getConfigFile());
        Yaml yaml = new Yaml(new Constructor(Config.class));

        this.config = yaml.load(is);
    }

    /**
     * File loader.
     *
     * @param file File to load.
     * @return File.
     */
    private InputStream loadFileToInputStream(File file) {
        InputStream result;

        try {
            result = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            throw new GradleScriptException("Can't read file: " +
                    file.getAbsolutePath(),
                    new Exception(e)
            );
        }

        return result;
    }
}
