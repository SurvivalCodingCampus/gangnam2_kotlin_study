package com.ezlevup.my.day251112.exercise

enum class KeyType {
    PADLOCK,
    BUTTON,
    DIAL,
    FINGER,
}

class KeyData {
    companion object {
        val MAX_ATTEMPTS = mapOf(
            KeyType.PADLOCK to 1024,
            KeyType.BUTTON to 10_000,
            KeyType.DIAL to 30_000,
            KeyType.FINGER to 1_000_000,
        )
    }
}

class StrongBox<T>(val keyType: KeyType) {
    private var _userCount: Int = 0
    private var _data: T? = null

    fun put(data: T) {
        _data = data
    }

    fun get(): T? {
        _userCount++

        val result: Boolean = when (keyType) {
            KeyType.PADLOCK -> (_userCount >= (KeyData.MAX_ATTEMPTS[KeyType.PADLOCK] ?: 0))
            KeyType.BUTTON -> (_userCount >= (KeyData.MAX_ATTEMPTS[KeyType.BUTTON] ?: 0))
            KeyType.DIAL -> (_userCount >= (KeyData.MAX_ATTEMPTS[KeyType.DIAL] ?: 0))
            KeyType.FINGER -> (_userCount >= (KeyData.MAX_ATTEMPTS[KeyType.FINGER] ?: 0))
        }

        return if (result) _data else null
    }
}


