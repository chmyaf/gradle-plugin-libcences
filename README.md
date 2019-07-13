# Libraries licenses reminder

Reminder about the licenses of used libraries.

## Description

This is a Gradle plugin to check dependencies their licenses.

## Usage 

### Include plugin 

#### Using the pluginsDSL

```groovy
plugins {
  id "com.chmyaf.gradle.plugin.libcenses" version "X.Y.Z"
}
```

#### Using legacy plugin application

```groovy
buildscript {
    repositories {
        jcenter()
    }
    dependencies {
        classpath 'com.chmyaf.gradle.plugin:libcenses:+'
    }
}
apply plugin: 'com.chmyaf.gradle.plugin.libcenses'

```

### Plugin configuration

```groovy
libcenses {
    config = "libcenses.yml"
}
```

### Libcenses configuration

```yaml
libraries:
  - name: "library_name"
    license: "example license"
    accepted:
      - "Licence.txt placed to root directory"
    waiting:
      - "Add author to readme"
```

Examples can be found in the [src/testFunc/resources](src/testFunc/resources) directory.

## License

This is Open Source software released under [Apache 2.0 license](./LICENSE).

## Third party

- [snakeyaml] -- YAML 1.1 processor for the Java Virtual Machine version 7.

## Links

* [Apache Linense, Version 2.0](https://apache.org/licenses/LICENSE-2.0)
* [Gradle](https://gradle.org/)

[snakeyaml]: https://bitbucket.org/asomov/snakeyaml/
