import org.gradle.api.tasks.testing.logging.TestExceptionFormat
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

val kotlinVersion = "1.3.40"
val jUnitVersion = "5.4.2"
val kluentVersion = "1.51"
val spekVersion = "2.0.5"


plugins {
    application
    kotlin("jvm") version "1.3.31"
    jacoco
}

repositories {
    mavenLocal()
    mavenCentral()
    maven("https://jitpack.io")
    jcenter()
}

application {
    mainClassName = "codecov.Request"
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))

    testImplementation(kotlin("test"))
    testImplementation(kotlin("test-junit"))

    testImplementation("org.junit.jupiter:junit-jupiter-api:$jUnitVersion")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:$jUnitVersion")

    testImplementation("org.amshove.kluent:kluent:$kluentVersion")

    testImplementation("org.spekframework.spek2:spek-dsl-jvm:$spekVersion")
    testRuntimeOnly("org.spekframework.spek2:spek-runner-junit5:$spekVersion")
	implementation("com.github.jkcclemens:khttp:0.1.0")
    implementation("com.beust:klaxon:5.0.1")
    compile("org.jetbrains.kotlin:kotlin-reflect:1.3.40")

}

jacoco {
        toolVersion = "0.8.4"
}

tasks.jacocoTestReport {
        reports {
                xml.isEnabled = true
                csv.isEnabled = true
                html.isEnabled = true
        }
}

tasks.test {
    finalizedBy(tasks.jacocoTestReport)
    useJUnitPlatform {
        includeEngines("junit-jupiter","spek2")
    }

    testLogging {
        exceptionFormat = TestExceptionFormat.FULL
        events("passed", "failed", "skipped")
    }
}

tasks.withType<KotlinCompile> {

    sourceCompatibility = "1.8"
    targetCompatibility = "1.8"

    kotlinOptions {
        jvmTarget = "1.8"
        apiVersion = "1.3"
        languageVersion = "1.3"
        allWarningsAsErrors = true
    }
}

tasks.wrapper {
    gradleVersion = "5.4.1"
}