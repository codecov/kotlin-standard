import org.gradle.api.tasks.testing.logging.TestExceptionFormat
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

val kotlinVersion = "1.8"
val jUnitVersion = "5.10.0"
val kluentVersion = "1.73"
val spekVersion = "2.0.19"
val khttpVersion = "1.3.2"
val klaxonVersion = "5.5"
val jacocoVersion = "0.8.10"
val gradleWrapperVersion = "8.3"

plugins {
    application
    kotlin("jvm") version "1.8.0"
    jacoco
}

repositories {
    mavenCentral()
}

application {
    getMainClass().set("codecov.Request")
}

dependencies {
    implementation(kotlin("reflect"))
    implementation("org.danilopianini:khttp:$khttpVersion")
    implementation("com.beust:klaxon:$klaxonVersion")

    testImplementation(kotlin("test-junit"))
    testImplementation("org.junit.jupiter:junit-jupiter-api:$jUnitVersion")
    testImplementation("org.amshove.kluent:kluent:$kluentVersion")
    testImplementation("org.spekframework.spek2:spek-dsl-jvm:$spekVersion")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:$jUnitVersion")
    testRuntimeOnly("org.spekframework.spek2:spek-runner-junit5:$spekVersion")
}

jacoco {
    toolVersion = jacocoVersion
}

kotlin {
    jvmToolchain(18)
}

tasks.jacocoTestReport {
    reports {
        xml.required = true
        csv.required = true
        html.required = true
    }
}

tasks.test {
    finalizedBy(tasks.jacocoTestReport)
    useJUnitPlatform {
        includeEngines("junit-jupiter", "spek2")
    }

    testLogging {
        exceptionFormat = TestExceptionFormat.FULL
        events("passed", "failed", "skipped")
    }
}

tasks.wrapper {
    gradleVersion = gradleWrapperVersion
}
