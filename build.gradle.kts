plugins {
    kotlin("jvm") version "2.2.21"
    kotlin("plugin.serialization") version "2.2.21"

}

group = "com.survivalcoding"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    testImplementation("junit:junit:4.13.1")
    //직렬화 역직렬화 관련 라이브러리
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.9.0")

}

tasks.test {
    useJUnit()
}

kotlin {
    jvmToolchain(21)
}