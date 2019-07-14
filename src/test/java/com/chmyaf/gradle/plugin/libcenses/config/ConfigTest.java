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

import static org.junit.jupiter.api.Assertions.*;

class ConfigTest {

    @Test
    void testFindLibrary() {
        Config config = new Config();
        ArrayList<ConfigLibrary> testLibs = new ArrayList<>();
        ConfigLibrary testLib = new ConfigLibrary();
        String libName = "testLib";

        assertNull(config.findLibrary(libName));

        testLib.setName(libName);
        testLibs.add(testLib);
        config.setLibraries(testLibs);

        assertNotNull(config.findLibrary(libName));
        assertEquals(config.findLibrary(libName).getName(), libName);
    }

    @Test
    void getLibraries() {
        Config config = new Config();
        ArrayList<ConfigLibrary> emptyList = new ArrayList<>();

        assertEquals(config.getLibraries(), emptyList);
    }

    @Test
    void setLibraries() {
        Config config = new Config();
        ArrayList<ConfigLibrary> testLibs = new ArrayList<>();
        testLibs.add(new ConfigLibrary());

        config.setLibraries(null);
        assertNotNull(config.getLibraries());

        config.setLibraries(testLibs);

        assertEquals(config.getLibraries(), testLibs);
    }
}