package com.sesac.practice.day09.generic

class StrongBox<T>(
    private var item: T? = null,
) {
    fun put(item: T) {
        this.item = item
    }

    fun get(): T? = item
}
