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

import org.gradle.testkit.runner.BuildResult;
import org.gradle.testkit.runner.BuildTask;
import org.gradle.testkit.runner.GradleRunner;
import org.gradle.testkit.runner.TaskOutcome;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

import static org.junit.jupiter.api.Assertions.*;

class LibcensesCheckTaskFunctionalTest {
    @TempDir
    public File testProjectDir;

    private void copyExampleProject() throws IOException {
        this.copyExampleProjectFile("build.gradle");
        this.copyExampleProjectFile("libcenses.yml");
    }

    private void copyExampleProjectFile(String fname) throws IOException {
        Path src;
        Path dst;

        ClassLoader classLoader = getClass().getClassLoader();
        URL resource = classLoader.getResource("libcensesCheckTask/" + fname);
        if (resource == null) {
            throw new FileNotFoundException("Can't get " + fname);
        }

        src = new File(resource.getFile()).toPath();
        dst = new File(this.testProjectDir, fname).toPath();

        Files.copy(src, dst, StandardCopyOption.REPLACE_EXISTING);
    }

    @Test
    void apply() throws IOException {
        this.copyExampleProject();

        BuildResult result = GradleRunner.create()
                .withProjectDir(this.testProjectDir)
                .withPluginClasspath()
                .withArguments("libcensesCheck")
                .build();

        BuildTask resultTask = result.task(":libcensesCheck");
        assertNotNull(resultTask);

        TaskOutcome outcome = resultTask.getOutcome();
        assertNotNull(outcome);

        assertEquals("SUCCESS", outcome.toString());
    }
}