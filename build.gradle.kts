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
    //coroutine관련 라이브러리
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.10.2")

    //코루틴 테스트 관련 라이브러리
    testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.10.2")

    //통신관련 공식 라이브러리 ktor
    implementation("io.ktor:ktor-client-core:3.3.2")
    implementation("io.ktor:ktor-client-cio:3.3.2") //코루틴 되도록 처리
    testImplementation("io.ktor:ktor-client-mock:3.3.2") //mockEngine을 이용하여 mock서버 만들기 위함

    implementation("io.ktor:ktor-client-content-negotiation:3.3.2")
    implementation("io.ktor:ktor-serialization-kotlinx-json:3.3.2")
}

tasks.test {
    useJUnit()
}

kotlin {
    jvmToolchain(21)
}