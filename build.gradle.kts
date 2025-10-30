plugins {
    kotlin("jvm") version "2.2.0"
}

group = "com.survivalcoding"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("junit:junit:4.13.1")
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnit()
}

kotlin {
    jvmToolchain(21)
}