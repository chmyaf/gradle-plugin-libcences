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

import org.gradle.api.Project;
import org.gradle.testfixtures.ProjectBuilder;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LibcensesPluginTest {
    @Test
    public void testApply() {
        String pluginId = "com.chmyaf.gradle.plugin.libcenses";
        Project project = ProjectBuilder.builder().build();
        project.getPluginManager().apply(pluginId);

        assertTrue(project.getPluginManager().hasPlugin(pluginId));

        assertNotNull(project.getTasks().getByName("libcensesCheck"));
    }
}
