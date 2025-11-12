package com.sesac.practice.day09.generic

class StrongBox<T>(
    private val keyType: KeyType,
    private var item: T? = null,
    private var tryCount: Int = INIT_TRY_COUNT,
) {
    fun put(item: T) {
        this.item = item
    }

    fun get(): T? {
        tryCount++

        if (keyType.canOpen(tryCount)) {
            return item
        }

        return null
    }

    companion object {
        const val INIT_TRY_COUNT = 0
    }
}
