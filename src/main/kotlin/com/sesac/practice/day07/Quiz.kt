package com.sesac.practice.day07

fun main() {
    val a = A()
    val b = B()
    val list: List<Y> = listOf(a, b)
    list.forEach { it.b() }
}

class A : Y() {
    override fun b() {
        println("Ab")
    }

    override fun a() {
        println("Aa")
    }

    fun c() {
        println("Ac")
    }
}

class B : Y() {
    override fun b() {
        println("Bb")
    }

    override fun a() {
        println("Ba")
    }

    fun c() {
        println("Bc")
    }
}

interface X {
    fun a()
}

abstract class Y : X {
    abstract fun b()
}
