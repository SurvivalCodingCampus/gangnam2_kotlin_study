package com.survivalcoding.kotlinstudy.`09_generic_enum`

// 연습문제 1. 금고 클래스 작성
// 금고에 담는 인스턴스의 타입은 미정(generic)
class StrongBox<E> {
    // 1개의 인스턴스만 담을 수 있음
    // 언더스코어는 내부에서만 쓰이는 변수임을 나타내기 위함 (그냥 data 라고 썼어도 무방)
    private var _data: E? = null

    // 인스턴스 저장
    fun put(data: E) {
        _data = data
    }

    // 인스턴스 얻음, 별도의 타입 캐스팅 X
    fun get(): E? = _data
}