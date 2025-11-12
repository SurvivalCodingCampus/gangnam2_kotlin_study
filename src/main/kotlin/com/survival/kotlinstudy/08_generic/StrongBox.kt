package com.survival.kotlinstudy.`08_generic`

class StrongBox<E> {
    private var _data : E? = null
    fun put(data: E) {
        _data = data
    }

    fun get(): E? = _data
}