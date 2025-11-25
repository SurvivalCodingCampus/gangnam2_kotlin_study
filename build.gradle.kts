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
    // Ktor 프레임워크 버전 변수 정의
    val ktorVersion = "3.3.2"

    // --- 테스트 의존성 (Test Dependencies) ---
    // Kotlin 테스트 프레임워크 핵심 라이브러리
    testImplementation("org.jetbrains.kotlin:kotlin-test")
    // JUnit 4 테스트 프레임워크
    testImplementation("junit:junit:4.13.1")
    // Kotlin 코루틴 기반 테스트를 위한 라이브러리
    testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.10.2")
    // Ktor 클라이언트 모의(Mock) 테스트를 위한 라이브러리
    testImplementation("io.ktor:ktor-client-mock:${ktorVersion}")

    // --- 주요 구현 의존성 (Main Implementation Dependencies) ---
    // Kotlin 객체를 JSON으로 직렬화/역직렬화하기 위한 kotlinx.serialization 라이브러리
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.9.0")
    // Kotlin 코루틴 핵심 라이브러리 (비동기 처리를 위함)
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.10.2")

    // Ktor 클라이언트 핵심 기능
    implementation("io.ktor:ktor-client-core:${ktorVersion}")
    // Ktor 클라이언트의 CIO 엔진 (Coroutine-based I/O) 구현체
    implementation("io.ktor:ktor-client-cio:${ktorVersion}")
    // Ktor 클라이언트의 콘텐츠 협상(Content Negotiation) 기능 추가
    implementation("io.ktor:ktor-client-content-negotiation:${ktorVersion}")
    // Ktor에서 kotlinx.serialization을 사용하여 JSON 직렬화/역직렬화를 처리하기 위한 모듈
    implementation("io.ktor:ktor-serialization-kotlinx-json:${ktorVersion}")
}

tasks.test {
    // 함수 호출
    useJUnitPlatform()
}

kotlin {
    // jvmToolchain도 함수 호출입니다.
    jvmToolchain(21)
}