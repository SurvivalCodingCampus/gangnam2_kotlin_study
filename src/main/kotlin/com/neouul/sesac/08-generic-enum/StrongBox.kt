package com.neouul.sesac.`08-generic-enum`

class StrongBox<T> {
    private var _data: T? = null

    fun put(data: T) {
        _data = data
    }

    fun get(): T? = _data
}