package com.survivaalcoding.kotlinstudy.`09_generic_enum_string`.example

class StrongBox<T>(keyType: KeyType) {
    private var _value: T? = null
    private var _keyType = keyType
    private var _count = _keyType.count

    fun get(): T? {
        if (_count == 0) {
            return _value
        }

        _count--
        return null
    }

    fun put(value: T) {
        _value = value
    }
}