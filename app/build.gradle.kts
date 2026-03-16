plugins {
    application
    checkstyle
    id("java")
    id("org.sonarqube") version "7.2.2.6593"
}

sonar {
    properties {
        property("sonar.projectKey", "Constantine72_qa-auto-engineer-java-project-71")
        property("sonar.organization", "constantine72")
    }
}

application {
    mainClass.set("hexlet.code.App")
}

group = "hexlet.code"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
    implementation("info.picocli:picocli:4.7.5")
    implementation("com.google.code.gson:gson:2.10.1")
    implementation("com.fasterxml.jackson.core:jackson-databind:2.16.1")
    implementation("com.fasterxml.jackson.dataformat:jackson-dataformat-yaml:2.16.1")
}

tasks.test {
    useJUnitPlatform()
}