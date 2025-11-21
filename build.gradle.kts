// build.gradle.kts
plugins {
    // 'id'는 함수 호출처럼 괄호를 사용합니다.
    kotlin("jvm") version "2.2.21"
    kotlin("plugin.serialization") version "2.2.21"
}

// 할당 연산자(=)를 사용합니다.
group = "com.survivalcoding"
version = "1.0-SNAPSHOT"

repositories {
    // 함수 호출 방식
    mavenCentral()
}

dependencies {
    // 키워드가 아닌 함수 호출로 변경됩니다.
    testImplementation("org.jetbrains.kotlin:kotlin-test")
    testImplementation("junit:junit:4.13.1")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.9.0")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.10.2")

    implementation("io.ktor:ktor-client-core:3.3.2")
    implementation("io.ktor:ktor-client-cio:3.3.2")
}

tasks.test {
    // 함수 호출
    useJUnitPlatform()
}

kotlin {
    // jvmToolchain도 함수 호출입니다.
    jvmToolchain(21)
}