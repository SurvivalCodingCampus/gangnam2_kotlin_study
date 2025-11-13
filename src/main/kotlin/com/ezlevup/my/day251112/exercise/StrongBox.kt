package com.ezlevup.my.day251112.exercise

enum class KeyType {
    PADLOCK,
    BUTTON,
    DIAL,
    FINGER,
}

object KeyData {
    val MAX_ATTEMPTS = mapOf(
        KeyType.PADLOCK to 1024,
        KeyType.BUTTON to 10_000,
        KeyType.DIAL to 30_000,
        KeyType.FINGER to 1_000_000,
    )

    fun isMaxAttemptsReached(keyType: KeyType, attemptCount: Int): Boolean {
        val maxAttempts = MAX_ATTEMPTS[keyType] ?: 0
        return attemptCount >= maxAttempts
    }
}


class StrongBox<T>(
    val keyType: KeyType,
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
        val result = KeyData.isMaxAttemptsReached(keyType, attemptCount)
        return if (result) data else null
    }
}


