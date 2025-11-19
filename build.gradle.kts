plugins {
    kotlin("jvm") version "2.2.0"
    kotlin("plugin.serialization") version "2.2.0"
}

group = "com.survivalcoding"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    testImplementation("junit:junit:4.13.1")
    testImplementation("io.mockk:mockk:1.13.12")    // 모킹(Mock)을 위한 mockk 라이브러리

    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.9.0")    // 직렬화 라이브러리
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.10.2")      // 코루틴
}

tasks.test {
    useJUnit()
}

kotlin {
    jvmToolchain(21)
}
