plugins {
    id("org.jetbrains.kotlin.jvm") version "2.2.0"
    id("org.jetbrains.kotlin.plugin.serialization") version "2.2.0"
}

group = "com.survivalcoding"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    // -------------------------------
    // ▶ Kotlin Coroutines
    // -------------------------------
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.8.1")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-jdk8:1.8.1")
    testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.8.1")

    // 지정 버전
    val ktorVersion = "3.3.2"

    // -------------------------------
    // ▶ Ktor Server (Netty)
    // -------------------------------
    implementation("io.ktor:ktor-server-core-jvm:$ktorVersion")
    implementation("io.ktor:ktor-server-netty-jvm:$ktorVersion")

    // JSON + Content Negotiation
    implementation("io.ktor:ktor-server-content-negotiation-jvm:$ktorVersion")
    implementation("io.ktor:ktor-serialization-kotlinx-json-jvm:$ktorVersion")

    // 추가 서버 기능
    implementation("io.ktor:ktor-server-call-logging-jvm:$ktorVersion")
    implementation("io.ktor:ktor-server-status-pages-jvm:$ktorVersion")
    implementation("io.ktor:ktor-server-host-common-jvm:$ktorVersion")

    // Server Test
    testImplementation("io.ktor:ktor-client-mock-jvm:${ktorVersion}")

    // -------------------------------
    // ▶ Ktor Client (HTTP 클라이언트)
    // -------------------------------
    implementation("io.ktor:ktor-client-core:$ktorVersion")
    implementation("io.ktor:ktor-client-cio:$ktorVersion")

    // JSON 직렬화
    implementation("io.ktor:ktor-client-content-negotiation:$ktorVersion")
    implementation("io.ktor:ktor-serialization-kotlinx-json:$ktorVersion")

    // -------------------------------
    // ▶ JUnit4
    // -------------------------------
    testImplementation(kotlin("test-junit"))
    testImplementation("junit:junit:4.13.1")

    // 이미지 비교 라이브러리
    testImplementation("com.github.romankh3:image-comparison:4.4.0")

    // -------------------------------
    // ▶ Kotlinx Serialization (기본 JSON)
    // -------------------------------
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.7.3")

    //모키
    testImplementation("io.mockk:mockk:1.13.10")
}

tasks.test {
    useJUnit()

    systemProperty("java.awt.headless", "true")

    testLogging {
        events("passed", "failed", "skipped", "standardOut", "standardError")
        showExceptions = true
        showStackTraces = true
        showCauses = true
    }
}

kotlin {
    jvmToolchain(21)
}
