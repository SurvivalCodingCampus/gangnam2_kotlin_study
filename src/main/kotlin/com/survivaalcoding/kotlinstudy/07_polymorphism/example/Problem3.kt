package com.survivaalcoding.kotlinstudy.`07_polymorphism`.example

fun main() {
    val list = listOf<Y>(A(), B())
    list.forEach { it.b() }
}