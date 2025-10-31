package com.ezlevup.my.day04

class MyClass {
    companion object {
        const val STATIC_CONST = "real static"
        val NOT_STATIC = "not static"
    }
}

fun main() {
    val myClass = MyClass()
}