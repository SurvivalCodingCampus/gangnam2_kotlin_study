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
    // 버전 관리
    val ktor_version = "3.3.2"

    // test를 하는 동안에만 들어가는 라이브러리
    testImplementation(kotlin("test"))
    testImplementation("junit:junit:4.13.1")
    testImplementation("io.mockk:mockk:1.13.12")    // 모킹(Mock)을 위한 mockk 라이브러리
    testImplementation("io.ktor:ktor-client-mock:${ktor_version}")    // HTTP Mock 객체를 위한 ktor 라이브러리

    // 주요 라이브러리
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.9.0")    // 직렬화 라이브러리
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.10.2")      // 코루틴

    implementation("io.ktor:ktor-client-core:${ktor_version}")    // http 통신을 위한 공식 라이브러리 ktor-client
    implementation("io.ktor:ktor-client-cio:${ktor_version}")
}

tasks.test {
    useJUnit()
}

kotlin {
    jvmToolchain(21)
}
