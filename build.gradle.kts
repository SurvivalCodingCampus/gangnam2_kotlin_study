// build.gradle.kts

plugins {
    kotlin("jvm") version "2.2.21"
    kotlin("plugin.serialization") version "2.2.0"

}

group = "com.survivalcoding"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.jetbrains.kotlin:kotlin-test")
    testImplementation("junit:junit:4.13.1")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.9.0")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.10.2")

    implementation("io.ktor:ktor-client-core:3.3.2")
    implementation("io.ktor:ktor-client-cio:3.3.2")
    testImplementation("io.ktor:ktor-client-mock:3.3.2")

}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(17)
}