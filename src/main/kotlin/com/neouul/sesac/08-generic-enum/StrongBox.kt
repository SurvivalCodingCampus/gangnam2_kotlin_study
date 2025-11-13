package com.neouul.sesac.`08-generic-enum`

class StrongBox<T>(private var keyType: KeyType) {
    private var _data: T? = null
    private var keyCounter = 0

    fun put(data: T) {
        _data = data
    }

    fun get(): T? {
        if (keyCounter == keyType.keyNumber) return _data
        keyCounter++
        return null
    }

    // 테스트를 위한 getter
    fun getKey(): KeyType = keyType
    fun getCounter(): Int = keyCounter
    fun getData(): T? = _data
}

// Since each enum is an instance of the enum class, it can be initialized
// 각 enum은 KeyType라는 이름의 enum class의 인스턴스임
// 즉, 각 enum은 생성자를 통해 필드를 초기화할 수 있음
enum class KeyType(val keyNumber: Int) {
    PADLOCK(1024),
    BUTTON(10000),
    DIAL(30000),
    FINGER(1000000),
}