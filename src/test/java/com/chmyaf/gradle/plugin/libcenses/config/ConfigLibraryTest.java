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

package com.chmyaf.gradle.plugin.libcenses.config;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ConfigLibraryTest {

    @Test
    void testGetAccepted() {
        ConfigLibrary configLibrary = new ConfigLibrary();

        assertNotNull(configLibrary.getAccepted());
        assertEquals(configLibrary.getAccepted().size(), 0);
    }

    @Test
    void testGetLicense() {
        ConfigLibrary configLibrary = new ConfigLibrary();

        assertNotNull(configLibrary.getLicense());
        assertEquals(configLibrary.getLicense(), "unknown");
    }

    @Test
    void testGetName() {
        ConfigLibrary configLibrary = new ConfigLibrary();

        assertNotNull(configLibrary.getName());
        assertEquals(configLibrary.getName(), "");
    }

    @Test
    void testGetWaiting() {
        ConfigLibrary configLibrary = new ConfigLibrary();

        assertNotNull(configLibrary.getWaiting());
        assertEquals(configLibrary.getWaiting().size(), 0);
    }

    @Test
    void testSetAccepted() {
        ConfigLibrary configLibrary = new ConfigLibrary();
        List<String> accepted = new ArrayList<>();

        accepted.add("example");
        configLibrary.setWaiting(accepted);

        assertEquals(configLibrary.getWaiting(), accepted);
    }

    @Test
    void testSetLicense() {
        ConfigLibrary configLibrary = new ConfigLibrary();
        String license = "license name";

        configLibrary.setLicense(license);

        assertEquals(configLibrary.getLicense(), license);
    }

    @Test
    void testSetName() {
        ConfigLibrary configLibrary = new ConfigLibrary();
        String testName = "testLibraryName.jar";

        configLibrary.setName(testName);

        assertEquals(configLibrary.getName(), testName);
    }

    @Test
    void testSetWaiting() {
        ConfigLibrary configLibrary = new ConfigLibrary();
        List<String> waiting = new ArrayList<>();

        waiting.add("example");
        configLibrary.setWaiting(waiting);

        assertEquals(configLibrary.getWaiting(), waiting);
    }
}