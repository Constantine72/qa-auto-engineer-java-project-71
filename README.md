### Hexlet tests and linter status:
[![Actions Status](https://github.com/Constantine72/qa-auto-engineer-java-project-71/actions/workflows/hexlet-check.yml/badge.svg)](https://github.com/Constantine72/qa-auto-engineer-java-project-71/actions)
[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=Constantine72_qa-auto-engineer-java-project-71&metric=alert_status)](https://sonarcloud.io/summary/new_code?id=Constantine72_qa-auto-engineer-java-project-71)
[![Bugs](https://sonarcloud.io/api/project_badges/measure?project=Constantine72_qa-auto-engineer-java-project-71&metric=bugs)](https://sonarcloud.io/summary/new_code?id=Constantine72_qa-auto-engineer-java-project-71)
[![Code Smells](https://sonarcloud.io/api/project_badges/measure?project=Constantine72_qa-auto-engineer-java-project-71&metric=code_smells)](https://sonarcloud.io/summary/new_code?id=Constantine72_qa-auto-engineer-java-project-71)
[![Duplicated Lines (%)](https://sonarcloud.io/api/project_badges/measure?project=Constantine72_qa-auto-engineer-java-project-71&metric=duplicated_lines_density)](https://sonarcloud.io/summary/new_code?id=Constantine72_qa-auto-engineer-java-project-71)
[![Coverage](https://sonarcloud.io/api/project_badges/measure?project=Constantine72_qa-auto-engineer-java-project-71&metric=coverage)](https://sonarcloud.io/summary/new_code?id=Constantine72_qa-auto-engineer-java-project-71)
https://asciinema.org/a/6NjviPPUONQh1uDA
https://asciinema.org/a/flxtASFGrocl8DYm
https://asciinema.org/a/z2y7RtaWTOeDCjg1
https://asciinema.org/a/9jdb0cRP7frxgJGq
https://asciinema.org/a/Z4hnbuHk7uAW839s


# Gendiff

Gendiff is a command-line utility that finds differences between two data structures. It supports JSON and YAML formats
and can generate reports in three different output styles


## Output Formats

1. Stylish - a tree-like structure that visually represents the hierarchy, similar to the original files but with  
change markers(+,-)
2. Plain - a flat text format that describes changes as a list of "Property was added/removed/updated" actions
3. JSON - produces the difference tree in a machine-readable format


## Architecture Logic

The app follows a three-step pipeline:

1. Parsing: identifies file extensions and parses content into a Map
2. Tree Building: compares two maps and creates an internal representation of the differences
3. Formatting: a formatter renders the representation into a requested string format (Stylish, Plain, JSON)


## Installation & Setup

### Technologies

- Java 21 or higher
- Gradle 8.x
- Jackson
- JUnit 5 & AssertJ
- Picocli

### Install 

```bash
make install
```

### Run Test

```bash
make test
```

