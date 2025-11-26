package com.hhp227.kotlinstudy.`17_result`

/*
과제1. 기본 Result 클래스 구현

Result<T, E> 클래스를 직접 만드세요
Success와 Error 서브클래스를 만드시오

과제2 : Repository 패턴 + Result 조합
다음 장표의 Result, NetworkError를 활용해서
사용자 관리를 위한 Repository 인터페이스를 정의하시고

요구사항:
- 사용자 ID로 단일 사용자 조회
- 전체 사용자 목록 조회
- 새 사용자 생성
- 모든 메서드는 Result 패턴 사용
   예: Result<User, NetworkError>, Result<List<User>, NetworkError> 등

sealed class Result<out T, out E> {
    data class Success<out T>(val data: T) : Result<T, Nothing>()

    data class Error<out E>(val error: E) : Result<Nothing, E>()
}

sealed class NetworkError {
    object NetworkUnavailable : NetworkError()
    object Timeout : NetworkError()
    data class HttpError(val code: Int) : NetworkError()
    object ParseError : NetworkError()
    data class Unknown(val message: String) : NetworkError()
}

과제3: 실제 네트워크 요청 구현

UserRepositoryImpl을 구현하세요

- 코루틴 기반 HTTP 클라이언트 사용
- 타임아웃 10초 설정
    클라이언트 설정 또는 withTimeout(10_000) 등을 사용할 수 있음
    타임아웃 발생 시 TimeoutCancellationException 또는 관련 예외가 발생함
- Http 상태코드별 적절한 NetworkError 반환
    예: 4xx → 클라이언트 에러, 5xx → 서버 에러 등으로 매핑
- JSON 파싱 에러 처리
    JSON 파싱 시 발생하는 예외 (예: SerializationException 등)은 ParseError 로 변환

 */
