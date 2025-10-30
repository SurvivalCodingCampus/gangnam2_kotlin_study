plugins {
    id("org.jetbrains.kotlin.jvm") version "2.0.0"
}

group = "com.survivalcoding"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    // JUnit4용 kotlin-test 바인딩
    testImplementation(kotlin("test-junit"))

    // JUnit 4 엔진 (명시)
    testImplementation("junit:junit:4.13.1")

    // 이미지 비교 라이브러리 (필요 시)
    testImplementation("com.github.romankh3:image-comparison:4.4.0")
}

tasks.test {
    // JUnit 4 실행
    useJUnit()

    // (이미지 처리 시 권장) headless 모드
    systemProperty("java.awt.headless", "true")

    // 로그 보이게
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
