package com.ezlevup.my.core

import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json

/**
 * Ktor HttpClient를 생성하는 팩토리 클래스.
 *
 * - CIO 엔진을 사용하여 비동기 I/O 기반 HTTP 통신을 수행한다.
 * - ContentNegotiation + Kotlinx Serialization(Json)을 설치해서
 *   서버와 JSON 형식으로 데이터를 주고받을 수 있도록 설정한다.
 */
class HttpClientFactory {

    /**
     * JSON 직렬화/역직렬화 설정이 적용된 HttpClient 인스턴스를 생성한다.
     *
     * @return 공통 설정이 적용된 HttpClient 인스턴스
     */
    fun create(): HttpClient {
        return HttpClient(CIO) {
            // 서버와의 요청/응답에서 Content-Type: application/json 을 사용하기 위한 설정
            install(ContentNegotiation) {
                json(
                    Json {
                        // 응답 JSON에 정의되지 않은 필드가 있어도 무시하고 파싱
                        ignoreUnknownKeys = true
                        // 조금 느슨한(JSON 표준을 완전히 지키지 않는) 형식도 허용
                        isLenient = true
                    }
                )
            }

            // 공통 타임아웃, 기본 헤더, 로깅, 에러 처리 등 추가 설정

            // 타임아웃 설정
            //install(HttpTimeout) {
            //    requestTimeoutMillis = 10_000
            //    connectTimeoutMillis = 10_000
            //    socketTimeoutMillis = 10_000
            //}

            // 로깅 설정 (디버그 모드에서만 보이게)
            //install(Logging) {
            //    logger = Logger.DEFAULT
            //    level = LogLevel.ALL // HEADERS, BODY, INFO, NONE
            //}

            // 기본 요청 설정 (모든 요청에 공통 적용)
            //defaultRequest {
            //    contentType(ContentType.Application.Json)
            //    accept(ContentType.Application.Json)
            //    // 헤더에 토큰 등을 넣을 때 유용
            //    // header("Authorization", "Bearer $token")
            //}
        }
    }
}
