package com.survivalcoding.kotlinstudy.`09_generic_enum`

// 연습문제 1. 금고 클래스 작성
// 금고에 담는 인스턴스의 타입은 미정(generic)
class StrongBox<E>(
    val keyType: KeyType   // 열쇠 종류 (enum)
) {
    // 1개의 인스턴스만 담을 수 있음
    // 언더스코어는 내부에서만 쓰이는 변수임을 나타내기 위함 (그냥 data 라고 썼어도 무방)
    private var _data: E? = null

    // 인스턴스 저장
    fun put(data: E) {
        _data = data
    }

    var count: Int = 0

    // 인스턴스 얻음, 별도의 타입 캐스팅 X
    fun get(): E? {
        // 연습문제 2. get 메서드 호출
        count++  // 호출할 때마다 시도 횟수 증가

        if (count < keyType.limit) {
            return null // 한도 도달 전 null 리턴
        } else {
            count = 0   // 시도 횟수 리셋
            return _data    // 한도 도달시 잠금 해제
        }
    }
}


// 연습문제 2. 열거형 정의와 시도 횟수 한계
enum class KeyType(
    val limit: Int
) {
    PADLOCK(1024),
    BUTTON(10000),
    DIAL(30000),
    FINGER(1000000)
}