package com.luca.kotlinstudy._09_generic

class StrongBox<E>(private val keyType: KeyType) {
    private var _data: E? = null
    private var count = 0
    fun put(data: E) {
        _data = data
    }

    fun get(): E? {
        count++
        val result = if(count > keyType.count) _data else null
        return result
    }
}
// 카운트 횟수일때 null
// 카운트 넘어갈 때 _data
// 키타입 횟수 확인?

enum class KeyType(val count: Int) {
    PADLOCK(1024),
    BUTTON(10000),
    DIAL(30000),
    FINGER(1000000),
}
