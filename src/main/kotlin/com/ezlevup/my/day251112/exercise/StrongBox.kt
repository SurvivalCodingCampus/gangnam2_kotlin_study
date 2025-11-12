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

class StrongBox<T>(
    val keyType: KeyType = KeyType.PADLOCK,
) {
    private var _attemptCount: Int = 0
    private var data: T? = null

    val attemptCount: Int
        get() = _attemptCount

    fun incrementAttempt() {
        _attemptCount++
    }

    fun put(data: T) {
        this.data = data
    }

    fun get(): T? {
        incrementAttempt()
        val result: Boolean = (attemptCount >= (KeyData.MAX_ATTEMPTS[keyType] ?: 0))
        return if (result) data else null
    }
}


