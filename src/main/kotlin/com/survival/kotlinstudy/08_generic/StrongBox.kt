package com.survival.kotlinstudy.`08_generic`

enum class KeyType {
    PADLOCK, BUTTON, DIAL, FINGER
}

class StrongBox<E>(keyType: KeyType) {
    private var _data: E? = null

    private var lockCount = when (keyType) {
        KeyType.PADLOCK -> 1024
        KeyType.BUTTON -> 10000
        KeyType.DIAL -> 30000
        KeyType.FINGER -> 1000000
    }

    fun put(data: E) {
        _data = data
    }

    fun get(): E? {
        if (lockCount == 0) return _data
        lockCount -= 1
        return null
    }
}
