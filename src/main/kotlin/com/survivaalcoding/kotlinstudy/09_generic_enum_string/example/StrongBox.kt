package com.survivaalcoding.kotlinstudy.`09_generic_enum_string`.example

class StrongBox<T>(box: T) {
    private var _value: T = box
    val value = _value

    fun get(): T = _value

    fun put(value: T) {
        this._value = value
    }
}