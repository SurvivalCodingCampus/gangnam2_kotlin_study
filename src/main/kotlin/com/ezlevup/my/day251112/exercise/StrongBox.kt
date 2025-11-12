package com.ezlevup.my.day251112.exercise

class StrongBox<T> {
    private var _data: T? = null

    fun put(data: T) {
        _data = data
    }

    fun get(): T? = _data
}


